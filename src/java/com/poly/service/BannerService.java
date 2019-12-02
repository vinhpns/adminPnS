/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Banner;
import com.poly.bean.TypeBanner;
import com.poly.constant.BannerConstant;
import com.poly.dao.BannerDAO;
import com.poly.tool.ConstantManager;
import com.poly.tool.checkLogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vinh
 */
@Service
public class BannerService {

    @Autowired
    private BannerDAO banDAO;

    public Boolean checkLogin(HttpSession session) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return !Objects.equals(checkLoginRole(session), Boolean.FALSE);
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute(ConstantManager.ROLEID)));
        return (Objects.equals(checkLogin.checkLoginRoleWriter(role), Boolean.TRUE)
                || Objects.equals(checkLogin.checkLoginRoleMod(role), Boolean.TRUE)
                || Objects.equals(checkLogin.checkLoginRoleAdmin(role), Boolean.TRUE));
    }

    public List<Banner> getListBanner(int type) {
        return banDAO.getAllBanner(type);
    }

    public Boolean deleteBanner(int id) {
        return !Objects.equals(banDAO.delete(id), Boolean.FALSE);
    }

    public Boolean changeActiveBanner(int id, Boolean active) {
        return !Objects.equals(banDAO.changeActive(id, active), Boolean.FALSE);
    }

    public Banner getBannerById(int id) {
        Banner banner = banDAO.getById(id);
        if (banner != ConstantManager.NULL) {
            return banner;
        }
        return null;
    }

    public Boolean insertBanner(Banner ban) {
        return !Objects.equals(banDAO.insert(ban), Boolean.FALSE);
    }

    public Boolean updateBanner(Banner ban) {
        return !Objects.equals(banDAO.update(ban), Boolean.FALSE);
    }
    
    public List<TypeBanner> initiateTypeContent() {
        ArrayList<TypeBanner> listTypeBanner = new ArrayList<>();
        TypeBanner tBanner = new TypeBanner(BannerConstant.LOGO_WEB, "Logo Web");
        TypeBanner tBanner1 = new TypeBanner(BannerConstant.BANNER_BIG_INTRODUCE, BannerConstant.BANNER_BIG_INTRODUCE_TITLE);
        TypeBanner tBanner2 = new TypeBanner(BannerConstant.BANNER_SUB_INTRODUCE, BannerConstant.BANNER_SUB_INTRODUCE_TITLE);
        TypeBanner tBanner3 = new TypeBanner(BannerConstant.HISTORY_INTRODUCE, BannerConstant.HISTORY_INTRODUCE_TITLE);
        TypeBanner tBanner4 = new TypeBanner(BannerConstant.STUCTURE_INTRODUCE, BannerConstant.STUCTURE_INTRODUCE_TITLE);
        TypeBanner tBanner5 = new TypeBanner(BannerConstant.PARTNER_INTRODUCE, BannerConstant.PARTNER_INTRODUCE_TITLE);
        TypeBanner tBanner6 = new TypeBanner(BannerConstant.ACTIVE_INTRODUCE, BannerConstant.ACTIVE_INTRODUCE_TITLE);
        TypeBanner tBanner7 = new TypeBanner(BannerConstant.RULE_INTRODUCE, BannerConstant.RULE_INTRODUCE_TITLE);
        TypeBanner tBanner8 = new TypeBanner(BannerConstant.PROCESS, BannerConstant.PROCESS_TITLE);
        TypeBanner tBanner9 = new TypeBanner(BannerConstant.BANNER_BIG_HELP, BannerConstant.BANNER_BIG_HELP_TITLE);
        TypeBanner tBanner10 = new TypeBanner(BannerConstant.BANNER_SUB_HELP, BannerConstant.BANNER_SUB_HELP_TITLE);
        
        listTypeBanner.add(tBanner);
        listTypeBanner.add(tBanner1);
        listTypeBanner.add(tBanner2);
        listTypeBanner.add(tBanner3);
        listTypeBanner.add(tBanner4);
        listTypeBanner.add(tBanner5);
        listTypeBanner.add(tBanner6);
        listTypeBanner.add(tBanner7);
        listTypeBanner.add(tBanner8);
        listTypeBanner.add(tBanner9);
        listTypeBanner.add(tBanner10);
        return listTypeBanner;
    }

    public List<TypeBanner> initiateTypeBanner() {
        ArrayList<TypeBanner> listTypeBanner = new ArrayList<>();
        TypeBanner tBanner = new TypeBanner(BannerConstant.TYPE_BANNER_MAIN_HOME_ID, BannerConstant.TYPE_BANNER_MAIN_HOME);
        TypeBanner tBanner1 = new TypeBanner(BannerConstant.TYPE_BANNER_SUBMAIN_HOME_ID, BannerConstant.TYPE_BANNER_SUBMAIN_HOME);
        TypeBanner tBanner2 = new TypeBanner(BannerConstant.TYPE_BANNER_LEFT_HOME_ID, BannerConstant.TYPE_BANNER_LEFT_HOME);
        TypeBanner tBanner3 = new TypeBanner(BannerConstant.TYPE_BANNER_LAST_HOME_ID, BannerConstant.TYPE_BANNER_LAST_HOME);
        listTypeBanner.add(tBanner);
        listTypeBanner.add(tBanner1);
        listTypeBanner.add(tBanner2);
        listTypeBanner.add(tBanner3);
        return listTypeBanner;
    }
}
