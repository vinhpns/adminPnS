/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.dao.PaymentDAO;
import com.poly.service.HistoryService;
import com.poly.tool.ConstantManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author Vinh
 */
@Controller
@RequestMapping("HistoryWinBid")
public class WinBidController {

    @Autowired
    private HistoryService hisSer;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {

        if (hisSer.checkLogin(session) == false) {
            model.addAttribute("errors", ConstantManager.NO_ACCEPTED_LOGIN);
            return "redirect:/index.htm";
        }
        model.addAttribute("winbidlist", hisSer.getWinList());
        return "HistoryWinBid";
    }

    @RequestMapping(params = "paid", method = RequestMethod.GET)
    public String changeStatusPaidPayment(ModelMap model, HttpSession session,
                                          @RequestParam("id") String biddingOrderCode,
                                          @RequestParam("accountId") String accountId) {
        hisSer.changeStatusWinBid(accountId, biddingOrderCode);
        return initiate(model, session);
    }
}
