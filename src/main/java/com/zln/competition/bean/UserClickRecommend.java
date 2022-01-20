package com.zln.competition.bean;


public class UserClickRecommend {
    private Integer clickId;

    private String openid;

    private String date;

    private Integer recId;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    private Integer number;

    public UserClickRecommend(Integer clickId, String openid, String date, Integer recId, Integer number) {
        this.clickId = clickId;
        this.openid = openid;
        this.date = date;
        this.recId = recId;
        this.number = number;
    }

    @Override
    public String toString() {
        return "UserClickRecommend{" +
                "clickId=" + clickId +
                ", openid='" + openid + '\'' +
                ", date='" + date + '\'' +
                ", recId='" + recId + '\'' +
                ", number=" + number +
                '}';
    }

    public UserClickRecommend() {
        super();
    }

    public Integer getClickId() {
        return clickId;
    }

    public void setClickId(Integer clickId) {
        this.clickId = clickId;
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

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }
}