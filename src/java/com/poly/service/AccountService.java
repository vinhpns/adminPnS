/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Account;
import com.poly.bean.Role;
import com.poly.dao.AccountDAO;
import com.poly.request.AccountPassword;
import com.poly.tool.checkLogin;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Vinh
 */
@Service
public class AccountService {

    @Autowired
    AccountDAO accDAO;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleAdmin(role) == true
                || checkLogin.checkLoginRoleSuperAdmin(role));
    }

    public Account getAccountLogin(String email) {
        Account checkByEmail = accDAO.getAccountByEmail(email);
        Account checkByUserName = accDAO.getAccountByUserName(email);
        if (checkByEmail == null && checkByUserName == null) {
            return null;
        }
        if (checkByEmail != null) {
            return checkByEmail;
        } else {
            return checkByUserName;
        }
    }

    public Boolean checkPassLogin(String password, String passlogin) {
        PasswordEncoder pw = new BCryptPasswordEncoder();
        if (pw.matches(password, passlogin)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<Account> getListAccount() {
        return accDAO.getList();
    }

    public List<Role> initListRole() {
        ArrayList<Role> role = new ArrayList<>();
        Role r = new Role(1, "Writer");
        Role r1 = new Role(2, "Mod");
        Role r2 = new Role(3, "Admin");
        Role r3 = new Role(4, "Super");
        role.add(r);
        role.add(r1);
        role.add(r2);
        role.add(r3);
        return role;
    }

    public Boolean updatePass(AccountPassword ap) {
        return !Objects.equals(accDAO.updatePassword(ap), Boolean.FALSE);
    }

    public Boolean insertAccount(Account ac) {
        UUID uuid = UUID.randomUUID();
        ac.setId(uuid.toString());
        PasswordEncoder pw = new BCryptPasswordEncoder();
        ac.setPassword(pw.encode(ac.getPassword()));
        if (Objects.equals(accDAO.insert(ac), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
