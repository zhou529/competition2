package com.zln.competition.mapper;

import com.zln.competition.bean.Ans_user;

import java.util.List;

public interface Ans_userMapper {
    List<Ans_user> selectByAnsId(Integer ansId);

    int insertAnsInformation(Ans_user ans_user);

    List<Ans_user> selectByUserId(Integer userId);

    int updateByUserId(Ans_user ans_user);

    int deleteByUserId(Integer userId);
}