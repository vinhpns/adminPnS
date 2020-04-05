/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.tool;

/**
 * @author 
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

    //Default Location, DB Name TCSG
//    public static final String DEFAULT_DB_NAME = "TCSG";
//    public static final String FOLDER_CONTAIN_IMG = "/opt/tomcat/admintcsg_webapps/picture/";
//    public static final String URL_SHOW_IMG = "http://admin.tcsaigon.edu.vn/picture/";
    //CDQT Default
    public static final String DEFAULT_DB_NAME = "manage_clinic";
    //NMLQ
    public static final String FOLDER_CONTAIN_IMG = "/opt/tomcat/ql_nmlq_webapps/picture/";
    public static final String URL_SHOW_IMG = "http://ql.nangmuilequy.com/picture/";
    public static final String COMPANY_ID = "114f79b8-333e-47b8-865b-6f162cdb02c7 ";
    //NMSG
//    public static final String FOLDER_CONTAIN_IMG = "/opt/tomcat/ql_nmsg_webapps/picture/";
//    public static final String URL_SHOW_IMG = "http://ql.nangmuisaigon.net/picture/";
//    public static final String COMPANY_ID = "134f79b8-333e-47b8-865b-6f162cdb02c7";

    //Default Character
    public static final String EMPTY = "";
    public static final String ROLEID = "roleiz";
    public static final String URL_REQUEST_PARAM = "url";
    public static final String EMAIL_SESSION_KEY = "email";
    public static final String LOGIN_NAME_SESSION_KEY = "loginName";
    public static final String ROLEIZ_SESSION_KEY = "roleiz";
    public static final String ACCOUNT_ID_SESSION_KEY = "accountId";
    public static final int ROLE_CUSTOMER = 1;
    public static final int ROLE_SUPER_ADMIN = 2;
    public static final int ROLE_ADMIN = 3;
    
    //Message 
    public static final String NO_ACCEPT_LOGIN = "Đăng nhập để vào hệ thống";
    public static final String LOGIN_PAGE = "login";
    public static final String NO_ACCEPTED_LOGIN = "Bạn không có quyền truy cập trang này!";
}
