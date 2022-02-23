package com.zln.competition.service.impl;

import com.zln.competition.bean.UserClickRecommend;
import com.zln.competition.mapper.UserClickRecommendMapper;
import com.zln.competition.service.UserClickRecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserClickRecommendServiceImpl implements UserClickRecommendService {
    @Resource
    UserClickRecommendMapper userClickRecommendMapper;

    @Override
    public int deleteByPrimaryKey(Integer clickId) {
        return userClickRecommendMapper.deleteByPrimaryKey(clickId);
    }

    @Override
    public int insert(UserClickRecommend record) {
        return userClickRecommendMapper.insert(record);
    }

    @Override
    public int insertSelective(UserClickRecommend record) {
        return userClickRecommendMapper.insertSelective(record);
    }

    @Override
    public UserClickRecommend selectByPrimaryKey(Integer clickId) {
        return userClickRecommendMapper.selectByPrimaryKey(clickId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserClickRecommend record) {
        return userClickRecommendMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserClickRecommend record) {
        return userClickRecommendMapper.updateByPrimaryKey(record);
    }

    @Override
    public UserClickRecommend selectByOpenId(String userOpenid) {
        return userClickRecommendMapper.selectByOpenId(userOpenid);
    }

    @Override
    public UserClickRecommend selectByOpenIdAndRecId(String userOpenid, Integer recId, String date) {
        return userClickRecommendMapper.selectByOpenIdAndRecId(userOpenid,recId,date);
    }
}
