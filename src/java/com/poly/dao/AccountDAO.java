/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Account;
import com.poly.request.AccountPassword;
import com.poly.response.AccountResponse;
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

    protected List<AccountResponse> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<AccountResponse> getRowMapper() {
        return new BeanPropertyRowMapper<>(AccountResponse.class);
    }

    protected List<Account> getBySqlAccount(String sql) {
        return jdbc.query(sql, getRowMapperAccount());
    }

    private RowMapper<Account> getRowMapperAccount() {
        return new BeanPropertyRowMapper<>(Account.class);
    }

    public List<AccountResponse> getList(String companyId) {
        try {
            String sql = "SELECT account.id, account_info.full_name, account.email, "
                    + "account_info.gender, account_info.role, account_info.phone, account_info.address, "
                    + "account_info.dob, account.is_active, account.count_news "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".account, "
                    + ConstantManager.DEFAULT_DB_NAME + ".account_info "
                    + "WHERE account.company_id = '" + companyId + "'"
                    + " AND account.id = account_info.account_id ORDER BY account.created_time DESC";
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public AccountResponse getAccountByEmail(String email) {
        try {
            String sql = "SELECT account.id, account_info.full_name, account_info.role, account.company_id, "
                    + "account.is_active, account.password "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".account, "
                    + ConstantManager.DEFAULT_DB_NAME + ".account_info "
                    + "WHERE account.email = ?";
            return jdbc.queryForObject(sql, getRowMapper(), email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

//    public Account getAccountById(String id) {
//        try {
//            String sql = "SELECT * from " + ConstantManager.DEFAULT_DB_NAME + ".account "
//                    + "WHERE account.id = ?";
//            return jdbc.queryForObject(sql, getRowMapper(), id);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//    public Boolean updatePassword(AccountPassword ap) {
//        try {
//            String sql = "UPDATE account SET password = ? "
//                    + "WHERE id = ?";
//            jdbc.update(sql, ap.getNewPassword(), ap.getId());
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Boolean.FALSE;
//        }
//    }
//
//    public Boolean insert(Account ac) {
//        try {
//            String sql = "INSERT INTO account (id, email, full_name, user_name, gender, "
//                    + "password, phone, address, "
//                    + "dob, role, created_by, company_id ) "
//                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
//            jdbc.update(sql, ac.getId(), ac.getEmail(), ac.getFullName(), ac.getUserName(), ac.getGender(),
//                    ac.getPassword(), ac.getPhone(), ac.getAddress(), ac.getDob(), 
//                    ac.getRole(), ac.getCreatedBy(), ac.getCompanyId());
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Boolean.FALSE;
//        }
//    }
//
//    public Boolean updateStatus(Account ac) {
//        try {
//            Boolean status = Boolean.TRUE;
//            if (Objects.equals(ac.getActive(), Boolean.TRUE)) {
//                status = Boolean.FALSE;
//            }
//            String sql = "UPDATE account SET active = " + status + " WHERE id = '" + ac.getId() + "'";
//            jdbc.update(sql);
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Boolean.FALSE;
//        }
//    }
//
//    public Boolean delete(String id) {
//        try {
//            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".account "
//                    + "SET deflg = true "
//                    + "WHERE id=?";
//            jdbc.update(sql, id);
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Boolean.FALSE;
//        }
//    }
//
//    public Boolean updateInfo(Account ac) {
//        try {
//            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".account "
//                    + "SET email = ?, full_name = ?, user_name = ?, gender =?, phone =?, "
//                    + "address =?, dob = ?, role=? , updated_by=? "
//                    + "WHERE id = ?";
//            jdbc.update(sql, ac.getEmail(), ac.getFullName(), ac.getUserName(), ac.getGender(),
//                    ac.getPhone(), ac.getAddress(), ac.getDob(),
//                    ac.getRole(), ac.getUpdatedBy(), ac.getId());
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Boolean.FALSE;
//        }
//    }
//
//    public Boolean updatePostByAccountId(String accountId, int post) {
//        try {
//            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".account "
//                    + "SET post = " + post + " WHERE id = '" + accountId + "'";
//            jdbc.update(sql);
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Boolean.FALSE;
//        }
//    }
}
