/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Comment;
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
                    + "comment.email, comment.content, comment.reply, comment.is_reply as isReply, comment.active "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".comment ";
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Comment> countNotReply() {
        String sql = "SELECT * FROM comment WHERE is_reply = false ";
        return getBySql(sql);
    }

    public Boolean updateReply(Comment c) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".comment "
                    + "SET reply = ?, is_reply = ?, active = ? "
                    + "WHERE id = ?";
            jdbc.update(sql, c.getReply(), c.getIsReply(), c.getActive(), c.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
    public Boolean deleteComment(String id) {
        try {
            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".comment "
                    + "WHERE id=?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
    
    public Boolean updateStatus(Comment comment) {
        try {
            Boolean status = Boolean.TRUE;
            if (Objects.equals(comment.getActive(), Boolean.TRUE)) {
                status = Boolean.FALSE;
            }
            String sql = "UPDATE comment SET active = " + status + " WHERE id = '" + comment.getId() + "'";
            jdbc.update(sql);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
