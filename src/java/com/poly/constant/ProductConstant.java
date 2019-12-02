/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.constant;

import com.poly.tool.ConstantManager;

/**
 * @author VinhNT
 */
public class ProductConstant {

    //Path
    public static final String URL_AUCTION_SERVER = ConstantManager.URL_SHOW_IMG + "bidproduct/";
    public static final String URL_AUCTION_STORE_SERVER = ConstantManager.FOLDER_CONTAIN_IMG + "bidproduct/";
    public static final String URL_SALE_SERVER = ConstantManager.URL_SHOW_IMG + "saleproduct/";
    public static final String URL_SALE_STORE_SERVER = ConstantManager.FOLDER_CONTAIN_IMG + "saleproduct/";
    public static final String SALE_PRODUCT_PAGE = "SaleProduct";
    public static final String RETURN_SALE_PRODUCT_PAGE = "SaleProduct";
    public static final String RETURN_SALE_INSERT_PRODUCT_PAGE = "InsertProduct";
    public static final String RETURN_EDIT_PRODUCT_PAGE = "EditSaleProduct";
    public static final String SALE_BID_PAGE = "SaleBid";
    public static final String APPROVED_FUNCTION = "approved";

    //Keys
    public static final String SALE_PRODUCTS_KEYS = "saleProduct";
    public static final String LIST_BRAND_KEY = "brandId";
    public static final String LIST_CATEGORY_KEY = "categoryId";
    public static final String KEY_SALE_PRODUCT = "saleProduct";
    public static final String KEY_PRODUCT_INFO_BY_ID = "saleProduct";
    public static final String KEY_URL = "url";
    public static final String BID_PRODUCT_KEYS = "bidProducts";

    //Message
    public static final String NOT_ALLOW_APPROVE = "Bạn không có quyền duyệt sản phẩm này";
    public static final String INSERT_PRODUCT_OK = "Thêm sản phẩm thành công";
    public static final String INSERT_PRODUCT_FAIL = "Thêm sản phẩm không thành công";
    public static final String UPDATE_PRODUCT_OK = "Cập nhập sản phẩm thành công";
    public static final String UPDATE_PRODUCT_FAIL = "Cập nhập sản phẩm không thành công";
    public static final String APPROVED_OK = "Duyệt sản phẩm thành công";

    //Param 
    public static final String ID_PARAM = "id";
    public static final String FIRST_IMG = "firstImg";
    public static final String SECOND_IMG = "secondImg";
    public static final String THIRD_IMG = "thirdImg";
    public static final String FOUR_IMG = "fourImg";
    public static final String FIVE_IMG = "fiveImg";
    public static final String URL_PARAM = "url";
    public static final String IMG_1_PARAM = "img1";
    public static final String IMG_2_PARAM = "img2";
    public static final String IMG_3_PARAM = "img3";
    public static final String IMG_4_PARAM = "img4";
    public static final String IMG_5_PARAM = "img5";
    public static final int AUCTION_PRODUCT = 1;
    public static final int SALE_PRODUCT = 2;
}
