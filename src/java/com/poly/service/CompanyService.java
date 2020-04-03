/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Company;
import com.poly.dao.CompanyDAO;
import com.poly.request.CompanyRequest;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinh1
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    public Company getInfo(String companyId) {
        return companyDAO.getInfo(companyId);
    }

    public Boolean uploadImg(String name, MultipartFile files) {
        try {
            List<String> listNames = new ArrayList<>();
            List<MultipartFile> listFiles = new ArrayList<>();
            listNames.add(name);
            listFiles.add(files);
            Utils.uploadImg(listNames, listFiles, ConstantManager.FOLDER_CONTAIN_IMG + "company/");
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Company getCompanyById(List<Company> com, String id) {
        Company result = null;
        for (Company temp : com) {
            if (id.equals(temp.getId())) {
                result = temp;
            }
        }
        return result;
    }

    public Boolean update(CompanyRequest c) {
        Company company = companyDAO.getInfo(c.getCompanyId());
        company.setId(c.getId());
        company.setAddress(c.getAddress());
        company.setAlias(c.getAlias());
        company.setDescriptionSeo(c.getDescriptionSeo());
        company.setTitleOne(c.getTitleOne());
        company.setTitleTwo(c.getTitleTwo());
        company.setTitleThree(c.getTitleThree());
        company.setDescriptionOne(c.getDescriptionOne());
        company.setDescriptionTwo(c.getDescriptionTwo());
        company.setDescriptionThree(c.getDescriptionThree());
        if (c.getAvatar().isEmpty()) {
            company.setLogo(company.getLogo());
        } else {
            String imgName = Utils.randomCodeImg() + c.getAvatar().getOriginalFilename();
            uploadImg(imgName, c.getAvatar());
            company.setLogo(ConstantManager.URL_SHOW_IMG + "company/" + imgName);
        }
        company.setMetaSeo(c.getMetaSeo());
        company.setName(c.getName());
        company.setPhone(c.getPhone());
        company.setTitleSeo(c.getTitleSeo());
        return !Objects.equals(companyDAO.updateInfo(company), Boolean.FALSE);
    }
}
