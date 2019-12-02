/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.dao.PaymentDAO;
import com.poly.service.HistoryService;
import com.poly.service.PaymentService;
import com.poly.tool.ConstantManager;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author phong
 */
@Controller
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    private PaymentDAO paymentDAO;

    @Autowired
    HistoryService pSER;

    AccountController accController = new AccountController();

    @RequestMapping(params = "HistoryDeposit", method = RequestMethod.GET)
    public String listDeposit(ModelMap model, HttpSession session) {
        if (pSER.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.addAttribute("payments", pSER.getListDeposit());
        return "HistoryDeposit";
    }

    @RequestMapping(params = "HistoryRefund", method = RequestMethod.GET)
    public String listRefund(ModelMap model, HttpSession session) {
        if (pSER.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.addAttribute("payments", paymentDAO.getListDeposit());
        return "HistoryRefund";
    }

    @RequestMapping(params = "paid", method = RequestMethod.GET)
    public String changeStatusPaidPayment(ModelMap model, HttpSession session,
                                          @RequestParam("id") String biddingOrderCode,
                                          @RequestParam("accountId") String accountId) {
        if (pSER.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }

        pSER.updateStatusDeposit(biddingOrderCode, accountId);
        return listDeposit(model, session);
    }
}
