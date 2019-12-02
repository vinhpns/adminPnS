/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.BiddingHistory;
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
public class HistoryService {

    @Autowired
    private PaymentDAO pDAO;

    @Autowired
    BiddingService bSER;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleSale(role) == true
                || checkLogin.checkLoginRoleHr(role) == true
                || checkLogin.checkLoginRoleWriter(role) == true
                || checkLogin.checkLoginRoleMod(role) == true
                || checkLogin.checkLoginRoleIt(role) == true
                || checkLogin.checkLoginRoleAdmin(role) == true);
    }

    public List<Payment> getListDeposit() {
        return pDAO.getListDeposit();
    }

    public List<Refund> getListRefund() {
        return pDAO.getListRefund();
    }

    public List<Refund> getListRefundDetail(String ordercode) {
        return pDAO.getListRefundDetail(ordercode);
    }

    public void changeStatusRefund(String accountId, String ordercode) {
        pDAO.updateStatusRefund(ordercode, accountId);
    }

    public void updateStatusDeposit(String orderCode, String accountId) {
        pDAO.updateStatusPaidDeposit(orderCode, accountId);
    }

    public void changeStatusWinBid(String accountId, String ordercode) {
        pDAO.updateStatusWinBid(ordercode, accountId);
    }

    public List<BiddingHistory> getWinList() {
        return bSER.getWinBidList();
    }
}
