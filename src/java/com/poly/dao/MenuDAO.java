/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Menu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author HP
 */
public class MenuDAO {
    @Autowired
    JdbcTemplate jdbc;

    protected List<Menu> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Menu> getRowMapper() {
        return new BeanPropertyRowMapper<>(Menu.class);
    }
    public List<Menu> getFather(){
        String sql = "SELECT *FROM menu WHERE parent_id = 0";
        return getBySql(sql);
    }
    public List<Menu> getSon(){
        String sql= "SELECT *FROM menu parent_id >0 ";
        return getBySql(sql);
    }
}
