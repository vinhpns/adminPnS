/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Category;
import com.poly.constant.CategoryConstant;
import com.poly.dao.CategoryDAO;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;
import com.poly.tool.checkLogin;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author VinhNT
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDAO cateDAO;

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

    public List<Category> getListCategory(int type) {
        return cateDAO.getListCategory(type);
    }

    public Category getById(int id, String url) {
        Category category = cateDAO.getById(id, url);
        if (category != null) {
            return category;
        }
        return null;
    }

    public Boolean changeActive(int id, Boolean active) {
        return !Objects.equals(cateDAO.changeActive(id, active), Boolean.FALSE);
    }

    public Boolean insert(Category category, String url) {
        if (url.equalsIgnoreCase("cate")) {
            return !Objects.equals(cateDAO.insert(category, CategoryConstant.CATEGORY), Boolean.FALSE);
        }
        return !Objects.equals(cateDAO.insert(category, CategoryConstant.CATEGORY_TYPE), Boolean.FALSE);
    }

    public Boolean checkCategoryByName(String name, int parentId) {
        List<Category> categoryCheck = cateDAO.getByName(name);
        if (categoryCheck == null || categoryCheck.isEmpty()) {
            return Boolean.TRUE;
        }
        for (int i = 0; i < categoryCheck.size(); i++) {
            if (categoryCheck.get(i).getParentId() == parentId) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public Boolean delete(int id) {
        return !Objects.equals(cateDAO.delete(id), Boolean.FALSE);
    }

    public Boolean update(Category category, String url) {
        if (url.equalsIgnoreCase("type")) {
            return !Objects.equals(cateDAO.update(category, CategoryConstant.CATEGORY_TYPE), Boolean.FALSE);
        }
        return !Objects.equals(cateDAO.update(category, CategoryConstant.CATEGORY), Boolean.FALSE);
    }

    public Boolean updateIcon(MultipartFile icon) {
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        if (icon != null) {
            String img1Name = Utils.randomCodeImg() + icon.getOriginalFilename();
            listNames.add(img1Name);
            listFiles.add(icon);
        }
        if (listNames.size() > 0 && listFiles.size() > 0) {
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, CategoryConstant.URL_STORE_SERVER);
            if (Objects.equals(checkUploadImg, Boolean.FALSE)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
