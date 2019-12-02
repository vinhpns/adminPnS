package com.poly.controller;

import com.poly.bean.Account;
import com.poly.constant.AccountConstant;
import com.poly.service.AccountService;
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

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        if (Objects.equals(checkLogin.checkLogin(session), ConstantManager.STATUS_FALSE)) {
            String errors = ConstantManager.NO_ACCEPTED_LOGIN;
            return logout(session, model, errors);
        }
        return AccountConstant.INDEXPAGE;
    }

    @RequestMapping(params = AccountConstant.BUTTON_LOGIN, method = RequestMethod.POST)
    public String login(ModelMap model, HttpSession session,
            @RequestParam(AccountConstant.USERNAME_REQUESTPARAM) String email,
            @RequestParam(AccountConstant.PASSWORD_REQUESTPARAM) String password) {
        Account ac = accService.getAccountLogin(email);
        if (ac == null) {
            model.put(ConstantManager.ERROR_POPUP, AccountConstant.NO_EMAIL_EXITS);
            return AccountConstant.LOGINPAGE;
        }
        if (Objects.equals(ac.getActive(), Boolean.FALSE)) {
            String errors = AccountConstant.BLOCK_ACCOUNT;
            return logout(session, model, errors);
        }
        if (Objects.equals(accService.checkPassLogin(password, ac.getPassword()), Boolean.FALSE)) {
            String errors = AccountConstant.WRONG_PASSWORD;
            return logout(session, model, errors);
        }
        if (ac.getRoleId() < 0 || ac.getRoleId() == 8) {
            model.put(ConstantManager.ERROR_POPUP, AccountConstant.EMPLOYEE_ONLY);
            return AccountConstant.LOGINPAGE;
        }
        if (ac.getRoleId() <= 7 || ac.getRoleId() == 9) {
            session.setAttribute(ConstantManager.EMAIL_SESSION_KEY, ac.getEmail());
            session.setAttribute(ConstantManager.LOGIN_NAME_SESSION_KEY, ac.getFullName());
            session.setAttribute(ConstantManager.ROLEIZ_SESSION_KEY, ac.getRoleId());
            session.setAttribute(ConstantManager.ACCOUNT_ID_SESSION_KEY, ac.getId());
            return initiate(model, session);
        }
        model.put(ConstantManager.ERROR_POPUP, AccountConstant.EMPLOYEE_ONLY);
        return AccountConstant.LOGINPAGE;
    }

    @RequestMapping(params = AccountConstant.BUTTON_LOGOUT)
    public String logout(HttpSession session, ModelMap model, String errors) {
        session.invalidate();
        model.put(ConstantManager.ERROR_POPUP, errors);
        return AccountConstant.LOGINPAGE;
    }
}
