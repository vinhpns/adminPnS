/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Video;
import com.poly.request.VideoRequest;
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

    public List<Video> getListVideo() {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".video";
        return getBySql(sql);
    }

    public Boolean insert(Video v) {
        try {
            String sql = "INSERT into video(id, link , title)"
                    + "VALUES(?,?,?)";
            jdbc.update(sql, v.getId(), v.getLink(), v.getTitle());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean delete(String id) {
        try {
            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".video "
                    + "WHERE id = ?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean update(Video video) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".video "
                    + "SET link =?, title =? "
                    + "WHERE id =?";
            jdbc.update(sql, video.getLink(), video.getTitle(), video.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
    
    public Video getById (String id) {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".video "
                + "WHERE id = ?";
        return jdbc.queryForObject(sql, getRowMapper(), id);
    }

    public Boolean updateStatus(Video vi) {
        try {
            Boolean status = Boolean.TRUE;
            if (Objects.equals(vi.getActive(), Boolean.TRUE)) {
                status = Boolean.FALSE;
            }
            String sql = "UPDATE video SET active = " + status + " WHERE id = '" + vi.getId() + "'";
            jdbc.update(sql);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public List<Video> getLastInsert() {
        String sql = "SELECT * FROM" + ConstantManager.DEFAULT_DB_NAME + ".video order by created_time DESC LIMIT 1;";
        return getBySql(sql);
    }
}
