package com.zln.competition.mapper;

import com.zln.competition.bean.Answer;
import com.zln.competition.bean.User;

import java.util.List;

public interface UserMapper {
    public int insertUser(User user);

    public User selectAllUserByOpenid(String userOpenid);

    public User selectByOpenId(String openId);

    int deleteByUserIdFromUser(Integer userId);

    int updateByOpenid(User record);
}
