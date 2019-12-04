/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Menu;
import com.poly.bean.News;
import com.poly.dao.MenuDAO;
import com.poly.dao.NewsDAO;
import com.poly.tool.ConstantManager;
import com.poly.tool.checkLogin;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class MenuService {

    @Autowired
    private MenuDAO mDAO;

    @Autowired
    private NewsDAO ndao;

    public Boolean checkLogin(HttpSession session) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return !Objects.equals(checkLogin(session), Boolean.FALSE);
    }

    public List<Menu> getFather() {
        return mDAO.getFather();
    }

    public List<Menu> getSon(String id) {
        return mDAO.getSon(id);
    }

    public Menu getMenuById(String id) {
        return mDAO.getMenuById(id);
    }
    public Menu getMenuByName(String name){
        return mDAO.getMenuByName(name);
    }

    public Boolean insertMenu(String name) {
        Menu menu = new Menu();
        UUID uuid = UUID.randomUUID();
        menu.setId(uuid.toString());
        menu.setParentId("0");
        menu.setName(name);
        if (Objects.equals(mDAO.insertMenu(menu), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean deleteMenu(String id) {
        Menu m = mDAO.getMenuById(id);
        if (m == null) {
            return Boolean.FALSE;
        }
        if (!m.getParentId().equals("0")) {
            deleteNewFollowMenu(id);
        } else {
            List<Menu> sub = mDAO.getSonOfFather(id);
            if (sub.size() > 0) {
                for (int i = 0; i < sub.size(); i++) {
                    deleteNewFollowMenu(sub.get(i).getId());
                }
            }
        }
        if (Objects.equals(mDAO.deleteMenu(id), Boolean.FALSE)) {
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

    public Boolean updateMenu(Menu menu) {
        return !Objects.equals(mDAO.updateMenu(menu), Boolean.FALSE);
    }

    public Boolean updateStatus(String id, Boolean status) {
        Menu menu = new Menu();
        menu.setActive(status);
        menu.setId(id);
        return !Objects.equals(mDAO.updateStatus(menu), Boolean.FALSE);
    }
}
