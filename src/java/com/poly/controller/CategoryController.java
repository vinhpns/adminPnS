/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Category;
import com.poly.constant.CategoryConstant;
import com.poly.service.CategoryService;
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
 * @author phong
 */
@Controller
@RequestMapping(CategoryConstant.CATEGORY_PAGE)
public class CategoryController {

    @Autowired
    CategoryService cateSer;

    AccountController accountController = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(cateSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        model.put(ConstantManager.URL_REQUEST_PARAM, url);
        if (url.equalsIgnoreCase("type")) {
        model.addAttribute(CategoryConstant.LIST_CATEGORY_KEY,cateSer.getListCategory(CategoryConstant.CATEGORY_TYPE));
        return CategoryConstant.CATEGORY_RETURN_PAGE;
        }
        model.put(CategoryConstant.LIST_CATEGORY_KEY, cateSer.getListCategory(CategoryConstant.CATEGORY));
        model.put(CategoryConstant.LIST_CATEGORYTYPE_KEY, cateSer.getListCategory(CategoryConstant.CATEGORY_TYPE));
        return CategoryConstant.CATEGORY_RETURN_PAGE;
    }

    @RequestMapping(params = ConstantManager.LOCK_FUNCTION)
    public String changeStatus(ModelMap model, HttpSession session,
            @RequestParam(CategoryConstant.ID_PARAM) int id,
            @RequestParam(CategoryConstant.STATUS_PARAM) Boolean active,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(cateSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        if (Objects.equals(cateSer.changeActive(id, active), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, CategoryConstant.LOCK_CATEGORY_FAIL);
            return initiate(model, session, url);
        }
        model.addAttribute(ConstantManager.OK_POPUP, CategoryConstant.LOCK_CATEGORY_OK);
        return initiate(model, session, url);
    }

    @RequestMapping(params = ConstantManager.INSERT_FUNCTION, method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @RequestParam(CategoryConstant.NAME_PARAM) String name,
            @RequestParam(CategoryConstant.FATHER_ID_PARAM) int id,
            @RequestParam("icon") MultipartFile icon,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(cateSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        if (Objects.equals(cateSer.checkCategoryByName(name, id), Boolean.FALSE)
                || (Objects.equals(cateSer.updateIcon(icon), Boolean.FALSE))) {
            model.put(ConstantManager.ERROR_POPUP, CategoryConstant.DUPLICATE_CATEGORY);
            return initiate(model, session, url);
        }
        Category category = new Category();
        String iconName = icon.getOriginalFilename();
        if (icon.isEmpty()) {
            iconName = "https://icon-library.net/images/category-icon-png/category-icon-png-10.jpg";
        }
        if (url.equalsIgnoreCase("type")) {
            category.setIcon(CategoryConstant.URL_SERVER + iconName);
            category.setParentId(0);
        } else {
            category.setIcon(null);
            category.setParentId(id);
        }
        category.setActive(Boolean.TRUE);
        category.setName(name);
        if (Objects.equals(cateSer.insert(category, url), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, CategoryConstant.INSERT_CATEGORY_FAIL);
        }
        model.put(ConstantManager.OK_POPUP, CategoryConstant.INSERT_CATEGORY_OK);
        return initiate(model, session, url);
    }

    @RequestMapping(params = ConstantManager.DELETE_FUNCTION, method = RequestMethod.GET)
    public String delete(ModelMap model, HttpSession session,
            @RequestParam(CategoryConstant.ID_PARAM) int id,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(cateSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        if (Objects.equals(cateSer.delete(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, CategoryConstant.DELETE_CATEGORY_FAIL);
            return initiate(model, session, url);
        }
        model.addAttribute(ConstantManager.OK_POPUP, CategoryConstant.DELETE_CATEGORY_OK);
        return initiate(model, session, url);
    }

    @RequestMapping(params = ConstantManager.GET_FUNCTION, method = RequestMethod.GET)
    public String redirectUpdatePage(@RequestParam(CategoryConstant.ID_PARAM) int id,
            ModelMap model, HttpSession session,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(cateSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        model.put(ConstantManager.URL_REQUEST_PARAM, url);
        Category cate = cateSer.getById(id, url);
        model.addAttribute(CategoryConstant.CATEGORY_TYPE_KEY,
                cateSer.getListCategory(CategoryConstant.CATEGORY_TYPE));
        model.addAttribute(CategoryConstant.CATEGORY_GET_BY_ID_KEY, cate);
        return CategoryConstant.CATEGORY_EDIT_REDIRECT_PAGE;
    }

    @RequestMapping(params = ConstantManager.UPDATE_FUNCTION, method = RequestMethod.POST)
    public String update(ModelMap model, HttpSession session,
            @RequestParam(CategoryConstant.ID_PARAM) int id,
            @RequestParam(CategoryConstant.NAME_PARAM) String name,
            @RequestParam(CategoryConstant.FATHER_ID_PARAM) int fatherId,
            @RequestParam("active") Boolean active,
            @RequestParam("icon") MultipartFile icon,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(cateSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        Category category = cateSer.getById(id, url);
        if (!icon.isEmpty()) {
            List<String> listNames = new ArrayList<>();
            List<MultipartFile> listFiles = new ArrayList<>();
            String imgName = Utils.randomCodeImg() + icon.getOriginalFilename();
            listNames.add(imgName);
            listFiles.add(icon);
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, CategoryConstant.URL_STORE_SERVER);
            if (Objects.equals(checkUploadImg, Boolean.FALSE)) {
                model.put(ConstantManager.ERROR_POPUP, CategoryConstant.UPDATE_CATEGORY_FAIL);
                return initiate(model, session, url);
            }
            category.setIcon(CategoryConstant.URL_SERVER + imgName);
        } else {
            category.setIcon(category.getIcon());
        }
        category.setActive(active);
       
        category.setId(id);
        category.setName(name);
        category.setParentId(fatherId);
        if (Objects.equals(cateSer.update(category, url), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, CategoryConstant.UPDATE_CATEGORY_FAIL);
            return redirectUpdatePage(id, model, session, url);
        }
        model.put(ConstantManager.OK_POPUP, CategoryConstant.UPDATE_CATEGORY_OK);
        return initiate(model, session, url);
    }
}