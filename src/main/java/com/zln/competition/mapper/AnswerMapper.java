package com.zln.competition.mapper;

import com.zln.competition.bean.Answer;

import java.util.List;

public interface AnswerMapper {

    public List<Answer> selectAllAnswer();

    public List<Answer> selectByUserId(Integer userId);

    public int insertAnswer(Answer answer);
}
