package com.zln.competition.service;

import com.zln.competition.bean.UserClickCommunity;

public interface UserClickCommunityService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserClickCommunity record);

    int insertSelective(UserClickCommunity record);

    UserClickCommunity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserClickCommunity record);

    int updateByPrimaryKey(UserClickCommunity record);

    UserClickCommunity selectByOpenId(String userOpenid);

    UserClickCommunity selectByOpenIdAndComId(String userOpenid, Integer communityId);

}
