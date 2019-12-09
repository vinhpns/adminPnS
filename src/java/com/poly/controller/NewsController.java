/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.News;
import com.poly.constant.NewsConstant;
import com.poly.request.NewsRequestEntity;
import com.poly.service.AccountService;
import com.poly.service.MenuService;
import com.poly.service.NewsService;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SGDG Company
 */
@Controller
@RequestMapping(value = "news")
public class NewsController {

    @Autowired
    NewsService newService;

    @Autowired
    MenuService menuService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session, @RequestParam("type") int type) {
        List<News> n = newService.getListNewsByType(type);
        model.put("newsList", n);
        model.put("type", type);
        model.put("link", "news.htm");
        return "news";
    }

    @RequestMapping(params = "insert", method = RequestMethod.GET)
    public String redirectInsertPage(ModelMap model, HttpSession session, @RequestParam("type") int type) {
        model.put("type", type);
        if (type == 1) {
            model.put("menuList", menuService.getListSon());
        } else {
            model.put("menuList", "0");
        }
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

    @RequestMapping(params = "insertNews", method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @ModelAttribute("ban") NewsRequestEntity n,
            @RequestParam("type") int type) {
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        String menuId = "0";
        String imgName = Utils.randomCodeImg() + n.getAvatar().getOriginalFilename();
        listNames.add(imgName);
        listFiles.add(n.getAvatar());
        Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, NewsConstant.URL_STORE_SERVER);
        if (checkUploadImg == false) {
            model.put(ConstantManager.ERROR_POPUP, NewsConstant.INSERT_NEWS_FAIL);
            return redirectInsertPage(model, session, (int) session.getAttribute("type"));
        }
        String link = NewsConstant.URL_SERVER + imgName;
        String userId = (String) session.getAttribute("accountId");
//        newService.insert(n, type, userId, menuId, link);
        return initiate(model, session, 1);
    }

    @RequestMapping(params = "fullNews", method = RequestMethod.GET)
    public String getFullNews(ModelMap model, HttpSession session) {
        model.put("newsList", newService.getListNewsByType(0));
        return "newsList";
    }
    @RequestMapping(params = "menu", method = RequestMethod.GET)
    public String getByMenuId(ModelMap model, HttpSession session){
        model.put("newsList", newService.getAllByMenuId());
        return "news";
}
    @RequestMapping(params = "account", method = RequestMethod.GET)
    public String getCreatBy(ModelMap model, HttpSession session){
        model.put("newsList", newService.getCreatBy());
        return "news";
}
}