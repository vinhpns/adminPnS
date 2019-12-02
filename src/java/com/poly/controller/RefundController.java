/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Refund;
import com.poly.dao.RefundDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author HoangDung
 */
@Controller
@RequestMapping(value = "Refund")
public class RefundController {

    @Autowired
    private RefundDAO refund;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("ref", new Refund());
        model.addAttribute("refs", refund.getAll());
        return "Refund";

    }

//    @RequestMapping(params = "refund", method = RequestMethod.POST)
//    public String refund1(@ModelAttribute("reff") Refund rfu, ModelMap model, HttpSession session, HttpServletRequest request) {
//
//        refund.update(rfu);
//        model.addAttribute("refss", refund.getAll());
//        return initiate(model, session, request);
//
//        
//    }
}
