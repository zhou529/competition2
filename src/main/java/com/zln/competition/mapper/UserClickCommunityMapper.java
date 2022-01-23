package com.zln.competition.mapper;

import com.zln.competition.bean.UserClickCommunity;
import com.zln.competition.bean.UserClickRecommend;

import java.util.List;

public interface UserClickCommunityMapper {

    List<UserClickCommunity> community_click(Integer communityId);

    int deleteByPrimaryKey(Integer id);

    int insert(UserClickCommunity record);

    int insertSelective(UserClickCommunity record);

    UserClickCommunity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserClickCommunity record);

    int updateByPrimaryKey(UserClickCommunity record);

    UserClickCommunity selectByOpenId(String userOpenid);

    UserClickCommunity selectByOpenIdAndComId(String userOpenid, Integer communityId);

}