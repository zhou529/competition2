package com.zln.competition.mapper;

import com.zln.competition.bean.UserClickRecommend;

public interface UserClickRecommendMapper {
    int deleteByPrimaryKey(Integer clickId);

    int insert(UserClickRecommend record);

    int insertSelective(UserClickRecommend record);

    UserClickRecommend selectByPrimaryKey(Integer clickId);

    UserClickRecommend selectByOpenId(String userOpenid);

    int updateByPrimaryKeySelective(UserClickRecommend record);

    int updateByPrimaryKey(UserClickRecommend record);

    UserClickRecommend selectByOpenIdAndRecId(String userOpenid, Integer recId, String date);
}