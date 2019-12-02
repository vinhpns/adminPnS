/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Bidding;
import com.poly.bean.BiddingHistory;
import com.poly.constant.AccountConstant;
import com.poly.request.BiddingResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BiddingDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Bidding> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Bidding> getRowMapper() {
        return new BeanPropertyRowMapper<>(Bidding.class);
    }

    protected List<BiddingHistory> getBiddingHistoryBySql(String sql) {
        return jdbc.query(sql, getBiddingHistoryRowMapper());
    }

    private RowMapper<BiddingHistory> getBiddingHistoryRowMapper() {
        return new BeanPropertyRowMapper<>(BiddingHistory.class);
    }

    protected List<BiddingResponse> getBiddingResponseBySql(String sql) {
        return jdbc.query(sql, getBiddingResponseRowMapper());
    }

    private RowMapper<BiddingResponse> getBiddingResponseRowMapper() {
        return new BeanPropertyRowMapper<>(BiddingResponse.class);
    }

    public Boolean insert(Bidding bidding) {
        try {
            String sql = "INSERT INTO bidding (order_code, end_time, max_money, product_id, room_id) "
                    + "VALUES (?,?,?,?,?)";
            jdbc.update(sql, bidding.getOrderCode(), bidding.getEndTime(),
                    bidding.getMaxMoney(), bidding.getProductId(), bidding.getRoomId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
    

    public List<BiddingResponse> getAllList(int roleId, String accountId) {
        String sql = "SELECT product.name, bidding.order_code, bidding.max_money, product.vip "
                + "FROM product, bidding "
                + "WHERE product.active = true "
                + "AND bidding.expired = false "
                + "AND bidding.paid = false "
                + "AND bidding.finished = false "
                + "AND end_time > now() "
                + "AND bidding.product_id = product.id";
        switch (roleId) {
            case AccountConstant.ROLE_IT:
                sql = "SELECT product.name, bidding.order_code, bidding.max_money, product.vip "
                        + "FROM product, bidding "
                        + "WHERE product.active = true "
                        + "AND bidding.expired = false "
                        + "AND bidding.paid = false "
                        + "AND bidding.finished = false "
                        + "AND end_time > now() "
                        + "AND bidding.product_id = product.id";
                break;
            case AccountConstant.ROLE_ADMIN:
                sql = "SELECT product.name, bidding.order_code, bidding.max_money, product.vip "
                        + "FROM product, bidding "
                        + "WHERE product.active = true "
                        + "AND bidding.expired = false "
                        + "AND bidding.paid = false "
                        + "AND bidding.finished = false "
                        + "AND end_time > now() "
                        + "AND bidding.product_id = product.id";
                break;
            case AccountConstant.ROLE_SALE:
                sql = "SELECT product.name, bidding.order_code, bidding.max_money, product.vip "
                        + "FROM product, bidding "
                        + "WHERE product.active = true "
                        + "AND bidding.expired = false "
                        + "AND bidding.paid = false "
                        + "AND bidding.finished = false "
                        + "AND end_time > now() "
                        + "AND bidding.product_id = product.id "
                        + "AND product.posted_account_id = '" + accountId + "'";
        }
        List<BiddingResponse> list = getBiddingResponseBySql(sql);
        return list;
    }

    public List<Bidding> getAllListBidding() {
        String sql = "SELECT bidding.order_code FROM bidding ORDER BY start_time DESC LIMIT 1";
        return getBySql(sql);
    }

    public List<Bidding> getListBidding() {
        String sql = "SELECT product.name, bidding.order_code, product.price, product.vip" +
                     "FROM product, bidding" +
                    "WHERE product.active = true" +
                    "AND bidding.end_time > now()" +
                    "AND bidding.paid = false" +
                    "AND bidding.expired = false" +
                    "AND bidding.finished = false" +
                    "ORDER BY bidding.end_time ASC";
        return getBySql(sql);
    }

    public List<Bidding> getListBiddingBySaler(String accountId) {
        String sql = "SELECT bidding.order_code, bidding.end_time, bidding.expired, "
                + "bidding.finished, bidding.max_money, bidding.paid, bidding.start_time, "
                + "bidding.product_id, bidding.room_id, product.name as name "
                + "FROM bidding "
                + "INNER JOIN product "
                + "WHERE product.active = true AND product.auction = true AND product.sale = false "
                + "AND product.id = bidding.product_id "
                + "AND expired = false "
                + "AND finished = false "
                + "AND paid = false "
                + "AND product.posted_account_id = ? AND bidding.repost = false "
                + "ORDER BY start_time DESC";
        return jdbc.query(sql, getRowMapper(), accountId);
    }

    public List<BiddingHistory> getBiddingHistoryByOrderCode(String ordercode) {
        String sql = "SELECT bidding_history.id, bidding_history.rank, bidding_history.date, bidding_history.money, "
                + "bidding_history.status, account.full_name as customerName, bidding_history.bidding_order_code "
                + "FROM sgdg_2019.bidding_history "
                + "INNER JOIN account on account.id = bidding_history.customer_account_id "
                + "AND bidding_history.bidding_order_code = '" + ordercode + "' "
                + "ORDER BY money";
        try {
            List<BiddingHistory> listBid = getBiddingHistoryBySql(sql);
            return listBid;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Bidding> getListBidExpired() {
        String sql = "SELECT product.name, bidding.order_code, product.price, product.vip " +
                    "FROM sgdg_2019.bidding, sgdg_2019.product " +
                    "WHERE  product.id = bidding.product_id and bidding.expired = true;";
        return getBySql(sql);
    }

    public List<Bidding> getListBidExpiredByUser(String account_id) {
        String sql = "SELECT bidding.order_code, bidding.end_time, bidding.expired, "
                + "bidding.finished, bidding.max_money, bidding.SELECT bidding.order_code , bidding.paid, bidding.start_time, "
                + "bidding.product_id, bidding.room_id, product.name "
                + "FROM bidding "
                + "INNER JOIN product "
                + "WHERE product.active = true AND product.auction = true AND product.sale = false "
                + "AND bidding.expired = true AND product.id = bidding.product_id AND bidding.repost = false "
                + "AND posted_account_id = '" + account_id + "'"
                + "ORDER BY id DESC";
        return getBySql(sql);
    }

    public Bidding getBidByOrderCode(String ordercode) {
        String sql = "SELECT * FROM bidding WHERE bidding.order_code = ?";
        return jdbc.queryForObject(sql, getRowMapper(), ordercode);
    }

    public void insertNewBidding(Bidding bid) {
        String sql = "INSERT INTO bidding (order_code, end_time, expired, finished, max_money, "
                + "paid, product_id, room_id) VALUES (?,?,?,?,?,?,?,?)";
        jdbc.update(sql, bid.getOrderCode(), bid.getEndTime(), bid.getExpired(), bid.getFinished(), bid.getMaxMoney(),
                bid.getPaid(), bid.getProductId(), bid.getRoomId());
    }

    public void deleteBidding(String ordercode) {
        String sql = "UPDATE bidding SET bidding.expired = true WHERE bidding.order_code = '" + ordercode + "'";
        jdbc.update(sql);
    }

    public void updateRepostStatus(String ordercode) {
        String sql = "UPDATE bidding SET bidding.repost = true WHERE bidding.order_code = '" + ordercode + "'";
        jdbc.update(sql);
    }

    public List<Bidding> getTopBidding() {
        String sql = "SELECT * FROM bidding ORDER BY start_time DESC LIMIT 1";
        return jdbc.query(sql, getRowMapper());
    }

    public List<BiddingHistory> getWinList() {
        String sql = "SELECT bidding_history.id, bidding_history.rank, bidding_history.date, bidding_history.money, "
                + "bidding_history.status, bidding_history.customer_account_id, "
                + "account.full_name as customerName, bidding_history.bidding_order_code "
                + "FROM sgdg_2019.bidding_history "
                + "INNER JOIN account "
                + "WHERE account.id = bidding_history.customer_account_id "
                + "AND (status = 2 or status = 4)"
                + "ORDER BY id DESC";
        try {
            List<BiddingHistory> listBid = getBiddingHistoryBySql(sql);
            return listBid;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
