package com.zln.competition.bean;

public class Fdback {
    private Integer fdbackId;

    private String fdbackInformation;

    private Integer userId;

    public Fdback(Integer fdbackId, String fdbackInformation, Integer userId) {
        this.fdbackId = fdbackId;
        this.fdbackInformation = fdbackInformation;
        this.userId = userId;
    }

    public Fdback() {
    }

    public Integer getFdbackId() {
        return fdbackId;
    }

    public void setFdbackId(Integer fdbackId) {
        this.fdbackId = fdbackId;
    }

    public String getFdbackInformation() {
        return fdbackInformation;
    }

    public void setFdbackInformation(String fdbackInformation) {
        this.fdbackInformation = fdbackInformation;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}