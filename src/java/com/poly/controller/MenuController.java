/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Menu;
import com.poly.constant.MenuConstant;
import com.poly.service.MenuService;
import com.poly.tool.ConstantManager;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SGDG Company
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        List<Menu> m = menuService.getFather();
        model.put("menuList", m);
        return "menu";
    }

    @RequestMapping(params = "getSubMenu")
    public String getSubMenu(ModelMap model, HttpSession session, @RequestParam("id") String id) {
        List<Menu> m = menuService.getSon(id);
        model.put("subMenu", m);
        model.put("menuName", menuService.getMenuById(id).getName());
        return "subMenu";
    }

    @RequestMapping(params = "insert", method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession Session,
            @RequestParam("name") String name) {

        if (Objects.equals(menuService.insertMenu(name), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, MenuConstant.INSERT_MENU_FAIL);
            return initiate(model, Session);
        }
        model.put(ConstantManager.OK_POPUP, MenuConstant.INSERT_MENU_OK);
        return initiate(model, Session);
    }

    public String delete(ModelMap model, HttpSession session,
            @RequestParam(MenuConstant.ID_PARAM) int id) {

        if (Objects.equals(menuService.deleteMenu(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, MenuConstant.DELETE_MENU_FAIL);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, MenuConstant.DELETE_MENU_OK);
        return initiate(model, session);
    }
     public String update(ModelMap model, HttpSession session,
                         @RequestParam(MenuConstant.ID_PARAM) String id,
                         @RequestParam(MenuConstant.NAME_PARAM) String name,
                         @RequestParam(MenuConstant.FATHER_ID_PARAM) int fatherId) {
       
        Menu menu = menuService.getMenuById(id);
        if (menu.getName().equalsIgnoreCase(name) ) {
            model.put(ConstantManager.OK_POPUP, MenuConstant.UPDATE_MENU_OK);
            return initiate(model, session);
        }
        
        menu.setParentId(name);
        menu.setName(name);
        
        model.put(ConstantManager.OK_POPUP, MenuConstant.UPDATE_MENU_OK);
        return initiate(model, session);
    }

    public String lock(@RequestParam(MenuConstant.ID_PARAM) String id,
            @RequestParam(MenuConstant.STATUS_PARAM) Boolean status,
            ModelMap model, HttpSession session) {
        if (Objects.equals(status, Boolean.TRUE)) {
            menuService.lockMenu(id);
            model.addAttribute(ConstantManager.OK_POPUP, MenuConstant.LOCK_MENU_CLOSE);
        } else {
            menuService.unLockMenu(id);
        }
        model.addAttribute(ConstantManager.OK_POPUP, MenuConstant.LOCK_MENU_OPEN);
        return initiate(model, session);
    }
}
