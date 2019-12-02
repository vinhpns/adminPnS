/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Brand;
import com.poly.bean.Product;
import com.poly.constant.BrandConstant;
import com.poly.dao.BidProductDAO;
import com.poly.dao.BrandDAO;
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
public class BrandService {

    @Autowired
    private BrandDAO brandDAO;

    @Autowired
    private BidProductDAO bidProductDAO;

    public List<Brand> getListBrand(int type) {
        return brandDAO.getAllBrand(type);
    }

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

    public Boolean changeActiveBrand(int id, Boolean statusBrand) {
        Boolean status;
        if (Objects.equals(statusBrand, Boolean.FALSE)) {
            status = unLockBrand(id);
        } else {
            status = lockBrand(id);
        }
        return status;
    }

    public Boolean unLockBrand(int id) {
        return !Objects.equals(brandDAO.setUnlockBrandById(id), Boolean.FALSE);
    }

    public Boolean lockBrand(int id) {
        List<Product> pList = bidProductDAO.getListProductBiddingByBrandId(id);
        if (Objects.equals(pList, ConstantManager.NULL) || pList.isEmpty()) {
            bidProductDAO.updateBrandIdOfProduct(id);
            return !Objects.equals(brandDAO.setLockBrandById(id), Boolean.FALSE);
        }
        return Boolean.FALSE;
    }

    public Brand getBrandById(int id) {
        return brandDAO.getByIdBrand(id);
    }

    public Boolean checkBrandExits(String name) {
        if (brandDAO.getByNameBrand(name) != null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean uploadImg(String imgName, MultipartFile image) {

        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();

        listNames.add(imgName);
        listFiles.add(image);

        if (listNames.size() > 0 && !listNames.isEmpty()) {
            for (int i = 0; i < listNames.size(); i++) {
                Utils.uploadImageToServer(BrandConstant.URL_STORE_SERVER, listNames.get(i), listFiles.get(i));
            }
            return true;
        }

        return false;
    }

    public String randomCodeImg() {

        Random rand = new Random();
        String codeN;
        String codeTotal = "SGDG";
        for (int i = 0; i < 16; i++) {
            int n = rand.nextInt(9);
            codeN = String.valueOf(n);
            codeTotal = codeTotal + codeN;
        }
        return codeTotal;
    }

    public Boolean deleteBrandById(int id) {
        return !Objects.equals(brandDAO.deleteBrandById(id), Boolean.FALSE);
    }

    public Boolean insertBrand(Brand brand) {
        return !Objects.equals(brandDAO.insertBrand(brand), Boolean.FALSE);
    }

    public Boolean updateBrand(Brand brand) {
        return !Objects.equals(brandDAO.updateBrandById(brand), Boolean.FALSE);
    }

    public Boolean reupOrDeleteBrand(int brandId, int type) {
        return !Objects.equals(brandDAO.deleteOrReupBrand(brandId, type), Boolean.FALSE);
    }
}
