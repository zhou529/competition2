package com.zln.competition.bean;

public class Ans_user{
    private Integer replyId;

    private Integer ansId;

    private Integer userId;

    private String replyInformation;

    private String replyImg1;

    private String replyImg2;

    private String replyImg3;

    private Integer replyIs;

    private String publishTime;

    @Override
    public String toString() {
        return "Ans_user{" +
                "replyId=" + replyId +
                ", ansId=" + ansId +
                ", userId=" + userId +
                ", replyInformation='" + replyInformation + '\'' +
                ", replyImg1='" + replyImg1 + '\'' +
                ", replyImg2='" + replyImg2 + '\'' +
                ", replyImg3='" + replyImg3 + '\'' +
                ", replyIs=" + replyIs +
                ", publishTime='" + publishTime + '\'' +
                '}';
    }

    public Ans_user() {
    }

    public Ans_user(Integer replyId, Integer ansId, Integer userId, String replyInformation, String replyImg1, String replyImg2, String replyImg3, Integer replyIs, String publishTime) {
        this.replyId = replyId;
        this.ansId = ansId;
        this.userId = userId;
        this.replyInformation = replyInformation;
        this.replyImg1 = replyImg1;
        this.replyImg2 = replyImg2;
        this.replyImg3 = replyImg3;
        this.replyIs = replyIs;
        this.publishTime = publishTime;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getAnsId() {
        return ansId;
    }

    public void setAnsId(Integer ansId) {
        this.ansId = ansId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReplyInformation() {
        return replyInformation;
    }

    public void setReplyInformation(String replyInformation) {
        this.replyInformation = replyInformation;
    }

    public String getReplyImg1() {
        return replyImg1;
    }

    public void setReplyImg1(String replyImg1) {
        this.replyImg1 = replyImg1;
    }

    public String getReplyImg2() {
        return replyImg2;
    }

    public void setReplyImg2(String replyImg2) {
        this.replyImg2 = replyImg2;
    }

    public String getReplyImg3() {
        return replyImg3;
    }

    public void setReplyImg3(String replyImg3) {
        this.replyImg3 = replyImg3;
    }

    public Integer getReplyIs() {
        return replyIs;
    }

    public void setReplyIs(Integer replyIs) {
        this.replyIs = replyIs;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}