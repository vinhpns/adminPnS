/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Banner;
import com.poly.constant.BannerConstant;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = ConstantManager.BANNER_PAGE)
public class BannerController {

    @Autowired
    BannerService banService;

    AccountController accountController = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(banService.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        model.put(ConstantManager.URL_REQUEST_PARAM, url);
        if (url.equalsIgnoreCase("banner")) {
            session.setAttribute(BannerConstant.TYPE_BANNER_KEY, banService.initiateTypeBanner());
            model.put(BannerConstant.LIST_BANNER_KEY, banService.getListBanner(BannerConstant.BANNER_TYPE));
            return BannerConstant.BANNER_RETURN_PAGE;
        }
        session.setAttribute(BannerConstant.TYPE_BANNER_KEY, banService.initiateTypeContent());
        model.put(BannerConstant.LIST_BANNER_KEY, banService.getListBanner(BannerConstant.CONTENT_TYPE));
        return BannerConstant.CONTENT_WEB_PAGE;
    }

    @RequestMapping(params = ConstantManager.LOCK_FUNCTION)
    public String changeStatus(ModelMap model, HttpSession session,
            @RequestParam(BannerConstant.ID_PARAM) int id,
            @RequestParam(BannerConstant.STATUS_PARAM) Boolean active,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(banService.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        Boolean resultStatus = banService.changeActiveBanner(id, active);
        if (Objects.equals(resultStatus, Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, BannerConstant.LOCK_BANNER_FAIL);
        }
        model.addAttribute(ConstantManager.OK_POPUP, BannerConstant.LOCK_BANNER_OK);
        return initiate(model, session, url);
    }

    @RequestMapping(params = ConstantManager.DELETE_FUNCTION)
    public String delete(ModelMap model, HttpSession session,
            @RequestParam(BannerConstant.ID_PARAM) int id,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(banService.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        if (Objects.equals(banService.deleteBanner(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, BannerConstant.DELETE_BANNER_FAIL);
            return initiate(model, session, url);
        }
        model.addAttribute(ConstantManager.OK_POPUP, BannerConstant.DELETE_BANNER_OK);
        return initiate(model, session, url);
    }

    @RequestMapping(params = ConstantManager.GET_FUNCTION, method = RequestMethod.GET)
    public String redirectUpdatePage(@RequestParam(BannerConstant.ID_PARAM) int id,
            ModelMap model, HttpSession session,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(banService.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        model.put(ConstantManager.URL_REQUEST_PARAM, url);
        Banner banner = banService.getBannerById(id);
        if (Objects.equals(banner, ConstantManager.NULL)) {
            model.put(ConstantManager.ERROR_POPUP, BannerConstant.CANNOT_FIND_BANNER);
            return initiate(model, session, url);
        }
        model.put(BannerConstant.BANNER_FIND_KEY, banner);
        return BannerConstant.BANNER_EDIT_REDIRECT_PAGE;
    }

    @RequestMapping(params = ConstantManager.INSERT_FUNCTION, method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @RequestParam(BannerConstant.LINK_PARAM) String banLink,
            @RequestParam(BannerConstant.TYPE_ID_PARAM) int typeId,
            @RequestParam(BannerConstant.IMG_PARAM) MultipartFile image,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        if (Objects.equals(banService.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        try {
            if (ConstantManager.EMPTY.equalsIgnoreCase(image.getOriginalFilename())) {
                model.addAttribute(ConstantManager.ERROR_POPUP, BannerConstant.BANNER_NEED_IMG);
                return initiate(model, session, url);
            }
            Banner ban = new Banner();
            String imgName = Utils.randomCodeImg() + image.getOriginalFilename();
            listNames.add(imgName);
            listFiles.add(image);
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, BannerConstant.URL_STORE_SERVER);
            if (checkUploadImg == false) {
//                model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.UPDATE_FAIL);
                return initiate(model, session, url);
            }
            ban.setActive(Boolean.TRUE);
            ban.setImage(BannerConstant.URL_SERVER + imgName);
            ban.setLink(banLink);
            ban.setType(typeId);
            if (Objects.equals(banService.insertBanner(ban), Boolean.FALSE)) {
                model.put(ConstantManager.ERROR_POPUP, BannerConstant.INSERT_BANNER_FAIL);
                return initiate(model, session, url);
            }
            model.addAttribute(ConstantManager.OK_POPUP, BannerConstant.INSERT_BANNER_OK);
            return initiate(model, session, url);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            model.addAttribute(ConstantManager.ERROR_POPUP, BannerConstant.INSERT_BANNER_FAIL);
            return initiate(model, session, url);
        }
    }

    @RequestMapping(params = ConstantManager.UPDATE_FUNCTION, method = RequestMethod.POST)
    public String update(ModelMap model, HttpSession session,
            @RequestParam(BannerConstant.ID_PARAM) int id,
            @RequestParam(BannerConstant.ACTIVE_PARAM) Boolean active,
            @RequestParam(BannerConstant.LINK_PARAM) String banLink,
            @RequestParam(BannerConstant.TYPE_ID_PARAM) int typeId,
            @RequestParam(BannerConstant.IMG_PARAM) MultipartFile image,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url) {
        if (Objects.equals(banService.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accountController.initiate(model, session);
        }
        Banner ban = banService.getBannerById(id);
        if (!image.isEmpty()) {
            List<String> listNames = new ArrayList<>();
            List<MultipartFile> listFiles = new ArrayList<>();
            String imgName = Utils.randomCodeImg() + image.getOriginalFilename();
            listNames.add(imgName);
            listFiles.add(image);
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, BannerConstant.URL_STORE_SERVER);
            if (Objects.equals(checkUploadImg, Boolean.FALSE)) {
                model.addAttribute(ConstantManager.ERROR_POPUP, BannerConstant.UPDATE_BANNER_FAIL);
                return initiate(model, session, url);
            }
            ban.setImage(BannerConstant.URL_SERVER + imgName);
        } else {
            ban.setImage(ban.getImage());
        }
        ban.setLink(banLink);
        ban.setType(typeId);
        if (Objects.equals(banService.updateBanner(ban), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, BannerConstant.UPDATE_BANNER_FAIL);
            return redirectUpdatePage(id, model, session, url);
        }
        model.addAttribute(ConstantManager.OK_POPUP, BannerConstant.UPDATE_BANNER_OK);
        return initiate(model, session, url);
    }
}
