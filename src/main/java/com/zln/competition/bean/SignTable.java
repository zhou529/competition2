package com.zln.competition.bean;

public class SignTable {
    private Integer signId;

    private String userOpenid;

    private Integer year;

    private Integer month;

    private Integer day;

    private Integer user_pay;

    public Integer getUser_pay() {
        return user_pay;
    }

    public void setUser_pay(Integer user_pay) {
        this.user_pay = user_pay;
    }

    public SignTable(Integer signId, String userOpenid, Integer year, Integer month, Integer day, Integer user_pay) {
        this.signId = signId;
        this.userOpenid = userOpenid;
        this.year = year;
        this.month = month;
        this.day = day;
        this.user_pay = user_pay;
    }

    public SignTable() {
        super();
    }

    public Integer getSignId() {
        return signId;
    }

    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid == null ? null : userOpenid.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "SignTable{" +
                "signId=" + signId +
                ", userOpenid='" + userOpenid + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", user_pay=" + user_pay +
                '}';
    }
}
