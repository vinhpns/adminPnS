/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.News;
import com.poly.constant.NewsConstant;
import com.poly.tool.ConstantManager;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<News> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<News> getRowMapper() {
        return new BeanPropertyRowMapper<>(News.class);
    }

    public List<News> getAllNews(int type) {
        String sql = "";
        switch (type) {
            case NewsConstant.TYPE_FOOTER:
                sql = "SELECT news.id, news.active, news.avatar, news.hot, news.title, news.type "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news WHERE type <=3 ORDER BY id DESC";
                break;
            case NewsConstant.TYPE_NEWS:
                sql = "SELECT news.id, news.active, news.avatar, news.hot, news.title, news.type "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news WHERE type > 3 ORDER BY id DESC";
                break;
            case NewsConstant.TYPE_QNA:
                sql = "SELECT news.id, news.active, news.avatar, news.hot, news.title, news.type "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news WHERE type = 9 ORDER BY id DESC";
                break;
        }
        return getBySql(sql);
    }

    public Boolean deleteNews(int id) {
        try {
            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".news WHERE id = ?";
            jdbc.update(sql, id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean changeActive(int id, Boolean active) {
        try {
            if (Objects.equals(active, Boolean.FALSE)) {
                String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".news SET active = true WHERE id= ?";
                jdbc.update(sql, id);
                return Boolean.TRUE;
            }
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".news SET active = false WHERE id= ?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public News getNewsById(int id) {
        try {
            String sql = "SELECT news.id, news.active, news.avatar, news.hot, news.title, news.type, news.content FROM " + ConstantManager.DEFAULT_DB_NAME + ".news WHERE id = ?";
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean insertNews(News news) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".news (active, avatar, content, hot, title, type) "
                    + "VALUES (?,?,?,?,?,?)";
            jdbc.update(sql, news.getActive(), news.getAvatar(), news.getContent(), news.getHot(), news.getTitle(), news.getType());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateNews(News news) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".news SET avatar = ?, content = ?, hot = ?, title = ?, type = ? WHERE id = ?";
            jdbc.update(sql, news.getAvatar(), news.getContent(), news.getHot(), news.getTitle(), news.getType(), news.getId());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
