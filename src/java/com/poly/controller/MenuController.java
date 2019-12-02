/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SGDG Company
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController {

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        return "menu";
    }

    @RequestMapping(params = "getSubMenu")
    public String getSubMenu(ModelMap model, HttpSession session, @RequestParam("id") String id) {
        return "subMenu";
    }
}
