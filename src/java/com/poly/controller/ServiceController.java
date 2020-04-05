/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.request.ServiceRequest;
import com.poly.service.Ser;
import com.poly.tool.ConstantManager;
import com.poly.tool.checkLogin;
import java.text.DecimalFormat;
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
 * @author PnS
 */
@Controller
@RequestMapping("service")
public class ServiceController {

    @Autowired
    Ser s;
    AccountController ac = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            String errors = ConstantManager.NO_ACCEPTED_LOGIN;
            return ac.logout(session, model, errors);
        }
        model.put("right", "Dịch Vụ");
        model.put("listService", s.getListService((String) session.getAttribute(("companyId"))));
        return "list-service";
    }

    @RequestMapping(params = "status", method = RequestMethod.GET)
    public String updateStatus(ModelMap model, HttpSession session,
            @RequestParam("status") Boolean status,
            @RequestParam("id") String id) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            String errors = ConstantManager.NO_ACCEPTED_LOGIN;
            return ac.logout(session, model, errors);
        }
        if (Objects.equals(s.updateStatus(id, status,
                (String) session.getAttribute("accountId")), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Đổi trạng thái không thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Đổi trạng thái thành công");
        return initiate(model, session);
    }

    @RequestMapping(params = "delete", method = RequestMethod.GET)
    public String delete(ModelMap model, HttpSession session,
            @RequestParam("id") String id) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            String errors = ConstantManager.NO_ACCEPTED_LOGIN;
            return ac.logout(session, model, errors);
        }
        if (Objects.equals(s.delete(id,
                (String) session.getAttribute("accountId")), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Xóa không thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Xóa thành công");
        return initiate(model, session);
    }

    @RequestMapping(params = "edit", method = RequestMethod.GET)
    public String redirectEditPage(ModelMap model, HttpSession session,
            @RequestParam("id") String id) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            String errors = ConstantManager.NO_ACCEPTED_LOGIN;
            return ac.logout(session, model, errors);
        }
        model.put("right", "Dịch Vụ");
        model.put("service", s.getById(id));
        return "edit-service";
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(ModelMap model, HttpSession session,
            @ModelAttribute("service") ServiceRequest serviceRequest) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            String errors = ConstantManager.NO_ACCEPTED_LOGIN;
            return ac.logout(session, model, errors);
        }
        if (Objects.equals(s.updateInfo(serviceRequest), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Chỉnh sửa không thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Chỉnh sửa thành công");
        return initiate(model, session);
    }

    @RequestMapping(params = "insert", method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @ModelAttribute("service") ServiceRequest sr) {
        if (Objects.equals(checkLogin.checkLogin(session), Boolean.FALSE)) {
            String errors = ConstantManager.NO_ACCEPTED_LOGIN;
            return ac.logout(session, model, errors);
        }
        sr.setCompanyId((String) session.getAttribute("companyId"));
        sr.setCreatedBy((String) session.getAttribute("accountId"));
        if(sr.getIsMenu() == null){
            sr.setIsMenu(Boolean.FALSE);
        }else{
            sr.setIsMenu(Boolean.TRUE);
        }
        if (Objects.equals(s.insert(sr), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Thêm Dịch Vụ không thành công");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Thêm Dịch Vụ Thành Công");
        return initiate(model, session);
    }
}
