/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Bidding;
import com.poly.bean.BiddingHistory;
import com.poly.bean.Brand;
import com.poly.bean.Category;
import com.poly.bean.Product;
import com.poly.bean.ProductImage;
import com.poly.bean.Room;
import com.poly.dao.BiddingDAO;
import com.poly.request.BiddingResponse;
import com.poly.tool.checkLogin;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VinhNT
 */
@Service
public class BiddingService {

    @Autowired
    private BiddingDAO bDAO;

    @Autowired
    ProductService pSER;

    @Autowired
    RoomService rSER;

    @Autowired
    BrandService bSER;

    @Autowired
    CategoryService cSER;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleSale(role) == true
                || checkLogin.checkLoginRoleIt(role) == true
                || checkLogin.checkLoginRoleAdmin(role) == true);
    }

    public List<BiddingResponse> getListAuctionByRole(HttpSession session) {
        return bDAO.getAllList(Integer.parseInt(String.valueOf(session.getAttribute("roleiz"))),
                (String) session.getAttribute("accountId"));
    }

    public List<BiddingHistory> getListBiddingByOrdercode(String ordercode) {
        return bDAO.getBiddingHistoryByOrderCode(ordercode);
    }

    public List<Bidding> getListBidExpired(HttpSession session) {
        List<Bidding> listProduct = null;
        switch (Integer.parseInt(String.valueOf(session.getAttribute("roleiz")))) {
            case 1:
                listProduct = bDAO.getListBidExpiredByUser((String) session.getAttribute("accountId"));
                break;
            case 6:
                listProduct = bDAO.getListBidExpired();
                break;
            case 7:
                listProduct = bDAO.getListBidExpired();
                break;
        }
        return listProduct;
    }

    public Bidding getBidInfoByOrderCode(String ordercode) {
        return bDAO.getBidByOrderCode(ordercode);
    }

    public Product getProductInfoById(int id) {
        return pSER.getProductInfoByProductId(id);
    }

    public Room getRoomDuration(int id) {
        return rSER.getRoomById(id);
    }

//    public String getNewOrderCode(String ordercode) {
//        return Utils.getNewOrderCode(ordercode);
//    }
    public void deleteBidding(String ordercode) {
        bDAO.deleteBidding(ordercode);
    }

    public void updateRepostBid(String ordercode) {
        bDAO.updateRepostStatus(ordercode);
    }

    public List<ProductImage> getListImgByBid(int productId) {
        return pSER.getImgByProductId(productId);
    }

    public List<Brand> getListBrand() {
        return bSER.getListBrand(1);
    }

    public List<Room> getListRoom() {
        return rSER.getListRoom();
    }

    public List<Category> getListCategory() {
        return cSER.getListCategory(2);
    }

    public List<Bidding> getTopBidding() {
        return bDAO.getTopBidding();
    }

    public List<ProductImage> getImgOfProduct(int id) {
        return pSER.getImgByProductId(id);
    }

    public List<BiddingHistory> getWinBidList() {
        return bDAO.getWinList();
    }
}
