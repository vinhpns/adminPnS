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
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String update(ModelMap model, HttpSession session, @ModelAttribute("banner") Banner ban) {
        if (Objects.equals(banService.updateBanner(ban), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Update banner không thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Update thành công");
        return initiate(model, session);
    }
    
    @RequestMapping(params = "insert", method = RequestMethod.POST)
    public String insert (ModelMap model, HttpSession session, @ModelAttribute("banner") Banner banner){
        if(Objects.equals(banService.insertBanner(banner), Boolean.FALSE)){
            model.put(ConstantManager.ERROR_POPUP, "Thêm banner không thành công");
            return initiate(model, session);
        }
        return initiate(model, session);
    }
}
