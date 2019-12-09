/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Comment;
import com.poly.dao.CommentDAO;
import java.util.List;
import java.util.Objects;
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
    
    public int countNotReply() {
        return commentDAO.countNotReply().size();
    }
    public Boolean updateReply(String id, String reply) {
        Comment c = new Comment();
        c.setReply(reply);
        c.setId(id);
        c.setIsReply(Boolean.TRUE);
        c.setActive(Boolean.TRUE);
        return !Objects.equals(commentDAO.updateReply(c), Boolean.FALSE);
    }
    public Boolean deleteComment(String id){
         return !Objects.equals(commentDAO.deleteComment(id), Boolean.FALSE);
    }
    public Boolean updateStatus(String id, Boolean status) {
        Comment ac = new Comment();
        ac.setActive(status);
        ac.setId(id);
        return !Objects.equals(commentDAO.updateStatus(ac), Boolean.FALSE);
    }
}
