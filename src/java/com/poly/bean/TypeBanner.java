/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

/**
 * @author vinh1
 */
public class TypeBanner {

    private int id;
    private String name;

    public TypeBanner(int BANNER_BIG_INTRODUCE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public TypeBanner() {
    }

    public TypeBanner(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
