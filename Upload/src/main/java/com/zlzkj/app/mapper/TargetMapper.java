package com.zlzkj.app.mapper;

import com.zlzkj.app.model.Target;

public interface TargetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Target record);

    int insertSelective(Target record);

    Target selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Target record);

    int updateByPrimaryKey(Target record);
}