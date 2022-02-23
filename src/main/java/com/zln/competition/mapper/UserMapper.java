package com.zln.competition.mapper;

import com.zln.competition.bean.Users;

public interface UserMapper {
    public int insertUser(Users user);

    public Users selectAllUserByOpenid(String userOpenid);

    public Users selectByOpenId(String openId);

    int deleteByUserIdFromUser(Integer userId);

    int updateByOpenid(Users record);

    Users individualRank(Integer userId);

    int updateNickNameAndAvatarUrl(String nickName, String avatarUrl, String userOpenid);
}
