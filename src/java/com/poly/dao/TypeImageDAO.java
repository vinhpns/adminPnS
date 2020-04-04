/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.TypeImage;
import com.poly.tool.ConstantManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 1
 */
@Repository
public class TypeImageDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<TypeImage> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<TypeImage> getRowMapper() {
        return new BeanPropertyRowMapper<>(TypeImage.class);
    }

    public List<TypeImage> getByTypeId(int typeId) {
        String sql = "SELECT * FROM type_image WHERE type = " + typeId
                + " AND company_id = '" + ConstantManager.COMPANY_ID + "'";
        try {
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean insert(TypeImage typeImage) {
        String sql = "INSERT INTO type_image (link, type, company_id) "
                + "VALUES (?,?,?)";
        try {
            jdbc.update(sql, typeImage.getLink(), typeImage.getType(), typeImage.getCompanyId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateStatus(int id, Boolean status) {
        String sql = "UPDATE type_image SET status = ? "
                + "WHERE id = ?";
        try {
            jdbc.update(sql, status, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean delete(int id) {
        String sql = "DELETE FROM type_image WHERE id = ?";
        try {
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
