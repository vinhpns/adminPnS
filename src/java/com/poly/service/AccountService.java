/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Account;
import com.poly.bean.Customer;
import com.poly.bean.Rank;
import com.poly.bean.Role;
import com.poly.constant.AccountConstant;
import com.poly.dao.AccountDAO;
import com.poly.dao.RoleDAO;
import com.poly.request.AccountPassword;
import com.poly.request.AccountRequestEntity;
import com.poly.tool.Utils;
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
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Vinh
 */
@Service
public class AccountService {

    @Autowired
    private AccountDAO accDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    RankService rankService;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleHr(role) == true
                || checkLogin.checkLoginRoleIt(role) == true
                || checkLogin.checkLoginRoleAdmin(role) == true);
    }

    public List<Rank> getListRank() {
        return rankService.getListRank();
    }

    public List<Account> getList(int type) {
        return accDAO.getList(type);
    }

    public List<Role> getListRole(int type) {
        return roleDAO.getListRole(type);
    }

    public Boolean changeActive(String id, Boolean active) {
        return !Objects.equals(accDAO.changeActive(active, id), Boolean.FALSE);
    }

    public Boolean checkAccountExits(String email, int socialId) {
        if (accDAO.getByEmail(email) != null
                || accDAO.getBySocialIdNumber(socialId) != null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean insert(AccountRequestEntity ac, int type) {
        UUID uuid = UUID.randomUUID();
        PasswordEncoder pw = new BCryptPasswordEncoder();
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        Customer customer = new Customer();

        String custId = uuid.toString();
        Account account = new Account();
        account.setId(custId);
        account.setActive(Boolean.TRUE);
        account.setAddress(ac.getAddress());
        account.setDob(ac.getDob());
        account.setEmail(ac.getEmail());
        account.setFullName(ac.getFullName());
        account.setGender(ac.getGender());
        account.setPassword(pw.encode(ac.getPassword()));
        account.setPhone(ac.getPhone());
        account.setRoleId(ac.getRoleId());
        if (Objects.equals(accDAO.insertAccount(account), Boolean.FALSE)) {
            return Boolean.FALSE;
        }

        customer.setAccountId(custId);
        if (!ac.getAvatar().isEmpty()) {
            String imgName = Utils.randomCodeImg() + ac.getAvatar().getOriginalFilename();
            listNames.add(imgName);
            listFiles.add(ac.getAvatar());
            customer.setAvatar(AccountConstant.URL_SERVER + imgName);
        } else {
            customer.setAvatar(AccountConstant.DEFAULT_AVATAR);
        }

        if (!ac.getBackIdCard().isEmpty()) {
            String backCardName = Utils.randomCodeImg() + ac.getBackIdCard().getOriginalFilename();
            listNames.add(backCardName);
            listFiles.add(ac.getBackIdCard());
            customer.setBackIdCard(AccountConstant.URL_SERVER + backCardName);
        } else {
            customer.setBackIdCard(AccountConstant.DEFAULT_BACK_ID_CARD);
        }

        if (!ac.getFrontIdCard().isEmpty()) {
            String frontCardName = Utils.randomCodeImg() + ac.getFrontIdCard().getOriginalFilename();
            listNames.add(frontCardName);
            listFiles.add(ac.getFrontIdCard());
            customer.setFrontIdCard(AccountConstant.URL_SERVER + frontCardName);
        } else {
            customer.setFrontIdCard(AccountConstant.DEFAULT_FRONT_ID_CARD);
        }

        customer.setBankName(ac.getBankName());
        if (ac.getBankName().equals(AccountConstant.EMPTY)) {
            customer.setBankName(AccountConstant.NONE);
        }
        customer.setBankBranch(ac.getBankBranch());
        if (ac.getBankBranch().equals(AccountConstant.EMPTY)) {
            customer.setBankBranch(AccountConstant.NONE);
        }
        customer.setBankNameHolder(ac.getBankNameHolder());
        if (ac.getBankNameHolder().equals(AccountConstant.EMPTY)) {
            customer.setBankNameHolder(AccountConstant.NONE);
        }
        customer.setBankNumber(ac.getBankNumber());
        if (ac.getBankNumber().equals(AccountConstant.EMPTY)) {
            customer.setBankNumber(AccountConstant.NONE);
        }

        customer.setSocialIdNumber(ac.getSocialIdNumber());
        customer.setRankId(AccountConstant.ACCOUNT_VIP);
        if (type == AccountConstant.TYPE_ROLE_ACCESS_SYSTEM) {
            customer.setRankId(AccountConstant.ACCOUNT_MEMBER);
        }

        if (listNames.size() > 0 && listFiles.size() > 0) {
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, AccountConstant.URL_STORE_SERVER);
            if (Objects.equals(checkUploadImg, Boolean.FALSE)) {
                return Boolean.FALSE;
            }
        }
        if (Objects.equals(accDAO.insertCustomer(customer), Boolean.FALSE)) {
            accDAO.deleteAccount(account.getId());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean delete(String id) {
        if (Objects.equals(accDAO.deleteAccount(id), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Account getAccountInfo(String id) {
        return accDAO.getById(id);
    }

    public Account getAccountLogin(String email) {
        Account account = accDAO.getByEmail(email);
        if (account != null) {
            return account;
        }
        return null;
    }

    public Boolean checkPassLogin(String password, String passlogin) {
        PasswordEncoder pw = new BCryptPasswordEncoder();
        if (pw.matches(password, passlogin)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Customer getCustomerByAccountId(String id) {
        return accDAO.getCustomerByIdAccount(id);
    }

    public Boolean update(AccountRequestEntity ac) {
        Account account = new Account();
        account.setId(ac.getId());
        account.setActive(ac.getActive());
        account.setAddress(ac.getAddress());
        account.setDob(ac.getDob());
        account.setEmail(ac.getEmail());
        account.setFullName(ac.getFullName());
        account.setGender(ac.getGender());
        account.setPassword(ac.getPassword());
        account.setPhone(ac.getPhone());
        account.setRoleId(ac.getRoleId());
        Account check = accDAO.getById(ac.getId());
        if (ac.getEmail().equalsIgnoreCase(check.getEmail())) {
            return !Objects.equals(updateNonEmail(account), Boolean.FALSE);
        }
        return !Objects.equals(updateWithEmail(account), Boolean.FALSE);
    }

    public Boolean updateCustomer(AccountRequestEntity ac) {
        Customer customer = accDAO.getCustomerByIdAccount(ac.getId());
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        if (!ac.getAvatar().isEmpty()) {
            String imgName = Utils.randomCodeImg() + ac.getAvatar().getOriginalFilename();
            listNames.add(imgName);
            listFiles.add(ac.getAvatar());
            customer.setAvatar(AccountConstant.URL_SERVER + imgName);
        }

        if (!ac.getBackIdCard().isEmpty()) {
            String backCardName = Utils.randomCodeImg() + ac.getBackIdCard().getOriginalFilename();
            listNames.add(backCardName);
            listFiles.add(ac.getBackIdCard());
            customer.setBackIdCard(AccountConstant.URL_SERVER + backCardName);
        }

        if (!ac.getFrontIdCard().isEmpty()) {
            String frontCardName = Utils.randomCodeImg() + ac.getFrontIdCard().getOriginalFilename();
            listNames.add(frontCardName);
            listFiles.add(ac.getFrontIdCard());
            customer.setFrontIdCard(AccountConstant.URL_SERVER + frontCardName);
        }
        customer.setBankBranch(ac.getBankBranch());
        customer.setBankName(ac.getBankName());
        customer.setBankNameHolder(ac.getBankNameHolder());
        customer.setBankNumber(ac.getBankNumber());
        customer.setPoint(ac.getPoint());
        customer.setRankId(ac.getRankId());

        if (listNames.size() > 0 && listFiles.size() > 0) {
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, AccountConstant.URL_STORE_SERVER);
            if (Objects.equals(checkUploadImg, Boolean.FALSE)) {
                return Boolean.FALSE;
            }
        }
        if (customer.getSocialIdNumber() == ac.getSocialIdNumber()) {
            return !Objects.equals(accDAO.updateCustomerInfo(customer, AccountConstant.UPDATE_NON_IDNUMBER), Boolean.FALSE);
        }
        customer.setSocialIdNumber(ac.getSocialIdNumber());
        return !Objects.equals(updateWithIdNumber(customer), Boolean.FALSE);
    }

    public Boolean updateWithIdNumber(Customer customer) {
        if (accDAO.getBySocialIdNumber(customer.getSocialIdNumber()) != null) {
            return Boolean.FALSE;
        }
        return !Objects.equals(accDAO.updateCustomerInfo(customer, AccountConstant.UPDATE_WITH_IDNUMBER), Boolean.FALSE);
    }

    public Boolean updateNonEmail(Account ac) {
        return !Objects.equals(accDAO.updateAccountInfo(ac, AccountConstant.UPDATE_NON_EMAIL), Boolean.FALSE);
    }

    public Boolean updateWithEmail(Account ac) {
        if (getAccountLogin(ac.getEmail()) != null) {
            return Boolean.FALSE;
        }
        return !Objects.equals(accDAO.updateAccountInfo(ac, AccountConstant.UPDATE_WITH_EMAIL), Boolean.FALSE);
    }

    public Boolean updatePassword(AccountPassword accountPassword) {
        Account ac = new Account();
        ac.setId(accountPassword.getId());
        ac.setPassword(accountPassword.getNewPassword());
        return !Objects.equals(accDAO.updateAccountInfo(ac, 3), Boolean.FALSE);
    }
}
