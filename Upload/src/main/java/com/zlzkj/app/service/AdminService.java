package com.zlzkj.app.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zlzkj.app.mapper.AdminMapper;
import com.zlzkj.app.model.Admin;
import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import com.zlzkj.core.util.Fn;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminMapper mapper;
	
	@Autowired
	private SqlRunner sqlRunner;
	
	public Integer delete(Integer id){
		return mapper.deleteByPrimaryKey(id);
	}
	
	public Integer update(Admin entity){
		return mapper.updateByPrimaryKey(entity);
	}
	
	public void save(Admin entity) {
		
		entity.setLoginPass(DigestUtils.md5Hex(entity.getLoginPass()));
		entity.setAddTime(Fn.time());
		entity.setLoginCount(0);
		entity.setLastLoginIp("127.0.0.1");
		entity.setLastLoginTime(0);
		entity.setIsDisabled((byte) 0);
		
		mapper.insert(entity);
	}
	
	public List<Admin> findAll() {
		return mapper.selectAll();
	}
	
	public Admin findById(Integer id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public List<Row> findBySQL(){
		
		String sql = SQLBuilder.getSQLBuilder(Admin.class).fields("nickname,login_name,add_time").where("id=#{0}").selectSql();
		
		return sqlRunner.select(sql,1);
	}
	
}

