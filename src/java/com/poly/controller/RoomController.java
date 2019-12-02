/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Room;
import com.poly.constant.RoomConstant;
import com.poly.service.RoomService;
import com.poly.tool.ConstantManager;
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
 * @author phong
 */
@Controller
@RequestMapping(value = "room")
public class RoomController {

    @Autowired
    RoomService rSer;

    AccountController accController = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        if (rSer.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.addAttribute("rooms", rSer.getListRoom());
        return "room";
    }

    @RequestMapping(params = ConstantManager.DELETE_FUNCTION, method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer id, ModelMap model, HttpSession session) {
        if (rSer.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(rSer.deleteRoom(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, RoomConstant.DELETE_FAIL);
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, RoomConstant.DELETE_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.INSERT_FUNCTION, method = RequestMethod.POST)
    public String insertRoom(@ModelAttribute("room") Room room, ModelMap model, HttpSession session) {
        if (rSer.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(rSer.insertRoom(room), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, RoomConstant.INSERT_FAIL);
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, RoomConstant.INSERT_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.UPDATE_FUNCTION, method = RequestMethod.POST)
    public String updateRoom(@ModelAttribute("room") Room room, ModelMap model, HttpSession session) {
        if (rSer.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(rSer.updateRoom(room), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, RoomConstant.UPDATE_FAIL);
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, RoomConstant.UPDATE_OK);
        return initiate(model, session);
    }
}
