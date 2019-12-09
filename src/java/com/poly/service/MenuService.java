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
    private NewsService newsService;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleAdmin(role) == true
                || checkLogin.checkLoginRoleSuperAdmin(role));
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
        try {
            Menu last = mDAO.getLastPosition();
            m.setId(UUID.randomUUID().toString());
            m.setPosition(last.getPosition() + 1);
            mDAO.insertMenu(m);
            if (!m.getParentId().equals("0")) {
                updateCountAdd(m.getParentId());
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public void changePostion(MenuRequest m, int oldPosition) {
        Menu menu = mDAO.findMenuByPosition(m.getPosition());
        if (menu != null && !m.getId().equals(menu.getId())) {
            menu.setPosition(oldPosition);
            mDAO.updatePosition(menu);
        }
    }

    public void deleteSon(String id, String parentId) {
        mDAO.deleteMenu(id);
        updateCountSub(parentId);
    }

    public Boolean deleteMenu(String id) {
        try {
            Menu m = mDAO.getMenuById(id);
            if (!m.getParentId().equals("0")) {
                updateCountSub(m.getParentId());
            } else {
                List<Menu> menu = mDAO.getSon(id);
                if (menu.size() > 0) {
                    for (int i = 0; i < menu.size(); i++) {
                        deleteSon(menu.get(i).getId(), menu.get(i).getParentId());
                        newsService.deleteNewFollowMenu(menu.get(i).getParentId());
                    }
                }
            }
            newsService.deleteNewFollowMenu(id);
            mDAO.deleteMenu(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateMenu(MenuRequest menu) {
        try {
            Menu m = mDAO.getMenuById(menu.getId());
            m.setName(menu.getName());
            m.setParentId(menu.getParentId());
            m.setUpdatedBy(menu.getCreatedBy());
            m.setCount(menu.getCount());
            if (menu.getParentId().equals("0") && menu.getPosition() != m.getPosition()) {
                changePostion(menu, m.getPosition());
            }
            if (!menu.getParentId().equals(m.getParentId()) && !m.getParentId().equals("0")) {
                updateCountSub(m.getParentId());
                updateCountAdd(menu.getParentId());
            }
            m.setPosition(menu.getPosition());
            mDAO.updateMenu(m);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateCountSub(String parentId) {
        Menu m = mDAO.getMenuById(parentId);
        m.setCount(m.getCount() - 1);
        return !Objects.equals(mDAO.updateCount(m), Boolean.FALSE);
    }

    public Boolean updateCountAdd(String parentId) {
        Menu m = mDAO.getMenuById(parentId);
        m.setCount(m.getCount() + 1);
        return !Objects.equals(mDAO.updateCount(m), Boolean.FALSE);
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
