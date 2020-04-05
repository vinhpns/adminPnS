/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author 1
 */
public class Company {

    private String id;
    private String name;
    private String logo;
    private String alias;
    private String titleSeo;
    private String metaSeo;
    private String descriptionSeo;
    private String address;
    private String phone;
    private MultipartFile avatar;
    private String titleOne;
    private String titleTwo;
    private String titleThree;
    private String descriptionOne;
    private String descriptionTwo;
    private String descriptionThree;

    public Company() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitleSeo() {
        return titleSeo;
    }

    public void setTitleSeo(String titleSeo) {
        this.titleSeo = titleSeo;
    }

    public String getMetaSeo() {
        return metaSeo;
    }

    public void setMetaSeo(String metaSeo) {
        this.metaSeo = metaSeo;
    }

    public String getDescriptionSeo() {
        return descriptionSeo;
    }

    public void setDescriptionSeo(String descriptionSeo) {
        this.descriptionSeo = descriptionSeo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public String getTitleOne() {
        return titleOne;
    }

    public void setTitleOne(String titleOne) {
        this.titleOne = titleOne;
    }

    public String getTitleTwo() {
        return titleTwo;
    }

    public void setTitleTwo(String titleTwo) {
        this.titleTwo = titleTwo;
    }

    public String getTitleThree() {
        return titleThree;
    }

    public void setTitleThree(String titleThree) {
        this.titleThree = titleThree;
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
}
