package com.zln.competition.service;

import com.zln.competition.bean.UserClickCommunity;

import java.util.List;

public interface UserClickCommunityService {
    int deleteByPrimaryKey(Integer id);

    List<UserClickCommunity> community_click(Integer communityId);


    int insert(UserClickCommunity record);

    int insertSelective(UserClickCommunity record);

    UserClickCommunity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserClickCommunity record);

    int updateByPrimaryKey(UserClickCommunity record);

    UserClickCommunity selectByOpenId(String userOpenid);

    UserClickCommunity selectByOpenIdAndComId(String userOpenid, Integer communityId, String date);

}
