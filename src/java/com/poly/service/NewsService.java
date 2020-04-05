/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.News;
import com.poly.bean.NewsImage;
import com.poly.bean.Url;
import com.poly.constant.NewsConstant;
import com.poly.dao.NewsDAO;
import com.poly.request.NewsRequestEntity;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SGDG Company
 */
@Service
public class NewsService {
    
    @Autowired
    NewsDAO ndao;
    
    @Autowired
    NewsImageService newsImageService;
    
    @Autowired
    AccountService accountService;
    
    public List<News> getAllListNews(int type) {
        return ndao.listNews(type);
    }
    
    public News getNewsById(String id) {
        News n = ndao.getNewsById(id);
        return n;
    }
    
    public News initiateNews(NewsRequestEntity news) {
        News n = new News();
        n.setId(news.getId());
        n.setTitle(news.getTitle());
        n.setMeta(news.getMeta());
        n.setContent(news.getContent());
        n.setType(news.getType());
        n.setCreatedBy(news.getCreatedBy());
        n.setUpdatedBy(news.getCreatedBy());
        n.setDescription(news.getDescription());
        n.setTitleWeb(news.getTitleWeb());
        n.setComapnyId(ConstantManager.COMPANY_ID);
        n.setAvatar(news.getLink());
        n.setMetaDescription(news.getMetaDescription());
        if (news.getUrl().equals("")) {
            n.setUrl(Utils.createUrl(news.getTitle()));
        } else {
            n.setUrl(news.getUrl());
        }
        n.setSave(news.getSave());
        return n;
    }
    
    public Boolean uploadImg(String names, MultipartFile files) {
        try {
            List<String> listNames = new ArrayList<>();
            List<MultipartFile> listFiles = new ArrayList<>();
            listNames.add(names);
            listFiles.add(files);
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, NewsConstant.URL_STORE_SERVER);
            if (checkUploadImg == false) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
    
    public Boolean insert(NewsRequestEntity news) {
        try {
            if (news.getAvatar().isEmpty()) {
                news.setLink("https://previews.123rf.com/images/varijanta/varijanta1602/"
                        + "varijanta160200058/52885027-thin-line-flat-design-for-news-web-page-"
                        + "information-on-events-activities-recent-company-information-.jpg");
            } else {
                String imgName = Utils.randomCodeImg() + news.getAvatar().getOriginalFilename();
                uploadImg(imgName, news.getAvatar());
                news.setLink(NewsConstant.URL_SERVER + imgName);
            }
            news.setId(UUID.randomUUID().toString());
            News n = initiateNews(news);
            Url u = new Url();
            u.setUrlName(n.getUrl());
            u.setType(1);
            ndao.insertNews(n);
//            newsImageService.insertNewsImage(newsImageService.initiate(news));
//            accountService.updatePost(news.getCreatedBy(), 1);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
    
    public Boolean update(NewsRequestEntity news) {
        try {
            News newsFirst = ndao.getNewsById(news.getId());
            if (news.getAvatar().isEmpty()) {
                news.setLink(newsFirst.getAvatar());
            } else {
                String imgName = Utils.randomCodeImg() + news.getAvatar().getOriginalFilename();
                uploadImg(imgName, news.getAvatar());
                news.setLink(NewsConstant.URL_SERVER + imgName);
            }
            ndao.updateNews(news);
//            accountService.updatePost(news.getCreatedBy(), 1);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
    
    public Boolean updateStatus(String id, Boolean status) {
        News news = new News();
        news.setActive(status);
        news.setId(id);
        return !Objects.equals(ndao.updateStatusNews(news), Boolean.FALSE);
    }
    
    public Boolean deleteNews(String id) {
        try {
//            News n = ndao.getNewsById(id);
//            Url u = urlService.getById(id);
//            urlService.deleteUrl(ndao.getNewsById(id).getUrl());
            newsImageService.deleteNewsImage(id);
            ndao.deleteNews(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
