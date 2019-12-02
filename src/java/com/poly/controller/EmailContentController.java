/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.EmailContent;
import com.poly.constant.EmailConstant;
import com.poly.service.EmailService;
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
 * @author VinhNT
 */
@Controller
@RequestMapping(ConstantManager.EMAIL_PAGE)
public class EmailContentController {

    @Autowired
    EmailService emailSer;

    AccountController accController = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        if (emailSer.checkLogin(session) == false) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.addAttribute(EmailConstant.LIST_EMAIL, emailSer.getListEmail());
        return EmailConstant.PAGE_EMAIL;
    }

    @RequestMapping(params = ConstantManager.GET_FUNCTION, method = RequestMethod.GET)
    public String redirectEditPage(ModelMap model, HttpSession session,
            @RequestParam(EmailConstant.ID_PARAM) int id) {
        if (emailSer.checkLogin(session) == false) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        EmailContent mail = emailSer.getEmailById(id);
        if (mail != null) {
            model.addAttribute(EmailConstant.EMAIL_INFO, emailSer.getEmailById(id));
            return EmailConstant.PAGE_EDIT_EMAIL;
        }
        model.put(ConstantManager.ERROR_POPUP, EmailConstant.CANNOT_FIND_EMAIL);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.INSERT_FUNCTION, method = RequestMethod.POST)
    public String addNewEmail(HttpSession session, ModelMap model,
            @ModelAttribute(EmailConstant.EMAIL_CONTENT_PARAM) EmailContent email) {
        if (emailSer.checkLogin(session) == false) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(emailSer.checkEmailExits(email.getTitle()), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, EmailConstant.EMAIL_EXITS);
            return initiate(model, session);
        }
        if (Objects.equals(emailSer.insertEmail(email), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, EmailConstant.INSERT_EMAIL_FAIL);
        }
        model.put(ConstantManager.OK_POPUP, EmailConstant.INSERT_EMAIL_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.UPDATE_FUNCTION, method = RequestMethod.POST)
    public String updateEmail(HttpSession session, ModelMap model,
            @ModelAttribute(EmailConstant.EMAIL_CONTENT_PARAM) EmailContent email) {
        if (emailSer.checkLogin(session) == false) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        EmailContent emailLoad = emailSer.getEmailById(email.getId());
        if (!emailLoad.getTitle().equalsIgnoreCase(email.getTitle())) {
            if (Objects.equals(emailSer.checkEmailExits(email.getTitle()), Boolean.FALSE)) {
                model.addAttribute(ConstantManager.ERROR_POPUP, EmailConstant.EMAIL_EXITS);
                return initiate(model, session);
            }
            emailLoad.setTitle(email.getTitle());
        }
        emailLoad.setTitle(emailLoad.getTitle());
        emailLoad.setContent(email.getContent());
        if (Objects.equals(emailSer.updateEmail(emailLoad), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.OK_POPUP, EmailConstant.UPDATE_EMAIL_FAIL);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, EmailConstant.UPDATE_EMAIL_OK);
        return initiate(model, session);
    }
}
