package com.zln.competition.bean;

public class Users {
    private Integer userId;

    private String userOpenid;

    private Integer userPay;

    private String nickName;

    private String avatarUrl;


    public String getNickName() {
        return nickName;
    }

    public Users(Integer userId, String userOpenid, Integer userPay, String nickName, String avatarUrl) {
        this.userId = userId;
        this.userOpenid = userOpenid;
        this.userPay = userPay;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
    }


    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }



    public Users(Integer userId, String userOpenid, Integer userPay) {
        this.userId = userId;
        this.userOpenid = userOpenid;
        this.userPay = userPay;
    }

    public Users() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid == null ? null : userOpenid.trim();
    }

    public Integer getUserPay() {
        return userPay;
    }

    public void setUserPay(Integer userPay) {
        this.userPay = userPay;
    }

    @Override
    public String  toString() {
        return "Users{" +
                "userId=" + userId +
                ", userOpenid='" + userOpenid + '\'' +
                ", userPay=" + userPay +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}