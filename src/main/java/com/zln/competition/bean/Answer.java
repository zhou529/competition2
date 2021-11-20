package com.zln.competition.bean;

public class Answer {
    private Integer ansId;

    private String ansTitle;

    private String ansInformation;

    private String ansQq;

    private String ansTime;

    private Integer ansPay;

    private String ansImg1;

    private String ansImg2;

    private String ansImg3;

    private String ansImg4;

    private String ansImg5;

    private Integer userId;

    private Integer ansIs;

    private Integer ansOverhead;

    @Override
    public String toString() {
        return "Answer{" +
                "ansId=" + ansId +
                ", ansTitle='" + ansTitle + '\'' +
                ", ansInformation='" + ansInformation + '\'' +
                ", ansQq='" + ansQq + '\'' +
                ", ansTime='" + ansTime + '\'' +
                ", ansPay=" + ansPay +
                ", ansImg1='" + ansImg1 + '\'' +
                ", ansImg2='" + ansImg2 + '\'' +
                ", ansImg3='" + ansImg3 + '\'' +
                ", ansImg4='" + ansImg4 + '\'' +
                ", ansImg5='" + ansImg5 + '\'' +
                ", userId=" + userId +
                ", ansIs=" + ansIs +
                ", ansOverhead=" + ansOverhead +
                '}';
    }

    public Answer(Integer ansId, String ansTitle, String ansInformation, String ansQq, String ansTime, Integer ansPay, String ansImg1, String ansImg2, String ansImg3, String ansImg4, String ansImg5, Integer userId, Integer ansIs, Integer ansOverhead) {
        this.ansId = ansId;
        this.ansTitle = ansTitle;
        this.ansInformation = ansInformation;
        this.ansQq = ansQq;
        this.ansTime = ansTime;
        this.ansPay = ansPay;
        this.ansImg1 = ansImg1;
        this.ansImg2 = ansImg2;
        this.ansImg3 = ansImg3;
        this.ansImg4 = ansImg4;
        this.ansImg5 = ansImg5;
        this.userId = userId;
        this.ansIs = ansIs;
        this.ansOverhead = ansOverhead;
    }

    public Answer() {
    }

    public Integer getAnsId() {
        return ansId;
    }

    public void setAnsId(Integer ansId) {
        this.ansId = ansId;
    }

    public String getAnsTitle() {
        return ansTitle;
    }

    public void setAnsTitle(String ansTitle) {
        this.ansTitle = ansTitle;
    }

    public String getAnsInformation() {
        return ansInformation;
    }

    public void setAnsInformation(String ansInformation) {
        this.ansInformation = ansInformation;
    }

    public String getAnsQq() {
        return ansQq;
    }

    public void setAnsQq(String ansQq) {
        this.ansQq = ansQq;
    }

    public String getAnsTime() {
        return ansTime;
    }

    public void setAnsTime(String ansTime) {
        this.ansTime = ansTime;
    }

    public Integer getAnsPay() {
        return ansPay;
    }

    public void setAnsPay(Integer ansPay) {
        this.ansPay = ansPay;
    }

    public String getAnsImg1() {
        return ansImg1;
    }

    public void setAnsImg1(String ansImg1) {
        this.ansImg1 = ansImg1;
    }

    public String getAnsImg2() {
        return ansImg2;
    }

    public void setAnsImg2(String ansImg2) {
        this.ansImg2 = ansImg2;
    }

    public String getAnsImg3() {
        return ansImg3;
    }

    public void setAnsImg3(String ansImg3) {
        this.ansImg3 = ansImg3;
    }

    public String getAnsImg4() {
        return ansImg4;
    }

    public void setAnsImg4(String ansImg4) {
        this.ansImg4 = ansImg4;
    }

    public String getAnsImg5() {
        return ansImg5;
    }

    public void setAnsImg5(String ansImg5) {
        this.ansImg5 = ansImg5;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAnsIs() {
        return ansIs;
    }

    public void setAnsIs(Integer ansIs) {
        this.ansIs = ansIs;
    }

    public Integer getAnsOverhead() {
        return ansOverhead;
    }

    public void setAnsOverhead(Integer ansOverhead) {
        this.ansOverhead = ansOverhead;
    }
}
