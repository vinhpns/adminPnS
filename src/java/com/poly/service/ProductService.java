/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Bidding;
import com.poly.bean.Category;
import com.poly.bean.Product;
import com.poly.bean.ProductImage;
import com.poly.bean.Room;
import com.poly.bean.Selling;
import com.poly.constant.AccountConstant;
import com.poly.dao.BiddingDAO;
import com.poly.dao.ProductDAO;
import com.poly.dao.ProductImgDAO;
import com.poly.dao.SellingProductDAO;
import com.poly.tool.Utils;
import com.poly.tool.checkLogin;

import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VinhNT
 */
@Service
public class ProductService {

    @Autowired
    private ProductDAO pDAO;

    @Autowired
    private ProductImgDAO pImgDAO;

    @Autowired
    BiddingDAO biddingDAO;

    @Autowired
    SellingProductDAO selling;

    @Autowired
    RoomService rSER;

    @Autowired
    BrandService bSER;

    @Autowired
    CategoryService cSER;

    @Autowired
    BiddingService biddingSER;

    public Boolean checkLogin(HttpSession session) {
        return checkLogin.checkLogin(session) != false;
    }

    public List<Product> getListProduct(int type, HttpSession session) {
        int roleId = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        String accountId = (String) session.getAttribute("accountId");
        return pDAO.getListProduct(type, roleId, accountId);
    }

    public Boolean updatApprovedStatus(HttpSession session, int id) {
        int roleId = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return !Objects.equals(pDAO.approved(id, roleId), Boolean.FALSE);
    }

