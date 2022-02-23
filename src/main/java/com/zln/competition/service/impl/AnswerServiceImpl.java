package com.zln.competition.service.impl;

import com.zln.competition.bean.Answer;
import com.zln.competition.mapper.AnswerMapper;
import com.zln.competition.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Resource
    AnswerMapper answerMapper;

    @Override
    public List<Answer> selectAllAnswer() {
        List<Answer> answers = answerMapper.selectAllAnswer();
        return answers;
    }

    @Override
    public List<Answer> selectByUserId(Integer userId){
        List<Answer> answers = answerMapper.selectByUserId(userId);
        return answers;
    }

    @Override
    public int insertAnswer(Answer answer) {
        int i = answerMapper.insertAnswer(answer);
        return i;
    }

    @Override
    public int updateAnswerByAnsId(Answer answer) {
        return answerMapper.updateAnswerByAnsId(answer);
    }

    @Override
    public int deleteAnswerByAnsId(Integer ansId) {
        return answerMapper.deleteAnswerByAnsId(ansId);
    }
}
