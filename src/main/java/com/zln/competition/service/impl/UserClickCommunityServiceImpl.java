package com.zln.competition.service.impl;

import com.zln.competition.bean.UserClickCommunity;
import com.zln.competition.mapper.UserClickCommunityMapper;
import com.zln.competition.service.UserClickCommunityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserClickCommunityServiceImpl implements UserClickCommunityService {
    @Resource
    UserClickCommunityMapper userClickCommunityMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userClickCommunityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserClickCommunity record) {
        return userClickCommunityMapper.insert(record);
    }

    @Override
    public int insertSelective(UserClickCommunity record) {
        return userClickCommunityMapper.insertSelective(record);
    }

    @Override
    public UserClickCommunity selectByPrimaryKey(Integer id) {
        return userClickCommunityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserClickCommunity record) {
        return userClickCommunityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserClickCommunity record) {
        return userClickCommunityMapper.updateByPrimaryKey(record);
    }

    @Override
    public UserClickCommunity selectByOpenId(String userOpenid) {
        return userClickCommunityMapper.selectByOpenId(userOpenid);
    }

    @Override
    public UserClickCommunity selectByOpenIdAndComId(String userOpenid, Integer communityId) {
        return userClickCommunityMapper.selectByOpenIdAndComId(userOpenid,communityId);
    }

}
