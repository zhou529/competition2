package com.zln.competition.service;

import com.zln.competition.bean.Fdback;

public interface FdbackService {
    int deleteByPrimaryKey(Integer fdbackId);

    int insert(Fdback record);

    int insertSelective(Fdback record);

    Fdback selectByPrimaryKey(Integer fdbackId);

    int updateByPrimaryKeySelective(Fdback record);

    int updateByPrimaryKey(Fdback record);
}
