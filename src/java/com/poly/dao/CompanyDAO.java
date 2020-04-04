/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Company;
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
public class CompanyDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private RowMapper<Company> getRowMapper() {
        return new BeanPropertyRowMapper<>(Company.class);
    }

    protected List<Company> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    public Company getInfo(String companyId) {
        try {
            String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".company "
                    + "WHERE company.id = ?";
            return jdbc.queryForObject(sql, getRowMapper(), companyId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean updateInfo(Company c) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".company "
                    + "SET name = ?, logo = ?, address = ?, phone = ?,"
                    + "title_seo = ?, meta_seo = ?, description_seo = ?, "
                    + "title_one = ?, title_two = ?, title_three = ?, "
                    + "description_one = ?, description_two = ?, description_three = ? "
                    + "WHERE id = ?";
            jdbc.update(sql, c.getName(), c.getLogo(), c.getAddress(), c.getPhone(),
                    c.getTitleSeo(), c.getMetaSeo(), c.getDescriptionSeo(), 
                    c.getTitleOne(), c.getTitleTwo(), c.getTitleThree(), 
                    c.getDescriptionOne(), c.getDescriptionTwo(), c.getDescriptionThree(), c.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
