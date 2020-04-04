/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Account;
import com.poly.bean.AccountInfo;
import com.poly.bean.Role;
import com.poly.dao.AccountDAO;
import com.poly.request.AccountPassword;
import com.poly.request.AccountRequestEntity;
import com.poly.response.AccountResponse;
import com.poly.tool.checkLogin;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author
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

    public AccountResponse getAccountLogin(String email) {
        AccountResponse checkByEmail = accDAO.getAccountByEmail(email);
        if (checkByEmail == null) {
            return null;
        }
        return checkByEmail;
    }

    public Boolean checkPassLogin(String password, String passlogin) {
        PasswordEncoder pw = new BCryptPasswordEncoder();
        if (pw.matches(password, passlogin)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<AccountResponse> getListAccount(String companyId, int type) {
        List<AccountResponse> accountResponse = accDAO.getList(companyId);
        List<AccountResponse> list = accountResponse;
        switch (type) {
            case 1:
                list = accountResponse.stream()
                        .filter(p -> p.getRole() != 1)
                        .collect(Collectors.toList());
                System.out.println(list);
                break;
            case 2:
                list = accountResponse.stream()
                        .filter(p -> p.getRole() == 1)
                        .collect(Collectors.toList());
                System.out.println(list);
                break;
        }
        return list;
    }

    public List<Role> initListRole() {
        ArrayList<Role> role = new ArrayList<>();
        Role r = new Role(1, "Customer");
        Role r1 = new Role(2, "Super Admin");
        Role r2 = new Role(3, "Admin");
        Role r3 = new Role(4, "Writer");
        Role r4 = new Role(5, "Caisher");
        role.add(r);
        role.add(r1);
        role.add(r2);
        role.add(r3);
        role.add(r4);
        return role;
    }

    public Boolean updatePass(AccountPassword ap) {
        PasswordEncoder pw = new BCryptPasswordEncoder();
        ap.setNewPassword(pw.encode(ap.getNewPassword()));
        return !Objects.equals(accDAO.updatePassword(ap), Boolean.FALSE);
    }

    public Boolean insertAccount(AccountRequestEntity ac) {
        UUID uuid = UUID.randomUUID();
        PasswordEncoder pw = new BCryptPasswordEncoder();
        Account account = new Account();
        account.setId(uuid.toString());
        account.setEmail(ac.getEmail());
        account.setPassword(pw.toString());
        account.setCompanyId(ac.getCompanyId());
        account.setCreatedBy(ac.getCreatedBy());
        if (Objects.equals(accDAO.insert(account), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountId(account.getId());
        accountInfo.setFullName(ac.getFullName());
        accountInfo.setGender(ac.getGender());
        accountInfo.setRole(ac.getRole());
        accountInfo.setPhone(ac.getPhone());
        accountInfo.setDob(ac.getDob());
        accountInfo.setAddress(ac.getAddress());
        if (Objects.equals(accDAO.insertAccountInfo(accountInfo), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean updateStatus(String id, Boolean status) {
        Account ac = new Account();
        ac.setIsActive(status);
        ac.setId(id);
        return !Objects.equals(accDAO.updateStatus(ac), Boolean.FALSE);
    }

    public AccountResponse getAccountById(String id) {
        return accDAO.getAccountById(id);
    }

    public Boolean delete(String id) {
        return !Objects.equals(accDAO.delete(id), Boolean.FALSE);
    }

    public Boolean updateInfo(AccountRequestEntity acc) {
        Account a = new Account();
        a.setId(acc.getId());
        a.setUpdatedBy(acc.getCreatedBy());
        a.setEmail(acc.getEmail());
        if (Objects.equals(accDAO.updateAccount(a), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setFullName(acc.getFullName());
        accountInfo.setGender(acc.getGender());
        accountInfo.setRole(acc.getRole());
        accountInfo.setPhone(acc.getPhone());
        accountInfo.setDob(acc.getDob());
        accountInfo.setAddress(acc.getAddress());
        accountInfo.setAccountId(acc.getId());
        return !Objects.equals(accDAO.updateInfo(accountInfo), Boolean.FALSE);
    }

    public Boolean updatePost(String id, int type) {
        AccountResponse a = getAccountById(id);
        switch (type) {
            case 1:
                a.setCountNews(a.getCountNews() + 1);
                break;
            case 2:
                a.setCountNews(a.getCountNews() - 1);
                break;
        }
        return !Objects.equals(accDAO.updatePostByAccountId(a.getId(), a.getCountNews()), Boolean.FALSE);
    }
}
