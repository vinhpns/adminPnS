package com.poly.service;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.poly.service;
//
//import com.poly.bean.Account;
//import com.poly.bean.Customer;
//import com.poly.bean.Rank;
//import com.poly.bean.Role;
//import com.poly.constant.AccountConstant;
//import com.poly.constant.CustomerConstant;
//import com.poly.constant.RoleConstant;
//import com.poly.dao.AccountDAO;
//import com.poly.dao.CustomerDAO;
//import com.poly.dao.RankDAO;
//import com.poly.tool.Utils;
//import com.poly.tool.checkLogin;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Random;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
///**
// * @author Vinh
// */
//@Service
//public class CustomerService {
//
//    @Autowired
//    private AccountDAO accDAO;
//
//    @Autowired
//    private CustomerDAO custDAO;
//
//    @Autowired
//    private RankDAO rDAO;
//
//    public List<Account> getListCustomer() {
//        return accDAO.getListCustomer(AccountConstant.ROLE_CUSTOMER);
//    }
//
//    public List<Rank> getListRank() {
//        return rDAO.getListRank();
//    }
//
//    public Boolean checkLogin(HttpSession session) {
//        if (checkLogin.checkLogin(session) == false) {
//            return false;
//        }
//        return checkLoginRole(session) != false;
//    }
//
//    public Boolean checkLoginRole(HttpSession session) {
//        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
//        return (checkLogin.checkLoginRoleHr(role) == true
//                || checkLogin.checkLoginRoleIt(role) == true
//                || checkLogin.checkLoginRoleAdmin(role) == true);
//    }
//
//    public Boolean changeActiveAccount(String id, Boolean statusCategory) {
//        if (Objects.equals(statusCategory, Boolean.FALSE)) {
//            return !Objects.equals(accDAO.changeActiveStatus(Boolean.TRUE, id), Boolean.FALSE);
//        }
//        return !Objects.equals(accDAO.changeActiveStatus(Boolean.FALSE, id), Boolean.FALSE);
//    }
//
//    public List<Role> returnListRole() {
//        return accDAO.getListCustomerRole(AccountConstant.ROLE_CUSTOMER);
//    }
//
//    public Boolean checkAccountExits(String email, String socialNumber) {
//        if (custDAO.checkIdNumberExits(socialNumber) != null) {
//            return false;
//        }
//        return accDAO.checkEmailExits(email) == null;
//    }
//
//    public Boolean checkEmailExits(String email) {
//        return accDAO.checkEmailExits(email) != null;
//    }
//
//    public Boolean checkIdExits(String id) {
//        return custDAO.checkIdNumberExits(id) != null;
//    }
//
//    public void delteAccountRoleCustomer(String id) {
//        deleteCustomerInfo(id);
//        deleteCustomerAccount(id);
//    }
//
//    public void deleteCustomerAccount(String id) {
//        accDAO.deleteAccount(id);
//    }
//
//    public void deleteCustomerInfo(String customerId) {
//        custDAO.deleteCustomerInfo(customerId);
//    }
//
//    public void insertAccount(Account ac, Customer custEntity) {
//        accDAO.insertAccount(ac);
//        insertCustomerInfo(custEntity);
//    }
//
//    public void updateAccountWithEmail(Account ac) {
//        accDAO.updateAccountInfo(ac);
//    }
//
//    public void updateAccountNonEmail(Account ac) {
//        accDAO.updateAccountNoEmailInfo(ac);
//    }
//
//    public void updateAccount(Customer cust) {
//        updateCustomerInfo(cust);
//    }
//
//    public void updateCustomerInfo(Customer cust) {
//        custDAO.updateCustomerInfo(cust);
//    }
//
//    public void insertCustomerInfo(Customer custEntity) {
//        custDAO.insertCustomerInfo(custEntity);
//    }
//
//    public Account getAccountInfo(String customerId) {
//        return accDAO.getAccountInfo(customerId);
//    }
//
//    public Customer getCustomerInfo(String id) {
//        return custDAO.getCustomerInfoById(id);
//    }
//
//    public String randomCodeImg() {
//
//        Random rand = new Random();
//        String codeN;
//        String codeTotal = "SGDG";
//        for (int i = 0; i < 8; i++) {
//            int n = rand.nextInt(9);
//            codeN = String.valueOf(n);
//            codeTotal = codeTotal + codeN;
//        }
//        return codeTotal;
//    }
//
//    public Boolean uploadImg(List<String> listNames, List<MultipartFile> listFiles) {
//
//        if (listNames.size() > 0 && !listNames.isEmpty()) {
//            for (int i = 0; i < listNames.size(); i++) {
//                Utils.uploadImageToServer(CustomerConstant.URL_STORE_SERVER, listNames.get(i), listFiles.get(i));
//            }
//            return true;
//        }
//
//        return false;
//    }
//
//    public void updatePass(Account ac) {
//        accDAO.updatePass(ac);
//    }
//}
