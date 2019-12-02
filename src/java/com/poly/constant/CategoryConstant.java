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
public class CategoryConstant {

    //path
    public static final String CATEGORY_PAGE = "category";

    public static final String CATEGORYTYPE_PAGE = "categoryType";

    public static final String CATEGORY_RETURN_PAGE = "ListCategory";

    public static final String CATEGORYTYPE_RETURN_PAGE = "ListCategoryType";

    public static final String CATEGORY_INSERT_REDIRECT_PAGE = "InsertCategory";

    public static final String CATEGORY_EDIT_REDIRECT_PAGE = "EditCategory";

    public static final String CATEGORYTYPE_EDIT_REDIRECT_PAGE = "EditCategoryType";

    public static final String CATEGORYTYPE_INSERT_REDIRECT_PAGE = "InsertCategoryType";

    //Request Param
    public static final String ID_PARAM = "id";

    public static final String STATUS_PARAM = "status";

    public static final String LINK_PARAM = "link";

    public static final String TYPE_ID_PARAM = "typeId";

    public static final String NAME_PARAM = "name";

    public static final String FATHER_ID_PARAM = "parentId";

    //Key Model
    public static final String LIST_CATEGORYTYPE_KEY = "listcategorytypes";

    public static final String LIST_CATEGORY_KEY = "listcategory";

    public static final String CATEGORY_TYPE_KEY = "categorytype";

    public static final String CATEGORY_GET_BY_ID_KEY = "category";

    public static final String CATEGORYTYPE_FIND_KEY = "categorytype";

    //Message Error
    public static final String DELETE_CATEGORY_FAIL = "Xoá danh mục không thành công";
    public static final String DELETE_CATEGORY_OK = "Xoá danh mục thành công";
    public static final String LOCK_CATEGORY_FAIL = "Đổi trạng thái danh mục không thành công do tồn tại sản phẩm đang đấu giá";
    public static final String LOCK_CATEGORY_OK = "Đổi trạng thái danh mục thành công";
    public static final String INSERT_CATEGORY_FAIL = "Thêm danh mục không thành công";
    public static final String ALREADY_CATEGORY_FAIL = "Tên danh mục đã tồn tại";
    public static final String INSERT_CATEGORY_OK = "Thêm danh mục thành công";
    public static final String UPDATE_CATEGORY_FAIL = "Chỉnh sửa danh mục không thành công";
    public static final String UPDATE_CATEGORY_OK = "Chỉnh sửa danh mục thành công";
    public static final String CANNOT_FIND_CATEGORY = "Không tìm thấy danh mục cần chỉnh sửa";
    public static final String DUPLICATE_CATEGORY = "Đã tồn tại danh mục trong hệ thống";

    public static final int CATEGORY_TYPE = 1;
    public static final int CATEGORY = 2;
    public static final String URL_STORE_SERVER = ConstantManager.FOLDER_CONTAIN_IMG + "category_type/";
    public static final String URL_SERVER = ConstantManager.URL_SHOW_IMG + "category_type/";
}
