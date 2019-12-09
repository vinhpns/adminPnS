/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Banner;
import com.poly.bean.Video;
import com.poly.tool.ConstantManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public class VideoDAO {
    @Autowired
    JdbcTemplate jdbc;

    protected List<Video> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Video> getRowMapper() {
        return new BeanPropertyRowMapper<>(Video.class);
    }
     public List<Video> getVideo(){
        String sql = "SELECT * FROM "+ConstantManager.DEFAULT_DB_NAME+".video ORDER BY created_time";
        return getBySql(sql);
    }
}
