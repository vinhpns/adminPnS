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
public class AccountConstant {

    //Path
    public static final String INDEXPAGE = "index";
    public static final String LOGINPAGE = "login";

    //Param
    public static final String BUTTON_LOGIN = "btnLogin";
    public static final String BUTTON_LOGOUT = "logout";

    //RequestParam
    public static final String USERNAME_REQUESTPARAM = "username";
    public static final String PASSWORD_REQUESTPARAM = "password";
    public static final String ID_REQUEST_PARAM = "id";
    public static final String STATUS_REQUEST_PARAM = "status";
    public static final String ACCOUNT_MODEL_REQUEST_PARAM = "account";
    
    //Default
    public static final String DEFAULT_BACK_ID_CARD = "https://image2.tienphong.vn/w665/Uploaded/2019/ymnjs/2016_01_01/cmnd_con_thoi_han_nguoi_dan_khong_can_doi_sang_the_can_cuoc_2__qssh.jpg";
    public static final String DEFAULT_FRONT_ID_CARD = "https://image2.tienphong.vn/w665/Uploaded/2019/ymnjs/2016_01_01/cmnd_con_thoi_han_nguoi_dan_khong_can_doi_sang_the_can_cuoc_2__qssh.jpg";
    public static final String URL_SERVER = ConstantManager.URL_SHOW_IMG + "employee/";
    public static final String DEFAULT_AVATAR = "http://kangenhoangngan.com/data_store/upload/chuyen-gia-dien-giai.png";
    public static final String URL_STORE_SERVER = ConstantManager.FOLDER_CONTAIN_IMG + "employee/";
    public static final String ADMIN_SITE = "admin";

    //Key Return
    public static final String ROLE_KEY = "listRole";
    public static final String LISTUSER = "listUser";
    public static final String ACCOUNT_INFO = "AccountInfo";
    public static final String CUSTOMER_INFO = "customerInfo";
    public static final String RANK_ID = "rankId";
    public static final String LIST_CUSTOMER = "customerInfo";

    //Message
    public static final String NO_EMAIL_EXITS = "Email không tồn tại";
    public static final String EMPLOYEE_ONLY = "Bạn phải là nhân viên để được truy cập";
    public static final String BLOCK_ACCOUNT = "Tài khoản bị khóa, vui lòng liên hệ ADMIN";
    public static final String WRONG_PASSWORD = "Sai Mật Khẩu";
    public static final String LOCK_SUCCESSFUL = "Thay đổi trạng thái Tài khoản thành công";
    public static final String LOCK_FAIL = "Thay đổi trạng thái Tài khoản không thành công";
    public static final String EMAIL_EXITED = "Tài khoản vừa nhập đã tồn tại";
    public static final String INSERT_FAIL = "Thêm tài khoản không thành công";
    public static final String INSERT_OK = "Thêm tài khoản thành công";
    public static final String DELETE_FAIL = "Xóa tài khoản không thành công";
    public static final String DELETE_OK = "Xóa tài khoản thành công";
    public static final String UPDATE_FAIL = "Update không thành công";
    public static final String UPDATE_OK = "Update thành công";
    public static final String NONE = "Không có";
    public static final String EMPTY = "";
    public static final String DUPLICATE_OLD_PASSWORD = "Trùng với mật khẩu cũ";
    public static final String NOT_LIKE_IN_PASSWORD = "Mật khẩu nhập 2 lần không trùng nhau";
    public static final String URL_PARAM = "url";

    public static final int ROLE_SALE = 1;
    public static final int ROLE_HR = 2;
    public static final int ROLE_ACC = 3;
    public static final int ROLE_WRITER = 4;
    public static final int ROLE_MOD = 5;
    public static final int ROLE_IT = 6;
    public static final int ROLE_ADMIN = 7;
    public static final int ROLE_CUSTOMER = 8;
    public static final int ROLE_SUPER_ADMIN = 9;

    public static final int ACCOUNT_MEMBER = 1;
    public static final int ACCOUNT_BRONZE = 2;
    public static final int ACCOUNT_SLIVER = 3;
    public static final int ACCOUNT_GOLD = 4;
    public static final int ACCOUNT_DIAMOND = 5;
    public static final int ACCOUNT_VIP = 6;

    public static final int TYPE_ROLE_MANAGER_SYSTEM = 1;
    public static final int TYPE_ROLE_ACCESS_SYSTEM = 2;

    public static final int UPDATE_NON_EMAIL = 2;
    public static final int UPDATE_WITH_EMAIL = 1;

    public static final int UPDATE_NON_IDNUMBER = 2;
    public static final int UPDATE_WITH_IDNUMBER = 1;

    //Return Page
    public static final String LIST_USER_PAGE = "ListUser";
    public static final String UPDATE_PAGE = "UpdateAccount";
}
