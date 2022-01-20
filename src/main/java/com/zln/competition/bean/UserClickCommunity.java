package com.zln.competition.bean;

import java.util.Date;

public class UserClickCommunity {
    private Integer id;

    private String openid;

    private String date;



    private Integer communityId;

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "UserClickCommunity{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", date=" + date +
                ", communityId=" + communityId +
                ", number=" + number +
                '}';
    }

    public UserClickCommunity(Integer id, String openid, String date, Integer communityId, Integer number) {
        this.id = id;
        this.openid = openid;
        this.date = date;
        this.communityId = communityId;
        this.number = number;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public UserClickCommunity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}