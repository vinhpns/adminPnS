/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.tool.ConstantManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vinh
 */
@Controller
@RequestMapping(value = "login")
public class LoginController {

    @RequestMapping()
    public String index(ModelMap model, HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("loginName") == null) {
            return ConstantManager.LOGIN_PAGE;
        }
        return "redirect:/index.htm";
    }
}
