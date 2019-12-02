///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.poly.controller;
//
//import com.poly.dao.PaymentDAO;
//import com.poly.service.HistoryService;
//import com.poly.service.CustomerService;
//import com.poly.tool.ConstantManager;
//import com.poly.tool.checkLogin;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
///**
// * @author Vinh
// */
//@Controller
//@RequestMapping("HistoryDeposit")
//public class HistoryDepositController {
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
//        model.addAttribute("deposit", hisSer.getListDeposit());
//        return "HistoryDeposit";
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
//        return initiate(model, session);
//    }
//}
