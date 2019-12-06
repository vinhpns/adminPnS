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
import com.poly.request.MenuRequest;
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

    public Menu getMenuByName(String name) {
        return mDAO.getMenuByName(name);
    }

    public Boolean insertMenu(MenuRequest m) {
        Boolean status = mDAO.insertMenu(m, UUID.randomUUID().toString());
        if (m.getParentId().equals("0")) {
            return status;
        }
        Menu menu = mDAO.getMenuById(m.getParentId());
        menu.setCount(menu.getCount() + 1);
        return !Objects.equals(mDAO.updateCount(menu), Boolean.FALSE);
    }

    public void deleteSon(String id, String parentId) {
        mDAO.deleteMenu(id);
        Menu menu = mDAO.getMenuById(parentId);
        menu.setCount(menu.getCount() - 1);
        mDAO.updateCount(menu);
    }

    public Boolean deleteMenu(String id) {
        Menu m = mDAO.getMenuById(id);
        Boolean status;
        if (!m.getParentId().equals("0")) {
            mDAO.deleteMenu(id);
            Menu menu = mDAO.getMenuById(m.getParentId());
            menu.setCount(menu.getCount() - 1);
            status = mDAO.updateCount(menu);
        } else {
            List<Menu> menu = mDAO.getSon(id);
            if (menu.size() > 0) {
                for (int i = 0; i < menu.size(); i++) {
                    deleteSon(menu.get(i).getId(), menu.get(i).getParentId());
                }
            }
            status = mDAO.deleteMenu(id);
        }
        return status;
    }

    public void deleteNewFollowMenu(String id) {
        List<News> n = ndao.getNewsByMenuId(id);
        if (n.size() > 0) {
            for (int i = 0; i < n.size(); i++) {
                ndao.updateTypeNews(n.get(i).getId());
            }
        }
    }

    public Boolean updateMenu(MenuRequest menu, int count) {
        Menu m = mDAO.getMenuById(menu.getId());
        m.setName(menu.getName());
        m.setParentId(menu.getParentId());
        m.setUpdatedBy(menu.getCreatedBy());
        m.setCount(count);
        return !Objects.equals(mDAO.updateMenu(m), Boolean.FALSE);
    }

    public Boolean updateStatus(String id, Boolean status) {
        Menu menu = new Menu();
        menu.setActive(status);
        menu.setId(id);
        return !Objects.equals(mDAO.updateStatus(menu), Boolean.FALSE);
    }

    public List<Menu> checkLastInsert() {
        return mDAO.getLastInsert();
    }
}
