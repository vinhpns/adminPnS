/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Menu;
import com.poly.dao.MenuDAO;
import com.poly.tool.ConstantManager;
import com.poly.tool.checkLogin;
import java.util.List;
import java.util.Objects;
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

    public Boolean checkLogin(HttpSession session) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return !Objects.equals(checkLogin(session), Boolean.FALSE);
    }

    public List<Menu> getFather() {
        return mDAO.getFather();
    }

    public List<Menu> getSon() {
        return mDAO.getSon();
    }
    public Boolean insertMenu(String name, int father){
        Menu menu = new Menu();
        menu.setActive(Boolean.TRUE);
        menu.setParentid(father);
        if(Objects.equals(mDAO.insertMenu(menu), Boolean.FALSE)){
            return Boolean.FALSE;
        }
        return null;
    }
     public Boolean deleteMenu(int id) {
        List<Menu> pList = mDAO.getFather();
        if (Objects.equals(pList, ConstantManager.NULL) || pList.isEmpty()) {
            mDAO.deleteMenu(id);
            return !Objects.equals(mDAO.deleteMenu(id), Boolean.FALSE);
        }
        return Boolean.FALSE;
    }
     public Boolean updateMenu(Menu menu) {
        return !Objects.equals(mDAO.updateMenu(menu), Boolean.FALSE);
    }
}
