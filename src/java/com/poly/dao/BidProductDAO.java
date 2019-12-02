/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Product;
import com.poly.bean.Room;
import com.poly.tool.ConstantManager;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BidProductDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Product> getListBidWaitApprove() {
        String sql = "SELECT * FROM product WHERE auction = true";
        return jdbc.query(sql, getRowMapper());
    }

    public List<Product> getListBidByAccountSale(int saleId) {
        String sql = "SELECT * FROM product WHERE auction = true AND posted_account_id = ?";
        return jdbc.query(sql, getRowMapper(), saleId);
    }

    public List<Product> getListBidWaitApproveByWriter() {
        String sql = "SELECT * FROM product WHERE auction = true AND writer_approved = false";
        try {
            List<Product> getlist = jdbc.query(sql, getRowMapper());
            return getlist;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Product> getListBidWaitApproveByHR() {
        String sql = "SELECT * FROM product WHERE auction = true AND hr_approved = false";
        return jdbc.query(sql, getRowMapper());
    }

    public List<Product> getListBidWaitApproveByACC() {
        String sql = "SELECT * FROM product WHERE auction = true AND acc_approved = false";
        return jdbc.query(sql, getRowMapper());
    }

    public List<Product> getListBidWaitApproveByMod() {
        String sql = "SELECT * FROM product WHERE auction = true AND mod_approved = false";
        return jdbc.query(sql, getRowMapper());
    }

    public List<Product> getListBidWaitApproveByIT() {
        String sql = "SELECT * FROM product WHERE auction = true AND it_approved = false";
        return jdbc.query(sql, getRowMapper());
    }

    public void hrApproved() {
        String sql = "UPDATE product SET hr_approved = true AND hr_approved = true";
        jdbc.update(sql);
    }

    public void accApproved() {
        String sql = "UPDATE product SET acc_approved = true AND acc_approved = true";
        jdbc.update(sql);
    }

    public void writerApproved() {
        String sql = "UPDATE product SET writer_approved = true AND writer_approved = true";
        jdbc.update(sql);
    }

    public void modApproved() {
        String sql = "UPDATE product SET mod_approved = true AND mod_approved = true";
        jdbc.update(sql);
    }

    public void itApproved() {
        String sql = "UPDATE product SET it_approved = true AND it_approved = true";
        jdbc.update(sql);
    }

    public void adminApproved() {
        String sql = "UPDATE product SET writer_approved = true, hr_approved = true, acc_approved = true, "
                + "mod_approved = true, it_approved = true";
        jdbc.update(sql);
    }

    ///Not Use
    public List<Product> getProductBiddingByBrand(int brandId) {
        String sql = "SELECT id FROM bid_product WHERE brandId =? "
                + "and status = 4 and isApproved = 4";
        return jdbc.query(sql, new Object[]{brandId}, getBidProductMapper());
    }

    public List<Product> getBidProductsByStatus(String status) {
        String sql = "SELECT id, name, ordercode,initalMoney, status, image, isApproved "
                + "FROM bid_product "
                + "WHERE status = ? AND isDel = 0 and isApproved > 0 ";
        return jdbc.query(sql, new Object[]{status}, getBidProductMapper());
    }

    public List<Product> getBidProductsByStatusBidding(String status) {
        String sql = "SELECT id, name, ordercode,initalMoney, status, image, isApproved "
                + "FROM bid_product "
                + "WHERE status = ? AND isDel = 0 and isApproved = 4 ";
        return jdbc.query(sql, new Object[]{status}, getBidProductMapper());
    }

    public List<Product> getBidProductsByAdmin() {
        String sql = "SELECT id, name, ordercode,initalMoney, status, image, isApproved "
                + "FROM bid_product "
                + "WHERE isDel = 0 and status < 4 and isApproved > 0";
        return getBySql(sql);
    }

    public List<Product> getBidProductsByAdminStatusCancel() {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".bid_product where status = 7";
        return getBySql(sql);
    }

    public List<Product> getBidProductsByAdminStatusBidding() {
        String sql = "SELECT id, name, ordercode,initalMoney, status, image, isApproved "
                + "FROM bid_product "
                + "WHERE isDel = 0 and endTime > now() and isApproved = 4 order by endTime ";
        return getBySql(sql);
    }

    protected List<Product> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Product> getRowMapper() {
        return new BeanPropertyRowMapper<>(Product.class);
    }

    public List<Product> getBidProductsBySales(String createdBy) {
        String sql = "SELECT * from bid_product WHERE createdBy = ? and isApproved > 0 and status < 4 and isApproved < 4 and isDel = 0 order by status";
        return jdbc.query(sql, new Object[]{createdBy}, getBidProductMapper());
    }

    public List<Product> getBidProductsBySalesStatusCancel(String createdBy) {
        String sql = "SELECT id, name, ordercode,initalMoney, status, image, isApproved "
                + "FROM bid_product "
                + "WHERE createdBy = ? and status = 7 order by status";
        return jdbc.query(sql, new Object[]{createdBy}, getBidProductMapper());
    }

    public List<Product> getBidProductsBySalesStatusBidding(String createdBy) {
        String sql = "SELECT id, name, ordercode,initalMoney, status, image, isApproved "
                + "FROM bid_product "
                + "WHERE createdBy = ? and isDel = 0 and endTime > now() "
                + "and isApproved = 4 and status = 4 order by status ";
        return jdbc.query(sql, new Object[]{createdBy}, getBidProductMapper());
    }

    public Product getBidProductsById(int id) {
        String sql = "SELECT * FROM bid_product WHERE id = ?";
        try {

            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Room getBidRoomById(int id) {
        String sql = "SELECT * FROM room WHERE id = ?";
        return jdbc.queryForObject(sql, getBidRoomMapper(), id);
    }

    public List<Product> getBidProductDetailByBrandId(int id) {
        String sql = "SELECT * FROM bid_product WHERE brandId = ? AND active = true";
        try {
            return jdbc.query(sql, getRowMapper(), id);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Product> getBidProductDetailByCategoryId(int id) {
        String sql = "SELECT * FROM bid_product WHERE categoryId = ?";
        return jdbc.query(sql, getRowMapper(), id);
    }

    public Product getBidProductDetailByCategoryTypeId(int id) {
        String sql = "SELECT * FROM bid_product WHERE categoryTypeId = ? AND status = 4";
        try {
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void changeBrandId(int id) {
        String sql = "UPDATE bid_product SET brandId = 1 WHERE brandId= ?";
        jdbc.update(sql, id);
    }

    public void changeCategoryId(int id) {
        String sql = "UPDATE bid_product SET categoryId = 1 WHERE categoryId= ?";
        jdbc.update(sql, id);
    }

    public void updateStatus(Serializable id, Serializable status, Serializable isApproved) {
        String sql = "UPDATE bid_product SET status = ?, isApproved = ? WHERE id = ?";
        jdbc.update(sql, status, isApproved, id);
    }

    public void updateEndTime(int id, String endTime) {
        String sql = "UPDATE bid_product SET endTime = ? WHERE id = ?";
        jdbc.update(sql, endTime, id);
    }

    public void deleteBidProduct(Serializable id) {
        String sql = "UPDATE bid_product SET isDel = 1 WHERE id = ?";
        jdbc.update(sql, id);
    }

    public void deleteBidProductToCancelStatus(Serializable id) {
        String sql = "UPDATE bid_product SET isDel = 1, status = 7 WHERE id = ?";
        jdbc.update(sql, id);
    }

    public Product getTopProduct() {
        String sql = "SELECT * FROM bid_product ORDER BY id desc LIMIT 1";
        return jdbc.queryForObject(sql, getBidProductMapper());
    }

    private RowMapper<Product> getBidProductMapper() {
        return new BeanPropertyRowMapper<>(Product.class);
    }

    private RowMapper<Room> getBidRoomMapper() {
        return new BeanPropertyRowMapper<>(Room.class);
    }

    public List<Product> getListProductBiddingByCategoryId(int categoryId) {
        try {
            String sql = "SELECT * FROM daugia_project.product, daugia_project.bidding "
                    + "WHERE category_id = " + categoryId + " "
                    + "AND bidding.product_id = product.id "
                    + "AND bidding.expired = false "
                    + "AND bidding.finished = false "
                    + "AND bidding.paid = false "
                    + "AND product.active = true";
            List<Product> p = getBySql(sql);
            System.out.println(p.size());
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Product> getListProductBiddingByBrandId(int brandId) {
        try {
            String sql = "SELECT * FROM daugia_project.product, daugia_project.bidding "
                    + "WHERE brand_id = " + brandId + " "
                    + "AND bidding.product_id = product.id "
                    + "AND bidding.expired = false "
                    + "AND bidding.finished = false "
                    + "AND bidding.paid = false "
                    + "AND product.active = true";
            List<Product> p = getBySql(sql);
            System.out.println(p.size());
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean updateCategoryIdOfProduct(int categoryId) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                    + "SET category_id = 1 "
                    + "WHERE active = false AND category_id = " + categoryId;
            jdbc.update(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateBrandIdOfProduct(int brandId) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                    + "SET brand_id = 1 "
                    + "WHERE active = false AND category_id = " + brandId;
            jdbc.update(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
