/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Register;
import com.poly.request.AccountPassword;
import com.poly.tool.ConstantManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public class RegisterDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Register> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Register> getRowMapper() {
        return new BeanPropertyRowMapper<>(Register.class);
    }

    public List<Register> getListRegister() {
        try {
            String sql = "SELECT register.id, register.full_name, register.email,  "
                    + "register.phone, register.speciaization, register.created_time "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".register ";
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
