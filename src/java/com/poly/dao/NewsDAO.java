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
            case NewsConstant.TYPE_MENU:
                sql = "SELECT news.id, news.active, news.title, news.type, "
                        + "account.full_name as createdBy, "
                        + "news_image.link as avatar "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news, "
                        + ConstantManager.DEFAULT_DB_NAME + ".account, "
                        + ConstantManager.DEFAULT_DB_NAME + ".news_image "
                        + "WHERE news.type = 1 "
                        + "AND news.created_by = account.id "
                        + "AND news.id = news_image.news_id "
                        + "ORDER BY id DESC";
                break;
            case NewsConstant.TYPE_NEWS:
                sql = "SELECT news.id, news.active, news.title, news.type, "
                        + "account.full_name as createdBy, "
                        + "news_image.link as avatar "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news, "
                        + ConstantManager.DEFAULT_DB_NAME + ".account, "
                        + ConstantManager.DEFAULT_DB_NAME + ".news_image "
                        + "WHERE news.type = 2 "
                        + "AND news.created_by = account.id "
                        + "AND news.id = news_image.news_id "
                        + "ORDER BY id DESC";
                break;
            case NewsConstant.TYPE_EVENT:
                sql = "SELECT news.id, news.active, news.title, news.type, "
                        + "account.full_name as createdBy, "
                        + "news_image.link as avatar "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news, "
                        + ConstantManager.DEFAULT_DB_NAME + ".account, "
                        + ConstantManager.DEFAULT_DB_NAME + ".news_image "
                        + "WHERE news.type = 3 "
                        + "AND news.created_by = account.id "
                        + "AND news.id = news_image.news_id "
                        + "ORDER BY id DESC";
                break;
            case NewsConstant.TYPE_FOOTER:
                sql = "SELECT news.id, news.active, news.title, news.type, "
                        + "account.full_name as createdBy, "
                        + "news_image.link as avatar "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news, "
                        + ConstantManager.DEFAULT_DB_NAME + ".account, "
                        + ConstantManager.DEFAULT_DB_NAME + ".news_image "
                        + "WHERE news.type = 4 "
                        + "AND news.created_by = account.id "
                        + "AND news.id = news_image.news_id "
                        + "ORDER BY id DESC";
                break;
            default:
                sql = "SELECT news.id, news.active, news.title, news.type, "
                        + "account.full_name as createdBy, "
                        + "news_image.link as avatar "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news, "
                        + ConstantManager.DEFAULT_DB_NAME + ".account, "
                        + ConstantManager.DEFAULT_DB_NAME + ".news_image "
                        + "WHERE news.created_by = account.id "
                        + "AND news.id = news_image.news_id "
                        + "ORDER BY id DESC";
                break;
        }
        return getBySql(sql);
    }

    public List<News> getNewsByMenuId(String id) {
        String sql = "SELECT * FROM news WHERE menu_id = '" + id + "'";
        return getBySql(sql);
    }

    public Boolean updateTypeNews(String id) {
        try {
            String sql = "UPDATE news SET type = 2, menu_id = 0 WHERE id = '" + id + "'";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insert(News n) {
        try {
            String sql = "INSERT INTO news (id, title, meta, content, type, created_by, "
                    + "description, title_web, meta_description, menu_id, vip, register_form ) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbc.update(sql, n.getId(), n.getTitle(), n.getMeta(), n.getContent(),
                    n.getType(), n.getCreatedBy(), n.getDescription(), n.getTitleWeb(),
                    n.getMetaDescription(), n.getMenuId(), n.getVip(), n.getRegisterForm());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
    
    public Boolean updateStatus(News n) {
        try {
            Boolean status = Boolean.TRUE;
            if (Objects.equals(n.getActive(), Boolean.TRUE)) {
                status = Boolean.FALSE;
            }
            String sql = "UPDATE news SET active = " + status + " WHERE id = '" + n.getId() + "'";
            jdbc.update(sql);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
