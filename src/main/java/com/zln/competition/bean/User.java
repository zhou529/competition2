package com.zln.competition.bean;

public class User {
    private Integer userId;

    private String userOpenid;

    private Integer userPay;

    public User(Integer userId, String userOpenid, Integer userPay) {
        this.userId = userId;
        this.userOpenid = userOpenid;
        this.userPay = userPay;
    }

    public User() {
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
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userOpenid='" + userOpenid + '\'' +
                ", userPay=" + userPay +
                '}';
    }
}