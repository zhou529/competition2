package com.zln.competition.mapper;

import com.zln.competition.bean.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    List<UserInfo> selectAllUserInfo();

    int deleteByUserId(Integer userId);

    int insertUSerInfo(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectUserByLikeNameOrPhone(String nameOrPhone);

    UserInfo selectByPrimaryKey(Integer userId);

    UserInfo selectByOpenId(String userOpenid);

    int updateUserInfoByUserId(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}