/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Type;
import com.poly.dao.TypeDAO;
import com.poly.request.TypeRequest;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author 1
 */
@Service
public class TypeService {

    @Autowired
    TypeDAO typeDAO;

    public Type getTypeById(int id, String companyId) {
        return typeDAO.getTypeByTypeId(id, companyId);
    }

    public Boolean uploadImg(String name, MultipartFile files) {
        try {
            List<String> listNames = new ArrayList<>();
            List<MultipartFile> listFiles = new ArrayList<>();
            listNames.add(name);
            listFiles.add(files);
            Utils.uploadImg(listNames, listFiles, ConstantManager.FOLDER_CONTAIN_IMG + "type/");
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateType(TypeRequest typeReq) {
        Type type = typeDAO.getTypeByTypeId(typeReq.getType(), typeReq.getCompanyId());
        type.setId(typeReq.getId());
        type.setTitle(typeReq.getTitle());
        type.setTitleDescription(typeReq.getTitleDescription());
        type.setShortTitle(typeReq.getShortTitle());
        type.setShortDescription(typeReq.getShortDescription());
        type.setReasonOne(typeReq.getReasonOne());
        type.setDescriptionOne(typeReq.getDescriptionOne());
        type.setReasonTwo(typeReq.getReasonTwo());
        type.setDescriptionTwo(typeReq.getDescriptionTwo());
        type.setReasonThree(typeReq.getReasonThree());
        type.setDescriptionThree(typeReq.getDescriptionThree());
        if (typeReq.getPicOne().isEmpty()) {
            type.setPicOne(type.getPicOne());
        } else {
            String imgName = Utils.randomCodeImg() + typeReq.getPicOne().getOriginalFilename();
            uploadImg(imgName, typeReq.getPicOne());
            type.setPicOne(ConstantManager.URL_SHOW_IMG + "type/" + imgName);
        }
        if (typeReq.getPicTwo().isEmpty()) {
            type.setPicTwo(type.getPicTwo());
        } else {
            String imgName = Utils.randomCodeImg() + typeReq.getPicTwo().getOriginalFilename();
            uploadImg(imgName, typeReq.getPicTwo());
            type.setPicTwo(ConstantManager.URL_SHOW_IMG + "type/" + imgName);
        }
        if (typeReq.getPicThree().isEmpty()) {
            type.setPicThree(type.getPicThree());
        } else {
            String imgName = Utils.randomCodeImg() + typeReq.getPicThree().getOriginalFilename();
            uploadImg(imgName, typeReq.getPicThree());
            type.setPicThree(ConstantManager.URL_SHOW_IMG + "type/" + imgName);
        }
        if (typeReq.getPicMain().isEmpty()) {
            type.setPicMain(type.getPicMain());
        } else {
            String imgName = Utils.randomCodeImg() + typeReq.getPicMain().getOriginalFilename();
            uploadImg(imgName, typeReq.getPicMain());
            type.setPicMain(ConstantManager.URL_SHOW_IMG + "type/" + imgName);
        }
        return typeDAO.update(type);
    }
}
