/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.EmailContent;
import com.poly.dao.EmailContentDAO;
import com.poly.tool.checkLogin;

import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VinhNT
 */
@Service
public class EmailService {

    @Autowired
    private EmailContentDAO emailDAO;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleMod(role) == true
                || checkLogin.checkLoginRoleAdmin(role) == true);
    }

    public List<EmailContent> getListEmail() {
        return emailDAO.getListEmail();
    }

    public Boolean checkEmailExits(String title) {
        EmailContent email = emailDAO.checkEmailExits(title);
        if (email == null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean insertEmail(EmailContent email) {
        return !Objects.equals(emailDAO.insertEmail(email), Boolean.FALSE);
    }

    public EmailContent getEmailById(int id) {
        EmailContent email = emailDAO.getEmailById(id);
        if (email == null) {
            return null;
        }
        return email;
    }

    public Boolean updateEmail(EmailContent email) {
        return !Objects.equals(emailDAO.updateEmail(email), Boolean.FALSE);
    }
}
