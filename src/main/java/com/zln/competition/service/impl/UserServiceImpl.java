package com.zln.competition.service.impl;

import com.zln.competition.bean.Users;
import com.zln.competition.mapper.UserMapper;
import com.zln.competition.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public int updateByOpenid(Users record){
        return userMapper.updateByOpenid(record);
    }

    @Override
    public Users individualRank(Integer userId) {
        return userMapper.individualRank(userId);
    }

    @Override
    public int updateNickNameAndAvatarUrl(String nickName, String avatarUrl, String userOpenid) {
        return userMapper.updateNickNameAndAvatarUrl(nickName,avatarUrl, userOpenid);
    }

    @Override
    public int deleteByUserIdFromUser(Integer userId){
        return userMapper.deleteByUserIdFromUser(userId);
    }

    @Override
    public Users selectAllUserByOpenid(String userOpenid){
        Users user = userMapper.selectAllUserByOpenid(userOpenid);
        System.out.println("UserServiceImpl的selectAllUserByOpenid的方法的返回值users ： " + user);
        return user;
    }


    @Override
    public int insertUser(Users user) {
        System.out.println("UserServiceImpl的insertUser方法执行了");
        System.out.println("userMapper : " + userMapper);
        int i = userMapper.insertUser(user);
        System.out.println("UserServiceImpl的insertUser方法的返回值i : " + i);
        return i;
    }

    @Override
    public Users selectByOpenId(String openId){
        Users user = userMapper.selectByOpenId(openId);
        return user;
    }
}
