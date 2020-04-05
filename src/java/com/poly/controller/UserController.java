package com.poly.controller;

import com.poly.constant.AccountConstant;
import com.poly.request.AccountPassword;
import com.poly.request.AccountRequestEntity;
import com.poly.response.AccountResponse;
import com.poly.service.AccountService;
import com.poly.tool.ConstantManager;
import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = ConstantManager.USER_PAGE)
public class UserController {

    @Autowired
    AccountService accSer;

    AccountController accController = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session, @ModelAttribute("type") int type) {
        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.put("right", "Tài khoản");
        model.put("listRole", accSer.initListRole());
        model.put("listUser", accSer.getListAccount((String) session.getAttribute("companyId"), type));
        model.put("type", type);
        model.put("link", "ListUser.htm?type=" + type);
        return "ListUser";
    }

    @RequestMapping(params = "insert", method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @ModelAttribute("account") AccountRequestEntity ac) {
        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        int type = 1;
        if(ac.getRole() == 1){
            type = 2;
        }
        if (!Objects.equals(accSer.getAccountLogin(ac.getEmail()), null)) {
            model.put(ConstantManager.ERROR_POPUP, "Tài khoản đã có trong hệ thống");
            return initiate(model, session, type);
        }
        ac.setCreatedBy((String) session.getAttribute("accountId"));
        ac.setCompanyId((String) session.getAttribute("companyId"));
        if (Objects.equals(accSer.insertAccount(ac), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Thêm tài khoản không thành công");
            return initiate(model, session, type);
        }
        model.put(ConstantManager.OK_POPUP, "Thêm tài khoản thành công");
        return initiate(model, session, type);
    }
    
    @RequestMapping(params = "changeStatus")
    public String updateStatus(ModelMap model, HttpSession session,
            @RequestParam("id") String id,
            @RequestParam("status") Boolean status,
            @RequestParam("type") int type) {
        if (Objects.equals(accSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (id.equals((String) session.getAttribute(("accountId")))) {
            model.put(ConstantManager.ERROR_POPUP, "Bạn không thể khóa chính bạn");
            return initiate(model, session, type);
        }
        if (Objects.equals(accSer.updateStatus(id, status), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Đổi trạng thái không thành công");
            return initiate(model, session, type);
        }
        model.put(ConstantManager.OK_POPUP, "Đổi trạng thái thành công");
        return initiate(model, session, type);
    }

    @RequestMapping(params = "delete", method = RequestMethod.GET)
    public String delete(ModelMap model, HttpSession session,
            @RequestParam("id") String id,
            @RequestParam("type") int type) {
        if (Objects.equals(accSer.delete(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Xóa không thành công");
            return initiate(model, session, type);
        }
        model.put(ConstantManager.OK_POPUP, "Xóa tài khoản thành công");
        return initiate(model, session, type);
    }

    @RequestMapping(params = "updatePassword", method = RequestMethod.POST)
    public String updatePassword(ModelMap model, HttpSession session,
            @ModelAttribute("account") AccountPassword ap) {
        PasswordEncoder pw = new BCryptPasswordEncoder();
        if (pw.matches(ap.getNewPassword(), ap.getOldPassword())) {
            model.put(ConstantManager.ERROR_POPUP, "Mật khẩu mới không được trùng mật khẩu cũ");
            return initiate(model, session, ap.getType());
        }
        if (Objects.equals(accSer.updatePass(ap), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Đổi mật khẩu không thành công");
            return initiate(model, session, ap.getType());
        }
        model.put(ConstantManager.OK_POPUP, "Đổi mật khẩu thành công");
        return initiate(model, session, ap.getType());
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(HttpSession session, ModelMap model,
            @ModelAttribute("account") AccountRequestEntity accountRequestEntity) {
        accountRequestEntity.setCreatedBy((String) session.getAttribute("accountId"));
        AccountResponse account = accSer.getAccountById(accountRequestEntity.getId());
        int type = 1;
        if(accountRequestEntity.getRole() == 1){
            type = 2;
        }
        if (account.getEmail().equals(accountRequestEntity.getEmail())
                && !account.getId().equals(accountRequestEntity.getId())) {
            model.put(ConstantManager.ERROR_POPUP, "Email vừa nhập đã tồn tại trong hệ thống!");
            return initiate(model, session, type);
        }
        if (Objects.equals(accSer.updateInfo(accountRequestEntity), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Update tài khoản không thành công");
            return initiate(model, session, type);
        }
        model.put(ConstantManager.OK_POPUP, "Cập nhật thành công");
        return initiate(model, session, type);
    }
}
