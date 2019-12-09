/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Video;
import com.poly.dao.VideoDAO;
import com.poly.request.VideoRequest;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
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

    public List<Video> getListVideo() {
        return vDAO.getListVideo();
    }

    public Boolean delete(String id) {
        return !Objects.equals(vDAO.delete(id), Boolean.FALSE);
    }

    public Boolean insert(VideoRequest video) {
        Video vi = new Video();
        vi.setId(UUID.randomUUID().toString());
        vi.setLink(video.getLink());
        vi.setTitle(video.getTitle());
        if (Objects.equals(vDAO.insert(vi), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean update(VideoRequest video) {
        Video vi = vDAO.getById(video.getId());
        vi.setLink(video.getLink());
        vi.setTitle(video.getTitle());
        return !Objects.equals(vDAO.update(vi), Boolean.FALSE);
    }

    public Boolean updateStatus(String id, Boolean status) {
        Video vi = new Video();
        vi.setActive(status);
        vi.setId(id);
        return !Objects.equals(vDAO.updateStatus(vi), Boolean.FALSE);
    }

    public List<Video> checkLastInsert() {
        return vDAO.getLastInsert();
    }
}
