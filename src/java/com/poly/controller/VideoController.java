/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.constant.VideoConstant;
import com.poly.request.VideoRequest;
import com.poly.service.VideoService;
import com.poly.tool.ConstantManager;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        model.put(VideoConstant.LIST_VIDEO_KEY, videoService.getListVideo());
        return "video";
    }

    @RequestMapping(params = "delete", method = RequestMethod.GET)
    public String delete(ModelMap model, HttpSession session,
        @PathParam("id") String id) {
        if (Objects.equals(videoService.delete(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Xóa video không thành công");
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, "Xóa thành công video");
        return initiate(model, session);
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(ModelMap model, HttpSession session,
            @ModelAttribute("video") VideoRequest video) {  
        if (Objects.equals(videoService.update(video), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Cập nhật không thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Cập nhật thành công");
        return initiate(model, session);

    }

    @RequestMapping(params = "changeStatus", method = RequestMethod.GET)
    public String lock(@RequestParam("id") String id,
            @RequestParam("status") Boolean status,
            ModelMap model, HttpSession session) {
        if (Objects.equals(videoService.updateStatus(id, status), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Thay đổi trạng thái không thành công");
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, "Thay đổi trạng thái thành công");
        return initiate(model, session);
    }

    @RequestMapping(params = "insert", method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @ModelAttribute("video") VideoRequest video) {
        if (Objects.equals(videoService.insert(video), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Thêm video không thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Thêm video thành công");
        return initiate(model, session);
    }
}
