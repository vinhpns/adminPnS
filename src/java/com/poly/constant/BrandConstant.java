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
public class BrandConstant {
    //path
    public static final String BRAND_PAGE = "brandpages";

    public static final String URL_STORE_SERVER = ConstantManager.FOLDER_CONTAIN_IMG + "brand/";

    public static final String BRAND_EDIT_REDIRECT_PAGE = "editBrand";
//    public static final String URL_STORE_SERVER = "E:";

    public static final String URL_SERVER = ConstantManager.URL_SHOW_IMG + "brand/";

    //REQUEST Param
    public static final String ID_PARAM = "id";

    public static final String STATUS_PARAM = "status";

    public static final String BRAND_NAME_PARAM = "brandName";

    public static final String IMAGES_PARAM = "images";

    public static final String ACTIVE_PARAM = "active";


    //Message
    public static final String BRAND_EXITS = "Thương hiệu đã tồn tại!";

    public static final String CHANGE_STATUS_BRAND_OK = "Thay đổi trạng thái thương hiệu thành công";

    public static final String BID_PRODUCT_EXITS_BY_BRAND = "Không thể xoá vì tồn tại sản phẩm của thương hiệu";

    public static final String LOCK_BRAND_FAIL = "Đổi trạng thái brand không thành công";

    public static final String LOCK_BRAND_OK = "Đổi trạng thái brand thành công";

    public static final String DELETE_BRAND_FAIL = "Xoá brand không thành công";

    public static final String DELETE_BRAND_OK = "Xoá brand thành công";

    public static final String CANNOT_FIND_BRAND = "Không tìm thấy brand cần chỉnh sửa";

    public static final String BRAND_NEED_IMG = "Mỗi brand cần có hình ảnh";

    public static final String INSERT_BRAND_FAIL = "Thêm brand không thành công";

    public static final String INSERT_BRAND_OK = "Thêm brand thành công";

    public static final String UPDATE_BRAND_FAIL = "Cập nhập brand khoonh thành công";

    public static final String UPDATE_BRAND_OK = "Cập nhập brand thành công";
    //Key model

    public static final String LIST_BRAND_KEY = "brands";

    public static final String BRAND_RETURN_PAGE = "brandpages";

    public static final String BRAND_INSERT_REDIRECT_PAGE = "insertBrand";

    public static final String BRAND_FIND_KEY = "brand";
}
