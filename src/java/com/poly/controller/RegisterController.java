package com.poly.controller;

import com.poly.bean.Register;
import com.poly.constant.AccountConstant;
import com.poly.request.AccountRequestEntity;
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
@RequestMapping(value = "register")
public class RegisterController {

    @Autowired
    Register reSer;

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
//        List<Register> m = registerService.getFather();
//        model.put("registerList", m);
        return "register";
    }

    @RequestMapping(params = "getRegister")
    public String getRegister(ModelMap model, HttpSession session, @RequestParam("id") String id) {
//        List<Register> m = RegisterService.getSon(id);
//        model.put("Register", m);
//        model.put("RegisterName", RegisterService.getRegisterById(id).getName());
        return "Register";
    }    
}

