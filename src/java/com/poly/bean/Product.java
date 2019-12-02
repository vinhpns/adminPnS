/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {

    private int id;
    private Boolean accApproved;
    private Boolean active;
    private String area;
    private Boolean auction;
    private Date createdTime;
    private String description;
    private Boolean hrApproved;
    private Boolean itApproved;
    private Boolean modApproved;
    private String name;
    private String origin;
    private int postedCount;
    private long price;
    private Boolean sale;
    private String state;
    private Boolean vip;
    private String warranty;
    private Boolean writerApproved;
    private int brandId;
    private int categoryId;
    private String postedAccountId;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Boolean getAuction() {
        return auction;
    }

    public void setAuction(Boolean auction) {
        this.auction = auction;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getItApproved() {
        return itApproved;
    }

    public void setItApproved(Boolean itApproved) {
        this.itApproved = itApproved;
    }

    public Boolean getModApproved() {
        return modApproved;
    }

    public void setModApproved(Boolean modApproved) {
        this.modApproved = modApproved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPostedCount() {
        return postedCount;
    }

    public void setPostedCount(int postedCount) {
        this.postedCount = postedCount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Boolean getSale() {
        return sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Boolean getWriterApproved() {
        return writerApproved;
    }

    public void setWriterApproved(Boolean writerApproved) {
        this.writerApproved = writerApproved;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getPostedAccountId() {
        return postedAccountId;
    }

    public void setPostedAccountId(String postedAccountId) {
        this.postedAccountId = postedAccountId;
    }

    public Boolean getAccApproved() {
        return accApproved;
    }

    public void setAccApproved(Boolean accApproved) {
        this.accApproved = accApproved;
    }

    public Boolean getHrApproved() {
        return hrApproved;
    }

    public void setHrApproved(Boolean hrApproved) {
        this.hrApproved = hrApproved;
    }

}
