package com.zln.competition.service;

import com.zln.competition.bean.UserClickRecommend;

public interface UserClickRecommendService {
    int deleteByPrimaryKey(Integer clickId);

    int insert(UserClickRecommend record);

    int insertSelective(UserClickRecommend record);

    UserClickRecommend selectByPrimaryKey(Integer clickId);

    int updateByPrimaryKeySelective(UserClickRecommend record);

    int updateByPrimaryKey(UserClickRecommend record);

    UserClickRecommend selectByOpenId(String userOpenid);

    UserClickRecommend selectByOpenIdAndRecId(String userOpenid, Integer recId, String date);
}
