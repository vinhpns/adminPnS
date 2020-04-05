/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.TypeImage;
import com.poly.service.TypeImageService;
import com.poly.tool.ConstantManager;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author 1
 */
@Controller
@RequestMapping("img")
public class TypeImageController {

    @Autowired
    TypeImageService typeImageService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session, @RequestParam("type") int type) {
        model.put("list", typeImageService.listByType(type));
        model.put("right", "Hình Ảnh");
        model.put("type", type);
        return "img-upload";
    }

    @RequestMapping(params = "upload", method = RequestMethod.POST)
    public String uploadImg(ModelMap model, HttpSession session, @ModelAttribute("img") TypeImage image) {
        if (Objects.equals(typeImageService.insert(image), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Thêm không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Thêm thành công");
        }
        return initiate(model, session, image.getType());
    }

    @RequestMapping(params = "updateStatus", method = RequestMethod.GET)
    public String updateStatus(ModelMap model, HttpSession session,
            @RequestParam("status") Boolean status,
            @RequestParam("type") int type,
            @RequestParam("id") int id) {
        if (Objects.equals(typeImageService.updateStatus(id, status), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Chỉnh sửa không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Chỉnh sửa thành công");
        }
        return initiate(model, session, type);
    }

    @RequestMapping(params = "delete", method = RequestMethod.GET)
    public String delete(ModelMap model, HttpSession session,
            @RequestParam("type") int type,
            @RequestParam("id") int id) {
        if (Objects.equals(typeImageService.delete(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Xóa không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Xóa thành công");
        }
        return initiate(model, session, type);
    }
}
