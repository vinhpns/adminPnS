/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

/**
 *
 * @author Kiet
 */
public class SellingProduct {

    private String orderCode;
    private Boolean expired;
    private long maxMoney;
    private int productId;

    public SellingProduct() {

    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public long getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(long maxMoney) {
        this.maxMoney = maxMoney;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
