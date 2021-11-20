package com.zln.competition.bean;

public class ComAdmin {
    private String comUsername;

    private Integer comId;

    private String comUserpwd;

    private Integer comOrder;

    private Integer comIs;

    private Integer comDel;

    private String comTime;

    private String comName;

    public ComAdmin(String comUsername, Integer comId, String comUserpwd, Integer comOrder, Integer comIs, Integer comDel, String comTime, String comName) {
        this.comUsername = comUsername;
        this.comId = comId;
        this.comUserpwd = comUserpwd;
        this.comOrder = comOrder;
        this.comIs = comIs;
        this.comDel = comDel;
        this.comTime = comTime;
        this.comName = comName;
    }

    public ComAdmin() {
        super();
    }

    public String getComUsername() {
        return comUsername;
    }

    public void setComUsername(String comUsername) {
        this.comUsername = comUsername == null ? null : comUsername.trim();
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComUserpwd() {
        return comUserpwd;
    }

    public void setComUserpwd(String comUserpwd) {
        this.comUserpwd = comUserpwd == null ? null : comUserpwd.trim();
    }

    public Integer getComOrder() {
        return comOrder;
    }

    public void setComOrder(Integer comOrder) {
        this.comOrder = comOrder;
    }

    public Integer getComIs() {
        return comIs;
    }

    public void setComIs(Integer comIs) {
        this.comIs = comIs;
    }

    public Integer getComDel() {
        return comDel;
    }

    public void setComDel(Integer comDel) {
        this.comDel = comDel;
    }

    public String getComTime() {
        return comTime;
    }

    public void setComTime(String comTime) {
        this.comTime = comTime;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    @Override
    public String toString() {
        return "ComAdmin{" +
                "comUsername='" + comUsername + '\'' +
                ", comId=" + comId +
                ", comUserpwd='" + comUserpwd + '\'' +
                ", comOrder=" + comOrder +
                ", comIs=" + comIs +
                ", comDel=" + comDel +
                ", comTime='" + comTime + '\'' +
                ", comName='" + comName + '\'' +
                '}';
    }
}