package com.zln.competition.mapper;

import com.zln.competition.bean.UserClickCommunity;
import com.zln.competition.bean.UserClickRecommend;

public interface UserClickCommunityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserClickCommunity record);

    int insertSelective(UserClickCommunity record);

    UserClickCommunity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserClickCommunity record);

    int updateByPrimaryKey(UserClickCommunity record);

    UserClickCommunity selectByOpenId(String userOpenid);

    UserClickCommunity selectByOpenIdAndComId(String userOpenid, Integer communityId);

}