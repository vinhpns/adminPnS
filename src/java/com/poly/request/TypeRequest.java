/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.request;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinh1
 */
public class TypeRequest {

    private int id;
    private String title;
    private String titleDescription;
    private String shortTitle;
    private String shortDescription;
    private String reasonOne;
    private String reasonTwo;
    private String reasonThree;
    private String descriptionOne;
    private String descriptionTwo;
    private String descriptionThree;
    private MultipartFile picOne;
    private MultipartFile picTwo;
    private MultipartFile picThree;
    private MultipartFile picMain;
    private String companyId;
    private int type;

    public TypeRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleDescription() {
        return titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getReasonOne() {
        return reasonOne;
    }

    public void setReasonOne(String reasonOne) {
        this.reasonOne = reasonOne;
    }

    public String getReasonTwo() {
        return reasonTwo;
    }

    public void setReasonTwo(String reasonTwo) {
        this.reasonTwo = reasonTwo;
    }

    public String getReasonThree() {
        return reasonThree;
    }

    public void setReasonThree(String reasonThree) {
        this.reasonThree = reasonThree;
    }

    public String getDescriptionOne() {
        return descriptionOne;
    }

    public void setDescriptionOne(String descriptionOne) {
        this.descriptionOne = descriptionOne;
    }

    public String getDescriptionTwo() {
        return descriptionTwo;
    }

    public void setDescriptionTwo(String descriptionTwo) {
        this.descriptionTwo = descriptionTwo;
    }

    public String getDescriptionThree() {
        return descriptionThree;
    }

    public void setDescriptionThree(String descriptionThree) {
        this.descriptionThree = descriptionThree;
    }

    public MultipartFile getPicOne() {
        return picOne;
    }

    public void setPicOne(MultipartFile picOne) {
        this.picOne = picOne;
    }

    public MultipartFile getPicTwo() {
        return picTwo;
    }

    public void setPicTwo(MultipartFile picTwo) {
        this.picTwo = picTwo;
    }

    public MultipartFile getPicThree() {
        return picThree;
    }

    public void setPicThree(MultipartFile picThree) {
        this.picThree = picThree;
    }

    public MultipartFile getPicMain() {
        return picMain;
    }

    public void setPicMain(MultipartFile picMain) {
        this.picMain = picMain;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
