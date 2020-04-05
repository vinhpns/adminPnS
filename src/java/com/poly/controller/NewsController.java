/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.News;
import com.poly.request.NewsRequestEntity;
import com.poly.service.NewsService;
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
 * @author SGDG Company
 */
@Controller
@RequestMapping(value = "news")
public class NewsController {

    @Autowired
    NewsService newService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session, @RequestParam("type") int type) {
        model.put("newsList", newService.getAllListNews(type));
        model.put("type", type);
        return "news";
    }

    @RequestMapping(params = "insert", method = RequestMethod.GET)
    public String redirectInsertPage(ModelMap model, HttpSession session, @RequestParam("type") int type) {
        model.put("type", type);
        return "insert-news";
    }

    @RequestMapping(params = "viewById", method = RequestMethod.GET)
    public String viewByIdUser(ModelMap model, HttpSession session,
            @RequestParam("id") String id) {
        model.put("newsList", newService.getNewsById(id));
        return "update-news";
    }

    @RequestMapping(params = "insertNews", method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @ModelAttribute("ban") NewsRequestEntity n) {
        n.setSave(Boolean.FALSE);
        n.setCreatedBy((String) session.getAttribute("accountId"));
        n.setSave(Boolean.FALSE);
        if (Objects.equals(newService.insert(n), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Thêm tin mới không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Thêm tin mới thành công");
        }
        return initiate(model, session, n.getType());
    }

    @RequestMapping(params = "saveNews", method = RequestMethod.POST)
    public String save(ModelMap model, HttpSession session,
            @ModelAttribute("ban") NewsRequestEntity n) {
        n.setSave(Boolean.FALSE);
        n.setCreatedBy((String) session.getAttribute("accountId"));
        n.setSave(Boolean.TRUE);
        if (Objects.equals(newService.insert(n), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Thêm tin mới không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Thêm tin mới thành công");
        }
        return initiate(model, session, n.getType());
    }

    @RequestMapping(params = "delete", method = RequestMethod.GET)
    public String deleteNews(ModelMap model, HttpSession session,
            @RequestParam("id") String id) {
        News n = newService.getNewsById(id);
        if (Objects.equals(newService.deleteNews(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Xóa không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Xóa thành công");
        }
        return initiate(model, session, n.getType());
    }

    @RequestMapping(params = "changeStatus", method = RequestMethod.GET)
    public String updateStatus(ModelMap model, HttpSession session,
            @RequestParam("id") String id,
            @RequestParam("status") Boolean status) {
        News n = newService.getNewsById(id);
        if (Objects.equals(newService.updateStatus(id, status), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Đổi trạng thái không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Đổi trạng thái thành công");
        }
        return initiate(model, session, n.getType());
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String updateInfo(ModelMap model, HttpSession session,
            @ModelAttribute("news") NewsRequestEntity n) {
        n.setCreatedBy((String) session.getAttribute("accountId"));
        n.setSave(Boolean.FALSE);
        if (Objects.equals(newService.update(n), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Cập Nhật không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Cập Nhật thành công");
        }
        return initiate(model, session, n.getType());
    }

    @RequestMapping(params = "save", method = RequestMethod.POST)
    public String saveInfo(ModelMap model, HttpSession session, @ModelAttribute("news") NewsRequestEntity n) {
        n.setCreatedBy((String) session.getAttribute("accountId"));
        n.setSave(Boolean.TRUE);
        if (Objects.equals(newService.update(n), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Cập Nhật không thành công");
        } else {
            model.put(ConstantManager.OK_POPUP, "Cập Nhật thành công");
        }
        return initiate(model, session, n.getType());
    }
}
