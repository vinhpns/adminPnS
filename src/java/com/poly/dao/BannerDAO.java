package com.poly.dao;

import com.poly.bean.Banner;
import com.poly.tool.ConstantManager;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Banner> getBanner() {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".banner ORDER BY id DESC";
        return getBySql(sql);
    }

    public Boolean delete(String id) {
        try {
            String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".banner WHERE id=?";
            jdbc.update(sql, id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateStatus(Banner banner) {
        try {
            Boolean status = Boolean.TRUE;
            if (Objects.equals(banner.getActive(), Boolean.TRUE)) {
                status = Boolean.FALSE;
            }
            String sql = "UPDATE banner SET active = " + status + " WHERE id = '" + banner.getId() + "'";
            jdbc.update(sql);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insert(Banner banner) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".banner (id, img, link , type, createdB) VALUES (?,?,?,?,?)";
            jdbc.update(sql, banner.getId(), banner.getImg(), banner.getLink(), banner.getType(), banner.getCreatedBy());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean update(Banner banner) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".banner SET img = ?,  link = ?,type = ?, updatedBy = ? WHERE id = ?";
            jdbc.update(sql, banner.getImg(), banner.getLink(), banner.getType(), banner.getUpdatedBy(), banner.getId());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
