/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Different;
import com.poly.service.AccountService;
import com.poly.service.DifferentService;
import com.poly.tool.ConstantManager;
import com.poly.tool.checkLogin;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 1
 */
@Controller
@RequestMapping("different")
public class DifferentController {

    @Autowired
    DifferentService differentService;

    @Autowired
    AccountService accService;

    AccountController ac = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            String errors = ConstantManager.NO_ACCEPTED_LOGIN;
            return ac.logout(session, model, errors);
        }
//        model.put("diff", differentService.getByCompanyId(accService.getAccountById((String) session.getAttribute("accountId")).getCompanyId()));
        return "different";
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(ModelMap model, HttpSession session, @ModelAttribute("different") Different d) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            String errors = ConstantManager.NO_ACCEPTED_LOGIN;
            return ac.logout(session, model, errors);
        }
        if (Objects.equals(differentService.update(d), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Chỉnh sửa không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Chỉnh sửa thành công");
        }
        return initiate(model, session);
    }
}
