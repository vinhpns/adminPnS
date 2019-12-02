/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

/**
 *
 * @author SGDG Company
 */
public class TypeVideo {

    private int id;
    private String name;

    public TypeVideo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeVideo(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
