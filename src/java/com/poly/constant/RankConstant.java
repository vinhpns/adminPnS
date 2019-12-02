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
public class RankConstant {
    
    //Model key
    public static final String RANK_LIST = "rank";
    
    //Default Path
    public static final String URL_SERVER = ConstantManager.URL_SHOW_IMG + "rank/";
    public static final String URL_STORE_SERVER = ConstantManager.FOLDER_CONTAIN_IMG + "rank/";
    
    //return page
    public static final String RANK_PAGE = "RankList";
    
    //request param
    public static final String NAME_REQUEST_PARAM = "name";
    public static final String REQUIRED_POINT_REQUEST_PARAM = "requirePoint";
    public static final String ICON_REQUEST_PARAM = "icon";
    public static final String ID_REQUEST_PARAM = "id";
    
    //Message
    public static final String RANK_EXITS = "Đã tồn tại danh hiệu!";
    public static final String RANK_UPLOAD_IMG_FAIL = "Úp ảnh bị lỗi";
    public static final String INSERT_FAIL = "Thêm danh hiệu không thành công";
    public static final String INSERT_OK = "Thêm danh hiệu thành công";
    public static final String UPDATE_OK = "Chỉnh sửa danh hiệu thành công";
    public static final String UPDATE_FAIL = "Chỉnh sửa danh hiệu không thành công";
    public static final String RANK_CANNOT_FIND = "Không tìm thấy Danh hiệu cần chỉnh sửa";
    public static final String REDIRECT_UPDATE_PAGE = "UpdateRank";
}
