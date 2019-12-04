/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.constant.AccountConstant;
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

//    @RequestMapping(params = "password", method = RequestMethod.POST)
//    public String updatePassword(ModelMap model, HttpSession session,
//            @ModelAttribute("account") AccountPassword ap) {
//        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
//            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//        if (ap.getNewPassword().equalsIgnoreCase(ap.getOldPassword())) {
//            model.put(ConstantManager.ERROR_POPUP, "Mật khẩu mới không được trùng mật khẩu cũ");
//            return initiate(model, session);
//        }
//        if (Objects.equals(accSer.updatePass(ap), Boolean.FALSE)) {
//            model.put(ConstantManager.ERROR_POPUP, "Đổi mật khẩu không thành công");
//            return initiate(model, session);
//        }
//        model.put(ConstantManager.OK_POPUP, "Đổi mật khẩu thành công");
//        return initiate(model, session);
//    }
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

//    @RequestMapping(params = ConstantManager.INSERT_FUNCTION, method = RequestMethod.POST)
//    public String insert(ModelMap model, HttpSession session,
//            @ModelAttribute(AccountConstant.ACCOUNT_MODEL_REQUEST_PARAM) AccountRequestEntity ac,
//            @RequestParam("url") String url) {
//        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
//            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//        if (Objects.equals(accSer.checkAccountExits(ac.getEmail(), ac.getSocialIdNumber()), Boolean.FALSE)) {
//            model.addAttribute(ConstantManager.ERROR_POPUP, AccountConstant.EMAIL_EXITED);
//            return initiate(model, session, url);
//        }
//        int type = AccountConstant.TYPE_ROLE_ACCESS_SYSTEM;
//        if (url.equalsIgnoreCase(AccountConstant.ADMIN_SITE)) {
//            type = AccountConstant.TYPE_ROLE_MANAGER_SYSTEM;
//        }
//        if (Objects.equals(accSer.insert(ac, type), Boolean.FALSE)) {
//            model.put(ConstantManager.ERROR_POPUP, AccountConstant.INSERT_FAIL);
//            return initiate(model, session, url);
//        }
//        model.put(ConstantManager.OK_POPUP, AccountConstant.INSERT_OK);
//        return initiate(model, session, url);
//    }
//
//    @RequestMapping(params = ConstantManager.DELETE_FUNCTION, method = RequestMethod.GET)
//    public String deleteCustomer(ModelMap model, HttpSession session,
//            @RequestParam(AccountConstant.ID_REQUEST_PARAM) String id,
//            @RequestParam("url") String url) {
//        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
//            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//        if (Objects.equals(accSer.delete(id), Boolean.FALSE)) {
//            model.put(ConstantManager.ERROR_POPUP, AccountConstant.DELETE_FAIL);
//            return initiate(model, session, url);
//        }
//        model.put(ConstantManager.OK_POPUP, AccountConstant.DELETE_OK);
//        return initiate(model, session, url);
//    }
//
//    @RequestMapping(params = ConstantManager.GET_FUNCTION, method = RequestMethod.GET)
//    public String redirectUpdatePage(ModelMap model, HttpSession session,
//            @RequestParam(AccountConstant.ID_REQUEST_PARAM) String customerId,
//            @RequestParam("url") String url) {
//        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
//            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//        model.put("url", url);
//        if (url.equalsIgnoreCase(AccountConstant.ADMIN_SITE)) {
//            model.put(AccountConstant.ROLE_KEY,
//                    accSer.getListRole(AccountConstant.TYPE_ROLE_MANAGER_SYSTEM));
//        } else {
//            model.put(AccountConstant.ROLE_KEY,
//                    accSer.getListRole(AccountConstant.TYPE_ROLE_ACCESS_SYSTEM));
//        }
//        model.addAttribute(AccountConstant.ACCOUNT_INFO, accSer.getAccountInfo(customerId));
//        model.addAttribute(AccountConstant.CUSTOMER_INFO, accSer.getCustomerByAccountId(customerId));
//        model.addAttribute(AccountConstant.RANK_ID, accSer.getListRank());
//
//        return AccountConstant.UPDATE_PAGE;
//    }
//
//    @RequestMapping(params = ConstantManager.UPDATE_FUNCTION, method = RequestMethod.POST)
//    public String updateInfoCustomer(ModelMap model, HttpSession session,
//            @ModelAttribute(AccountConstant.ACCOUNT_MODEL_REQUEST_PARAM) AccountRequestEntity ac,
//            @RequestParam("url") String url) {
//        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
//            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//        if (Objects.equals(accSer.updateCustomer(ac), Boolean.FALSE)) {
//            model.put(ConstantManager.ERROR_POPUP, AccountConstant.UPDATE_FAIL);
//            return redirectUpdatePage(model, session, ac.getId(), url);
//        }
//        if (Objects.equals(accSer.update(ac), Boolean.FALSE)) {
//            model.put(ConstantManager.ERROR_POPUP, AccountConstant.UPDATE_FAIL);
//            return redirectUpdatePage(model, session, ac.getId(), url);
//        }
//        model.put(ConstantManager.OK_POPUP, AccountConstant.UPDATE_OK);
//        return initiate(model, session, url);
//    }
//
//    @RequestMapping(params = ConstantManager.UPDATE_PASSWORD, method = RequestMethod.POST)
//    public String updatePassCustomer(ModelMap model, HttpSession session,
//            @ModelAttribute(AccountConstant.ACCOUNT_MODEL_REQUEST_PARAM) AccountPassword ac,
//            @RequestParam("url") String url) {
//        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
//            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//        if (!ac.getNewPassword().equalsIgnoreCase(ac.getReNewPassword())) {
//            model.put(ConstantManager.ERROR_POPUP, AccountConstant.NOT_LIKE_IN_PASSWORD);
//            return initiate(model, session, url);
//        }
//        if (Objects.equals(accSer.checkPassLogin(ac.getNewPassword(), ac.getOldPassword()), Boolean.TRUE)) {
//            model.put(ConstantManager.ERROR_POPUP, AccountConstant.DUPLICATE_OLD_PASSWORD);
//            return initiate(model, session, url);
//        }
//        PasswordEncoder pw = new BCryptPasswordEncoder();
//        ac.setNewPassword(pw.encode(ac.getNewPassword()));
//        if (Objects.equals(accSer.updatePassword(ac), Boolean.FALSE)) {
//            model.put(ConstantManager.ERROR_POPUP, AccountConstant.UPDATE_FAIL);
//            return initiate(model, session, url);
//        }
//        model.put(ConstantManager.OK_POPUP, AccountConstant.UPDATE_OK);
//        return initiate(model, session, url);
//    }
}
