/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Account;
import com.poly.request.AccountPassword;
import com.poly.tool.ConstantManager;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Account> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Account> getRowMapper() {
        return new BeanPropertyRowMapper<>(Account.class);
    }

    public List<Account> getList() {
        String sql = "SELECT account.id, account.email, account.full_name, account.user_name, account.gender,"
                + "account.password, account.phone, account.active, account.address, account.dob, "
                + "account.role "
                + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".account "
                + "WHERE deflg = false ";
        return getBySql(sql);
    }

    public Account getAccountByEmail(String email) {
        try {
            String sql = "SELECT * from " + ConstantManager.DEFAULT_DB_NAME + ".account "
                    + "WHERE account.email = ?";
            return jdbc.queryForObject(sql, getRowMapper(), email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Account getAccountByUserName(String userName) {
        try {
            String sql = "SELECT * from " + ConstantManager.DEFAULT_DB_NAME + ".account "
                    + "WHERE account.user_name = '" + userName + "'";
            return jdbc.queryForObject(sql, getRowMapper(), userName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Account getAccountById(String id) {
        try {
            String sql = "SELECT * from " + ConstantManager.DEFAULT_DB_NAME + ".account "
                    + "WHERE account.id = '" + id + "'";
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean updatePassword(AccountPassword ap) {
        try {
            String sql = "UPDATE account SET password = '" + ap.getNewPassword() + "' "
                    + "WHERE id = '" + ap.getId() + '"';
            jdbc.update(sql, ap.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insert(Account ac) {
        try {
            String sql = "INSERT INTO account (id, email, full_name, user_name, gender, password, phone, address, "
                    + "dob, role, created_by ) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            jdbc.update(sql, ac.getId(), ac.getEmail(), ac.getFullName(), ac.getUserName(), ac.getGender(),
                    ac.getPassword(), ac.getPhone(), ac.getAddress(), ac.getDob(), ac.getRole(), ac.getCreatedBy());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateStatus(Account ac) {
        try {
            Boolean status = Boolean.TRUE;
            if (Objects.equals(ac.getActive(), Boolean.TRUE)) {
                status = Boolean.FALSE;
            }
            String sql = "UPDATE account SET active = " + status + " WHERE id = '" + ac.getId() + "'";
            jdbc.update(sql);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
    public Boolean delete(String id){
        try {
            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".account "
                    + "WHERE id=?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
            
        
    }
}
