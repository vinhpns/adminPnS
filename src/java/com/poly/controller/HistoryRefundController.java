///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.poly.controller;
//
//import com.poly.service.HistoryService;
//import com.poly.service.CustomerService;
//import com.poly.tool.ConstantManager;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * @author Vinh
// */
//@Controller
//@RequestMapping("HistoryRefund")
//public class HistoryRefundController {
//
//    @Autowired
//    HistoryService hisSer;
//
//    @Autowired
//    CustomerService custSer;
//
//    AccountController accController = new AccountController();
//
//    @RequestMapping()
//    public String initiate(ModelMap model, HttpSession session) {
//
//        if (hisSer.checkLogin(session) == false) {
//            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//
//        model.addAttribute("deposit", hisSer.getListRefund());
//        return "HistoryRefund";
//    }
//
//    @RequestMapping(params = "paid", method = RequestMethod.GET)
//    public String changeStatusPaidPayment(ModelMap model, HttpSession session,
//                                          @RequestParam("id") String biddingOrderCode,
//                                          @RequestParam("accountId") String accountId) {
//        if (hisSer.checkLogin(session) == false) {
//            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//        hisSer.changeStatusRefund(accountId, biddingOrderCode);
//        return initiate(model, session);
//    }
//
//    @RequestMapping(params = "DetailRefundByBid", method = RequestMethod.GET)
//    public String getListRefundByBid(ModelMap model, HttpSession session,
//                                     @RequestParam("ordercode") String ordercode) {
//        if (hisSer.checkLogin(session) == false) {
//            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//
//        model.addAttribute("refundDetail", hisSer.getListRefundDetail(ordercode));
//        return "DetailRefund";
//    }
//}
