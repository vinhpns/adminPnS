/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.News;
import com.poly.bean.TypeNews;
import com.poly.constant.NewsConstant;
import com.poly.dao.NewsDAO;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;
import com.poly.tool.checkLogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author VinhNT
 */
@Service
public class NewsService {

    @Autowired
    private NewsDAO nDAO;

    public Boolean checkLogin(HttpSession session) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return !Objects.equals(checkLoginRole(session), Boolean.FALSE);
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute(ConstantManager.ROLEID)));
        return (Objects.equals(checkLogin.checkLoginRoleWriter(role), Boolean.TRUE)
                || Objects.equals(checkLogin.checkLoginRoleMod(role), Boolean.TRUE)
                || Objects.equals(checkLogin.checkLoginRoleAdmin(role), Boolean.TRUE));
    }

    public List<News> getListNews(int type) {
        return nDAO.getAllNews(type);
    }

    public Boolean changeActiveNews(int id, Boolean active) {
        return !Objects.equals(nDAO.changeActive(id, active), Boolean.FALSE);
    }

    public Boolean deleteNews(int id) {
        return !Objects.equals(nDAO.deleteNews(id), Boolean.FALSE);
    }

    public Boolean insertNews(News news) {
        return !Objects.equals(nDAO.insertNews(news), Boolean.FALSE);
    }

    public Boolean updateNews(News news) {
        return !Objects.equals(nDAO.updateNews(news), Boolean.FALSE);
    }

    public News getNewsById(int id) {
        News news = nDAO.getNewsById(id);
        if (news != ConstantManager.NULL) {
            return news;
        }
        return null;
    }

    public Boolean uploadImg(List<String> listNames, List<MultipartFile> listFiles) {

        if (listNames.size() > 0 && !listNames.isEmpty()) {
            for (int i = 0; i < listNames.size(); i++) {
                Utils.uploadImageToServer(NewsConstant.URL_STORE_SERVER, listNames.get(i), listFiles.get(i));
            }
            return true;
        }

        return false;
    }

    public List<TypeNews> initiateTypeNews(int type) {
        ArrayList<TypeNews> listTypeNews = new ArrayList<>();
        TypeNews tNews1 = new TypeNews(NewsConstant.ABOUT_US, NewsConstant.ABOUT_US_TITLE);
        TypeNews tNews2 = new TypeNews(NewsConstant.CUSTOMER_HELP, NewsConstant.CUSTOMER_HELP_TITLE);
        TypeNews tNews3 = new TypeNews(NewsConstant.CONTACT, NewsConstant.CONTACT_TITLE);
        TypeNews tNews4 = new TypeNews(NewsConstant.MARKET_INFO, NewsConstant.MARKET_INFO_TITLE);
        TypeNews tNews5 = new TypeNews(NewsConstant.DO_YOU_KNOW, NewsConstant.DO_YOU_KNOW_TITLE);
        TypeNews tNews6 = new TypeNews(NewsConstant.WORLD_NEWS, NewsConstant.WORLD_NEWS_TITLE);
        TypeNews tNews7 = new TypeNews(NewsConstant.SGDG_NEWS, NewsConstant.SGDG_NEWS_TITLE);
        TypeNews tNews8 = new TypeNews(NewsConstant.PROMOTION, NewsConstant.PROMOTION_TITLE);
        TypeNews tNews9 = new TypeNews(NewsConstant.Q_A, NewsConstant.Q_A_TITLE);
        switch (type) {
            case 1:
                listTypeNews.add(tNews1);
                listTypeNews.add(tNews2);
                listTypeNews.add(tNews3);
                break;
            case 2:               
                listTypeNews.add(tNews4);
                listTypeNews.add(tNews5);
                listTypeNews.add(tNews6);
                listTypeNews.add(tNews7);
                listTypeNews.add(tNews8);
                break;
            case 3:
                listTypeNews.add(tNews9);
                break;
        }

        return listTypeNews;
    }
}
