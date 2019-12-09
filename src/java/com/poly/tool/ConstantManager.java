/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.tool;

/**
 * @author VinhNT
 */
public class ConstantManager {

    //Page
    public static final String USER_PAGE = "ListUser";
    public static final String CUSTOMER_PAGE = "ListCustomer";
    public static final String VIDEO_PAGE = "video";
    public static final String NEWS_PAGE = "news";
    public static final String BID_PRODUCT = "SaleBid";
    public static final String EMAIL_PAGE = "EmailContent";
    public static final String RANK_PAGE = "RankList";
    public static final String BANNER_PAGE = "banner";

    //Pop Up
    public static final String ERROR_POPUP = "errors";
    public static final String OK_POPUP = "okNotification";

    //Default Location, DB Name
    public static final String DEFAULT_DB_NAME = "TCSG";
    public static final String FOLDER_CONTAIN_IMG = "/opt/tomcat/webapps/picture/";
    public static final String URL_SHOW_IMG = "http://120.72.85.106/picture/";

    //Default Character
    public static final String EMPTY = "";
    public static final String UPDATE_FUNCTION = "update";
    public static final String DELETE_FUNCTION = "delete";
    public static final String INSERT_FUNCTION = "insert";
    public static final String REDIRECT_INSERT_FUNCTION = "add";
    public static final String UPDATE_PASSWORD = "updatePass";
    public static final String LOCK_FUNCTION = "lock";
    public static final Boolean STATUS_FALSE = false;
    public static final Boolean STATUS_TRUE = true;
    public static final String GET_FUNCTION = "get";
    public static final String ROLEID = "roleiz";
    public static final Object NULL = null;
    public static final String URL_REQUEST_PARAM = "url";
    public static final String EMAIL_SESSION_KEY = "email";
    public static final String LOGIN_NAME_SESSION_KEY = "loginName";
    public static final String ROLEIZ_SESSION_KEY = "roleiz";
    public static final String ACCOUNT_ID_SESSION_KEY = "accountId";
    
    //Message 
    public static final String NO_ACCEPT_LOGIN = "Đăng nhập để vào hệ thống";
    public static final String LOGIN_PAGE = "login";
    public static final String NO_ACCEPTED_LOGIN = "Bạn không có quyền truy cập trang này!";
    public static final String IMAGE_MUST_BE_IN = "Mỗi thương hiệu cần có hình ảnh";
    public static final String UPDATE_FAIL = "Cập nhật không thành công";
}
