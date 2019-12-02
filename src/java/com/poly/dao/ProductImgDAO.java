/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.ProductImage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductImgDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<ProductImage> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<ProductImage> getRowMapper() {
        return new BeanPropertyRowMapper<>(ProductImage.class);
    }

    public List<ProductImage> getListImgByProductId(int productId) {
        String sql = "SELECT * FROM product_image WHERE product_id = '" + productId + "'";
        return getBySql(sql);
    }

    public void insertImg(ProductImage pImg) {
        String sql = "INSERT INTO product_image (link, product_id) VALUES (?,?)";
        jdbc.update(sql, pImg.getLink(), pImg.getProductId());
    }

    public List<ProductImage> getIdByLinkImg(String link) {
        String sql = "SELECT * FROM product_image WHERE link = '" + link + "'";
        try {
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateProductImg(ProductImage p) {
        String sql = "UPDATE product_image SET link = ?, product_id = ? WHERE id = ?";
        jdbc.update(sql, p.getLink(), p.getProductId(), p.getId());
    }
}
