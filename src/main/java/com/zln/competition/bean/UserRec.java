package com.zln.competition.bean;

public class UserRec {
    private Integer likeIs;

    private Integer careIs;

    private Integer userId;

    private Integer recId;

    public UserRec() {
    }

    public UserRec(Integer likeIs, Integer careIs, Integer userId, Integer recId) {
        this.likeIs = likeIs;
        this.careIs = careIs;
        this.userId = userId;
        this.recId = recId;
    }

    public Integer getLikeIs() {
        return likeIs;
    }

    public void setLikeIs(Integer likeIs) {
        this.likeIs = likeIs;
    }

    public Integer getCareIs() {
        return careIs;
    }

    public void setCareIs(Integer careIs) {
        this.careIs = careIs;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    @Override
    public String toString() {
        return "UserRec{" +
                "likeIs=" + likeIs +
                ", careIs=" + careIs +
                ", userId=" + userId +
                ", recId=" + recId +
                '}';
    }
}
