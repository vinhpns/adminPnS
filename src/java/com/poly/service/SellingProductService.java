/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Product;
import com.poly.bean.SellingProduct;
import com.poly.dao.SellingProductDAO;
import com.poly.request.SellingResponse;
import com.poly.tool.checkLogin;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kiet
 */
@Service
public class SellingProductService {

    @Autowired
    private SellingProductDAO sellDAO;

    @Autowired
    ProductService pSER;

    @Autowired
    RoomService rSER;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLogin(session) != false;
    }
    
    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleSale(role) == true
                || checkLogin.checkLoginRoleIt(role) == true
                || checkLogin.checkLoginRoleAdmin(role) == true);
    }
    
    public List<SellingResponse> getListSelling(HttpSession session) {
        return sellDAO.getAllList(Integer.parseInt(String.valueOf(session.getAttribute("roleiz"))),
                (String) session.getAttribute("accountId"));
    }
}

