/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.News;
import com.poly.service.AccountService;
import com.poly.service.NewService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SGDG Company
 */
@Controller
@RequestMapping(value = "news")
public class NewsController {

    @Autowired
    NewService newService;

    @Autowired
    AccountService accountService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session, @RequestParam("type") int type) {
        List<News> n = newService.getListNewsByType(type);
        model.put("newsList", n);
        return "news";
    }

    @RequestMapping(params = "insert", method = RequestMethod.GET)
    public String redirectInsertPage(ModelMap model, HttpSession session) {
        return "insert-news";
    }

    @RequestMapping(params = "viewById", method = RequestMethod.GET)
    public String viewByIdUser(ModelMap model, HttpSession session,
            @RequestParam("type") int type,
            @RequestParam("id") String id) {
        List<News> n = newService.getNewsByMenuId(id);
        model.put("newsList", n);
        return "news";
    }
}
