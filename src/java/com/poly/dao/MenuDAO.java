/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Menu;
import com.poly.request.MenuRequest;
import com.poly.tool.ConstantManager;
import java.util.List;
import java.util.Objects;
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
        String sql = "SELECT * FROM menu WHERE parent_id = 0 ORDER BY position DESC";
        return getBySql(sql);
    }

    public List<Menu> getSon(String id) {
        String sql = "SELECT * FROM menu WHERE parent_id = '" + id + "'";
        return getBySql(sql);
    }

    public List<Menu> getSonOfFather(String id) {
        String sql = "SELECT * FROM menu WHERE parent_id = '" + id + "'";
        return getBySql(sql);
    }

    public Menu getMenuById(String id) {
        String sql = "SELECT * FROM menu WHERE id = ?";
        return jdbc.queryForObject(sql, getRowMapper(), id);
    }

    public Menu getMenuByName(String name) {
        String sql = "SELECT * FROM menu WHERE name = ?";
        return jdbc.queryForObject(sql, getRowMapper(), name);
    }

    public Boolean insertMenu(MenuRequest menu, String uuid) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".menu "
                    + "(id,name, parent_id, created_by, position) VALUES (?,?,?,?,?)";
            jdbc.update(sql, uuid, menu.getName(), menu.getParentId(), menu.getCreatedBy(), menu.getPosition());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean deleteMenu(String id) {
        try {
            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".menu "
                    + "WHERE id=?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateMenu(Menu menu) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".menu "
                    + "SET name = ?, parent_id = ? "
                    + "WHERE id = ?";
            jdbc.update(sql, menu.getName(), menu.getParentId(), menu.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateStatus(Menu menu) {
        try {
            Boolean status = Boolean.TRUE;
            if (Objects.equals(menu.getActive(), Boolean.TRUE)) {
                status = Boolean.FALSE;
            }
            String sql = "UPDATE menu SET active = " + status + " WHERE id = '" + menu.getId() + "'";
            jdbc.update(sql);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public List<Menu> getLastInsert() {
        String sql = "SELECT * FROM sgdg_jpa.menu order by created_time DESC LIMIT 1;";
        return getBySql(sql);
    }

    public Boolean updateCount(Menu m) {
        try {
            String sql = "UPDATE menu SET count = ? WHERE id = ?";
            jdbc.update(sql, m.getCount(), m.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
