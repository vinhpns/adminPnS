/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.service.SellingProductService;
import com.poly.tool.ConstantManager;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Kiet
 */
@Controller
@RequestMapping("Selling")
public class SellingController {

    @Autowired
    SellingProductService sellSer;

    AccountController accController = new AccountController();

    @RequestMapping
    public String initiate(ModelMap model, HttpSession session) {
//        if (sellSer.checkLogin(session) == false) {
//            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }

        model.addAttribute("sellProducts", sellSer.getListSelling(session));
        return "Selling";
    }
}
