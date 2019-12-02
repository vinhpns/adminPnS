/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

/**
 * @author VinhNT
 */
public class TypeNews {

    private int id;
    private String name;

    public TypeNews() {

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

    public TypeNews(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
