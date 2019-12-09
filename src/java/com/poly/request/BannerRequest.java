/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.request;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author hieuh
 */
public class BannerRequest {

    private String id;
    private String link;
    private MultipartFile img;
    private int type;
    private String createdBy;

    public BannerRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

}
