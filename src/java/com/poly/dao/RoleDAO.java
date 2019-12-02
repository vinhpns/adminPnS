/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Role;
import com.poly.tool.ConstantManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Role> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Role> getRowMapper() {
        return new BeanPropertyRowMapper<>(Role.class);
    }

    public List<Role> getListRole(int type) {
        if (type == 1) {
            String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".role "
                    + "WHERE id < 8";
            return getBySql(sql);
        }
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".role "
                + "WHERE id = 8";
        return getBySql(sql);
    }
}
