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
 * @author Vinh
 */
@Service
public class checkLogin {

    public static Boolean checkLogin(HttpSession session) {
//        if(session.equals("")){
//            return false;
//        }else if(session.get)
        if (session.getAttribute("email") != null) {
            return true;
        }
        return session.equals("");
    }

    public static Boolean checkLoginRoleAdmin(int role) {
        return role == AccountConstant.ROLE_ADMIN;
    }

    public static Boolean checkLoginRoleSale(int role) {
        return role == AccountConstant.ROLE_SALE;
    }

    public static Boolean checkLoginRoleHr(int role) {
        return role == AccountConstant.ROLE_HR;
    }

    public static Boolean checkLoginRoleAcc(int role) {
        return role == AccountConstant.ROLE_ACC;
    }

    public static Boolean checkLoginRoleWriter(int role) {
        return role == AccountConstant.ROLE_WRITER;
    }

    public static Boolean checkLoginRoleMod(int role) {
        return role == AccountConstant.ROLE_MOD;
    }

    public static Boolean checkLoginRoleIt(int role) {
        return role == AccountConstant.ROLE_IT;
    }
    
    public static Boolean checkLoginRoleSuperAdmin (int role) {
        return role == AccountConstant.ROLE_SUPER_ADMIN;
    }
}
