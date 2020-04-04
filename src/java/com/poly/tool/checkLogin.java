/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.tool;

import com.poly.constant.AccountConstant;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

/**
 * @author 
 */
@Service
public class checkLogin {

    public static Boolean checkLogin(HttpSession session) {
        if (session.getAttribute("loginName") != null) {
            return true;
        }
        return session.equals("");
    }

    public static Boolean checkLoginRoleCustomer(int role) {
        return role == ConstantManager.ROLE_CUSTOMER;
    }

    public static Boolean checkLoginRoleAdmin(int role) {
        return role == ConstantManager.ROLE_ADMIN;
    }

    public static Boolean checkLoginRoleSuperAdmin(int role) {
        return role == ConstantManager.ROLE_SUPER_ADMIN;
    }
}
