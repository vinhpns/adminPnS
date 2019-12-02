/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Selling;
import com.poly.constant.AccountConstant;
import com.poly.request.SellingResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SellingProductDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Selling> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Selling> getRowMapper() {
        return new BeanPropertyRowMapper<>(Selling.class);
    }

    protected List<SellingResponse> getSellingResponseSellingResponseBySql(String sql) {
        return jdbc.query(sql, getSellingResponseRowMapper());
    }

    private RowMapper<SellingResponse> getSellingResponseRowMapper() {
        return new BeanPropertyRowMapper<>(SellingResponse.class);
    }

    public Boolean insert(Selling selling) {
        try {
            String sql = "INSERT INTO selling (order_code, end_time, max_money, product_id, room_id) "
                    + "VALUES (?,?,?,?,?)";
            jdbc.update(sql, selling.getOrderCode(), selling.getEndTime(),
                    selling.getMaxMoney(), selling.getProductId(), selling.getRoomId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public List<Selling> getAllListBidding() {
        String sql = "SELECT selling.order_code FROM selling ORDER BY start_time DESC LIMIT 1";
        return getBySql(sql);
    }
    
    public List<SellingResponse> getAllList(int roleId, String accountId) {
        String sql = "SELECT product.name, selling.order_code, selling.max_money, product.vip "
                + "FROM product, selling "
                + "WHERE product.active = true "
                + "AND selling.expired = false "
                + "AND selling.paid = false "
                + "AND selling.finished = false "
                + "AND end_time > now() "
                + "AND selling.product_id = product.id";
        switch (roleId) {
            case AccountConstant.ROLE_IT:
                sql = "SELECT product.name, selling.order_code, selling.max_money, product.vip "
                        + "FROM product, selling "
                        + "WHERE product.active = true "
                        + "AND selling.expired = false "
                        + "AND selling.paid = false "
                        + "AND selling.finished = false "
                        + "AND end_time > now() "
                        + "AND selling.product_id = product.id";
                break;
            case AccountConstant.ROLE_ADMIN:
                sql = "SELECT product.name, selling.order_code, selling.max_money, product.vip "
                        + "FROM product, selling "
                        + "WHERE product.active = true "
                        + "AND selling.expired = false "
                        + "AND selling.paid = false "
                        + "AND selling.finished = false "
                        + "AND end_time > now() "
                        + "AND selling.product_id = product.id";
                break;
            case AccountConstant.ROLE_SALE:
                sql = "SELECT product.name, selling.order_code, selling.max_money, product.vip "
                        + "FROM product, selling "
                        + "WHERE product.active = true "
                        + "AND selling.expired = false "
                        + "AND selling.paid = false "
                        + "AND selling.finished = false "
                        + "AND end_time > now() "
                        + "AND selling.product_id = product.id "
                        + "AND product.posted_account_id = '" + accountId + "'";
        }
        List<SellingResponse> list = getSellingResponseSellingResponseBySql(sql);
        return list;
    }
}
