/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

/**
 * @author VinhNT
 */
public class BiddingHistory {

    private int id;
    private String date;
    private long money;
    private int rank;
    private int status;
    private String biddingOrderCode;
    private String customerAccountId;
    private String customerName;

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBiddingOrderCode() {
        return biddingOrderCode;
    }

    public void setBiddingOrderCode(String biddingOrderCode) {
        this.biddingOrderCode = biddingOrderCode;
    }

    public String getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(String customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String cusstomerName) {
        this.customerName = cusstomerName;
    }


}
