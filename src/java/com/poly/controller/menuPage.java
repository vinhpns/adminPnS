/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author VinhNT
 */
@Controller
@RequestMapping(value = "menuPage")
public class menuPage {

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session, HttpServletRequest request) {
//        Object obc = session.getAttribute("id");
        model.addAttribute("fullname", "Vinh");
        model.put("activePage", 1);
        return "customerList";
    }

}
