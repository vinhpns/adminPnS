/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.News;
import com.poly.dao.NewsDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SGDG Company
 */
@Service
public class NewService {

    @Autowired
    NewsDAO ndao;

    public List<News> getListNewsByType(int type) {
        return ndao.getAllNews(type);
    }
}
