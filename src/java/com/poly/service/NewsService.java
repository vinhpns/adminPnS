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

    public Boolean insert(NewsRequestEntity news) {
        News n = new News();
        String id = UUID.randomUUID().toString();
        n.setId(id);
        n.setTitle(news.getTitle());
        n.setMeta(news.getMeta());
        n.setContent(news.getContent());
        n.setType(news.getType());
        n.setCreatedBy(news.getCreatedBy());
        n.setDescription(news.getDescription());
        n.setTitleWeb(news.getTitleWeb());
        n.setMetaDescription(news.getMetaDescription());
        n.setMenuId(news.getMenuId());
        n.setVip(news.getVip());
        n.setRegisterForm(news.getRegisterForm());
        if (Objects.equals(ndao.insert(n), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        NewsImage newsImage = new NewsImage();
        newsImage.setNewsId(id);
        newsImage.setCreatedBy(news.getCreatedBy());
        newsImage.setLink(news.getLink());
        if (Objects.equals(newsImageDAO.insert(newsImage), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void deleteNewFollowMenu(String id) {
        List<News> n = ndao.getNewsByMenuId(id);
        if (n.size() > 0) {
            for (int i = 0; i < n.size(); i++) {
                ndao.updateTypeNews(n.get(i).getId());
            }
        }
    }
    public List<News> getAllByMenuId(){
        return ndao.getAllByMenuId();
    }
    public List<News> getCreatBy(){
        return ndao.getCreatBy();
    }
}
