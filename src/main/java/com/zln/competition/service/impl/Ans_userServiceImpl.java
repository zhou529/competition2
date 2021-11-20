package com.zln.competition.service.impl;

import com.zln.competition.bean.Ans_user;
import com.zln.competition.mapper.Ans_userMapper;
import com.zln.competition.service.Ans_userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Ans_userServiceImpl implements Ans_userService {
    @Resource
    Ans_userMapper ans_userMapper;

    @Override
    public List<Ans_user> selectByAnsId(Integer ansId) {
        return ans_userMapper.selectByAnsId(ansId);
    }

    @Override
    public int insertAnsInformation(Ans_user ans_user) {
        return ans_userMapper.insertAnsInformation(ans_user);
    }
}
