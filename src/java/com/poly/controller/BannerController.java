/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Banner;
import com.poly.constant.BannerConstant;
import com.poly.request.BannerRequest;
import com.poly.service.BannerService;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("banner")
public class BannerController {

    @Autowired
    BannerService banService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        model.put(BannerConstant.LIST_BANNER_KEY, banService.getListBanner());
        return BannerConstant.BANNER_RETURN_PAGE;
    }

    @RequestMapping(params = "changeStatus", method = RequestMethod.GET)
    public String updateStatus(ModelMap model, HttpSession session,
            @RequestParam("id") String id,
            @RequestParam("status") Boolean status) {
        if (Objects.equals(banService.updateStatus(id, status), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Đổi trạng thái không thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Đổi trạng thái thành công");
        return initiate(model, session);
    }

    @RequestMapping(params = "getBannerById", method = RequestMethod.GET)
    public String getBannerById(ModelMap model, HttpSession session, @RequestParam("id") String id) {

        return "getBanner";
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(ModelMap model, HttpSession session, @ModelAttribute("banner") BannerRequest ban) {
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        String imgName = Utils.randomCodeImg() + ban.getImg().getOriginalFilename();
        listNames.add(imgName);
        listFiles.add(ban.getImg());
        ban.setCreatedBy((String)session.getAttribute("accountId"));
//        if (Objects.equals(banService.updateBanner(ban), Boolean.FALSE)) {
//            model.put(ConstantManager.ERROR_POPUP, "Update banner không thành công");
//            return initiate(model, session);
//        }
        model.put(ConstantManager.OK_POPUP, "Update thành công");
        return initiate(model, session);
    }

    @RequestMapping(params = "insert", method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @ModelAttribute("banner") BannerRequest banner) {
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        String imgName = Utils.randomCodeImg() + banner.getImg().getOriginalFilename();
        listNames.add(imgName);
        listFiles.add(banner.getImg());
        banner.setCreatedBy((String)session.getAttribute("accountId"));
        Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, BannerConstant.URL_STORE_SERVER);
        if (checkUploadImg == false) {
            model.put(ConstantManager.ERROR_POPUP, BannerConstant.INSERT_BANNER_FAIL);
            return initiate(model, session);
        }
        if(Objects.equals(banService.insertBanner(banner, imgName), Boolean.FALSE)){
            model.put(ConstantManager.ERROR_POPUP, "Thêm banner không thành công");
            return initiate(model, session);
        }
        return initiate(model, session);
    }
}
