/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

/**
 * @author ASUS
 */
public class Rank {

    private int id;
    private String name;
    private int requirePoint;
    private String icon;
     

    public Rank() {
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

    public int getRequirePoint() {
        return requirePoint;
    }

    public void setRequirePoint(int requirePoint) {
        this.requirePoint = requirePoint;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
