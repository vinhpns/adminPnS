/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Video;
import com.poly.request.VideoRequest;
import com.poly.service.VideoService;
import com.poly.tool.ConstantManager;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.runtime.Debug.id;
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
public class VideoController {
    @Autowired
    VideoService videoService;
    @RequestMapping()
     public String initiate(ModelMap model, HttpSession session) {
          List<Video> h = videoService.getVideo();
         model.put("videoList", h);
        return initiate(model, session);
     }
      @RequestMapping(params = "delete", method = RequestMethod.GET)
     public String delete(ModelMap model, HttpSession session,
            @RequestParam("id") String id) {
         if (Objects.equals(videoService.delete(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Xóa video không thành công");
            return initiate(model, session);
        }
          model.addAttribute(ConstantManager.OK_POPUP, "Xóa thành công video");
        return initiate(model, session);
     }
     public String update(ModelMap model, HttpSession session,
            @ModelAttribute("video") VideoRequest video,
            @RequestParam("id") String id){
       video.setLink((String) session.getAttribute("accountId"));
        if(Objects.equals(videoService.update(video, id), Boolean.FALSE)){
            model.put(ConstantManager.ERROR_POPUP, "Cập nhật không thành công");
            return initiate(model, session);
        }     
        model.put(ConstantManager.OK_POPUP,"Cập nhật thành công");
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
}
