/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Video;
import com.poly.constant.VideoConstant;
import com.poly.service.VideoService;
import com.poly.tool.ConstantManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author vinh1
 */
@Controller
@RequestMapping(value = ConstantManager.VIDEO_PAGE)
public class VideoController {

    @Autowired
    VideoService vSer;

    AccountController accController = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        if (Objects.equals(vSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.put(VideoConstant.TYPE_VIDEO_KEY, vSer.initiateTypeVideo());
        model.put(VideoConstant.LIST_VIDEO_KEY, vSer.getListVideo());
        return VideoConstant.VIDEO_PAGE;
    }

    @RequestMapping(params = ConstantManager.LOCK_FUNCTION, method = RequestMethod.GET)
    public String lock(ModelMap model, HttpSession session,
            @RequestParam(VideoConstant.VIDEO_PARAM_ID) int id,
            @RequestParam(VideoConstant.VIDEO_PARAM_STATUS) Boolean active) {
        if (Objects.equals(vSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(vSer.changeActiveVideo(id, active), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, VideoConstant.LOCK_VIDEO_FAIL);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, VideoConstant.LOCK_VIDEO_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.GET_FUNCTION, method = RequestMethod.GET)
    public String getVideoById(@RequestParam(VideoConstant.VIDEO_PARAM_ID) int id,
            ModelMap model, HttpSession session) {
        if (Objects.equals(vSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.put(VideoConstant.TYPE_VIDEO_KEY, vSer.initiateTypeVideo());
        model.addAttribute(VideoConstant.VIDEO_BY_ID_KEY, vSer.getVideoById(id));
        return VideoConstant.UPDATE_VIDEO_PAGE;
    }

    @RequestMapping(params = ConstantManager.DELETE_FUNCTION)
    public String delete(ModelMap model, HttpSession session,
            @RequestParam(VideoConstant.VIDEO_PARAM_ID) int id) {
        if (vSer.checkLogin(session) == false) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        vSer.deleteVideo(id);
//        model.addAttribute(ConstantManager.OK_POPUP, ConstantManager.UPDATE_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.INSERT_FUNCTION, method = RequestMethod.POST)//params ="name" bên jsp//
    public String insert(ModelMap model, HttpSession session,
            @RequestParam(VideoConstant.LINK_PARAM) String videoLink,
            @RequestParam(VideoConstant.TYPE_ID_PARAM) int typeId,
            @RequestParam(VideoConstant.IMAGES_PARAM) MultipartFile image,
            @RequestParam(VideoConstant.TITLE_PARAM) String title) {
        if (vSer.checkLogin(session) == false) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        if (ConstantManager.EMPTY.equalsIgnoreCase(image.getOriginalFilename())) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.IMAGE_MUST_BE_IN);
            return initiate(model, session);
        }
        Video video = new Video();
        String imgName = vSer.randomCodeImg() + image.getOriginalFilename();
        listNames.add(imgName);
        listFiles.add(image);
        Boolean checkUploadImg = vSer.uploadImg(listNames, listFiles);
        if (checkUploadImg == false) {
            model.addAttribute(ConstantManager.ERROR_POPUP, VideoConstant.INSERT_FAIL);
            return initiate(model, session);
        }
        video.setActive(true);
        video.setImage(VideoConstant.URL_SERVER + imgName);
        video.setLink(videoLink);
        video.setType(typeId);
        video.setTitle(title);
        if (Objects.equals(vSer.insert(video), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, VideoConstant.INSERT_FAIL);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, VideoConstant.INSERT_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.UPDATE_FUNCTION, method = RequestMethod.POST)
    public String updateVideo(ModelMap model, HttpSession session,
            @RequestParam(VideoConstant.VIDEO_PARAM_ID) int id,
            @RequestParam(VideoConstant.LINK_PARAM) String videoLink,
            @RequestParam(VideoConstant.TYPE_ID_PARAM) int typeId,
            @RequestParam(VideoConstant.IMAGES_PARAM) MultipartFile image,
            @RequestParam(VideoConstant.TITLE_PARAM) String title) {
        Video video = vSer.getVideoById(id);
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();

        video.setActive(video.getActive());
        video.setImage(video.getImage());
        video.setLink(videoLink);
        video.setTitle(title);
        video.setType(typeId);
        if (!image.isEmpty()) {
            String imgName = vSer.randomCodeImg() + image.getOriginalFilename();
            listNames.add(imgName);
            listFiles.add(image);
            video.setImage(VideoConstant.URL_SERVER + imgName);
        }
        if (listFiles.size() > 0 && listFiles.size() > 0) {
            Boolean checkUploadImg = vSer.uploadImg(listNames, listFiles);
            if (checkUploadImg == false) {
                model.addAttribute(ConstantManager.ERROR_POPUP, VideoConstant.INSERT_FAIL);
                return initiate(model, session);
            }
        }
        if (Objects.equals(vSer.update(video), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, VideoConstant.UPDATE_FAIL);
            return getVideoById(id, model, session);
        }
        model.put(ConstantManager.OK_POPUP, VideoConstant.UPDATE_OK);
        return initiate(model, session);
    }
}
