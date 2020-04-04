/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Different;
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
public class DifferentDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Different> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Different> getRowMapper() {
        return new BeanPropertyRowMapper<>(Different.class);
    }

    public Different getByCompanyId(String companyId) {
        String sql = "SELECT * FROM different WHERE company_id = ?";
        return jdbc.queryForObject(sql, getRowMapper(), companyId);
    }

    public Boolean update(Different d) {
        try {
            String sql = "UPDATE different "
                    + "SET title_one = ?, title_two = ?, title_three = ?, title_four = ?, "
                    + "title_five = ?, title_six = ?, description_one = ?, "
                    + "description_two = ?, description_three = ?, "
                    + "description_four = ?, description_five = ?, description_six = ? "
                    + "WHERE company_id = ?";
            jdbc.update(sql, d.getTitleOne(), d.getTitleTwo(), d.getTitleThree(),
                    d.getTitleFour(), d.getTitleFive(), d.getTitleSix(), d.getDescriptionOne(),
                    d.getDescriptionTwo(), d.getDescriptionThree(), d.getDescriptionFour(),
                    d.getDescriptionFive(), d.getDescriptionSix(), d.getCompanyId());
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
