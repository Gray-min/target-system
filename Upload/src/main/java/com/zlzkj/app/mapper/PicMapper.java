package com.zlzkj.app.mapper;

import com.zlzkj.app.model.Pic;

public interface PicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pic record);

    int insertSelective(Pic record);

    Pic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pic record);

    int updateByPrimaryKey(Pic record);
}