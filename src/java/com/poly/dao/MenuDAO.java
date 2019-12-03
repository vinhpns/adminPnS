/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Menu;
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
public class MenuDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Menu> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Menu> getRowMapper() {
        return new BeanPropertyRowMapper<>(Menu.class);
    }

    public List<Menu> getFather() {
        String sql = "SELECT *FROM menu WHERE parent_id = 0";
        return getBySql(sql);
    }

    public List<Menu> getSon(String id) {
        String sql = "SELECT *FROM menu WHERE parent_id = '" + id + "'";
        return getBySql(sql);
    }

    public Menu getMenuById(String id) {
        String sql = "SELECT * FROM menu WHERE id = ?";
        return jdbc.queryForObject(sql, getRowMapper(), id);
    }

//    public Boolean insertMenu(Menu menu) {
//        try {
//            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".menu "
//                    + "(name, active, parent_id) VALUES (?,?,?)";
//            jdbc.update(sql, menu.getName(), menu.getActive(), menu.getParentid());
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Boolean.FALSE;
//        }
//    }
//public Boolean deleteMenu(int id) {
//        try {
//            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".menu "
//                    + "WHERE id=?";
//            jdbc.update(sql, id);
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Boolean.FALSE;
//        }
//    }
//public Boolean updateMenu(Menu menu) {
//        try {
//            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".menu "
//                    + "SET name = ?, parent_id = ? "
//                    + "WHERE id = ?";
//            jdbc.update(sql, menu.getName(),  menu.getId());
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Boolean.FALSE;
//        }
//    }
}
