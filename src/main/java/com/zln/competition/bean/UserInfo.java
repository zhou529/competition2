package com.zln.competition.bean;

public class UserInfo {
    private Integer userId;

    private String userOpenid;

    private String userPhone;

    private String userSchool;

    private String userMajor;

    private String userStuimg1;

    private String userStuimg2;

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getId_cart() {
        return id_cart;
    }

    public void setId_cart(String id_cart) {
        this.id_cart = id_cart;
    }

    private String username;

    private String stu_id;

    private String id_cart;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserInfo(Integer userId, String userOpenid, String userPhone, String userSchool, String userMajor, String userStuimg1, String userStuimg2, String username, String stu_id, String id_cart) {
        this.userId = userId;
        this.userOpenid = userOpenid;
        this.userPhone = userPhone;
        this.userSchool = userSchool;
        this.userMajor = userMajor;
        this.userStuimg1 = userStuimg1;
        this.userStuimg2 = userStuimg2;
        this.username = username;
        this.stu_id = stu_id;
        this.id_cart = id_cart;
    }

    public UserInfo() {
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool == null ? null : userSchool.trim();
    }

    public String getUserMajor() {
        return userMajor;
    }

    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor == null ? null : userMajor.trim();
    }

    public String getUserStuimg1() {
        return userStuimg1;
    }

    public void setUserStuimg1(String userStuimg1) {
        this.userStuimg1 = userStuimg1 == null ? null : userStuimg1.trim();
    }

    public String getUserStuimg2() {
        return userStuimg2;
    }

    public void setUserStuimg2(String userStuimg2) {
        this.userStuimg2 = userStuimg2 == null ? null : userStuimg2.trim();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userOpenid='" + userOpenid + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userSchool='" + userSchool + '\'' +
                ", userMajor='" + userMajor + '\'' +
                ", userStuimg1='" + userStuimg1 + '\'' +
                ", userStuimg2='" + userStuimg2 + '\'' +
                ", username='" + username + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", id_cart='" + id_cart + '\'' +
                '}';
    }
}