package com.zln.competition.service;

import com.zln.competition.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> selectAllUserInfo();

    int deleteByUserId(Integer userId);

    int insertUSerInfo(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    List<UserInfo> selectUserByLikeNameOrPhone(String nameOrPhone);

    int updateUserInfoByUserId(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo selectByOpenId(String userOpenid);
}
