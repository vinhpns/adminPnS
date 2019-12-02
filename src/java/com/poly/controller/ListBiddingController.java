/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.controller;

import com.poly.bean.Bidding;
import com.poly.bean.Product;
import com.poly.bean.ProductImage;
import com.poly.bean.Room;
import com.poly.service.BiddingService;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author VinhNT
 */
@Controller
@RequestMapping("Bidding")
public class ListBiddingController {

    @Autowired
    BiddingService biddingSer;

    AccountController accController = new AccountController();

    @RequestMapping
    public String initiate(ModelMap model, HttpSession session) {
        if (biddingSer.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.put("bidProducts", biddingSer.getListAuctionByRole(session));
        return "Bidding";
    }

    @RequestMapping(params = "customerBidding", method = RequestMethod.GET)
    public String redirectBiddingHistory(ModelMap model, HttpSession session,
            @RequestParam("ordercode") String ordercode) {
        if (biddingSer.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.addAttribute("bidProducts", biddingSer.getListBiddingByOrdercode(ordercode));
        return "CustomerBidding";
    }

//    @RequestMapping(params = "bidExpired", method = RequestMethod.GET)
//    public String redirectBidExpiredPage(ModelMap model, HttpSession session) {
//        if (biddingSer.checkLogin(session) == false) {
//            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//        model.addAttribute("bidProducts", biddingSer.getListBidExpired(session));
//        return "BidExpired";
//    }
//
//    @RequestMapping(params = "reup", method = RequestMethod.GET)
//    public String reupBid(ModelMap model, HttpSession session, @RequestParam("ordercode") String ordercode) {
//        if (biddingSer.checkLogin(session) == false) {
//            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//        Bidding bid = biddingSer.getBidInfoByOrderCode(ordercode);
//        Product product = biddingSer.getProductInfoById(bid.getProductId());
//        Room room = biddingSer.getRoomDuration(bid.getRoomId());
//
//        String endTime = Utils.getDayByIT(room.getDuration());
//        bid.setEndTime(endTime);
//        bid.setExpired(Boolean.FALSE);
//        bid.setFinished(Boolean.FALSE);
//        bid.setPaid(Boolean.FALSE);
//        bid.setProductId(product.getId());
//        bid.setRoomId(room.getId());
//        bid.setMaxMoney(product.getPrice());
//
////        bid.setOrderCode(biddingSer.getNewOrderCode(ordercode));
////        biddingSer.insertNewBidding(bid);
//        biddingSer.updateRepostBid(ordercode);
//
//        return initiate(model, session);
//    }
//
//    @RequestMapping(params = "deleteBidding", method = RequestMethod.GET)
//    public String changeExpiredBidTrue(ModelMap model, HttpSession session,
//            @RequestParam("ordercode") String ordercode) {
//        if (biddingSer.checkLogin(session) == false) {
//            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
//            return accController.initiate(model, session);
//        }
//        biddingSer.deleteBidding(ordercode);
//        return initiate(model, session);
//    }
    @RequestMapping(params = "editBid", method = RequestMethod.GET)
    public String editBid(ModelMap model, HttpSession session,
            @RequestParam("ordercode") String ordercode,
            @RequestParam("url") String url) {
        if (biddingSer.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        Bidding bidding = biddingSer.getBidInfoByOrderCode(ordercode);
        model.addAttribute("bidProduct", biddingSer.getProductInfoById(bidding.getProductId()));
        model.addAttribute("idbrand", biddingSer.getListBrand());
        model.addAttribute("idcategory", biddingSer.getListCategory());
        model.addAttribute("url", url);
        List<ProductImage> pImg = biddingSer.getImgOfProduct(bidding.getProductId());
        model.addAttribute("img1", pImg.get(0).getLink());
        model.addAttribute("img2", pImg.get(1).getLink());
        model.addAttribute("img3", pImg.get(2).getLink());
        model.addAttribute("img4", pImg.get(3).getLink());
        model.addAttribute("img5", pImg.get(4).getLink());
        return "EditSaleBid";
    }
}
