package com.zln.competition.bean;

public class Winners {
    private Integer winId;

    private String winName;

    private String winImg;

    private String winQq;

    private Integer winNum;

    private String winRec;

    private String winIntroduce;

    private Integer winBrowse;

    private Integer winLike;

    private String winImg1;

    private String winImg2;

    private String winImg3;

    private String winImg4;

    private Integer comId;

    public Winners(Integer winId, String winName, String winImg, String winQq, Integer winNum, String winRec, String winIntroduce, Integer winBrowse, Integer winLike, String winImg1, String winImg2, String winImg3, String winImg4, Integer comId) {
        this.winId = winId;
        this.winName = winName;
        this.winImg = winImg;
        this.winQq = winQq;
        this.winNum = winNum;
        this.winRec = winRec;
        this.winIntroduce = winIntroduce;
        this.winBrowse = winBrowse;
        this.winLike = winLike;
        this.winImg1 = winImg1;
        this.winImg2 = winImg2;
        this.winImg3 = winImg3;
        this.winImg4 = winImg4;
        this.comId = comId;
    }

    public Winners() {
        super();
    }

    public Integer getWinId() {
        return winId;
    }

    public void setWinId(Integer winId) {
        this.winId = winId;
    }

    public String getWinName() {
        return winName;
    }

    public void setWinName(String winName) {
        this.winName = winName == null ? null : winName.trim();
    }

    public String getWinImg() {
        return winImg;
    }

    public void setWinImg(String winImg) {
        this.winImg = winImg == null ? null : winImg.trim();
    }

    public String getWinQq() {
        return winQq;
    }

    public void setWinQq(String winQq) {
        this.winQq = winQq == null ? null : winQq.trim();
    }

    public Integer getWinNum() {
        return winNum;
    }

    public void setWinNum(Integer winNum) {
        this.winNum = winNum;
    }

    public String getWinRec() {
        return winRec;
    }

    public void setWinRec(String winRec) {
        this.winRec = winRec == null ? null : winRec.trim();
    }

    public String getWinIntroduce() {
        return winIntroduce;
    }

    public void setWinIntroduce(String winIntroduce) {
        this.winIntroduce = winIntroduce == null ? null : winIntroduce.trim();
    }

    public Integer getWinBrowse() {
        return winBrowse;
    }

    public void setWinBrowse(Integer winBrowse) {
        this.winBrowse = winBrowse;
    }

    public Integer getWinLike() {
        return winLike;
    }

    public void setWinLike(Integer winLike) {
        this.winLike = winLike;
    }

    public String getWinImg1() {
        return winImg1;
    }

    public void setWinImg1(String winImg1) {
        this.winImg1 = winImg1 == null ? null : winImg1.trim();
    }

    public String getWinImg2() {
        return winImg2;
    }

    public void setWinImg2(String winImg2) {
        this.winImg2 = winImg2 == null ? null : winImg2.trim();
    }

    public String getWinImg3() {
        return winImg3;
    }

    public void setWinImg3(String winImg3) {
        this.winImg3 = winImg3 == null ? null : winImg3.trim();
    }

    public String getWinImg4() {
        return winImg4;
    }

    public void setWinImg4(String winImg4) {
        this.winImg4 = winImg4 == null ? null : winImg4.trim();
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }
}