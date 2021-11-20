package com.zln.competition.service;

import com.zln.competition.bean.Answer;

import java.util.List;

public interface AnswerService {
    public List<Answer> selectAllAnswer();

    public List<Answer> selectByUserId(Integer userId);

    public int insertAnswer(Answer answer);
}
