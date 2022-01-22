package com.zln.competition.service.impl;

import com.zln.competition.bean.UserInfo;
import com.zln.competition.mapper.UserInfoMapper;
import com.zln.competition.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectAllUserInfo(){
        List<UserInfo> userInfos = userInfoMapper.selectAllUserInfo();
        return userInfos;
    }

    @Override
    public int deleteByUserId(Integer userId) {
        return userInfoMapper.deleteByUserId(userId);
    }

    @Override
    public int insertUSerInfo(UserInfo record){
        return userInfoMapper.insertUSerInfo(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return 0;
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer userId) {
        return null;
    }

    @Override
    public List<UserInfo> selectUserByLikeNameOrPhone(String nameOrPhone) {
        return userInfoMapper.selectUserByLikeNameOrPhone(nameOrPhone);
    }

    @Override
    public int updateUserInfoByUserId(UserInfo record){
        return userInfoMapper.updateUserInfoByUserId(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return 0;
    }

    @Override
    public UserInfo selectByOpenId(String userOpenid) {
        return userInfoMapper.selectByOpenId(userOpenid);
    }

}
