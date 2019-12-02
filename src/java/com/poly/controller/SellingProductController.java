///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.poly.controller;
//
//import com.poly.bean.Selling;
//import com.poly.dao.CategoryTypeDAO;
//import com.poly.dao.SaleProductDAO;
//import com.poly.tool.ConstantManager;
//import com.poly.tool.Utils;
//import java.util.ArrayList;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.multipart.MultipartFile;
//
///**
// *
// * @author Vinh
// */
//@Controller
//@RequestMapping("Selling")
//@SessionAttributes(value = {"username", "id", "role", "fullname"})
//public class SellingProductController {
//
//    @Autowired
//    private SaleProductDAO saleProductDAO;
//    
//    @Autowired
//    private CategoryTypeDAO cateDAO;
//
//    private static int u = 0;
//
//    @RequestMapping
//    public String initiate(ModelMap model, HttpSession session, HttpServletRequest request) {
//
//        session = request.getSession();
//
//        if (session.getAttribute("loginname") == null
//                || session.getAttribute("loginname").equals(ConstantManager.EMPTY)) {
//            model.addAttribute("errors", ConstantManager.NO_ACCEPT_LOGIN);
//            return "login";
//        }
//
//        String roleId = (String) session.getAttribute("roleiz");
//        String saleName = (String) session.getAttribute("loginname");
//
//        List<Selling> saleProducts = null;
//
//        switch (roleId) {
//            case ConstantManager.ROLE_SALE:
//                saleProducts = saleProductDAO.getSaleProductsBySalesStatusSelling(saleName);
//                break;
//            case ConstantManager.ROLE_IT:
//                saleProducts = saleProductDAO.getSaleProductsByStatus(ConstantManager.SELLING);
//                break;
//            case ConstantManager.ROLE_ADMIN:
//                saleProducts = saleProductDAO.getSaleProductsByAdminStatusSelling();
//                break;
//        }
//        if (saleProducts != null && !saleProducts.isEmpty()) {
//            model.addAttribute("saleProducts", saleProducts);
//
//        }
////        model.addAttribute("idcategory", cateDAO.getAllCategory());
//
//        return "Selling";
//    }
//
//    @RequestMapping(params = ConstantManager.SALE_PRODUCT_ID, method = {RequestMethod.GET})
//    public String getSaleProductById(@RequestParam("id") int id, ModelMap model) {
//        Selling saleProductDetail = saleProductDAO.getSaleProductsById(id);
//        model.addAttribute("saleProduct", saleProductDetail);
////        model.addAttribute("idcategory", cateDAO.getAllCategory());
//        return "EditSaleSelling";
//    }
//
//    @RequestMapping(params = ConstantManager.UPDATE, method = {RequestMethod.POST})
//    public String update(@ModelAttribute("saleProduct") Selling saleProductDetail,
//            @RequestParam("firstImage") MultipartFile firstImage,
//            @RequestParam("secondImage") MultipartFile secondImage,
//            @RequestParam("thirdImage") MultipartFile thirdImage, ModelMap model) {
//
//        List<String> listNames = new ArrayList<>();
//        List<MultipartFile> listFiles = new ArrayList<>();
//        String firstImageName = firstImage.getOriginalFilename();
//        String secondImageName = secondImage.getOriginalFilename();
//        String thirdImageName = thirdImage.getOriginalFilename();
//
//        if (saleProductDetail != null) {
//
//            Selling sale = saleProductDAO.getSaleProductsById(saleProductDetail.getId());
//
//            if (!ConstantManager.EMPTY.equalsIgnoreCase(firstImageName)) {
//                listNames.add(firstImageName);
//                listFiles.add(firstImage);
//                saleProductDetail.setImage(ConstantManager.URL_SERVER + firstImage.getOriginalFilename());
//            } else if (!ConstantManager.EMPTY.equalsIgnoreCase(sale.getImage()) && ConstantManager.EMPTY.equalsIgnoreCase(firstImageName)) {
//                saleProductDetail.setImage(sale.getImage());
//            }
//
//            if (!ConstantManager.EMPTY.equalsIgnoreCase(secondImageName)) {
//                listNames.add(secondImageName);
//                listFiles.add(secondImage);
//                saleProductDetail.setImg1(ConstantManager.URL_SERVER + secondImage.getOriginalFilename());
//            } else if (!ConstantManager.EMPTY.equalsIgnoreCase(sale.getImg1()) && ConstantManager.EMPTY.equalsIgnoreCase(secondImageName)) {
//                saleProductDetail.setImg1(sale.getImg1());
//            }
//
//            if (!ConstantManager.EMPTY.equalsIgnoreCase(thirdImageName)) {
//                listNames.add(thirdImageName);
//                listFiles.add(thirdImage);
//                saleProductDetail.setImg2(ConstantManager.URL_SERVER + thirdImage.getOriginalFilename());
//            } else if (!ConstantManager.EMPTY.equalsIgnoreCase(sale.getImg2()) && ConstantManager.EMPTY.equalsIgnoreCase(thirdImageName)) {
//                saleProductDetail.setImg2(sale.getImg2());
//            }
//
//            if (listNames.size() > 0 && !listNames.isEmpty()) {
//                for (int i = 0; i < listNames.size(); i++) {
//                    Utils.uploadImageToServer(ConstantManager.URL_STORE_SERVER, listNames.get(i), listFiles.get(i));
//                }
//            }
//
//            saleProductDAO.update(saleProductDetail);
//            model.addAttribute("SUCCESS", "Chỉnh Sửa Thành Công!!!");
//            return getSaleProductById(saleProductDetail.getId(), model);
//        } else {
//            model.addAttribute("FAIL", "Chỉnh Sửa Thất bại!!!");
//            return "SaleProduct.htm";
//        }
//    }
//
//    @RequestMapping(params = ConstantManager.DELETE, method = {RequestMethod.GET})
//    public String deleteSaleProduct(@RequestParam("id") int id, ModelMap model, HttpSession session, HttpServletRequest request) {
//        saleProductDAO.deleteSaleProduct(id);
//        return initiate(model, session, request);
//    }
//
//    @RequestMapping(params = ConstantManager.RETURN_STATUS, method = {RequestMethod.POST})
//    public String returnStatus(@RequestParam("id") int id,
//            @RequestParam("status") int status, ModelMap model,
//            HttpSession session, HttpServletRequest request) {
//
//        session = request.getSession();
//
//        String roleId = (String) session.getAttribute("roleiz");
//
//        if (null != roleId) {
//            switch (roleId) {
//                case ConstantManager.ROLE_IT:
//                    status = 2;
//                    saleProductDAO.updateStatus(id, status, 2);
//                    break;
//                case ConstantManager.ROLE_ADMIN:
//                    status = 2;
//                    saleProductDAO.updateStatus(id, status, 2);
//                    //update by IT
//                    break;
//            }
//        }
//        return initiate(model, session, request);
//    }
//
//}
