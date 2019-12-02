/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Payment;
import com.poly.bean.Refund;
import com.poly.dao.PaymentDAO;
import com.poly.tool.checkLogin;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VinhNT
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentDAO pDAO;

    @Autowired
    HistoryService hsSER;

    public Boolean checkLogin(HttpSession session) {
        if (session.getAttribute("loginname").equals("")) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return !(checkLogin.checkLoginRoleSale(role) == true
                || checkLogin.checkLoginRoleHr(role) == true
                || checkLogin.checkLoginRoleWriter(role) == true
                || checkLogin.checkLoginRoleMod(role) == true
                || checkLogin.checkLoginRoleIt(role) == true);
    }

    public List<Payment> getListDeposit() {
        return pDAO.getListDeposit();
    }

    public List<Refund> getListRefund() {
        return hsSER.getListRefund();
    }
}
