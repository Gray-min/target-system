package com.zlzkj.app.mapper;

import com.zlzkj.app.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User select_userinfo(User user);

	User modify_password(String account,String password);
}