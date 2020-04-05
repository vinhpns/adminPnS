package com.poly.controller;

import com.poly.constant.AccountConstant;
import com.poly.response.AccountResponse;
import com.poly.service.AccountService;
import com.poly.service.CompanyService;
import com.poly.service.NewsService;
import com.poly.tool.ConstantManager;
import com.poly.tool.checkLogin;

import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(AccountConstant.INDEXPAGE)
public class AccountController {

    @Autowired
    AccountService accService;

    @Autowired
    NewsService newService;

    @Autowired
    CompanyService companyService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            String errors = ConstantManager.NO_ACCEPTED_LOGIN;
            return logout(session, model, errors);
        }
        model.put("link", "index.htm");
        session.setAttribute("commentNotRead", 0);
        session.setAttribute("info", companyService.getInfo((String) session.getAttribute("companyId")));
        model.put("newsCount", 0);
        model.put("commentCount", 0);
        model.put("customerCount", accService.getListAccount((String)session.getAttribute("companyId"),2).size());
        model.put("accountCount", accService.getListAccount((String)session.getAttribute("companyId"),1).size());
        return AccountConstant.INDEXPAGE;
    }

    @RequestMapping(params = AccountConstant.BUTTON_LOGIN, method = RequestMethod.POST)
    public String login(ModelMap model, HttpSession session,
            @RequestParam(AccountConstant.USERNAME_REQUESTPARAM) String email,
            @RequestParam(AccountConstant.PASSWORD_REQUESTPARAM) String password) {
        AccountResponse ac = accService.getAccountLogin(email);
        if (ac == null) {
            return logout(session, model, AccountConstant.NO_EMAIL_EXITS);
        }
        if (Objects.equals(ac.getIsActive(), Boolean.FALSE)) {
            String errors = AccountConstant.BLOCK_ACCOUNT;
            return logout(session, model, errors);
        }
        if (Objects.equals(accService.checkPassLogin(password, ac.getPassword()), Boolean.FALSE)) {
            String errors = AccountConstant.WRONG_PASSWORD;
            return logout(session, model, errors);
        }
        session.setAttribute(ConstantManager.ROLEID, ac.getRole());
        session.setAttribute(ConstantManager.LOGIN_NAME_SESSION_KEY, ac.getFullName());
        session.setAttribute(ConstantManager.ACCOUNT_ID_SESSION_KEY, ac.getId());
        session.setAttribute("companyId", ac.getCompanyId());
        return initiate(model, session);
    }

    @RequestMapping(params = AccountConstant.BUTTON_LOGOUT)
    public String logout(HttpSession session, ModelMap model, String errors) {
        session.invalidate();
        model.put(ConstantManager.ERROR_POPUP, errors);
        return ConstantManager.LOGIN_PAGE;
    }
}
