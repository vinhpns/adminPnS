/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.News;
import com.poly.bean.NewsImage;
import com.poly.dao.NewsDAO;
import com.poly.dao.NewsImageDAO;
import com.poly.request.NewsRequestEntity;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SGDG Company
 */
@Service
public class NewsService {

    @Autowired
    NewsDAO ndao;

    @Autowired
    NewsImageDAO newsImageDAO;

    public List<News> getListNewsByType(int type) {
        return ndao.getAllNews(type);
    }

    public List<News> getNewsByMenuId(String id) {
        return ndao.getNewsByMenuId(id);
    }

    public Boolean insert(NewsRequestEntity news, int type, String userId, String menuId, String link) {
        News n = new News();
        UUID uuid = UUID.randomUUID();
        n.setId(uuid.toString());
        n.setTitle(news.getTitle());
        n.setMeta(news.getMeta());
        n.setContent(news.getContent());
        n.setType(type);
        n.setCreatedBy(userId);
        n.setUpdatedBy(userId);
        n.setDescription(news.getDescription());
        n.setTitleWeb(news.getTitleWeb());
        n.setMetaDescription(news.getMetaDescription());
        n.setMenuId(menuId);
        if (Objects.equals(ndao.insert(n), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        NewsImage newsImage = new NewsImage();
        newsImage.setNewsId(n.getId());
        newsImage.setCreatedBy(userId);
        newsImage.setUpdatedBy(userId);
        newsImage.setLink(link);
        if (Objects.equals(newsImageDAO.insert(newsImage), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
