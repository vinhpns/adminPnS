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

    public Boolean updatePassword(AccountPassword ap) {
        try {
            String sql = "UPDATE account SET password = '" + ap.getNewPassword() + "' "
                    + "WHERE id = '" + ap.getId() + '"';
            jdbc.update(sql);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
