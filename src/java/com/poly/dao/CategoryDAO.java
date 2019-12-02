/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Category;
import com.poly.constant.CategoryConstant;
import com.poly.tool.ConstantManager;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Category> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Category> getRowMapper() {
        return new BeanPropertyRowMapper<>(Category.class);
    }

    public List<Category> getListCategory(int type) {
        if (type == CategoryConstant.CATEGORY_TYPE) {
            String sql = "SELECT category.id, category.active, category.icon, category.name "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".category "
                    + "WHERE delfg = false AND parent_category_id IS NULL";
            return getBySql(sql);
        }
        String sql = "SELECT category.id, category.active, category.icon, category.name, category.parent_category_id as parentId  "
                + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".category "
                + "WHERE delfg = false AND parent_category_id IS NOT NULL";
        return getBySql(sql);
    }

    public Category getById(int id, String url) {
        if (url.equalsIgnoreCase("type")) {
            try {
                String sql = "SELECT * FROM category WHERE id = ?";
                return jdbc.queryForObject(sql, getRowMapper(), id);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        try {
            String sql = "SELECT category.id, category.active, category.icon, category.name, "
                    + "category.parent_category_id as parentId FROM category WHERE id = ?";
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean changeActive(int id, Boolean active) {
        try {
            if (Objects.equals(active, Boolean.TRUE)) {
                String sql = "UPDATE category SET active = false WHERE id = ?";
                jdbc.update(sql, id);
                return Boolean.TRUE;
            }
            String sql = "UPDATE category SET active = true WHERE id = ?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insert(Category category, int type) {
        if (type == CategoryConstant.CATEGORY) {
            try {
                String sql = "INSERT INTO category (name, active, icon, parent_category_id) VALUES (?,?,?,?)";
                jdbc.update(sql, category.getName(), category.getActive(), category.getIcon(), category.getParentId());
                return Boolean.TRUE;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return Boolean.FALSE;
            }
        }
        try {
            String sql = "INSERT INTO category (name, active, icon) VALUES (?,?,?)";
            jdbc.update(sql, category.getName(), category.getActive(), category.getIcon());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public List<Category> getByName(String name) {
        try {
            String sql = "SELECT category.id, category.active, category.icon, category.name, category.parent_category_id as parentId "
                    + "FROM category WHERE name = '" + name + "' "
                    + "AND parent_category_id IS NOT NULL";
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean delete(int id) {
        try {
            String sql = "UPDATE category SET delfg = true WHERE id = ?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean update(Category category, int type) {
        try {
            if (type == CategoryConstant.CATEGORY) {
                String sql = "UPDATE category SET name = ?, active = ?, icon = ?, parent_category_id = ? WHERE id = ?";
                jdbc.update(sql, category.getName(), category.getActive(), category.getIcon(), category.getParentId(), category.getId());
                return Boolean.TRUE;
            }
            String sql = "UPDATE category SET name = ?, active = ?, icon = ? WHERE id = ?";
            jdbc.update(sql, category.getName(), category.getActive(), category.getIcon(), category.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
