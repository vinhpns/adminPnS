/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.TypeVideo;
import com.poly.bean.Video;
import com.poly.constant.VideoConstant;
import com.poly.dao.VideoDAO;
import com.poly.tool.Utils;
import com.poly.tool.checkLogin;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Kiet
 */
@Service
public class VideoService {

    @Autowired
    private VideoDAO vdao;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleWriter(role) == true
                || checkLogin.checkLoginRoleMod(role) == true
                || checkLogin.checkLoginRoleAdmin(role) == true);
    }

    public List<Video> getListVideo() {
        return vdao.getListVideo();
    }

    public Boolean deleteVideo(int id) {
        return !Objects.equals(vdao.deleteVideo(id), Boolean.FALSE);
    }

    public Video getVideoById(int id) {
        Video video = vdao.getVideoById(id);
        if (video == null) {
            return null;
        }
        return video;
    }

    public Boolean uploadImg(List<String> listNames, List<MultipartFile> listFiles) {
        if (listNames.size() > 0 && !listNames.isEmpty()) {
            for (int i = 0; i < listNames.size(); i++) {
                Utils.uploadImageToServer(VideoConstant.URL_STORE_SERVER, listNames.get(i), listFiles.get(i));
            }
            return true;
        }
        return false;
    }

    public String randomCodeImg() {
        Random rand = new Random();
        String codeN;
        String codeTotal = "SGDG";
        for (int i = 0; i < 16; i++) {
            int n = rand.nextInt(9);
            codeN = String.valueOf(n);
            codeTotal = codeTotal + codeN;
        }
        return codeTotal;
    }

    public Boolean changeActiveVideo(int id, Boolean active) {
        return !Objects.equals(vdao.changeActive(id, active), Boolean.FALSE);
    }

    public List<TypeVideo> initiateTypeVideo() {
        ArrayList<TypeVideo> type = new ArrayList<>();
        TypeVideo typeVideo1 = new TypeVideo(1, "Video Quảng Cáo");
        TypeVideo typeVideo2 = new TypeVideo(2, "Video Tin Tức");
        type.add(typeVideo1);
        type.add(typeVideo2);
        return type;
    }

    public Boolean insert(Video video) {
        return !Objects.equals(vdao.insertVideo(video), Boolean.FALSE);
    }
    
    public Boolean update(Video video) {
        return !Objects.equals(vdao.updateVideo(video), Boolean.FALSE);
    }
}
