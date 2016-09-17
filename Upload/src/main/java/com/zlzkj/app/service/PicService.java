package com.zlzkj.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zlzkj.app.mapper.PicMapper;
import com.zlzkj.app.model.Pic;
import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;

@Service
@Transactional
public class PicService {

	@Autowired
	private PicMapper mapper;
	
	@Autowired
	private SqlRunner sqlRunner;
	
	public Integer delete(Integer id){
		return mapper.deleteByPrimaryKey(id);
	}
	
	public Integer update(Pic entity){
		return mapper.updateByPrimaryKey(entity);
	}
	
	public void save(Pic entity) {
	
		mapper.insert(entity);
	}
	
	
	public Pic findById(Integer id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public List<Row> findALL(){
		String sql = SQLBuilder.getSQLBuilder(Pic.class)
				.fields("*")
				.selectSql();
		//System.out.println(sqlRunner.select(sql,1));
		return sqlRunner.select(sql,1);
	}
	
}
//编写者：张佳旻
