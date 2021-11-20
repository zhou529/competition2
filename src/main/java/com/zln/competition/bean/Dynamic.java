package com.zln.competition.bean;

public class Dynamic {
    private Integer dynId;

    private String dynTitle;

    private String dynInformation;

    private String dynImg1;

    private String dynImg2;

    private Integer comId;

    private Integer dynIs;

    public Dynamic(Integer dynId, String dynTitle, String dynInformation, String dynImg1, String dynImg2, Integer comId, Integer dynIs) {
        this.dynId = dynId;
        this.dynTitle = dynTitle;
        this.dynInformation = dynInformation;
        this.dynImg1 = dynImg1;
        this.dynImg2 = dynImg2;
        this.comId = comId;
        this.dynIs = dynIs;
    }

    public Dynamic() {
        super();
    }

    public Integer getDynId() {
        return dynId;
    }

    public void setDynId(Integer dynId) {
        this.dynId = dynId;
    }

    public String getDynTitle() {
        return dynTitle;
    }

    public void setDynTitle(String dynTitle) {
        this.dynTitle = dynTitle == null ? null : dynTitle.trim();
    }

    public String getDynInformation() {
        return dynInformation;
    }

    public void setDynInformation(String dynInformation) {
        this.dynInformation = dynInformation == null ? null : dynInformation.trim();
    }

    public String getDynImg1() {
        return dynImg1;
    }

    public void setDynImg1(String dynImg1) {
        this.dynImg1 = dynImg1 == null ? null : dynImg1.trim();
    }

    public String getDynImg2() {
        return dynImg2;
    }

    public void setDynImg2(String dynImg2) {
        this.dynImg2 = dynImg2 == null ? null : dynImg2.trim();
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getDynIs() {
        return dynIs;
    }

    public void setDynIs(Integer dynIs) {
        this.dynIs = dynIs;
    }

    @Override
    public String toString() {
        return "Dynamic{" +
                "dynId=" + dynId +
                ", dynTitle='" + dynTitle + '\'' +
                ", dynInformation='" + dynInformation + '\'' +
                ", dynImg1='" + dynImg1 + '\'' +
                ", dynImg2='" + dynImg2 + '\'' +
                ", comId=" + comId +
                ", dynIs=" + dynIs +
                '}';
    }
}