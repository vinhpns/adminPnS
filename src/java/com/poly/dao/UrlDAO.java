/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Url;
import com.poly.tool.ConstantManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinh1
 */
@Repository
public class UrlDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private RowMapper<Url> getRowMapper() {
        return new BeanPropertyRowMapper<>(Url.class);
    }

    protected List<Url> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper(), sql);
    }

    public Boolean insert(Url u) {
        try {
            String sql = "INSERT INTO url "
                    + "SET url_name = ?, type = ?";
            jdbc.update(sql, u.getUrlName(), u.getType());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean delete(int id) {
        try {
            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".url "
                    + "WHERE id = ?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Url getByUrl(String url) {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".url "
                + "WHERE url_name = ?";
        return jdbc.queryForObject(sql, getRowMapper(), url);
    }

    public Boolean update(Url u) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".url "
                    + "SET url_name = ? WHERE id = ?";
            jdbc.update(sql, u.getUrlName(), u.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
