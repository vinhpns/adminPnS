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
import static jdk.nashorn.internal.runtime.Debug.id;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
    MenuController menuController = new MenuController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {

        List<Menu> m = menuService.getFather();
        model.put("menuList", m);
        return "menu";

    }

    @RequestMapping(params = "getSubMenu")
    public String getSubMenu(ModelMap model, HttpSession session, @RequestParam("id") String id) {
        List<Menu> m = menuService.getSon();
        model.put("menuList", m);
        return "subMenu";
    }

    @RequestMapping()
    public String insert(ModelMap model, HttpSession Session,
            @RequestParam(MenuConstant.NAME_PARAM) String name,
            @RequestParam(MenuConstant.FATHER_ID_PARAM) int id) {
        if (Objects.equals(menuService.checkLogin(Session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPT_LOGIN);
            return menuController.initiate(model, Session);
        }
        if (Objects.equals(menuService.insertMenu(name, id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, MenuConstant.INSERT_MENU_FAIL);
            return menuController.initiate(model, Session);
        }
        model.put(ConstantManager.OK_POPUP, MenuConstant.INSERT_MENU_OK);
        return initiate(model, Session);
    }

    public String delete(ModelMap model, HttpSession session,
            @RequestParam(MenuConstant.ID_PARAM) int id) {
        if (Objects.equals(menuService.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return menuController.initiate(model, session);
        }
        if (Objects.equals(menuService.deleteMenu(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, MenuConstant.DELETE_MENU_FAIL);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, MenuConstant.DELETE_MENU_OK);
        return initiate(model, session);
    }
     public String update(ModelMap model, HttpSession session,
                         @RequestParam(MenuConstant.ID_PARAM) int id,
                         @RequestParam(MenuConstant.NAME_PARAM) String name,
                         @RequestParam(MenuConstant.FATHER_ID_PARAM) int fatherId) {
        if (Objects.equals(menuService.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return menuController.initiate(model, session);
        }
        Menu menu = menuService.getFather(id);
        if (menu.getName().equalsIgnoreCase(name) ) {
            model.put(ConstantManager.OK_POPUP, MenuConstant.UPDATE_MENU_OK);
            return initiate(model, session);
        }
        
        menu.setParentid(fatherId);
        menu.setName(name);
        
        model.put(ConstantManager.OK_POPUP, MenuConstant.UPDATE_MENU_OK);
        return initiate(model, session);
    }
}
