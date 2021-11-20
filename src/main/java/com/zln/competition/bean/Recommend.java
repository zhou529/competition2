package com.zln.competition.bean;

import java.util.List;

public class Recommend {
    private Integer recId;

    private String recName;

    private String recBegintime;

    private String recEndtime;

    private String recOrganizer;

    private Integer recBrowse;

    private Integer recCare;

    private String recInformation;

    private String recImg;

    private Integer recLike;

    private String recTime;

    private Integer recIs;

    private Integer comId;

    private List<Community> community;

    public Recommend() {
        super();
    }

    public Recommend(Integer recId, String recName, String recBegintime, String recEndtime, String recOrganizer, Integer recBrowse, Integer recCare, String recInformation, String recImg, Integer recLike, String recTime, Integer recIs, Integer comId, List<Community> community) {
        this.recId = recId;
        this.recName = recName;
        this.recBegintime = recBegintime;
        this.recEndtime = recEndtime;
        this.recOrganizer = recOrganizer;
        this.recBrowse = recBrowse;
        this.recCare = recCare;
        this.recInformation = recInformation;
        this.recImg = recImg;
        this.recLike = recLike;
        this.recTime = recTime;
        this.recIs = recIs;
        this.comId = comId;
        this.community = community;
    }

    public List<Community> getCommunity() {
        return community;
    }

    public void setCommunity(List<Community> community) {
        this.community = community;
    }


    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName == null ? null : recName.trim();
    }

    public String getRecBegintime() {
        return recBegintime;
    }

    public void setRecBegintime(String recBegintime) {
        this.recBegintime = recBegintime == null ? null : recBegintime.trim();
    }

    public String getRecEndtime() {
        return recEndtime;
    }

    public void setRecEndtime(String recEndtime) {
        this.recEndtime = recEndtime == null ? null : recEndtime.trim();
    }

    public String getRecOrganizer() {
        return recOrganizer;
    }

    public void setRecOrganizer(String recOrganizer) {
        this.recOrganizer = recOrganizer == null ? null : recOrganizer.trim();
    }

    public Integer getRecBrowse() {
        return recBrowse;
    }

    public void setRecBrowse(Integer recBrowse) {
        this.recBrowse = recBrowse;
    }

    public Integer getRecCare() {
        return recCare;
    }

    public void setRecCare(Integer recCare) {
        this.recCare = recCare;
    }

    public String getRecInformation() {
        return recInformation;
    }

    public void setRecInformation(String recInformation) {
        this.recInformation = recInformation == null ? null : recInformation.trim();
    }

    public String getRecImg() {
        return recImg;
    }

    public void setRecImg(String recImg) {
        this.recImg = recImg == null ? null : recImg.trim();
    }

    public Integer getRecLike() {
        return recLike;
    }

    public void setRecLike(Integer recLike) {
        this.recLike = recLike;
    }

    public String getRecTime() {
        return recTime;
    }

    public void setRecTime(String recTime) {
        this.recTime = recTime == null ? null : recTime.trim();
    }

    public Integer getRecIs() {
        return recIs;
    }

    public void setRecIs(Integer recIs) {
        this.recIs = recIs;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "recId=" + recId +
                ", recName='" + recName + '\'' +
                ", recBegintime='" + recBegintime + '\'' +
                ", recEndtime='" + recEndtime + '\'' +
                ", recOrganizer='" + recOrganizer + '\'' +
                ", recBrowse=" + recBrowse +
                ", recCare=" + recCare +
                ", recInformation='" + recInformation + '\'' +
                ", recImg='" + recImg + '\'' +
                ", recLike=" + recLike +
                ", recTime='" + recTime + '\'' +
                ", recIs=" + recIs +
                ", comId=" + comId +
                ", community=" + community +
                '}';
    }
}