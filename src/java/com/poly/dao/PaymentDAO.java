/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Payment;
import com.poly.bean.Refund;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDAO {

    @Autowired
    protected JdbcTemplate jdbc;

    public List<Payment> getListDeposit() {
        String sql = "SELECT payment.id, payment.bank_transaction, payment.money, payment.paid, \n"
                + "payment.purpose, payment.bidding_order_code, payment.customer_account_id, account.full_name \n"
                + "FROM payment \n"
                + "INNER JOIN account ON account.id = payment.customer_account_id\n"
                + "WHERE payment.purpose = 1 ";
        return getBySql(sql);
    }

    public List<Refund> getListRefund() {
        String sql = "SELECT DISTINCT bidding_order_code FROM sgdg_2019.refund;";
        return getRefundBySql(sql);
    }

    public List<Refund> getListRefundDetail(String ordercode) {
        String sql = "SELECT refund.id, refund.money, refund.customer_account_id, refund.paid, "
                + "refund.bidding_order_code, account.full_name "
                + "FROM refund "
                + "INNER JOIN account "
                + "WHERE refund.bidding_order_code = '" + ordercode + "' AND account.id = refund.customer_account_id ";
        return getRefundBySql(sql);
    }

    public List<Payment> getAllWin() {
        String sql = "select payment.id, payment.customer_id, payment.amount, payment.is_paid, payment.purpose,\n"
                + "customer.fullname, payment.order_code\n"
                + "from sgdg_old.payment \n"
                + "join sgdg_old.customer\n"
                + "where \n"
                + "customer.id = payment.customer_id\n"
                + "and payment.purpose = 2\n";
        return getBySql(sql);
    }

    public void updateStatusRefund(String ordercode, String customerid) {
        String sql = "UPDATE refund SET paid = true WHERE bidding_order_code = ? AND customer_account_id = ?";
        jdbc.update(sql, ordercode, customerid);
    }

    public void updateStatusWinBid(String ordercode, String customerid) {
        String sql = "UPDATE bidding_history SET status = 4 WHERE bidding_order_code = ? AND customer_account_id = ?";
        jdbc.update(sql, ordercode, customerid);
    }

    public void updateStatusPaidDeposit(String orderCode, String customerid) {
        String sql = "UPDATE payment SET paid = true WHERE bidding_order_code = ? AND customer_account_id = ?";
        jdbc.update(sql, orderCode, customerid);
    }

    protected List<Payment> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Payment> getRowMapper() {
        return new BeanPropertyRowMapper<>(Payment.class);
    }

    protected List<Refund> getRefundBySql(String sql) {
        return jdbc.query(sql, getRefundRowMapper());
    }

    private RowMapper<Refund> getRefundRowMapper() {
        return new BeanPropertyRowMapper<>(Refund.class);
    }
}
