package com.poly.controller;

import com.poly.bean.Brand;
import com.poly.constant.BrandConstant;
import com.poly.service.BrandService;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;
import com.poly.tool.checkLogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = BrandConstant.BRAND_PAGE)
public class BrandController {

    @Autowired
    BrandService brSer;

    AccountController accController = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        if (Objects.equals(brSer.checkLogin(session), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.addAttribute(BrandConstant.LIST_BRAND_KEY, brSer.getListBrand(1));
        return BrandConstant.BRAND_RETURN_PAGE;
    }

    @RequestMapping(params = "deleted", method = RequestMethod.GET)
    public String getListDelete(ModelMap model, HttpSession session) {
        if (!Objects.equals(checkLogin.checkLoginRoleSuperAdmin(Integer.parseInt(String.valueOf(session.getAttribute(ConstantManager.ROLEID)))), Boolean.TRUE)) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.addAttribute(BrandConstant.LIST_BRAND_KEY, brSer.getListBrand(2));
        return "brandDelete";
    }

    @RequestMapping(params = ConstantManager.GET_FUNCTION, method = RequestMethod.GET)
    public String getBrandById(@RequestParam(BrandConstant.ID_PARAM) int id, ModelMap model, HttpSession session) {
        if (Objects.equals(brSer.checkLogin(session), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        Brand brand = brSer.getBrandById(id);
        if (Objects.equals(brand, ConstantManager.NULL)) {
            model.put(ConstantManager.ERROR_POPUP, BrandConstant.CANNOT_FIND_BRAND);
            return initiate(model, session);
        }
        model.put(BrandConstant.BRAND_FIND_KEY, brand);
        return BrandConstant.BRAND_EDIT_REDIRECT_PAGE;
    }

    @RequestMapping(params = ConstantManager.LOCK_FUNCTION)
    public String lock(@RequestParam(BrandConstant.ID_PARAM) int id,
            @RequestParam(BrandConstant.STATUS_PARAM) Boolean active,
            ModelMap model, HttpSession session) {
        if (Objects.equals(brSer.checkLogin(session), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(brSer.changeActiveBrand(id, active), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, BrandConstant.LOCK_BRAND_FAIL);
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, BrandConstant.LOCK_BRAND_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = "action", method = RequestMethod.GET)
    public String reUpOrDelete(@RequestParam(BrandConstant.ID_PARAM) int id,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url,
            ModelMap model, HttpSession session) {
        if (!Objects.equals(checkLogin.checkLoginRoleSuperAdmin(Integer.parseInt(String.valueOf(session.getAttribute(ConstantManager.ROLEID)))), Boolean.TRUE)) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        Boolean action = Boolean.FALSE;
        if (url.equalsIgnoreCase("reup")) {
            action = brSer.reupOrDeleteBrand(id, 2);
        } else {
            action = brSer.reupOrDeleteBrand(id, 1);
        }
        if (Objects.equals(action, Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, "Lỗi");
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, "Thành công");
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.DELETE_FUNCTION)
    public String delete(@RequestParam(BrandConstant.ID_PARAM) int id,
            ModelMap model, HttpSession session) {
        if (Objects.equals(brSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(brSer.deleteBrandById(id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, BrandConstant.DELETE_BRAND_FAIL);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, BrandConstant.DELETE_BRAND_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.INSERT_FUNCTION, method = RequestMethod.POST)
    public String insert(ModelMap model, HttpSession session,
            @RequestParam(BrandConstant.BRAND_NAME_PARAM) String brandName,
            @RequestParam(BrandConstant.IMAGES_PARAM) MultipartFile image) {
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        if (Objects.equals(brSer.checkLogin(session), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (ConstantManager.EMPTY.equalsIgnoreCase(image.getOriginalFilename())) {
            model.addAttribute(ConstantManager.ERROR_POPUP, BrandConstant.BRAND_NEED_IMG);
            return initiate(model, session);
        }
        if (Objects.equals(brSer.checkBrandExits(brandName), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, BrandConstant.BRAND_EXITS);
            return initiate(model, session);
        }
        Brand brand = new Brand();
        String imgName = Utils.randomCodeImg() + image.getOriginalFilename();
        listNames.add(imgName);
        listFiles.add(image);
        Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, BrandConstant.URL_STORE_SERVER);
        if (Objects.equals(checkUploadImg, Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, BrandConstant.INSERT_BRAND_FAIL);
            return initiate(model, session);
        }
        brand.setActive(Boolean.TRUE);
        brand.setImage(BrandConstant.URL_SERVER + imgName);
        brand.setName(brandName);
        if (Objects.equals(brSer.insertBrand(brand), Boolean.TRUE)) {
            model.addAttribute(ConstantManager.OK_POPUP, BrandConstant.INSERT_BRAND_OK);
            return initiate(model, session);
        }
        model.addAttribute(ConstantManager.ERROR_POPUP, BrandConstant.INSERT_BRAND_FAIL);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.UPDATE_FUNCTION, method = RequestMethod.POST)
    public String update(ModelMap model, HttpSession session,
            @RequestParam(BrandConstant.ID_PARAM) int id,
            @RequestParam(BrandConstant.ACTIVE_PARAM) Boolean active,
            @RequestParam(BrandConstant.BRAND_NAME_PARAM) String brandName,
            @RequestParam(BrandConstant.IMAGES_PARAM) MultipartFile image) {
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        if (Objects.equals(brSer.checkLogin(session), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        Brand brand = brSer.getBrandById(id);
        if (!image.isEmpty()) {
            String imgName = Utils.randomCodeImg() + image.getOriginalFilename();
            listNames.add(imgName);
            listFiles.add(image);
            Boolean checkUploadImg = Utils.uploadImg(listNames, listFiles, BrandConstant.URL_STORE_SERVER);
            if (Objects.equals(checkUploadImg, Boolean.FALSE)) {
                model.addAttribute(ConstantManager.ERROR_POPUP, BrandConstant.UPDATE_BRAND_FAIL);
                return initiate(model, session);
            }
            brand.setImage(BrandConstant.URL_SERVER + imgName);
        } else {
            brand.setImage(brand.getImage());
        }
        brand.setName(brandName);
        brand.setActive(active);
        brand.setImage(brand.getImage());
        if (Objects.equals(brSer.updateBrand(brand), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, BrandConstant.UPDATE_BRAND_FAIL);
            return getBrandById(id, model, session);
        }
        model.addAttribute(ConstantManager.OK_POPUP, BrandConstant.UPDATE_BRAND_OK);
        return initiate(model, session);
    }
}
