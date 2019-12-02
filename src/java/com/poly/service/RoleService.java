/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.dao.RoleDAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vinh
 */
@Service
public class RoleService {

    @Autowired
    private RoleDAO rdao;

//    public List<Role> getListRole() {
//        return rdao.getListRole();
//    }
}
