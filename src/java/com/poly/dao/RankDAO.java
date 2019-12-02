/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Rank;
import com.poly.tool.ConstantManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RankDAO {

    @Autowired
    protected JdbcTemplate jdbc;

    protected List<Rank> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Rank> getRowMapper() {
        return new BeanPropertyRowMapper<>(Rank.class);
    }

    public List<Rank> getListRank() {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".rank";
        return getBySql(sql);
    }

    public Rank getRankById(int id) {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".rank WHERE id=?";
        try {
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Rank> checkExits(int point, String name) {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".rank "
                + "WHERE require_point = " + point + " OR name = '" + name + "'";
        try {
            return getBySql(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean insert(Rank rank) {
        try {
            String sql = "INSERT INTO rank (icon, name, require_point) VALUES (?,?,?)";
            jdbc.update(sql, rank.getIcon(), rank.getName(), rank.getRequirePoint());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean update(Rank rank, int type) {
        try {
            String sql = "UPDATE rank SET icon = ?, name = ?, require_point = ? WHERE id = ?";
            if (type == 1) {
                sql = "UPDATE rank SET icon = ?, require_point = ? WHERE id = ?";
                jdbc.update(sql, rank.getIcon(), rank.getRequirePoint(), rank.getId());
            } else {
                jdbc.update(sql, rank.getIcon(), rank.getName(), rank.getRequirePoint(), rank.getId());
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
