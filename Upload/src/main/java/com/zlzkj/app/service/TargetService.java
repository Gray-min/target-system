package com.zlzkj.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zlzkj.app.mapper.TargetMapper;
import com.zlzkj.app.model.Target;
import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;

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

	/*public List<Row> findUser(String account) {

		String sql = "select * from x_target where account='"+account+"'";
		return sqlRunner.select(sql);
	}*/

	public Integer finishtarget(String project) {
		String sql = "update x_target set status=0 where project='"+project+"'";
		return sqlRunner.update(sql);
	}

	public int alltarget_total(String account) {
		int total=0;
		String sql = "select count(*) as total from x_target where account='"+account+"' and status!=2";
		total = sqlRunner.select(sql).get(0).getInt("total");
		return total;
	}
	public List<Row> selectAlltarget(int start,int pagesize,String account){
		//start是从第几条开始 	desc倒序   asc正序
		String sql = "select * from x_target where account='"+account+"' and status!=2 "
				+ " ORDER BY id desc limit "+start+","+pagesize+"";
		List<Row> list = sqlRunner.select(sql);
		return list;
	}

	public void mydelete(String project) {
	
		String sql="update x_target set status=2 where project='"+project+"'";
		sqlRunner.update(sql);
		}

	public int alldeletetarget_total(String account) {
		int total=0;
		String sql = "select count(*) as total from x_target where account='"+account+"' and status=2";
		total = sqlRunner.select(sql).get(0).getInt("total");
		return total;
	}

	public List<Row> selectAlldeletetarget(int start, int pagesize,
			String account) {
		String sql = "select * from x_target where account='"+account+"' and status=2 "
				+ " ORDER BY id desc limit "+start+","+pagesize+"";
		List<Row> list = sqlRunner.select(sql);
		return list;
	}

	public void myrestore(String project) {

		String sql="update x_target set status=0 where project='"+project+"'";
		sqlRunner.update(sql);
	}
	public void myrestore2(String project) {

		String sql="update x_target set status=1 where project='"+project+"'";
		sqlRunner.update(sql);
	}

	/*public List<Row> findPoint(String account,String password){
		
		String sql = "select * from x_user where account="+account+" and password="+password;
		return sqlRunner.select(sql);
	}*/
}

//编写者：张佳旻