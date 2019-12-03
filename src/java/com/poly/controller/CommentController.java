/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Comment;
import com.poly.service.CommentService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
