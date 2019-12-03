/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Comment;
import com.poly.service.CommentService;
import com.poly.tool.ConstantManager;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SGDG Company
 */
@Controller
@RequestMapping(value = "comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        List<Comment> list = commentService.getListComment();
        model.put("commentList", list);
        session.setAttribute("commentNotRead", commentService.countNotReply());
        return "comment";
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(ModelMap model, HttpSession session,
            @RequestParam("id") String id,
            @RequestParam("reply") String reply) {

        if (Objects.equals(commentService.updateReply(id, reply), Boolean.TRUE)) {
            model.put(ConstantManager.OK_POPUP, "Cập nhật thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.ERROR_POPUP, "Cập nhật không thành công");
        return initiate(model, session);
    }
}
