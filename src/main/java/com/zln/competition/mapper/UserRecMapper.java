package com.zln.competition.mapper;

import com.zln.competition.bean.UserRec;

import java.util.List;

public interface UserRecMapper {
    //查询功能
    public List<UserRec> selectAllUserRecByUserid(Integer userId);
}
