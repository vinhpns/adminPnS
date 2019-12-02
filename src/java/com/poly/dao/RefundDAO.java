/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Refund;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RefundDAO {

    @Autowired
    protected JdbcTemplate jdbc;

    protected List<Refund> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Refund> getRowMapper() {
        return new BeanPropertyRowMapper<Refund>(Refund.class);
    }

    public List<Refund> getAll() {
        String sql = "Select refund.id,refund.bid_id, bid_product.ordercode, refund.customer_id, refund.money, refund.status,\n"
                + "customer.fullname, bid_product.name as productName\n"
                + "from sgdg_old.refund\n"
                + "join sgdg_old.customer\n"
                + "join sgdg_old.bid_product\n"
                + "where customer.id = refund.customer_id\n"
                + "and bid_product.id = refund.bid_id";
        return getBySql(sql);
    }

    public void updateStatus(String ordercode, String customerid) {
        String sql = "UPDATE refund SET status = 1 WHERE bid_id = ? and customer_id = ?";
        jdbc.update(sql, ordercode, customerid);
    }

    public void delete(Serializable id) {
        String sql = "delete from emailcontent where id=?";
        jdbc.update(sql, id);
    }

    public void insert(Refund refund) {
        String sql = "insert into emailcontent (title, content) values (?,?)";
        jdbc.update(sql, refund.getId());
    }

    public List<Refund> getById(Serializable id) {
        String sql = "SELECT * FROM emailcontent WHERE title = ?";
        return jdbc.query(sql, getRowMapper(), id);
    }

    public Refund getByPass(Serializable id) {
        String sql = "SELECT content FROM emailcontent WHERE title = ?";
        return jdbc.queryForObject(sql, getRowMapper(), id);
    }

    public List<Refund> getListIdParameter() {
        String sql = "select * from emailcontent where isDel= 1";
        return getBySql(sql);
    }

    public boolean checkexsist(String title) {
        boolean ck = false;
        try {
            List<Refund> ds;
            ds = getById(ck);
            if (ds.size() > 0) {
                ck = true;
            } else {
                ck = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ck;
    }
}
