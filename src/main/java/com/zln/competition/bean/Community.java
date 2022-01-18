package com.zln.competition.bean;

public class Community {
    private Integer comId;

    private Integer click_number;

    private String comInformation;

    private String comWin;

    private String comWinimg;

    private String comImg;

    private String comQq;

    private String comName;

    public Community(Integer comId, Integer click_number, String comInformation, String comWin, String comWinimg, String comImg, String comQq, String comName) {
        this.comId = comId;
        this.click_number = click_number;
        this.comInformation = comInformation;
        this.comWin = comWin;
        this.comWinimg = comWinimg;
        this.comImg = comImg;
        this.comQq = comQq;
        this.comName = comName;
    }

    public Community() {
        super();
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComInformation() {
        return comInformation;
    }

    public void setComInformation(String comInformation) {
        this.comInformation = comInformation == null ? null : comInformation.trim();
    }


    public Integer getClick_number() {
        return click_number;
    }

    public void setClick_number(Integer click_number) {
        this.click_number = click_number;
    }
    public String getComWin() {
        return comWin;
    }

    public void setComWin(String comWin) {
        this.comWin = comWin == null ? null : comWin.trim();
    }

    public String getComWinimg() {
        return comWinimg;
    }

    public void setComWinimg(String comWinimg) {
        this.comWinimg = comWinimg == null ? null : comWinimg.trim();
    }

    public String getComImg() {
        return comImg;
    }

    public void setComImg(String comImg) {
        this.comImg = comImg == null ? null : comImg.trim();
    }

    public String getComQq() {
        return comQq;
    }

    public void setComQq(String comQq) {
        this.comQq = comQq == null ? null : comQq.trim();
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    @Override
    public String toString() {
        return "Community{" +
                "comId=" + comId +
                ", click_number=" + click_number +
                ", comInformation='" + comInformation + '\'' +
                ", comWin='" + comWin + '\'' +
                ", comWinimg='" + comWinimg + '\'' +
                ", comImg='" + comImg + '\'' +
                ", comQq='" + comQq + '\'' +
                ", comName='" + comName + '\'' +
                '}';
    }
}