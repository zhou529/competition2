package com.zln.competition.bean;

import java.util.List;

public class Recommend {
    private Integer recId;

    private String recName;

    private String recBegintime;

    private String recEndtime;

    private String recOrganizer;

    private Integer recBrowse;

    private String recInformation;

    private String recImg;

    private String recTime;

    private Integer comId;

    private Integer tagId;

    private List<Community> community;

    @Override
    public String toString() {
        return "Recommend{" +
                "recId=" + recId +
                ", recName='" + recName + '\'' +
                ", recBegintime='" + recBegintime + '\'' +
                ", recEndtime='" + recEndtime + '\'' +
                ", recOrganizer='" + recOrganizer + '\'' +
                ", recBrowse=" + recBrowse +
                ", recInformation='" + recInformation + '\'' +
                ", recImg='" + recImg + '\'' +
                ", recTime='" + recTime + '\'' +
                ", comId=" + comId +
                ", community=" + community +
                ", tagId=" + tagId +
                '}';
    }

    public Recommend(Integer recId, String recName, String recBegintime, String recEndtime, String recOrganizer, Integer recBrowse, String recInformation, String recImg, String recTime, Integer comId, List<Community> community, Integer tagId) {
        this.recId = recId;
        this.recName = recName;
        this.recBegintime = recBegintime;
        this.recEndtime = recEndtime;
        this.recOrganizer = recOrganizer;
        this.recBrowse = recBrowse;
        this.recInformation = recInformation;
        this.recImg = recImg;
        this.recTime = recTime;
        this.comId = comId;
        this.community = community;
        this.tagId = tagId;
    }

    public Recommend() {
        super();
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
        this.recName = recName;
    }

    public String getRecBegintime() {
        return recBegintime;
    }

    public void setRecBegintime(String recBegintime) {
        this.recBegintime = recBegintime;
    }

    public String getRecEndtime() {
        return recEndtime;
    }

    public void setRecEndtime(String recEndtime) {
        this.recEndtime = recEndtime;
    }

    public String getRecOrganizer() {
        return recOrganizer;
    }

    public void setRecOrganizer(String recOrganizer) {
        this.recOrganizer = recOrganizer;
    }

    public Integer getRecBrowse() {
        return recBrowse;
    }

    public void setRecBrowse(Integer recBrowse) {
        this.recBrowse = recBrowse;
    }

    public String getRecInformation() {
        return recInformation;
    }

    public void setRecInformation(String recInformation) {
        this.recInformation = recInformation;
    }

    public String getRecImg() {
        return recImg;
    }

    public void setRecImg(String recImg) {
        this.recImg = recImg;
    }

    public String getRecTime() {
        return recTime;
    }

    public void setRecTime(String recTime) {
        this.recTime = recTime;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public List<Community> getCommunity() {
        return community;
    }

    public void setCommunity(List<Community> community) {
        this.community = community;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}