/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Menu;
import com.poly.constant.MenuConstant;
import com.poly.request.MenuRequest;
import com.poly.service.MenuService;
import com.poly.tool.ConstantManager;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.put("menuFatherId", id);
        return "subMenu";
    }

    @RequestMapping(params = "insert", method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @ModelAttribute("menu") MenuRequest menuRequest) {
        List<Menu> m = menuService.checkLastInsert();
        if (m.get(0).getName().equals(menuRequest.getName()) && m.get(0).getParentId().equals(menuRequest.getParentId())) {
            if (menuRequest.getUrl() == null) {
                return getSubMenu(model, session, menuRequest.getParentId());
            }
            return initiate(model, session);
        }
        menuRequest.setCreatedBy((String) (session.getAttribute("accountId")));
        if (Objects.equals(menuService.insertMenu(menuRequest), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, MenuConstant.INSERT_MENU_FAIL);
        } else {
            model.put(ConstantManager.OK_POPUP, MenuConstant.INSERT_MENU_OK);
        }
        if (menuRequest.getUrl() == null) {
            return getSubMenu(model, session, menuRequest.getParentId());
        }
        return initiate(model, session);
    }

    @RequestMapping(params = "delete", method = RequestMethod.GET)
    public String delete(ModelMap model, HttpSession session,
            @RequestParam(MenuConstant.ID_PARAM) String id) {
        if (Objects.equals(menuService.deleteMenu(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, MenuConstant.DELETE_MENU_FAIL);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, MenuConstant.DELETE_MENU_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = "edit", method = RequestMethod.POST)
    public String update(ModelMap model, HttpSession session,
            @RequestParam(MenuConstant.ID_PARAM) String id,
            @RequestParam(MenuConstant.NAME_PARAM) String name,
            @RequestParam(MenuConstant.FATHER_ID_PARAM) int fatherId) {

        Menu menu = menuService.getMenuByName(name);
        if (menu == null) {
            Objects.equals(menuService.updateMenu(menu), Boolean.FALSE);
            model.put(ConstantManager.OK_POPUP, MenuConstant.UPDATE_MENU_OK);
            return initiate(model, session);
        }
        if (menu.getName().equals(name) && menu.getId().equals(id)) {
            Objects.equals(menuService.updateMenu(menu), Boolean.TRUE);
            model.put(ConstantManager.OK_POPUP, MenuConstant.UPDATE_MENU_OK);
            return initiate(model, session);
        }
        if (menu.getName().equals(name) && !menu.getId().equals(id)) {
            Objects.equals(menuService.updateMenu(menu), Boolean.FALSE);
            model.put(ConstantManager.ERROR_POPUP, "Đã tồn tại Menu trong hệ thống");
            return initiate(model, session);
        }

        model.put(ConstantManager.ERROR_POPUP, MenuConstant.UPDATE_MENU_FAIL);
        return initiate(model, session);
    }

    @RequestMapping(params = "changeStatus", method = RequestMethod.GET)
    public String lock(@RequestParam(MenuConstant.ID_PARAM) String id,
            @RequestParam(MenuConstant.STATUS_PARAM) Boolean status,
            ModelMap model, HttpSession session) {
        if (Objects.equals(menuService.updateStatus(id, status), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Thay đổi trạng thái không thành công");
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, "Thay đổi trạng thái thành công");
        return initiate(model, session);
    }
}
