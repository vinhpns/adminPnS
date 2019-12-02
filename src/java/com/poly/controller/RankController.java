/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Rank;
import com.poly.constant.RankConstant;
import com.poly.service.RankService;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;

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

/**
 * @author phong
 */
@Controller
@RequestMapping(value = ConstantManager.RANK_PAGE)
public class RankController {

    @Autowired
    RankService rankSer;

    AccountController accController = new AccountController();

    @RequestMapping()
    public String initiate(ModelMap model, HttpSession session) {
        if (rankSer.checkLogin(session) == false) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.addAttribute(RankConstant.RANK_LIST, rankSer.getListRank());
        return RankConstant.RANK_PAGE;
    }

    @RequestMapping(params = ConstantManager.INSERT_FUNCTION, method = RequestMethod.POST)
    public String insertRank(ModelMap model, HttpSession session,
            @RequestParam(RankConstant.NAME_REQUEST_PARAM) String name,
            @RequestParam(RankConstant.REQUIRED_POINT_REQUEST_PARAM) int point,
            @RequestParam(RankConstant.ICON_REQUEST_PARAM) MultipartFile img) {
        if (rankSer.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        Rank rank = new Rank();
        if (rankSer.checkExits(point, name, 0) != null) {
            model.put(ConstantManager.ERROR_POPUP, RankConstant.RANK_EXITS);
            return initiate(model, session);
        }
        if (img != null) {
            List<String> listNames = new ArrayList<>();
            List<MultipartFile> listFiles = new ArrayList<>();
            listFiles.add(img);
            String imgName = Utils.randomCodeImg() + img.getOriginalFilename();
            listNames.add(imgName);
            rank.setIcon(RankConstant.URL_SERVER + imgName);
            Boolean checkLoadImg = Utils.uploadImg(listNames, listFiles, RankConstant.URL_STORE_SERVER);
            if (checkLoadImg == false) {
                model.put(ConstantManager.ERROR_POPUP, RankConstant.RANK_UPLOAD_IMG_FAIL);
            }
        } else {
            rank.setIcon(null);
        }
        rank.setName(name);
        rank.setRequirePoint(point);
        if (Objects.equals(rankSer.insert(rank), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, RankConstant.INSERT_FAIL);
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, RankConstant.INSERT_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.GET_FUNCTION, method = RequestMethod.GET)
    public String redirectUpdatePage(@RequestParam(RankConstant.ID_REQUEST_PARAM) int id,
            ModelMap model, HttpSession session) {
        if (Objects.equals(rankSer.checkLogin(session), Boolean.FALSE)) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        Rank rank = rankSer.getById(id);
        if (Objects.equals(rank, ConstantManager.NULL)) {
            model.put(ConstantManager.ERROR_POPUP, RankConstant.RANK_CANNOT_FIND);
            return initiate(model, session);
        }
        model.put(RankConstant.RANK_LIST, rank);
        return RankConstant.REDIRECT_UPDATE_PAGE;
    }

    @RequestMapping(params = ConstantManager.UPDATE_FUNCTION, method = RequestMethod.POST)
    public String updateRank(ModelMap model, HttpSession session,
            @RequestParam(RankConstant.ID_REQUEST_PARAM) int id,
            @RequestParam(RankConstant.NAME_REQUEST_PARAM) String name,
            @RequestParam(RankConstant.REQUIRED_POINT_REQUEST_PARAM) int point,
            @RequestParam(RankConstant.ICON_REQUEST_PARAM) MultipartFile img) {
        if (rankSer.checkLogin(session) == false) {
            model.addAttribute(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        Rank rank = rankSer.getById(id);
        if (rank == null) {
            model.put(ConstantManager.ERROR_POPUP, RankConstant.RANK_CANNOT_FIND);
            return initiate(model, session);
        }

        rank.setRequirePoint(point);
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        if (img != null) {
            listFiles.add(img);
            String imgName = Utils.randomCodeImg() + img.getOriginalFilename();
            listNames.add(imgName);
            rank.setIcon(RankConstant.URL_SERVER + imgName);
        } else {
            rank.setIcon(rank.getIcon());
        }
        if (listFiles.size() > 0 && listNames.size() > 0) {
            Boolean checkLoadImg = Utils.uploadImg(listNames, listFiles, RankConstant.URL_STORE_SERVER);
            if (checkLoadImg == false) {
                model.put(ConstantManager.ERROR_POPUP, RankConstant.RANK_UPLOAD_IMG_FAIL);
            }
        }
        Boolean update;
        if (rank.getName().equalsIgnoreCase(name)) {
            update = rankSer.update(rank, 1);
        } else {
            if (rankSer.checkExits(point, name, id) != null) {
                model.put(ConstantManager.ERROR_POPUP, RankConstant.RANK_EXITS);
                return initiate(model, session);
            }
            rank.setName(name);
            update = rankSer.update(rank, 2);
        }
        if (Objects.equals(update, Boolean.FALSE)) {
            model.put(ConstantManager.OK_POPUP, RankConstant.UPDATE_FAIL);
            return redirectUpdatePage(id, model, session);
        }
        model.put(ConstantManager.OK_POPUP, RankConstant.UPDATE_OK);
        return initiate(model, session);
    }
}
