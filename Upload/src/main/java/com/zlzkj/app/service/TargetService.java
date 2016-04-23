package com.zlzkj.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zlzkj.app.mapper.TargetMapper;
import com.zlzkj.app.model.Target;
import com.zlzkj.core.mybatis.SqlRunner;

@Service
@Transactional
public class TargetService {
	
	@Autowired
	private TargetMapper mapper;
	
	@Autowired
	private SqlRunner sqlRunner;
	
	public long delete(int id){
		return mapper.deleteByPrimaryKey(id);
	}
	
	public Integer update(Target entity){
		return mapper.updateByPrimaryKey(entity);
	}
	
	public Integer updateSelective(Target entity){
		return mapper.updateByPrimaryKeySelective(entity);
	}
	
	public Integer save(Target entity) {
		mapper.insertSelective(entity);
		return entity.getId();
	}

	public Target findById(Integer id){
		return mapper.selectByPrimaryKey(id);
	}
	
	/*public List<Row> findPoint(String account,String password){
		
		String sql = "select * from x_user where account="+account+" and password="+password;
		return sqlRunner.select(sql);
	}*/
}

