/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Comment;
import com.poly.dao.CommentDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SGDG Company
 */
@Service
public class CommentService {
    
    @Autowired
    CommentDAO commentDAO;
    
    public List<Comment> getListComment() {
        return commentDAO.getListComment();
    }
}
