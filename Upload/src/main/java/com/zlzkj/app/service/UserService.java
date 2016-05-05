package com.zlzkj.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zlzkj.app.mapper.UserMapper;
import com.zlzkj.app.model.User;
import com.zlzkj.app.util.UIUtils;
import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import com.zlzkj.core.util.Fn;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private SqlRunner sqlRunner;
	
	public long delete(int id){
		return mapper.deleteByPrimaryKey(id);
	}
	
	public Integer update(User entity){
		return mapper.updateByPrimaryKey(entity);
	}
	
	public Integer updateSelective(User entity){
		return mapper.updateByPrimaryKeySelective(entity);
	}
	
	public Integer save(User entity) {
		//mapper.insertSelective(entity);
		return mapper.insertSelective(entity);
	}

	public User findById(Integer id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public List<Row> findUser(String account){
		
		String sql = "select * from x_user where account='"+account+"'";
		return sqlRunner.select(sql);
	}
	
	
	public List<Row> findAllUser(){
		
		String sql = "select * from x_user where role=0";
		
		return sqlRunner.select(sql,1);
	}
	
	public User select_userinfo(User user){
		return mapper.select_userinfo(user);
	}
	
public User modify_password(String account,String password){
		
		return mapper.modify_password(account,password);
	}

	public User getObjByProperties(HashMap<String, Object> where) {
		SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(User.class);
		String sql = sqlBuilder.fields("*").where(where).selectSql();
		List<Row> list = sqlRunner.select(sql);
		if (list.size() == 0)
			return null;
		else
			return this.findById(list.get(0).getInt("id"));
	}

	public boolean userNameIsExist(String userName){
		SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(User.class);
		String sql = sqlBuilder.fields("*").where("name='"+userName+"'").selectSql();
		List<Row> list = sqlRunner.select(sql);
		if(list.size()==0){
			return false;
		}else{
			return true;
		}
	}
	public boolean checkLogin(String account, String password){
		HashMap<String, Object> where  = new HashMap<String,Object>();
		where.put("account", account);
		where.put("password",password);
		SQLBuilder sb = SQLBuilder.getSQLBuilder(User.class);
		String sql = sb.fields("*").where(where).selectSql();
//		List<Row> list = sqlRunner.select(sql,loginName,DigestUtils.md5Hex(loginPwd));
		List<Row> list = sqlRunner.select(sql);
		if(list.size()>0){ 
			return true;
		}
		else
			return false;
	}
	public Integer loginId(String loginName, String loginPwd){
		String sql = SQLBuilder.getSQLBuilder(User.class)
				.fields("id")   //这里约定前端grid需要显示多少个具体列，也可以全部*
				.where("name ='"+loginName+"' and password ='"+loginPwd+"'")
				.order("id", "asc")
				.selectSql();
		List<Row> list = sqlRunner.select(sql);
		Integer id = 0;
		for(Row row : list){
			id = Integer.valueOf(row.get("id").toString());
		}
		return id;
	}
	public Map<String, Object> getUIGridData(Map<String, Object> where, Map<String, String> pageMap) {
		SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(User.class);
		String sql = sqlBuilder
				.fields("*")   //这里约定前端grid需要显示多少个具体列，也可以全部*
				.where(where)
				.parseUIPageAndOrder(pageMap)
				.order("id", "desc")
				.selectSql();
		List<Row> list = sqlRunner.select(sql);
		for(Row row : list){
        	row.put("addTime", Fn.date(row.getInt("addTime"), "yyyy-MM-dd HH:mm:ss"));
        }
		String countSql = sqlBuilder.fields("count(*)").where(where).selectSql();
		Integer count = sqlRunner.count(countSql);
		return UIUtils.getGridData(count, list);
	}
	
	
}

