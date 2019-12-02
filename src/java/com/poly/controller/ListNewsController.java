/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.News;
import com.poly.constant.NewsConstant;
import com.poly.service.NewsService;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 */
@Controller
@RequestMapping(ConstantManager.NEWS_PAGE)
public class ListNewsController {

    @Autowired
    NewsService nSER;

    AccountController accController = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session,
            @RequestParam("url") String url) {
        if (Objects.equals(nSER.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.put("url", url);
        if (url.equalsIgnoreCase("typefooter")) {
            model.addAttribute(NewsConstant.TYPE_NEWS_KEY, nSER.initiateTypeNews(NewsConstant.TYPE_FOOTER));
            model.addAttribute(NewsConstant.LIST_NEWS_KEY, nSER.getListNews(NewsConstant.TYPE_FOOTER));
            return NewsConstant.NEWS_RETURN_PAGE;
        }
        if (url.equalsIgnoreCase("qna")) {
            model.addAttribute(NewsConstant.TYPE_NEWS_KEY, nSER.initiateTypeNews(NewsConstant.TYPE_QNA));
            model.addAttribute(NewsConstant.LIST_NEWS_KEY, nSER.getListNews(NewsConstant.TYPE_QNA));
            return NewsConstant.NEWS_RETURN_PAGE;
        }
        model.put(NewsConstant.TYPE_NEWS_KEY, nSER.initiateTypeNews(NewsConstant.TYPE_NEWS));
        model.put(NewsConstant.LIST_NEWS_KEY, nSER.getListNews(NewsConstant.TYPE_NEWS));
        return NewsConstant.NEWS_RETURN_PAGE;
    }

    @RequestMapping(params = ConstantManager.LOCK_FUNCTION, method = RequestMethod.GET)
    public String changeActiveStatusNews(ModelMap model, HttpSession session,
            @RequestParam(NewsConstant.ID_PARAM) int id,
            @RequestParam(NewsConstant.STATUS_PARAM) Boolean active,
            @RequestParam("url") String url) {
        if (Objects.equals(nSER.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(nSER.changeActiveNews(id, active), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, NewsConstant.LOCK_NEWS_FAIL);
        }
        model.put(ConstantManager.OK_POPUP, NewsConstant.LOCK_NEWS_OK);
        return initiate(model, session, url);
    }

    @RequestMapping(params = ConstantManager.DELETE_FUNCTION, method = RequestMethod.GET)
    public String deleteNews(ModelMap model, HttpSession session, @RequestParam(NewsConstant.ID_PARAM) int id,
            @RequestParam("url") String url) {
        if (Objects.equals(nSER.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(nSER.deleteNews(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, NewsConstant.DELETE_NEWS_FAIL);
            return initiate(model, session, url);
        }
        model.addAttribute(ConstantManager.OK_POPUP, NewsConstant.DELETE_NEWS_OK);
        return initiate(model, session, url);
    }

    @RequestMapping(params = ConstantManager.INSERT_FUNCTION, method = RequestMethod.POST)
    public String insertNews(ModelMap model, HttpSession session, @RequestParam(NewsConstant.TITLE_PARAM) String title,
            @RequestParam(NewsConstant.CONTENT_PARAM) String content,
            @RequestParam(NewsConstant.TYPE_PARAM) int type,
            @RequestParam(NewsConstant.HOT_PARAM) Boolean hot,
            @RequestParam(NewsConstant.AVATAR_PARAM) MultipartFile avatar,
            @RequestParam("url") String url) {
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        if (Objects.equals(nSER.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (ConstantManager.EMPTY.equalsIgnoreCase(avatar.getOriginalFilename()) && url.equalsIgnoreCase("news")) {
            model.put(ConstantManager.ERROR_POPUP, NewsConstant.NEWS_NEED_IMG);
            return initiate(model, session, url);
        }
        News news = new News();
        String imgName = Utils.randomCodeImg() + avatar.getOriginalFilename();
        listNames.add(imgName);
        listFiles.add(avatar);
        Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, NewsConstant.URL_STORE_SERVER);
        if (checkUploadImg == false) {
            model.put(ConstantManager.ERROR_POPUP, NewsConstant.INSERT_NEWS_FAIL);
            return initiate(model, session, url);
        }
        news.setTitle(title);
        news.setType(type);
        news.setContent(content);
        news.setHot(hot);
        news.setActive(Boolean.TRUE);
        news.setAvatar(NewsConstant.URL_SERVER + imgName);
        if (Objects.equals(nSER.insertNews(news), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, NewsConstant.INSERT_NEWS_FAIL);
            return initiate(model, session, url);
        }
        model.put(ConstantManager.OK_POPUP, NewsConstant.INSERT_NEWS_OK);
        return initiate(model, session, url);
    }

    @RequestMapping(params = ConstantManager.GET_FUNCTION, method = RequestMethod.GET)
    public String redirectUpdateNewsPage(ModelMap model, HttpSession session,
            @RequestParam(NewsConstant.ID_PARAM) int id,
            @RequestParam("url") String url) {
        if (Objects.equals(nSER.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        News news = nSER.getNewsById(id);
        if (Objects.equals(news, ConstantManager.NULL)) {
            model.put(ConstantManager.ERROR_POPUP, NewsConstant.CANNOT_FIND_NEWS);
            return initiate(model, session, url);
        }
        model.put(NewsConstant.TYPE_NEWS_KEY, nSER.initiateTypeNews(NewsConstant.TYPE_NEWS));
        model.addAttribute(NewsConstant.NEWS_BY_ID_FIND_KEY, news);
        model.put("url", url);
        return NewsConstant.NEWS_EDIT_REDIRECT_PAGE;
    }
//

    @RequestMapping(params = ConstantManager.UPDATE_FUNCTION, method = RequestMethod.POST)
    public String updateNews(ModelMap model, HttpSession session,
            @RequestParam(NewsConstant.TITLE_PARAM) String title,
            @RequestParam(NewsConstant.ID_PARAM) int id,
            @RequestParam(NewsConstant.CONTENT_PARAM) String content,
            @RequestParam(NewsConstant.HOT_PARAM) Boolean hot,
            @RequestParam(NewsConstant.TYPE_PARAM) int type,
            @RequestParam(NewsConstant.AVATAR_PARAM) MultipartFile avatar,
            @RequestParam("url") String url) {
        if (Objects.equals(nSER.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        News news = nSER.getNewsById(id);
        if (!avatar.isEmpty()) {
            if (Objects.equals(Utils.checkImgType(avatar), Boolean.FALSE)) {
                model.put(ConstantManager.ERROR_POPUP, "Sai định dạng hình ảnh");
                return redirectUpdateNewsPage(model, session, id, url);
            }
            List<String> listNames = new ArrayList<>();
            List<MultipartFile> listFiles = new ArrayList<>();
            String imgName = Utils.randomCodeImg() + avatar.getOriginalFilename();
            String last = avatar.getName();
            System.out.println(last);
            listNames.add(imgName);
            listFiles.add(avatar);
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, NewsConstant.URL_STORE_SERVER);
            if (Objects.equals(checkUploadImg, Boolean.FALSE)) {
                model.put(ConstantManager.ERROR_POPUP, NewsConstant.UPDATE_NEWS_FAIL);
                return initiate(model, session, url);
            }
            news.setAvatar(NewsConstant.URL_SERVER + imgName);
        } else {
            news.setAvatar(news.getAvatar());
        }
        news.setTitle(title);
        news.setContent(content);
        news.setType(type);
        news.setHot(hot);
        if (Objects.equals(nSER.updateNews(news), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, NewsConstant.UPDATE_NEWS_FAIL);
            return redirectUpdateNewsPage(model, session, id, url);
        }
        model.put(ConstantManager.OK_POPUP, NewsConstant.UPDATE_NEWS_OK);
        return initiate(model, session, url);
    }
}
