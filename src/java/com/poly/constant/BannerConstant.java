package com.poly.constant;

import com.poly.tool.ConstantManager;

public class BannerConstant {

    //Default Character
    public static final int BANNER_TYPE = 1;
    public static final int CONTENT_TYPE = 2;
    public static final int TYPE_BANNER_MAIN_HOME_ID = 1;
    public static final int TYPE_BANNER_SUBMAIN_HOME_ID = 2;
    public static final int TYPE_BANNER_LEFT_HOME_ID = 3;
    public static final int TYPE_BANNER_LAST_HOME_ID = 4;
    public static final int TYPE_BANNER_NEWS_HOME_ID = 5;
    public static final int LOGO_WEB = 5;
    public static final int BANNER_BIG_INTRODUCE = 6;
    public static final int BANNER_SUB_INTRODUCE = 7;
    public static final int HISTORY_INTRODUCE = 8;
    public static final int STUCTURE_INTRODUCE = 9;
    public static final int PARTNER_INTRODUCE = 10;
    public static final int ACTIVE_INTRODUCE = 11;
    public static final int RULE_INTRODUCE = 12;
    public static final int PROCESS = 13;
    public static final int BANNER_BIG_HELP = 14;
    public static final int BANNER_SUB_HELP = 15;

    public static final String TYPE_BANNER_MAIN_HOME = "Trang chủ chính";
    public static final String TYPE_BANNER_SUBMAIN_HOME = "Trang chủ - 3 cục dưới";
    public static final String TYPE_BANNER_LEFT_HOME = "Trang chủ - Trái";
    public static final String TYPE_BANNER_LAST_HOME = "Trang chủ - Cuối";
    public static final String BANNER_BIG_INTRODUCE_TITLE = "Ảnh lớn trang giới thiệu";
    public static final String BANNER_SUB_INTRODUCE_TITLE = "Ảnh nhỏ trang giới thiệu";
    public static final String HISTORY_INTRODUCE_TITLE = "Ảnh lịch sử trang giới thiệu";
    public static final String STUCTURE_INTRODUCE_TITLE = "Ảnh cơ cấu trang giới thiệu";
    public static final String PARTNER_INTRODUCE_TITLE = "Ảnh giới thiệu công ty đối tác";
    public static final String ACTIVE_INTRODUCE_TITLE = "Ảnh giới thiệu trạng thái";
    public static final String RULE_INTRODUCE_TITLE = "Ảnh giới thiệu điều khoản";
    public static final String PROCESS_TITLE = "Ảnh quá trình";
    public static final String BANNER_BIG_HELP_TITLE = "Ảnh bìa hỗ trợ lớn";
    public static final String BANNER_SUB_HELP_TITLE = "Ảnh bìa hỗ trợ phụ";
    //path
    public static final String BANNER_RETURN_PAGE = "banner";
    public static final String CONTENT_WEB_PAGE = "Content";
    public static final String URL_SERVER = ConstantManager.URL_SHOW_IMG + "banner/";
    public static final String URL_STORE_SERVER = ConstantManager.FOLDER_CONTAIN_IMG + "banner/";

    public static final String BANNER_INSERT_REDIRECT_PAGE = "InsertBanner";

    public static final String BANNER_EDIT_REDIRECT_PAGE = "EditBanner";

    //Request Param
    public static final String ID_PARAM = "id";

    public static final String STATUS_PARAM = "status";

    public static final String LINK_PARAM = "link";

    public static final String TYPE_ID_PARAM = "typeId";

    public static final String IMG_PARAM = "images";

    public static final String ACTIVE_PARAM = "active";

    //Key Model
    public static final String LIST_BANNER_KEY = "bannerList";

    public static final String BANNER_FIND_KEY = "banner";

    public static final String TYPE_BANNER_KEY = "type";


    //Message Error
    public static final String DELETE_BANNER_FAIL = "Xoá banner không thành công";

    public static final String DELETE_BANNER_OK = "Xoá banner thành công";

    public static final String LOCK_BANNER_FAIL = "Đổi trạng thái banner không thành công";

    public static final String LOCK_BANNER_OK = "Đổi trạng thái banner thành công";

    public static final String INSERT_BANNER_FAIL = "Thêm banner không thành công";

    public static final String INSERT_BANNER_OK = "Thêm banner thành công";

    public static final String UPDATE_BANNER_FAIL = "Chỉnh sửa banner không thành công";

    public static final String UPDATE_BANNER_OK = "Chỉnh sửa banner thành công";

    public static final String CANNOT_FIND_BANNER = "Không tìm thấy banner cần chỉnh sửa";

    public static final String BANNER_NEED_IMG = "Mỗi banner cần có hình ảnh";
    
    public static final String BANNER_EXITS = "Banner đã tồn tại"; 
}
