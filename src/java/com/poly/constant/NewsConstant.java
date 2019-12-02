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
public class NewsConstant {

    //Default Character
    public final static Integer ABOUT_US = 1;
    public final static Integer CUSTOMER_HELP = 2;
    public final static Integer CONTACT = 3;
    public final static Integer MARKET_INFO = 4;
    public final static Integer DO_YOU_KNOW = 5;
    public final static Integer WORLD_NEWS = 6;
    public final static Integer SGDG_NEWS = 7;
    public final static Integer PROMOTION = 8;
    public final static Integer Q_A = 9;

    public final static String ABOUT_US_TITLE = "Về Chúng tôi";
    public final static String CUSTOMER_HELP_TITLE = "Hướng dẫn";
    public final static String CONTACT_TITLE = "Liên hệ";
    public final static String MARKET_INFO_TITLE = "Thông tin thị trường";
    public final static String DO_YOU_KNOW_TITLE = "Bạn có biết";
    public final static String WORLD_NEWS_TITLE = "Thế giới đó đây";
    public final static String SGDG_NEWS_TITLE = "Tin đấu giá sài gòn";
    public final static String PROMOTION_TITLE = "Khuyến mãi hot";
    public final static String Q_A_TITLE = "Hỏi và đáp";

    //Path
    public static final String URL_SERVER = ConstantManager.URL_SHOW_IMG + "news/";
    public static final String URL_STORE_SERVER = ConstantManager.FOLDER_CONTAIN_IMG + "news/";
    public static final String NEWS_RETURN_PAGE = "ListNews";
    public static final String NEWS_INSERT_REDIRECT_PAGE = "InsertNews";
    public static final String NEWS_EDIT_REDIRECT_PAGE = "UpdateNews";
    public static final String FOOTER_NEWS_PAGE = "ListFooterNews";
    public static final String FOOTER_RETURN_PAGE = "ListFooterNews";
    public static final String FOOTER_INSERT_REDIRECT_PAGE = "InsertFooterNews";
    public static final String FOOTER_EDIT_REDIRECT_PAGE = "UpdateFooterNews";
    //Keys

    public static final String LIST_NEWS_KEY = "listnews";
    public static final String LIST_TYPENEWS_KEY = "typeNews";
    public static final String NEWS_BY_ID_FIND_KEY = "newById";
    public static final String TYPENEWS_FIND_KEY = "typeNews";
    public static final String LIST_FOOTER_KEY = "news";
    public static final String LIST_TYPE_FOOTER_KEY = "typeNews";
    public static final String LIST_TYPE_NEWS_FOOTER_KEY = "typeNews";
    public static final String NEWS_BY_ID_KEY = "newById";
    public static final String TYPE_NEWS_KEY = "typenews";

    //Param
    public static final String ID_PARAM = "id";
    public static final String STATUS_PARAM = "status";
    public static final String TITLE_PARAM = "title";
    public static final String CONTENT_PARAM = "content";
    public static final String TYPE_PARAM = "type";
    public static final String HOT_PARAM = "hot";
    public static final String AVATAR_PARAM = "avatar";
    public static final String FOOTER_ID_PARAM = "id";
    public static final String FOOTER_STATUS_PARAM = "status";
    public static final String FOOTER_TITLE_PARAM = "title";
    public static final String FOOTER_CONTENT_PARAM = "content";
    public static final String FOOTER_TYPE_PARAM = "type";

    //Message
    public static final String LOCK_NEWS_FAIL = "Đổi trạng thái tin tức không thành công";
    public static final String LOCK_NEWS_OK = "Đổi trạng thái tin tức thành công";
    public static final String DELETE_NEWS_FAIL = "Xóa tin tức không thành công";
    public static final String DELETE_NEWS_OK = "Xóa tin tức thành công";
    public static final String INSERT_NEWS_FAIL = "Thêm news không thành công";
    public static final String INSERT_NEWS_OK = "Thêm new thành công";
    public static final String NEWS_NEED_IMG = "Mỗi news cần có hình ảnh";
    public static final String CANNOT_FIND_NEWS = "Không tìm thấy news cần chỉnh sửa";
    public static final String UPDATE_NEWS_FAIL = "Chỉnh sửa news không thành công";
    public static final String UPDATE_NEWS_OK = "Chỉnh sửa news thành công";
    public static final String LOCK_FOOTER_FAIL = "Đổi trạng thái Footer không thành công";
    public static final String LOCK_FOOTER_OK = "Đổi trạng thái Footer thành công";
    public static final String DELETE_FOOTER_FAIL = "Xoá footer không thành công";
    public static final String DELETE_FOOTER_OK = "Xoá footer thành công";
    public static final String INSERT_FOOTER_FAIL = "Thêm footer không thành công";
    public static final String INSERT_FOOTER_OK = "Thêm footer thành công";
    public static final String UPDATE_FOOTER_FAIL = "Chỉnh sửa footer không thành công";
    public static final String UPDATE_FOOTER_OK = "Chỉnh sửa footer thành công";
    public static final int TYPE_FOOTER = 1;
    public static final int TYPE_NEWS = 2;
    public static final int TYPE_QNA = 3;

}
