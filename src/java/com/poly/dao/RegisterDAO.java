/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

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

    protected List<RegisterDAO> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<RegisterDAO> getRowMapper() {
        return new BeanPropertyRowMapper<>(RegisterDAO.class);
    }
 public List<RegisterDAO> getListRegister() {
        try {
            String sql = "SELECT register.id, register.fullname,register.email  "
                    + "register.phone, register.speciaization, register.created_time "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".register ";
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