    public Boolean checkProductFullApproved(int id) {
        Product p = pDAO.getById(id);
        if (Objects.equals(p.getWriterApproved(), Boolean.TRUE)
                && Objects.equals(p.getModApproved(), Boolean.TRUE)
                && Objects.equals(p.getItApproved(), Boolean.TRUE)
                && Objects.equals(p.getHrApproved(), Boolean.TRUE)
                && Objects.equals(p.getAccApproved(), Boolean.TRUE)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public String getCateFather(Category cate) {
        String cateFather = String.valueOf(cate.getParentId());
        if (cate.getParentId() < 10) {
            cateFather = "0" + String.valueOf(cate.getParentId());
        }
        return cateFather;
    }

    public Boolean insertBidding(int id) {
        Product product = pDAO.getById(id);
        Category cate = cSER.getById(product.getCategoryId(), "cate");
        String cateFather;
        if (cate == null) {
            cateFather = "01";
        } else {
            cateFather = getCateFather(cate);
        }
        Bidding bidding = new Bidding();
        List<Bidding> b = biddingDAO.getAllListBidding();
        String orderCode;
        if (b.isEmpty()) {
            orderCode = "s" + cateFather + Utils.getToday() + "1" + "0001";
            bidding.setOrderCode(orderCode);
        } else {
            bidding.setOrderCode("s" + cateFather + Utils.getToday() + "1" + Utils.getOrderCode(b.get(0).getOrderCode()));
        }
        bidding.setProductId(id);
        bidding.setMaxMoney(product.getPrice());
        List<Room> room = rSER.getRoomIdByMoney(product.getPrice());
        bidding.setRoomId(room.get(0).getId());
        bidding.setEndTime(Utils.getDayByIT(room.get(0).getDuration()));
        if (Objects.equals(biddingDAO.insert(bidding), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean insertSelling(int id) {
        Product product = pDAO.getById(id);
        Category cate = cSER.getById(product.getCategoryId(), "cate");
        String cateFather = String.valueOf(cate.getParentId());
        if (cate.getParentId() < 10) {
            cateFather = "0" + String.valueOf(cate.getParentId());
        }
        Selling bidding = new Selling();
        List<Selling> b = selling.getAllListBidding();
        String orderCode;
        if (b.isEmpty()) {
            orderCode = "s" + cateFather + Utils.getToday() + "1" + "0001";
            bidding.setOrderCode(orderCode);
        } else {
            bidding.setOrderCode("s" + cateFather + Utils.getToday() + "1" + Utils.getOrderCode(b.get(0).getOrderCode()));
        }
        bidding.setProductId(id);
        bidding.setMaxMoney(product.getPrice());
        List<Room> room = rSER.getRoomIdByMoney(product.getPrice());
        bidding.setRoomId(room.get(0).getId());
        bidding.setEndTime(Utils.getDayByIT(room.get(0).getDuration()));
        if (Objects.equals(selling.insert(bidding), Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean updateActive(int id) {
        return !Objects.equals(pDAO.updateActive(id), Boolean.FALSE);
    }

    public Boolean insertProduct(Product product, HttpSession session) {
        int roleId = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        product.setAuction(Boolean.TRUE);
        product.setPostedCount(1);
        product.setPostedAccountId((String) session.getAttribute("accountId"));
        product.setSale(Boolean.FALSE);
        product.setActive(Boolean.FALSE);
        switch (roleId) {
            case AccountConstant.ROLE_SALE:
                product.setAccApproved(Boolean.FALSE);
                product.setWriterApproved(Boolean.FALSE);
                product.setItApproved(Boolean.FALSE);
                product.setModApproved(Boolean.FALSE);
                product.setHrApproved(Boolean.FALSE);
                break;
            case AccountConstant.ROLE_WRITER:
                product.setAccApproved(Boolean.FALSE);
                product.setWriterApproved(Boolean.TRUE);
                product.setItApproved(Boolean.FALSE);
                product.setModApproved(Boolean.FALSE);
                product.setHrApproved(Boolean.FALSE);
                break;
            case AccountConstant.ROLE_ADMIN:
                product.setAccApproved(Boolean.TRUE);
                product.setWriterApproved(Boolean.TRUE);
                product.setItApproved(Boolean.TRUE);
                product.setModApproved(Boolean.TRUE);
                product.setHrApproved(Boolean.TRUE);
                break;
        }
        return !Objects.equals(pDAO.insert(product, roleId), Boolean.FALSE);
    }

    public Boolean insertEcomerceProduct(Product product, HttpSession session) {
        int roleId = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        product.setAuction(Boolean.FALSE);
        product.setPostedCount(1);
        product.setPostedAccountId((String) session.getAttribute("accountId"));
        product.setSale(Boolean.TRUE);
        product.setActive(Boolean.FALSE);
        switch (roleId) {
            case AccountConstant.ROLE_SALE:
                product.setAccApproved(Boolean.FALSE);
                product.setWriterApproved(Boolean.FALSE);
                product.setItApproved(Boolean.FALSE);
                product.setModApproved(Boolean.FALSE);
                product.setHrApproved(Boolean.FALSE);
                break;
            case AccountConstant.ROLE_WRITER:
                product.setAccApproved(Boolean.FALSE);
                product.setWriterApproved(Boolean.TRUE);
                product.setItApproved(Boolean.FALSE);
                product.setModApproved(Boolean.FALSE);
                product.setHrApproved(Boolean.FALSE);
                break;
            case AccountConstant.ROLE_ADMIN:
                product.setAccApproved(Boolean.TRUE);
                product.setWriterApproved(Boolean.TRUE);
                product.setItApproved(Boolean.TRUE);
                product.setModApproved(Boolean.TRUE);
                product.setHrApproved(Boolean.TRUE);
                break;
        }
        return !Objects.equals(pDAO.insert(product, roleId), Boolean.FALSE);
    }

    public Product getLastId() {
        return pDAO.getLastInsertProduct();
    }

    public void insertProductImg(String imgName, int productId) {
        ProductImage pImg = new ProductImage();
        pImg.setLink(imgName);
        pImg.setProductId(productId);
        pImgDAO.insertImg(pImg);
    }

    public Product getProductInfoByProductId(int productId) {
        return pDAO.getProductInfoById(productId);
    }

    public List<ProductImage> getImgByProductId(int productId) {
        return pImgDAO.getListImgByProductId(productId);
    }

    public void updateProduct(Product product) {
        pDAO.updateProduct(product);
    }

    public List<Bidding> getTopBidding() {
        return biddingSER.getTopBidding();
    }

    public List<ProductImage> getIdFromLink(String link) {
        return pImgDAO.getIdByLinkImg(link);
    }

    public void updateAuctionProductImg(String name, int id, int productId) {
        ProductImage p = new ProductImage();
        p.setId(id);
        p.setLink(name);
        p.setProductId(productId);
        pImgDAO.updateProductImg(p);
    }
}
