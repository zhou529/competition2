package com.zln.competition.service.impl;

import com.zln.competition.bean.Answer;
import com.zln.competition.bean.User;
import com.zln.competition.mapper.UserMapper;
import com.zln.competition.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public int updateByOpenid(User record){
        return userMapper.updateByOpenid(record);
    }

    @Override
    public int deleteByUserIdFromUser(Integer userId){
        return userMapper.deleteByUserIdFromUser(userId);
    }

    @Override
    public User selectAllUserByOpenid(String userOpenid){
        User user = userMapper.selectAllUserByOpenid(userOpenid);
        System.out.println("UserServiceImpl的selectAllUserByOpenid的方法的返回值users ： " + user);
        return user;
    }


    @Override
    public int insertUser(User user) {
        System.out.println("UserServiceImpl的insertUser方法执行了");
        System.out.println("userMapper : " + userMapper);
        int i = userMapper.insertUser(user);
        System.out.println("UserServiceImpl的insertUser方法的返回值i : " + i);
        return i;
    }

    @Override
    public User selectByOpenId(String openId){
        User user = userMapper.selectByOpenId(openId);
        return user;
    }
}
