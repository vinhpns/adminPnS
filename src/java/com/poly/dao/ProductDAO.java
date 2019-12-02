/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Product;
import com.poly.constant.AccountConstant;
import com.poly.constant.ProductConstant;
import com.poly.tool.ConstantManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<Product> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Product> getRowMapper() {
        return new BeanPropertyRowMapper<>(Product.class);
    }

    public List<Product> getListProduct(int type, int roleId, String accountId) {
        if (type == ProductConstant.AUCTION_PRODUCT) {
            String sql = "SELECT product.id, product.acc_approved, product.active, product.area, product.auction, "
                    + "product.hr_approved, product.writer_approved, product.it_approved, "
                    + "product.mod_approved, product.name, product.price   "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                    + "WHERE auction = true AND sale = false "
                    + "AND active = false AND posted_account_id = '" + accountId + "'";;
            switch (roleId) {
                case AccountConstant.ROLE_HR:
                    sql = "SELECT product.id, product.acc_approved, product.active, product.area, "
                            + "product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price   "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE hr_approved = false AND active = false AND sale = false";
                    break;
                case AccountConstant.ROLE_ACC:
                    sql = "SELECT product.id, product.acc_approved, product.active, product.area, "
                            + "product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price   "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE acc_approved = false AND active = false AND sale = false";
                    break;
                case AccountConstant.ROLE_WRITER:
                    sql = "SELECT product.id, product.acc_approved, product.active, product.area, "
                            + "product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price  "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE writer_approved = false AND active = false AND sale = false";
                    break;
                case AccountConstant.ROLE_MOD:
                    sql = "SELECT product.id, product.acc_approved, product.active, product.area, "
                            + "product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price   FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE writer_approved = true "
                            + "AND acc_approved = true AND hr_approved = true "
                            + "AND mod_approved = false AND active = false AND sale = false";
                    break;
                case AccountConstant.ROLE_IT:
                    sql = "SELECT product.id, product.acc_approved, product.active, "
                            + "product.area, product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price  "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE it_approved = false AND active = false AND auction = true";
                    break;
                case AccountConstant.ROLE_ADMIN:
                    sql = "SELECT product.id, product.acc_approved, product.active, "
                            + "product.area, product.auction, product.hr_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price, product.writer_approved "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE auction = true AND sale = false AND active = false";
                    break;
            }
            return getBySql(sql);
        } else {
            String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                    + "WHERE auction = false AND sale = true "
                    + "AND active = false AND posted_account_id = '" + accountId + "'";;
            switch (roleId) {
                case AccountConstant.ROLE_HR:
                    sql = "SELECT product.id, product.acc_approved, product.active, "
                            + "product.area, product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price  "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE hr_approved = false AND active = false auction = false AND sale = true ";
                    break;
                case AccountConstant.ROLE_ACC:
                    sql = "SELECT product.id, product.acc_approved, product.active, "
                            + "product.area, product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price  "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE acc_approved = false AND active = false "
                            + "AND auction = false AND sale = true ";
                    break;
                case AccountConstant.ROLE_WRITER:
                    sql = "SELECT product.id, product.acc_approved, product.active, "
                            + "product.area, product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price  "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE writer_approved = false AND active = false "
                            + "AND auction = false AND sale = true ";
                    break;
                case AccountConstant.ROLE_MOD:
                    sql = "SELECT product.id, product.acc_approved, product.active, "
                            + "product.area, product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price  "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE writer_approved = true "
                            + "AND acc_approved = true AND hr_approved = true "
                            + "AND mod_approved = false AND active = false "
                            + "AND auction = false AND sale = true ";
                    break;
                case AccountConstant.ROLE_IT:
                    sql = "SELECT product.id, product.acc_approved, product.active, "
                            + "product.area, product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price  "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE it_approved = false AND active = false "
                            + "AND auction = false AND sale = true ";
                    break;
                case AccountConstant.ROLE_ADMIN:
                    sql = "SELECT product.id, product.acc_approved, product.active, "
                            + "product.area, product.auction, product.hr_approved, product.writer_approved, "
                            + "product.it_approved, product.mod_approved, product.name, product.price  "
                            + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "WHERE auction = false AND sale = true AND active = false";
                    break;
            }
            return getBySql(sql);
        }
    }

    public Product getById(int id) {
        try {
            String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".product WHERE id = ?";
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean approved(int id, int roleId) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                    + "SET writer_approved = true "
                    + "WHERE id = " + id + "";
            switch (roleId) {
                case AccountConstant.ROLE_HR:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "SET hr_approved = true "
                            + "WHERE id = " + id + "";
                    break;
                case AccountConstant.ROLE_ACC:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "SET acc_approved = true "
                            + "WHERE id = " + id + "";
                    break;
                case AccountConstant.ROLE_WRITER:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "SET writer_approved = true "
                            + "WHERE id = " + id + "";
                    break;
                case AccountConstant.ROLE_MOD:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "SET mod_approved = true "
                            + "WHERE id = " + id + "";
                    break;
                case AccountConstant.ROLE_IT:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "SET it_approved = true "
                            + "WHERE id = " + id + "";
                    break;
                case AccountConstant.ROLE_ADMIN:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "SET hr_approved = true, acc_approved = true, "
                            + "mod_approved = true, it_approved = true "
                            + "WHERE id = ?";
                    break;
            }
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean returnStatus(int id, int roleId) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                    + "SET writer_approved = true "
                    + "WHERE id = " + id + "";
            switch (roleId) {
                case AccountConstant.ROLE_MOD:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "SET writer_approved = false "
                            + "WHERE id = " + id + "";
                    break;
                case AccountConstant.ROLE_IT:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "SET mod_approved = true "
                            + "WHERE id = " + id + "";
                    break;
                case AccountConstant.ROLE_ADMIN:
                    sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product "
                            + "SET hr_approved = true, acc_approved = true, "
                            + "mod_approved = true, it_approved = true "
                            + "WHERE id = ?";
                    break;
            }
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insert(Product product, int roleId) {
        String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".product (acc_approved, area, auction, description, hr_approved, "
                + "it_approved, mod_approved, name, origin, posted_count, price, sale, state, vip, warranty, "
                + "writer_approved, brand_id, category_id, posted_account_id, active) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            jdbc.update(sql, product.getAccApproved(), product.getArea(), product.getAuction(),
                    product.getDescription(), product.getHrApproved(), product.getItApproved(), product.getModApproved(),
                    product.getName(), product.getOrigin(), product.getPostedCount(), product.getPrice(),
                    product.getSale(), product.getState(), product.getVip(), product.getWarranty(),
                    product.getWriterApproved(), product.getBrandId(), product.getCategoryId(),
                    product.getPostedAccountId(), product.getActive());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateActive(int id) {
        try {
            String sql = "UPDATE product SET active = true WHERE id = ?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Product getLastInsertProduct() {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".product ORDER BY id desc LIMIT 1";
        return jdbc.queryForObject(sql, getRowMapper());
    }

    public Product getProductInfoById(int id) {
        String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".product WHERe id = ?";
        return jdbc.queryForObject(sql, getRowMapper(), id);
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product SET area = ?, description = ?, name = ?, origin = ?, price = ?, "
                + "state = ?, warranty = ?, brand_id = ?, category_id = ? WHERE id = ?";
        jdbc.update(sql, product.getArea(), product.getDescription(), product.getName(), product.getOrigin(),
                product.getPrice(), product.getState(), product.getWarranty(),
                product.getBrandId(), product.getCategoryId(), product.getId());
    }

    public List<Product> getListProductByCategoryId(int categoryId) {
        try {
            String sql = "SELECT * FROM " + ConstantManager.DEFAULT_DB_NAME + ".product WHERE category_id = ?";
            return jdbc.query(sql, getRowMapper(), categoryId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateCategoryId(int categoryId) {
        String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".product SET category_id = 1 WHERE category_id = " + categoryId + "";
        jdbc.update(sql);
    }
}
