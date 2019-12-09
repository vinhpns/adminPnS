/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Banner;
import com.poly.constant.BannerConstant;
import com.poly.dao.BannerDAO;
import com.poly.request.BannerRequest;
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
public class BannerService {

    @Autowired
    private BannerDAO banDAO;

    public List<Banner> getListBanner() {
        return banDAO.getBanner();

    }

    public Boolean deleteBanner(String id) {
        return !Objects.equals(banDAO.delete(id), Boolean.FALSE);
    }

    public Boolean updateStatus(String id, Boolean status) {
        Banner banner = new Banner();
        banner.setActive(status);
        banner.setId(id);
        return !Objects.equals(banDAO.updateStatus(banner), Boolean.FALSE);
    }

    public Boolean insertBanner(BannerRequest ban, String imgName) {
        Banner banner = new Banner();
        banner.setCreatedBy(ban.getCreatedBy());
        banner.setId(UUID.randomUUID().toString());
        banner.setImg(BannerConstant.URL_SERVER + imgName);
        banner.setLink(ban.getLink());
        banner.setType(ban.getType());
        return !Objects.equals(banDAO.insert(banner), Boolean.FALSE);
    }

    public Boolean updateBanner(Banner ban) {
        return !Objects.equals(banDAO.update(ban), Boolean.FALSE);
    }
}
