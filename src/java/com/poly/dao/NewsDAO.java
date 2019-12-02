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
                sql = "SELECT news.id, news.active, news.title, news.type "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news WHERE type = 1 "
                        + "ORDER BY id DESC";
                break;
            case NewsConstant.TYPE_NEWS:
                sql = "SELECT news.id, news.active, news.title, news.type "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news WHERE type = 2 "
                        + "ORDER BY id DESC";
                break;
            case NewsConstant.TYPE_EVENT:
                sql = "SELECT news.id, news.active, news.title, news.type "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news WHERE type = 3 "
                        + "ORDER BY id DESC";
                break;
            case NewsConstant.TYPE_FOOTER:
                sql = "SELECT news.id, news.active, news.title, news.type "
                        + "FROM " + ConstantManager.DEFAULT_DB_NAME + " WHERE type = 4 "
                        + "ORDER BY id DESC";
                break;
        }
        return getBySql(sql);
    }
}
