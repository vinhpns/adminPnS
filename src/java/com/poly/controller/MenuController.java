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

    @RequestMapping(params = "insertMenu", method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @ModelAttribute("menu") MenuRequest menuRequest) {
        List<Menu> m = menuService.checkLastInsert();
        if (m.get(0).getName().equals(menuRequest.getName()) && m.get(0).getParentId().equals(menuRequest.getParentId())) {
            return initiate(model, session);
        }
        menuRequest.setCreatedBy((String) (session.getAttribute("accountId")));
        if (Objects.equals(menuService.insertMenu(menuRequest), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, MenuConstant.INSERT_MENU_FAIL);
        } else {
            model.put(ConstantManager.OK_POPUP, MenuConstant.INSERT_MENU_OK);
        }
        return initiate(model, session);
    }

    @RequestMapping(params = "insertSubMenu", method = RequestMethod.POST)
    public String insertSub(ModelMap model, HttpSession session,
            @ModelAttribute("menu") MenuRequest menuRequest) {
        List<Menu> m = menuService.checkLastInsert();
        if (m.get(0).getName().equals(menuRequest.getName()) && m.get(0).getParentId().equals(menuRequest.getParentId())) {
            return getSubMenu(model, session, menuRequest.getParentId());
        }
        menuRequest.setCreatedBy((String) (session.getAttribute("accountId")));
        if (Objects.equals(menuService.insertMenu(menuRequest), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, MenuConstant.INSERT_MENU_FAIL);
        } else {
            model.put(ConstantManager.OK_POPUP, MenuConstant.INSERT_MENU_OK);
        }
        return getSubMenu(model, session, menuRequest.getParentId());
    }

    @RequestMapping(params = "deleteMenu", method = RequestMethod.GET)
    public String delete(ModelMap model, HttpSession session,
            @RequestParam(MenuConstant.ID_PARAM) String id) {
        if (Objects.equals(menuService.deleteMenu(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, MenuConstant.DELETE_MENU_FAIL);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, MenuConstant.DELETE_MENU_OK);
        return initiate(model, session);
    }
    
    @RequestMapping(params = "deleteSubMenu", method = RequestMethod.GET)
    public String deleteSub(ModelMap model, HttpSession session,
            @RequestParam(MenuConstant.ID_PARAM) String id) {
        Menu m = menuService.getMenuById(id);
        String fatherId = m.getParentId();
        if (Objects.equals(menuService.deleteMenu(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, MenuConstant.DELETE_MENU_FAIL);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, MenuConstant.DELETE_MENU_OK);
        return getSubMenu(model, session, fatherId);
    }

    @RequestMapping(params = "updateMenu", method = RequestMethod.POST)
    public String updateMenu(ModelMap model, HttpSession session,
            @ModelAttribute("menu") MenuRequest menu) {
        
        model.put(ConstantManager.ERROR_POPUP, MenuConstant.UPDATE_MENU_FAIL);
        return initiate(model, session);
    }
    
    @RequestMapping(params = "updateSubMenu", method = RequestMethod.POST)
    public String updateSubMenu(ModelMap model, HttpSession session,
            @ModelAttribute("sub") MenuRequest menu) {

        menu.setCreatedBy((String) session.getAttribute("accountId"));
        if(Objects.equals(menuService.updateMenu(menu), Boolean.FALSE)){
            model.put(ConstantManager.ERROR_POPUP, "Update không thành công");
            return getSubMenu(model, session, menu.getParentId());
        }
        model.put(ConstantManager.ERROR_POPUP, MenuConstant.UPDATE_MENU_FAIL);
        return getSubMenu(model, session, menu.getParentId());
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
