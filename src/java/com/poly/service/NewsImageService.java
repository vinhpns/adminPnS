/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.NewsImage;
import com.poly.dao.NewsImageDAO;
import com.poly.request.NewsRequestEntity;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 1
 */
@Service
public class NewsImageService {

    @Autowired
    NewsImageDAO newsImageDAO;

    public NewsImage initiate(NewsRequestEntity n) {
        NewsImage newsImage = new NewsImage();
        newsImage.setNewsId(n.getId());
        newsImage.setCreatedBy(n.getCreatedBy());
        newsImage.setLink(n.getLink());
        newsImage.setUpdatedBy(n.getCreatedBy());
        return newsImage;
    }

    public Boolean insertNewsImage(NewsImage n) {
        return !Objects.equals(newsImageDAO.insert(n), Boolean.FALSE);
    }

    public Boolean deleteNewsImage(String id) {
        return !Objects.equals(newsImageDAO.delete(id), Boolean.FALSE);
    }

    public NewsImage findById(String newsId) {
        return newsImageDAO.findById(newsId);
    }

    public Boolean updateNewsImg(NewsImage n) {
        return newsImageDAO.update(n);
    }
}
