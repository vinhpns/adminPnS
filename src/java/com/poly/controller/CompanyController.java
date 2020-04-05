/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.request.CompanyRequest;
import com.poly.service.AccountService;
import com.poly.service.CompanyService;
import com.poly.tool.ConstantManager;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    
    @Autowired
    AccountService accountService;

//    @RequestMapping()
//    public String initiate(ModelMap model, HttpSession session) {
//        model.put("company", companyService.getInfo(accountService.getAccountById
//        ((String) session.getAttribute("accountId")).getCompanyId()));
//        return "company-info";
//    }
//
//    @RequestMapping(params = "updateCompany", method = RequestMethod.POST)
//    public String update(ModelMap model, HttpSession session,
//            @ModelAttribute("company") CompanyRequest c) {
//        c.setCompanyId(accountService.getAccountById
//        ((String) session.getAttribute("accountId")).getCompanyId());
//        if (Objects.equals(companyService.update(c), Boolean.FALSE)) {
//            model.put(ConstantManager.ERROR_POPUP, "Chỉnh sửa không thành công");
//        } else {
//            model.put(ConstantManager.OK_POPUP, "Chỉnh sửa thành công");
//        }
//        return initiate(model, session);
//    }
}
