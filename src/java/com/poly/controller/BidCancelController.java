/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Product;
import com.poly.dao.BidProductDAO;
import com.poly.tool.ConstantManager;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author Vinh
 */
@Controller
@RequestMapping("ListBidCancel")
@SessionAttributes(value = {"username", "id", "role", "fullname"})
public class BidCancelController {

    @Autowired
    private BidProductDAO bidProductDAO;

    public static int u = 0;

    @RequestMapping
    public String initiate(ModelMap model, HttpSession session, HttpServletRequest request) {

        session = request.getSession();

        if (session.getAttribute("loginname") == null
                || session.getAttribute("loginname").equals(ConstantManager.EMPTY)) {
            model.addAttribute("errors", ConstantManager.NO_ACCEPT_LOGIN);
            return "login";
        }

        String roleId = (String) session.getAttribute("roleiz");
        String saleName = (String) session.getAttribute("loginname");

        List<Product> bidProducts = null;

//        switch (roleId) {
//            case ConstantManager.ROLE_SALE:
//                bidProducts = bidProductDAO.getBidProductsBySalesStatusCancel(saleName);
//                break;
//            
//            case ConstantManager.ROLE_IT:
//                bidProducts = bidProductDAO.getBidProductsByAdminStatusCancel();
//                break;
//        }

        if (bidProducts != null && !bidProducts.isEmpty()) {
            model.addAttribute("bidProducts", bidProducts);
            model.addAttribute("roleiz", roleId);
        }
        return "ListBidCancel";
    }
}
