package com.zln.competition.mapper;

import com.zln.competition.bean.Fdback;

public interface FdbackMapper {
    int deleteByPrimaryKey(Integer fdbackId);

    int insert(Fdback record);

    int insertSelective(Fdback record);

    Fdback selectByPrimaryKey(Integer fdbackId);

    int updateByPrimaryKeySelective(Fdback record);

    int updateByPrimaryKey(Fdback record);
}