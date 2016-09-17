package com.zlzkj.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zlzkj.app.mapper.ActionNodeMapper;
import com.zlzkj.app.model.ActionNode;
import com.zlzkj.app.model.User;
import com.zlzkj.app.util.UIUtils;
import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import com.zlzkj.core.util.Fn;

@Service
@Transactional
public class ActionNodeService {
	
	@Autowired
	private ActionNodeMapper mapper;
	
	@Autowired
	private SqlRunner sqlRunner;

	public long delete(int id){
		return mapper.deleteByPrimaryKey(id);
	}
	
	public Integer update(ActionNode entity){
		return mapper.updateByPrimaryKey(entity);
	}
	
	public Integer updateSelective(ActionNode entity){
		return mapper.updateByPrimaryKeySelective(entity);
	}
	
	public Integer save(ActionNode entity) {
		//mapper.insertSelective(entity);
		return mapper.insertSelective(entity);
	}

	public ActionNode findById(Integer id){
		return mapper.selectByPrimaryKey(id);
	}

	public List<Row> findNode(Integer role,int sort) {
	String Sql="select * from x_action_node where level<='"+role+"' and sort='"+sort+"'";
		return sqlRunner.select(Sql);
	}
	

}

//编写者：张佳旻