/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.constant.AccountConstant;
import com.poly.request.AccountPassword;
import com.poly.request.AccountRequestEntity;
import com.poly.service.AccountService;
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

@Controller
@RequestMapping(value = ConstantManager.USER_PAGE)
public class UserController {

    @Autowired
    AccountService accSer;

    AccountController accController = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.put(AccountConstant.ROLE_KEY, accSer.initListRole());
        model.put(AccountConstant.LISTUSER, accSer.getListAccount());
        return AccountConstant.LIST_USER_PAGE;
    }

    @RequestMapping(params = "insert", method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @ModelAttribute("account") AccountRequestEntity ac) {
        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (!Objects.equals(accSer.getAccountLogin(ac.getEmail()), null)
                || !Objects.equals(accSer.getAccountLogin(ac.getUserName()), null)) {
            model.put(ConstantManager.ERROR_POPUP, "Tài khoản đã có trong hệ thống");
            return initiate(model, session);
        }
        if (Objects.equals(accSer.insertAccount(ac, (String) session.getAttribute("accountId")), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Thêm tài khoản không thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Thêm tài khoản thành công");
        return initiate(model, session);
    }

    @RequestMapping(params = "changeStatus")
    public String updateStatus(ModelMap model, HttpSession session,
            @RequestParam(AccountConstant.ID_REQUEST_PARAM) String id,
            @RequestParam(AccountConstant.STATUS_REQUEST_PARAM) Boolean status) {
        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(accSer.updateStatus(id, status), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, AccountConstant.LOCK_FAIL);
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, AccountConstant.LOCK_SUCCESSFUL);
        return initiate(model, session);
    }

    @RequestMapping(params = "delete", method = RequestMethod.GET)
    public String delete(ModelMap model, HttpSession session,
            @RequestParam(AccountConstant.ID_REQUEST_PARAM) String id) {
        if (Objects.equals(accSer.delete(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, AccountConstant.DELETE_FAIL);
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, AccountConstant.DELETE_OK);
        return initiate(model, session);
    }
    
    @RequestMapping(params = "password", method = RequestMethod.POST)
    public String updatePassword(ModelMap model, HttpSession session,
            @ModelAttribute("account") AccountPassword ap) {
        if (ap.getNewPassword().equalsIgnoreCase(ap.getOldPassword())) {
            model.put(ConstantManager.ERROR_POPUP, "Mật khẩu mới không được trùng mật khẩu cũ");
            return initiate(model, session);
        }
        if (Objects.equals(accSer.updatePass(ap), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Đổi mật khẩu không thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Đổi mật khẩu thành công");
        return initiate(model, session);
    }
    public String updateInfo(HttpSession session , ModelMap model,
            @RequestParam("id") String id){
        if (Objects.equals(accSer.updateInfo(acc, id), Boolean.TRUE)) {
            model.put(ConstantManager.OK_POPUP, "Cập nhật thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.ERROR_POPUP, "Cập nhật không thành công");
        return initiate(model, session);
    }
}
