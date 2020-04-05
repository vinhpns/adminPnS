/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.ServiceCompany;
import com.poly.bean.ServiceInfo;
import com.poly.request.ServiceRequest;
import com.poly.response.ServiceResponse;
import com.poly.tool.ConstantManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PnS
 */
@Repository
public class ServiceDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<ServiceResponse> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<ServiceResponse> getRowMapper() {
        return new BeanPropertyRowMapper<>(ServiceResponse.class);
    }

    public List<ServiceResponse> getListService(String companyId) {
        try {
            String sql = "SELECT service.id, service.title, service.money, "
                    + "service_info.avatar, service.is_active "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".service, "
                    + ConstantManager.DEFAULT_DB_NAME + ".service_info "
                    + "WHERE company_id = '" + companyId + "' "
                    + "AND del_Flg = false "
                    + "AND service.id = service_info.service_id";
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean delete(String id, String updated_by) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".service "
                    + "SET del_Flg = true, updated_by = ? WHERE id = ?";
            jdbc.update(sql, updated_by, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateStatus(ServiceRequest s) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".service "
                    + "SET is_active = ?, updated_by = ? "
                    + "WHERE id = ?";
            jdbc.update(sql, s.getStatus(), s.getUpdatedBy(), s.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean update(ServiceRequest s) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".service "
                    + "SET title = ?, money = ?, updated_by = ?, is_menu = ? "
                    + "WHERE id = ?";
            jdbc.update(sql, s.getTitle(), s.getMoney(), s.getUpdatedBy(), s.getIsMenu(), s.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateDetail(ServiceInfo s) {
        try {
            String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".service_info "
                    + "SET avatar = ? "
                    + "WHERE service_id = ?";
            jdbc.update(sql, s.getAvatar(), s.getServiceId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insert(ServiceRequest s) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".service "
                    + "(id, title, money, created_by, is_menu, company_id) VALUES (?,?,?,?,?,?)";
            jdbc.update(sql, s.getId(), s.getTitle(), s.getMoney(),
                    s.getCreatedBy(), s.getIsMenu(), s.getCompanyId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insertDetail(ServiceInfo s) {
        try {
            String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".service_info "
                    + "(service_id, avatar) VALUES (?,?)";
            jdbc.update(sql, s.getServiceId(), s.getAvatar());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public ServiceResponse getById(String id) {
        try {
            String sql = "SELECT service.id, service.title, service.money, "
                    + "service_info.avatar, service.company_id, service.is_menu "
                    + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".service, "
                    + ConstantManager.DEFAULT_DB_NAME + ".service_info "
                    + "WHERE id = ?";
            return jdbc.queryForObject(sql, getRowMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
