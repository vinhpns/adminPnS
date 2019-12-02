/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

/**
 * @author phong
 */
public class Refund {

    private int id;
    private String date;
    private long money;
    private Boolean paid;
    private int purpose;
    private String customerAccountId;
    private String fullName;
    private String biddingOrderCode;

    public Refund() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public int getPurpose() {
        return purpose;
    }

    public void setPurpose(int purpose) {
        this.purpose = purpose;
    }

    public String getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(String customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBiddingOrderCode() {
        return biddingOrderCode;
    }

    public void setBiddingOrderCode(String biddingOrderCode) {
        this.biddingOrderCode = biddingOrderCode;
    }

}
