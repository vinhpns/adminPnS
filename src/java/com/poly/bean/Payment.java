/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

/**
 * @author tobias
 */
public class Payment {

    private int id;
    private String bankTransaction;
    private int method;
    private long money;
    private int paid;
    private String paidTime;
    private int purpose;
    private String customerAccountId;
    private String biddingOrderCode;
    private String fullName;

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankTransaction() {
        return bankTransaction;
    }

    public void setBankTransaction(String bankTransaction) {
        this.bankTransaction = bankTransaction;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
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

    public String getBiddingOrderCode() {
        return biddingOrderCode;
    }

    public void setBiddingOrderCode(String biddingOrderCode) {
        this.biddingOrderCode = biddingOrderCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
