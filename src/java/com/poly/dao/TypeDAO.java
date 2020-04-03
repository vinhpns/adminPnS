/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Type;
import com.poly.bean.TypeImage;
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
public class TypeDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Type> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Type> getRowMapper() {
        return new BeanPropertyRowMapper<>(Type.class);
    }

    public Type getTypeByTypeId(int id, String companyId) {
        String sql = "SELECT * FROM type WHERE type = ? AND company_id = ?";
        return jdbc.queryForObject(sql, getRowMapper(), id, companyId);
    }

    public Boolean update(Type t) {
        String sql = "UPDATE type "
                + "SET title = ?, title_description = ?, short_title = ?, short_description = ?, "
                + "reason_one = ?, description_one = ?, reason_two = ?, description_two = ?, "
                + "reason_three = ?, description_three = ?, pic_one = ?, "
                + "pic_two = ?, pic_three = ?, pic_main = ? WHERE id = ?";
        try {
            jdbc.update(sql, t.getTitle(), t.getTitleDescription(), t.getShortTitle(), t.getShortDescription(),
                    t.getReasonOne(), t.getDescriptionOne(), t.getReasonTwo(), t.getDescriptionTwo(),
                    t.getReasonThree(), t.getDescriptionThree(), t.getPicOne(),
                    t.getPicTwo(), t.getPicThree(), t.getPicMain(), t.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
