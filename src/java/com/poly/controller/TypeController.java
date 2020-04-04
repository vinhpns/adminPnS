/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.request.TypeRequest;
import com.poly.service.AccountService;
import com.poly.service.TypeService;
import com.poly.tool.ConstantManager;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author 1
 */
@Controller
@RequestMapping("type")
public class TypeController {

    @Autowired
    TypeService typeService;

    @Autowired
    AccountService accountService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session, @RequestParam("type") int type) {
        model.put("right", "Mục");
//        model.put("type", typeService.getTypeById(type,
//                accountService.getAccountById((String) session.getAttribute("accountId")).getCompanyId()));
        return "type";
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(ModelMap model, HttpSession session,
            @ModelAttribute("type") TypeRequest typeRequest) {
        if (Objects.equals(typeService.updateType(typeRequest), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Thêm tin mới không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Thêm tin mới thành công");
        }
        return initiate(model, session, typeRequest.getType());
    }
}
