/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.request;

/**
 *
 * @author SGDG Company
 */
public class BiddingResponse {
    private String name;
    private String orderCode;
    private String maxMoney;
    private Boolean vip;
    
    public BiddingResponse() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(String maxMoney) {
        this.maxMoney = maxMoney;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }
    
    
}
