package com.zln.competition.service;

import com.zln.competition.bean.Answer;
import com.zln.competition.bean.User;

import java.util.List;

public interface UserService {

    public int insertUser(User user);

    public User selectAllUserByOpenid(String userOpenid);

    public User selectByOpenId(String OpenId);

    public int deleteByUserIdFromUser(Integer userId);
    public int updateByOpenid(User record);

}
