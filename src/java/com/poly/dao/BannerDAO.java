
package com.poly.dao;

import com.poly.bean.Banner;
import com.poly.constant.BannerConstant;
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
public class BannerDAO {

    @Autowired 
    protected JdbcTemplate jdbc;

    protected List<Banner> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Banner> getRowMapper() {
        return new BeanPropertyRowMapper<>(Banner.class);
    }

    public List<Banner> getAllBanner(int type) {
        String sql = "";
        switch (type) {
            case BannerConstant.BANNER_TYPE:
                sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".banner WHERE  type <= 4 ORDER BY id DESC";
                break;
            case BannerConstant.CONTENT_TYPE:
                sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".banner WHERE type > 4 ORDER BY id DESC";
                break;
        }
        return getBySql(sql);
    }

    public Banner getById(int id) {
        try {
            String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".banner WHERE id = ?";
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean delete(int id) {
        try {
            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".banner WHERE id=?";
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
                String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".banner SET active = " + Boolean.TRUE + " WHERE id = " + id;
                jdbc.update(sql, id);
                return Boolean.TRUE;
            }
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".banner SET active = " + Boolean.FALSE + " WHERE id = " + id;
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insert(Banner banner) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".banner (img, type, active, link) VALUES (?,?,?,?)";
            jdbc.update(sql, banner.getImg(), banner.getType(),
                    banner.getActive(), banner.getLink());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean update(Banner banner) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".banner SET image=?, type=?, active=?, link=? WHERE id=?";
            jdbc.update(sql, banner.getImg(), banner.getType(),
                    banner.getActive(), banner.getLink(), banner.getId());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
