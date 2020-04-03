/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.TypeImage;
import com.poly.constant.NewsConstant;
import com.poly.dao.TypeImageDAO;
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
public class TypeImageService {

    @Autowired
    TypeImageDAO typeImageDAO;

    public List<TypeImage> listByType(int type) {
        return typeImageDAO.getByTypeId(type);
    }

    public Boolean insert(TypeImage t) {
        if (t.getImg().isEmpty()) {
            return Boolean.FALSE;
        }
        String imgName = Utils.randomCodeImg() + t.getImg().getOriginalFilename();
        uploadImg(imgName, t.getImg());
        t.setLink(ConstantManager.URL_SHOW_IMG + "img/" + imgName);
        t.setCompanyId(ConstantManager.COMPANY_ID);
        return typeImageDAO.insert(t);
    }

    public Boolean delete(int id) {
        return typeImageDAO.delete(id);
    }

    public Boolean uploadImg(String names, MultipartFile files) {
        try {
            List<String> listNames = new ArrayList<>();
            List<MultipartFile> listFiles = new ArrayList<>();
            listNames.add(names);
            listFiles.add(files);
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, ConstantManager.FOLDER_CONTAIN_IMG + "img/");
            if (checkUploadImg == false) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateStatus(int id, Boolean status) {
        return typeImageDAO.updateStatus(id, status);
    }
}
