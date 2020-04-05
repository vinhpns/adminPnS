/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.ServiceCompany;
import com.poly.bean.ServiceInfo;
import com.poly.constant.NewsConstant;
import com.poly.constant.ServiceConstant;
import com.poly.dao.ServiceDAO;
import com.poly.request.ServiceRequest;
import com.poly.response.ServiceResponse;
import com.poly.tool.Utils;
import com.poly.tool.checkLogin;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PnS
 */
@Service
public class Ser {

    @Autowired
    ServiceDAO sdao;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleAdmin(role) == true
                || checkLogin.checkLoginRoleSuperAdmin(role));
    }

    public List<ServiceResponse> getListService(String companyId) {
        return sdao.getListService(companyId);
    }

    public Boolean updateStatus(String id, Boolean status, String updated_by) {
        ServiceRequest s = new ServiceRequest();
        s.setId(id);
        s.setStatus(status);
        s.setUpdatedBy(updated_by);
        return sdao.updateStatus(s);
    }

    public Boolean delete(String id, String updated_by) {
        return sdao.delete(id, updated_by);
    }

    public ServiceResponse getById(String id) {
        return sdao.getById(id);
    }

    public Boolean updateInfo(ServiceRequest s) {
        if(s.getIsMenu() == null) {
            s.setIsMenu(Boolean.FALSE);
        }else{
            s.setIsMenu(Boolean.TRUE);
        }
        ServiceResponse sr = getById(s.getId());
        if (Objects.equals(sdao.update(s), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.setServiceId(s.getId());
        if (s.getAvatar().isEmpty()) {
            serviceInfo.setAvatar(sr.getAvatar());
        } else {
            String imgName = Utils.randomCodeImg() + s.getAvatar().getOriginalFilename();
            uploadImg(imgName, s.getAvatar());
            serviceInfo.setAvatar(ServiceConstant.URL_SERVER + imgName);
        }
        return sdao.updateDetail(serviceInfo);
    }

    public Boolean insert(ServiceRequest s) {
        UUID uuid = UUID.randomUUID();
        s.setId(uuid.toString());
        if (Objects.equals(sdao.insert(s), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.setServiceId(s.getId());
        String imgName = Utils.randomCodeImg() + s.getAvatar().getOriginalFilename();
        uploadImg(imgName, s.getAvatar());
        serviceInfo.setAvatar(ServiceConstant.URL_SERVER + imgName);
        return sdao.insertDetail(serviceInfo);
    }

    public Boolean uploadImg(String names, MultipartFile files) {
        try {
            List<String> listNames = new ArrayList<>();
            List<MultipartFile> listFiles = new ArrayList<>();
            listNames.add(names);
            listFiles.add(files);
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, ServiceConstant.URL_STORE_SERVER);
            if (checkUploadImg == false) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
