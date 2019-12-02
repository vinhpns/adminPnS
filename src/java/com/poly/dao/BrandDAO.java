/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Brand;
import com.poly.tool.ConstantManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDAO {

    @Autowired
    protected JdbcTemplate jdbc;

    protected List<Brand> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Brand> getRowMapper() {
        return new BeanPropertyRowMapper<>(Brand.class);
    }

    public List<Brand> getAllBrand(int type) {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".brand WHERE delfg = false "
                + "ORDER BY id DESC";
        if (type == 2) {
            sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".brand WHERE delfg = true "
                    + "ORDER BY id DESC";
        }
        return getBySql(sql);
    }

    public Boolean deleteBrandById(int id) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".brand "
                    + "SET delfg = " + Boolean.TRUE
                    + "  WHERE id = ?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insertBrand(Brand brand) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".brand (name, image, active) VALUES (?,?,?)";
            jdbc.update(sql, brand.getName(), brand.getImage(), brand.getActive());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateBrandById(Brand brand) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".brand SET name=?, image=? WHERE id=?";
            jdbc.update(sql, brand.getName(), brand.getImage(), brand.getId());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public Boolean setLockBrandById(int id) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".brand set active = false WHERE id= ?";
            jdbc.update(sql, id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public Boolean setUnlockBrandById(int id) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".brand set active = true WHERE id= ?";
            jdbc.update(sql, id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public Brand getByNameBrand(String name) {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".brand WHERE name = ?";
        try {
            return jdbc.queryForObject(sql, getRowMapper(), name);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Brand getByIdBrand(int id) {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".brand WHERE id = ?";
        try {
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Brand> getListBrandById(int brandId) {
        try {
            String sql = "SELECT * FROM product WHERE brand_id = ?";
            return jdbc.query(sql, getRowMapper(), brandId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void updateBrandId(int brandId) {
        String sql = "UPDATE product SET brand_id = 1 WHERE brand_id = " + brandId + "";
        jdbc.update(sql);
    }

    public Boolean deleteOrReupBrand(int brandId, int type) {
        try {
            String sql = "DELETE FROM brand WHERE id = ?";
            if (type == 2) {
                sql = "UPDATE brand SET delfg = false WHERE id = ?";
            }
            jdbc.update(sql, brandId);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
