/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Video;
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
public class VideoDAO {

    @Autowired
    protected JdbcTemplate jdbc;

    protected List<Video> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Video> getRowMapper() {
        return new BeanPropertyRowMapper<>(Video.class);
    }

    public List<Video> getListVideo() {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".video "
                + "ORDER BY ID DESC ";
        return getBySql(sql);
    }

    public Boolean deleteVideo(int id) {
        try {
            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".video WHERE id = ? ";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insertVideo(Video video) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".video (image, link, active, type, title) VALUES (?, ?, ?, ?, ?)";
            jdbc.update(sql, video.getImage(), video.getLink(), video.getActive(), video.getType(), video.getTitle());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateVideo(Video video) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".video "
                    + "SET image = ?, link = ?, active = ?, type = ?, title = ? WHERE id = ?";
            jdbc.update(sql, video.getImage(), video.getLink(), video.getActive(),
                    video.getType(), video.getTitle(), video.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean changeActive(int id, Boolean active) {
        try {
            if (Objects.equals(active, Boolean.FALSE)) {
                String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".video set active = true WHERE id = ? ";
                jdbc.update(sql, id);
                return Boolean.TRUE;
            }
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".video set active = false WHERE id = ? ";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Video getVideoById(int id) {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".video WHERE id = ?";
        try {
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
