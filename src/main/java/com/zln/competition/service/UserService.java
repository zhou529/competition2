package com.zln.competition.service;

import com.zln.competition.bean.Users;

public interface UserService {

    public int insertUser(Users user);

    public Users selectAllUserByOpenid(String userOpenid);

    public Users selectByOpenId(String OpenId);

    public int deleteByUserIdFromUser(Integer userId);

    public int updateByOpenid(Users record);

    Users individualRank(Integer userId);

    int updateNickNameAndAvatarUrl(String nickName, String avatarUrl, String userOpenid);

}
