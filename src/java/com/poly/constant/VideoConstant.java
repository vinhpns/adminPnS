/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.constant;

import com.poly.tool.ConstantManager;

/**
 * @author Kiet
 */
public class VideoConstant {
    //Path
    public static final String VIDEO_PAGE = "ListVideo";

    public static final String URL_SERVER = ConstantManager.URL_SHOW_IMG + "video/";

    public static final String URL_STORE_SERVER = ConstantManager.FOLDER_CONTAIN_IMG + "video/";

    public static final String UPDATE_VIDEO_PAGE = "EditVideo";

    //Keys

    public static final String LIST_VIDEO_KEY = "videoList";
    public static final String VIDEO_BY_ID_KEY = "video";
    public static final String TYPE_VIDEO_KEY = "typeVideo";

    //Param

    public static final String VIDEO_PARAM_ID = "id";
    public static final String VIDEO_PARAM_STATUS = "status";
    public static final String LINK_PARAM = "link";
    public static final String TYPE_ID_PARAM = "typeId";
    public static final String IMAGES_PARAM = "images";
    public static final String TITLE_PARAM = "title";

    //Messages
    public static final String LOCK_VIDEO_FAIL = "Đổi trạng thái video không thành công";
    public static final String LOCK_VIDEO_OK = "Đổi trạng thái video thành công";
    public static final String DELETE_FAIL = "Xóa video không thành công";
    public static final String DELETE_OK = "Xóa video thành công";
    public static final String INSERT_OK = "Thêm video thành công";
    public static final String INSERT_FAIL = "Thêm video không thành công";
    public static final String UPDATE_OK = "Chỉnh sửa thông tin video thành công";
    public static final String UPDATE_FAIL = "Chỉnh sửa thông tin video không thành công";
}
