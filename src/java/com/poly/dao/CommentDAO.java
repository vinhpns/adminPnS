/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Comment;
import com.poly.tool.ConstantManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SGDG Company
 */
@Repository
public class CommentDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Comment> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Comment> getRowMapper() {
        return new BeanPropertyRowMapper<>(Comment.class);
    }

    public List<Comment> getListComment() {
        try {
            String sql = "SELECT comment.id, comment.name, comment.phone, "
                    + "comment.email, comment.content, comment.reply "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".comment ";
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
