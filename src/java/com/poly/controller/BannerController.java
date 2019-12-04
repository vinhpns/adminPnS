/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.constant.BannerConstant;
import com.poly.service.BannerService;
import com.poly.tool.ConstantManager;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class BannerController {

    @Autowired
    BannerService banService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) { 
        model.put(BannerConstant.LIST_BANNER_KEY, banService.getListBanner());
        return BannerConstant.BANNER_RETURN_PAGE;
    }

    @RequestMapping(params = ConstantManager.LOCK_FUNCTION)
    public String updateStatus(ModelMap model, HttpSession session,
            @RequestParam(BannerConstant.ID_PARAM) String id,
            @RequestParam(BannerConstant.STATUS_PARAM) Boolean active) {
        
        Boolean resultStatus = banService.updateStatus(id, active);
        if (Objects.equals(resultStatus, Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, BannerConstant.LOCK_BANNER_FAIL);
        }
        model.addAttribute(ConstantManager.OK_POPUP, BannerConstant.LOCK_BANNER_OK);
        return initiate(model, session);
    }
    @RequestMapping(params = ConstantManager.DELETE_FUNCTION)
    public String delete(ModelMap model, HttpSession session,
            @RequestParam(BannerConstant.ID_PARAM) String id) {       
        if (Objects.equals(banService.deleteBanner(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, BannerConstant.DELETE_BANNER_FAIL);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, BannerConstant.DELETE_BANNER_OK);
        return initiate(model, session);
    }  
}
