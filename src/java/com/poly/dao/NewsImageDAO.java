/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.NewsImage;
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
public class NewsImageDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<NewsImage> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<NewsImage> getRowMapper() {
        return new BeanPropertyRowMapper<>(NewsImage.class);
    }

    public Boolean insert(NewsImage n) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".news_image (news_id, link, created_by, updated_by) "
                    + "VALUES (?,?,?,?)";
            jdbc.update(sql, n.getNewsId(), n.getLink(), n.getCreatedBy(), n.getUpdatedBy());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean delete(String id) {
        try {
            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".news_image "
                    + "WHERE news_image.news_id = ?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public NewsImage findById(String newsId) {
        try {
            String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".news_image "
                    + "WHERE news_image.news_id = ?";
            return jdbc.queryForObject(sql, getRowMapper(), newsId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean update(NewsImage n) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".news_image "
                    + "SET link = ?, updated_by = ? WHERE news_id = ?";
            jdbc.update(sql, n.getLink(), n.getUpdatedBy(), n.getNewsId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
