/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Account;
import com.poly.bean.Customer;
import com.poly.constant.AccountConstant;
import com.poly.tool.ConstantManager;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

    private RowMapper<Customer> getCustomerRowMapper() {
        return new BeanPropertyRowMapper<>(Customer.class);
    }

    protected List<Customer> getCustomerBySql(String sql) {
        return jdbc.query(sql, getCustomerRowMapper());
    }

    public List<Account> getList(int type) {
        if (type == AccountConstant.TYPE_ROLE_MANAGER_SYSTEM) {
            String sql = "SELECT account.id, account.email, account.phone, account.active, account.full_name, account.role_id, account.password "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".account "
                    + "WHERE delfg = false "
                    + "AND role_id < 9 "
                    + "AND role_id NOT LIKE " + AccountConstant.ROLE_CUSTOMER + " ORDER BY id DESC";
            return getBySql(sql);
        }
        String sql = "SELECT account.id, account.email, account.phone, account.active, account.full_name, account.role_id, account.password "
                + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".account "
                + "WHERE delfg = false "
                + "AND role_id = " + AccountConstant.ROLE_CUSTOMER + " ORDER BY id DESC";
        return getBySql(sql);
    }

    public Account getById(String id) {
        try {
            String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".account "
                    + "WHERE id = ? AND delfg = false ";
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Customer getCustomerByIdAccount(String id) {
        try {
            String sql = "SELECT * FROM customer WHERE account_id = ?";
            return jdbc.queryForObject(sql, getCustomerRowMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Account getByEmail(String email) {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".account "
                + "WHERE delfg = false AND email = ?";
        try {
            return jdbc.queryForObject(sql, getRowMapper(), email);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Customer getBySocialIdNumber(int socialId) {
        try {
            String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".customer "
                    + "WHERE social_id_number = '" + socialId + "'";
            return jdbc.queryForObject(sql, getCustomerRowMapper(), socialId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean changeActive(Boolean active, String id) {
        try {
            if (Objects.equals(active, Boolean.FALSE)) {
                String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".account "
                        + "SET active = " + Boolean.TRUE
                        + "  WHERE id = ?";
                jdbc.update(sql, id);
                return Boolean.TRUE;
            }
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".account "
                    + "SET active = " + Boolean.FALSE
                    + "  WHERE id = ?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateAccountInfo(Account acc, int type) {
        try {
            String sql;
            switch (type) {
                case 1:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".account SET address = ?, email = ?, dob = ?, full_name=?, gender = ?, phone = ?, role_id = ? WHERE id = ?";
                    jdbc.update(sql, acc.getAddress(), acc.getEmail(), acc.getDob(), acc.getFullName(), acc.getGender(), acc.getPhone(), acc.getRoleId(), acc.getId());
                    break;
                case 2:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".account SET address = ?, dob = ?, full_name=?, gender = ?, phone = ?, role_id = ? WHERE id = ?";
                    jdbc.update(sql, acc.getAddress(), acc.getDob(), acc.getFullName(), acc.getGender(), acc.getPhone(), acc.getRoleId(), acc.getId());
                    break;
                case 3:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".account SET password = ? WHERE id = ?";
                    jdbc.update(sql, acc.getPassword(), acc.getId());
                    break;
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateCustomerInfo(Customer customer, int type) {
        try {
            if (type == 1) {
                String sql = "UPDATE customer SET avatar = ?, back_id_card = ?, front_id_card = ?, "
                        + "social_id_number = ?, bank_branch = ?, bank_name = ?, "
                        + "bank_name_holder = ?, bank_number = ? "
                        + "WHERE account_id = ?";
                jdbc.update(sql, customer.getAvatar(), customer.getBackIdCard(), customer.getFrontIdCard(),
                        customer.getSocialIdNumber(), customer.getBankBranch(), customer.getBankName(),
                        customer.getBankNameHolder(), customer.getBankNumber(), customer.getAccountId());
                return Boolean.TRUE;
            }
            String sql = "UPDATE customer SET avatar = ?, back_id_card = ?, front_id_card = ?, "
                    + "bank_branch = ?, bank_name = ?, "
                    + "bank_name_holder = ?, bank_number = ? "
                    + "WHERE account_id = ?";
            jdbc.update(sql, customer.getAvatar(), customer.getBackIdCard(), customer.getFrontIdCard(),
                    customer.getBankBranch(), customer.getBankName(),
                    customer.getBankNameHolder(), customer.getBankNumber(), customer.getAccountId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean deleteAccount(String id) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".account "
                    + "SET delfg = " + Boolean.TRUE
                    + "  WHERE id = ?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insertAccount(Account ac) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".account (id, active, address, dob, email, full_name, gender, password, "
                    + "phone, role_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
            jdbc.update(sql, ac.getId(), ac.getActive(), ac.getAddress(), ac.getDob(), ac.getEmail(), ac.getFullName(),
                    ac.getGender(), ac.getPassword(), ac.getPhone(), ac.getRoleId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insertCustomer(Customer cust) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".customer "
                    + "(account_id, avatar, back_id_card, front_id_card, "
                    + "social_id_number, point, rank_id, bank_branch, "
                    + "bank_name, bank_name_holder, bank_number) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            jdbc.update(sql, cust.getAccountId(), cust.getAvatar(), cust.getBackIdCard(), cust.getFrontIdCard(),
                    cust.getSocialIdNumber(), cust.getPoint(), cust.getRankId(), cust.getBankBranch(),
                    cust.getBankName(), cust.getBankNameHolder(), cust.getBankNumber());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
