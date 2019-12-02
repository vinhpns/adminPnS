/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

/**
 * @author VinhNT
 */
public class Bidding {

    private String orderCode;
    private String endTime;
    private Boolean expired;
    private Boolean finished;
    private long maxMoney;
    private Boolean paid;
    private String startTime;
    private int productId;
    private int roomId;
    private String winnerAccountId;

    public Bidding() {

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

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public long getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(long maxMoney) {
        this.maxMoney = maxMoney;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getWinnerAccountId() {
        return winnerAccountId;
    }

    public void setWinnerAccountId(String winnerAccountId) {
        this.winnerAccountId = winnerAccountId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

}
