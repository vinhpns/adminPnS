/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SGDG Company
 */
@Controller
@RequestMapping(value = "comment")
public class CommentController {
    
    @RequestMapping()
    public String initiate() {
        return "comment";
    }
}
