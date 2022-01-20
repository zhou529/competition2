package com.zln.competition.bean;

public class PayStore {
    private Integer productId;

    private String productName;

    private Integer exchangedPay;


    private String productImg;

    private Integer exchangeNumber;

    public PayStore() {
    }



    @Override
    public String toString() {
        return "PayStore{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", exchangedPay=" + exchangedPay +
                ", productImg='" + productImg + '\'' +
                ", exchangeNumber=" + exchangeNumber +
                '}';
    }
    public PayStore(Integer productId, String productName, Integer exchangedPay, String productImg, Integer exchangeNumber) {
        this.productId = productId;
        this.productName = productName;
        this.exchangedPay = exchangedPay;
        this.productImg = productImg;
        this.exchangeNumber = exchangeNumber;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getExchangedPay() {
        return exchangedPay;
    }

    public void setExchangedPay(Integer exchangedPay) {
        this.exchangedPay = exchangedPay;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Integer getExchangeNumber() {
        return exchangeNumber;
    }

    public void setExchangeNumber(Integer exchangeNumber) {
        this.exchangeNumber = exchangeNumber;
    }
}
