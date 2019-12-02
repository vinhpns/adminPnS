package com.poly.controller;

import com.poly.bean.Product;
import com.poly.bean.ProductImage;
import com.poly.constant.CategoryConstant;
import com.poly.constant.ProductConstant;
import com.poly.service.BrandService;
import com.poly.service.CategoryService;
import com.poly.service.ProductService;
import com.poly.tool.ConstantManager;
import com.poly.tool.Utils;

import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(ConstantManager.BID_PRODUCT)
public class BidProductController {

    @Autowired
    ProductService pSER;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    AccountController accController = new AccountController();

    @RequestMapping
    public String initiate(ModelMap model, HttpSession session) {
        if (pSER.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        model.put(ProductConstant.LIST_BRAND_KEY, brandService.getListBrand(1));
        model.put(ProductConstant.LIST_CATEGORY_KEY, categoryService.getListCategory(CategoryConstant.CATEGORY));
        model.addAttribute(ProductConstant.BID_PRODUCT_KEYS, pSER.getListProduct(ProductConstant.AUCTION_PRODUCT, session));
        return ProductConstant.SALE_BID_PAGE;
    }

    @RequestMapping(params = ProductConstant.APPROVED_FUNCTION, method = RequestMethod.GET)
    public String approveByRole(ModelMap model, HttpSession session,
            @RequestParam(ProductConstant.ID_PARAM) int id) {
        if (pSER.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(pSER.updatApprovedStatus(session, id), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, ProductConstant.NOT_ALLOW_APPROVE);
            return initiate(model, session);
        }
        Boolean insertBid = Boolean.FALSE;
        if (Objects.equals(pSER.checkProductFullApproved(id), Boolean.TRUE)) {
            insertBid = pSER.insertBidding(id);
        }
        if (Objects.equals(insertBid, Boolean.TRUE)) {
            pSER.updateActive(id);
        }
        model.put(ConstantManager.OK_POPUP, ProductConstant.APPROVED_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = "returnStatus", method = RequestMethod.GET)
    public String returnApproveStatus(ModelMap model, HttpSession session, @RequestParam("id") int id) {
        if (pSER.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
//        pSER.requestEditProduct(session, id);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.INSERT_FUNCTION, method = RequestMethod.POST)
    public String insertAuctionProduct(ModelMap model, HttpSession session,
            @ModelAttribute("product") Product product,
            @RequestParam("fristImg") MultipartFile img1,
            @RequestParam("secondImg") MultipartFile img2,
            @RequestParam("thirdImg") MultipartFile img3,
            @RequestParam("fourImg") MultipartFile img4,
            @RequestParam("fiveImg") MultipartFile img5) {
        if (pSER.checkLogin(session) == false) {
            model.put(ConstantManager.ERROR_POPUP, ConstantManager.NO_ACCEPTED_LOGIN);
            return accController.initiate(model, session);
        }
        if (Objects.equals(pSER.insertProduct(product, session), Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, ProductConstant.INSERT_PRODUCT_FAIL);
            return initiate(model, session);
        }
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        Product productGetId = pSER.getLastId();
        if (!img1.isEmpty()) {
            String img1Name = Utils.randomCodeImg() + img1.getOriginalFilename();
            listNames.add(img1Name);
            pSER.insertProductImg(ProductConstant.URL_AUCTION_SERVER + img1Name, productGetId.getId());
            listFiles.add(img1);
        }
        if (!img2.isEmpty()) {
            String img2Name = Utils.randomCodeImg() + img2.getOriginalFilename();
            listNames.add(img2Name);
            pSER.insertProductImg(ProductConstant.URL_AUCTION_SERVER + img2Name, productGetId.getId());
            listFiles.add(img2);
        }
        if (!img3.isEmpty()) {
            String img3Name = Utils.randomCodeImg() + img3.getOriginalFilename();
            listNames.add(img3Name);
            pSER.insertProductImg(ProductConstant.URL_AUCTION_SERVER + img3Name, productGetId.getId());
            listFiles.add(img3);
        }
        if (!img4.isEmpty()) {
            String img4Name = Utils.randomCodeImg() + img4.getOriginalFilename();
            listNames.add(img4Name);
            pSER.insertProductImg(ProductConstant.URL_AUCTION_SERVER + img4Name, productGetId.getId());
            listFiles.add(img4);
        }
        if (!img5.isEmpty()) {
            String img5Name = Utils.randomCodeImg() + img5.getOriginalFilename();
            listNames.add(img5Name);
            pSER.insertProductImg(ProductConstant.URL_AUCTION_SERVER + img5Name, productGetId.getId());
            listFiles.add(img5);
        }
        try {
            Utils.uploadImg(listNames, listFiles, ProductConstant.URL_AUCTION_STORE_SERVER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return initiate(model, session);
        }
        Boolean insertBid = Boolean.FALSE;
        if (Objects.equals(pSER.checkProductFullApproved(productGetId.getId()), Boolean.TRUE)) {
            insertBid = pSER.insertBidding(productGetId.getId());
        }
        if (Objects.equals(insertBid, Boolean.TRUE)) {
            insertBid = pSER.updateActive(productGetId.getId());
        }
        if (Objects.equals(insertBid, Boolean.FALSE)) {
            model.put(ConstantManager.ERROR_POPUP, ProductConstant.INSERT_PRODUCT_FAIL);
            return initiate(model, session);
        }
        model.put(ConstantManager.OK_POPUP, ProductConstant.INSERT_PRODUCT_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.UPDATE_FUNCTION, method = RequestMethod.POST)
    public String updateAuctionProduct(ModelMap model, HttpSession session,
            @ModelAttribute("bidProduct") Product product,
            @RequestParam(ConstantManager.URL_REQUEST_PARAM) String url,
            @RequestParam("img1") MultipartFile img1,
            @RequestParam("img2") MultipartFile img2,
            @RequestParam("img3") MultipartFile img3,
            @RequestParam("img4") MultipartFile img4,
            @RequestParam("img5") MultipartFile img5) {

        pSER.updateProduct(product);
        List<String> listNames = new ArrayList<>();
        List<MultipartFile> listFiles = new ArrayList<>();
        List<ProductImage> getImg = pSER.getImgByProductId(product.getId());
        List<ProductImage> pImg;

        if (img1 != null) {
            String img1Name = Utils.randomCodeImg() + img1.getOriginalFilename();
            pImg = pSER.getIdFromLink(getImg.get(0).getLink());
            if (pImg == null) {
                pSER.insertProductImg(ProductConstant.URL_AUCTION_SERVER + img1Name, pImg.get(0).getProductId());
            }
            pSER.updateAuctionProductImg(ProductConstant.URL_AUCTION_SERVER + img1Name, pImg.get(0).getId(), pImg.get(0).getProductId());
            listNames.add(img1Name);
            listFiles.add(img1);
        }
        if (img2 != null) {
            String img2Name = Utils.randomCodeImg() + img2.getOriginalFilename();
            pImg = pSER.getIdFromLink(getImg.get(1).getLink());
            if (pImg == null) {
                pSER.insertProductImg(ProductConstant.URL_AUCTION_SERVER + img2Name, pImg.get(0).getProductId());
            }
            pSER.updateAuctionProductImg(ProductConstant.URL_AUCTION_SERVER + img2Name, pImg.get(0).getId(), pImg.get(0).getProductId());
            listNames.add(img2Name);
            listFiles.add(img2);
        }
        if (img3 != null) {
            String img3Name = Utils.randomCodeImg() + img3.getOriginalFilename();
            pImg = pSER.getIdFromLink(getImg.get(2).getLink());
            if (pImg == null) {
                pSER.insertProductImg(ProductConstant.URL_AUCTION_SERVER + img3Name, pImg.get(0).getProductId());
            }
            pSER.updateAuctionProductImg(ProductConstant.URL_AUCTION_SERVER + img3Name, pImg.get(0).getId(), pImg.get(0).getProductId());
            listNames.add(img3Name);
            listFiles.add(img3);
        }
        if (img4 != null) {
            String img4Name = Utils.randomCodeImg() + img4.getOriginalFilename();
            pImg = pSER.getIdFromLink(getImg.get(3).getLink());
            if (pImg == null) {
                pSER.insertProductImg(ProductConstant.URL_AUCTION_SERVER + img4Name, pImg.get(0).getProductId());
            }
            pSER.updateAuctionProductImg(ProductConstant.URL_AUCTION_SERVER + img4Name, pImg.get(0).getId(), pImg.get(0).getProductId());
            listNames.add(img4Name);
            listFiles.add(img4);
        }
        if (img5 != null) {
            String img5Name = Utils.randomCodeImg() + img5.getOriginalFilename();
            pImg = pSER.getIdFromLink(getImg.get(4).getLink());
            if (pImg == null) {
                pSER.insertProductImg(ProductConstant.URL_AUCTION_SERVER + img5Name, pImg.get(0).getProductId());
            }
            pSER.updateAuctionProductImg(ProductConstant.URL_AUCTION_SERVER + img5Name, pImg.get(0).getId(), pImg.get(0).getProductId());
            listNames.add(img5Name);
            listFiles.add(img5);
        }
        try {
            Utils.uploadImg(listNames, listFiles, ProductConstant.URL_AUCTION_STORE_SERVER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        model.put(ConstantManager.OK_POPUP, ProductConstant.UPDATE_PRODUCT_OK);
        return initiate(model, session);
    }

    @RequestMapping(params = ConstantManager.GET_FUNCTION, method = RequestMethod.GET)
    public String editBid(ModelMap model, HttpSession session,
            @RequestParam(ProductConstant.ID_PARAM) int id) {
        model.addAttribute("bidProduct", pSER.getProductInfoByProductId(id));
        model.put(ProductConstant.LIST_BRAND_KEY, brandService.getListBrand(1));
        model.put(ProductConstant.LIST_CATEGORY_KEY, categoryService.getListCategory(CategoryConstant.CATEGORY));
        List<ProductImage> pImg = pSER.getImgByProductId(id);
        System.out.println(pImg.size());
        for (int i = 0; i < pImg.size(); i++) {
            model.put("img" + i, pImg.get(i).getLink());
        }

        return "EditSaleBid";
    }
}
