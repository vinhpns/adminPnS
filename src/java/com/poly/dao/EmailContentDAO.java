/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.EmailContent;
import com.poly.tool.ConstantManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmailContentDAO {

    @Autowired
    protected JdbcTemplate jdbc;

    protected List<EmailContent> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<EmailContent> getRowMapper() {
        return new BeanPropertyRowMapper<>(EmailContent.class);
    }

    public List<EmailContent> getListEmail() {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".email_content";
        return getBySql(sql);
    }

    public EmailContent checkEmailExits(String title) {
        String sql = "SELECT * FROM email_content WHERE title = ?";
        try {

            return jdbc.queryForObject(sql, getRowMapper(), title);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean insertEmail(EmailContent email) {
        try {
            String sql = "INSERT INTO email_content (title, content) VALUES (?,?)";
            jdbc.update(sql, email.getTitle(), email.getContent());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateEmail(EmailContent email) {
        try {
            String sql = "UPDATE email_content SET title=?, content=? WHERE id = ?";
            jdbc.update(sql, email.getTitle(), email.getContent(), email.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public EmailContent getEmailById(int id) {
        try {
            String sql = "SELECT * FROM email_content WHERE id = ?";
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
