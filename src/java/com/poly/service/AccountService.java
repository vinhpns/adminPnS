/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Account;
import com.poly.dao.AccountDAO;
import com.poly.tool.checkLogin;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Vinh
 */
@Service
public class AccountService {

    @Autowired
    AccountDAO accDAO;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleHr(role) == true
                || checkLogin.checkLoginRoleIt(role) == true
                || checkLogin.checkLoginRoleAdmin(role) == true);
    }

//    public Boolean changeActive(String id, Boolean active) {
//        return !Objects.equals(accDAO.changeActive(active, id), Boolean.FALSE);
//    }
    public Account getAccountLogin(String email) {
        Account checkByEmail = accDAO.getAccountByEmail(email);
        Account checkByUserName = accDAO.getAccountByUserName(email);
        if (checkByEmail == null && checkByUserName == null) {
            return null;
        }
        if (checkByEmail != null) {
            return checkByEmail;
        } else {
            return checkByUserName;
        }
    }

    public Boolean checkPassLogin(String password, String passlogin) {
        PasswordEncoder pw = new BCryptPasswordEncoder();
        if (pw.matches(password, passlogin)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<Account> getListAccount() {
        return accDAO.getList();
    }
}
