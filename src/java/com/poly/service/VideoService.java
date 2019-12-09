/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Video;
import com.poly.dao.VideoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class VideoService {
      @Autowired
    private VideoDAO vDAO;
public List<Video> getVideo(){
    return vDAO.getVideo();
}
   
}
