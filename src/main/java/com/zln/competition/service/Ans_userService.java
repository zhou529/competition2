package com.zln.competition.service;

import com.zln.competition.bean.Ans_user;

import java.util.List;

public interface Ans_userService {
    List<Ans_user> selectByAnsId(Integer ansId);

    int insertAnsInformation(Ans_user ans_user);

}
