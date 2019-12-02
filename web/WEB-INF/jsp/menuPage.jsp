<%-- 
    Document   : menuPage
    Created on : Jan 4, 2019, 9:56:56 PM
    Author     : VinhNT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <body>
        <div id="sidebar" class="sidebar responsive ace-save-state">
            <ul class="nav nav-list">
                <li class="">
                    <a href="index.htm">
                        <i class="menu-icon fa fa-tachometer blue"></i>
                        <span class="menu-text blue"> Dashboard </span>
                    </a>
                    <b class="arrow"></b>
                </li>
                <c:if test="${sessionScope.roleiz=='6' || sessionScope.roleiz=='7' || sessionScope.roleiz == '2'}">
                    <li>
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-list"></i>
                            <span class="menu-text"> Quản Lý Người Dùng</span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">
                            <li>
                                <a href="ListUser.htm?url=customer">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Quản Lý Khách Hàng
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="ListUser.htm?url=admin">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Quản Lý Nhân Viên
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li<c:if test="${sessionScope.roleiz=='7'}">>
                                    <a href="RankList.htm">
                                        <i class="menu-icon fa fa-caret-right"></i>
                                        Quản Lý Danh Hiệu
                                    </a>
                                    <b class="arrow"></b>
                                </c:if>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${sessionScope.roleiz=='5' || sessionScope.roleiz == '7' || sessionScope.roleiz == '9'}">
                    <li>
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-pencil-square-o"></i>
                            <span class="menu-text"> Quản Lý Sản Phẩm </span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">
                            <li class="">
                                <a href="brandpages.htm">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Thương Hiệu
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <c:if test="${sessionScope.roleiz == '9'}">
                                <li class="">
                                    <a href="brandpages.htm?deleted">
                                        <i class="menu-icon fa fa-caret-right"></i>
                                        Thương Hiệu Đã Xoá
                                    </a>
                                    <b class="arrow"></b>
                                </li>
                            </c:if>
                            <li class="">
                                <a href="category.htm?url=type">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Ngành Hàng
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="category.htm?url=cate">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Danh Mục
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="category.htm?url=deleted">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Danh Mục Đã Xoá
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <li>
                    <a href="" class="dropdown-toggle">
                        <i class="menu-icon fa fa-list-alt"></i>
                        <span class="menu-text"> Quản Lý Đấu Giá </span>
                        <b class="arrow fa fa-angle-down"></b>
                    </a>
                    <b class="arrow"></b>
                    <ul class="submenu">
                        <li>
                            <a href="SaleBid.htm">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Danh Sách Đấu Giá
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <c:if test="${sessionScope.roleiz=='7'}">
                            <li>
                                <a href="room.htm">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Phòng Đấu Giá
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.roleiz=='1'|| sessionScope.roleiz=='7'}">
                            <li>
                                <a href="Bidding.htm">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Phiên Đang Đấu
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.roleiz=='1'|| sessionScope.roleiz=='7'}">
                            <li>
                                <a href="Bidding.htm?bidExpired">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Phiên Bị Hủy & Hết Hạn
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </c:if>
                    </ul>
                </li>
                <li>
                    <a href="" class="dropdown-toggle">
                        <i class="menu-icon fa fa-list-alt"></i>
                        <span class="menu-text"> Quản Lý Mua Bán </span>
                        <b class="arrow fa fa-angle-down"></b>
                    </a>
                    <b class="arrow"></b>
                    <ul class="submenu">
                        <li>
                            <a href="SaleProduct.htm">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Danh Sách Sản Phẩm
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li
                            <c:if test="${sessionScope.roleiz=='2'}">class="hidden"</c:if>
                            <c:if test="${sessionScope.roleiz=='3'}">class="hidden"</c:if>>
                                <a href="Selling.htm">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Sản Phẩm Đang Bán
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>
                <c:if test="${sessionScope.roleiz=='4' || sessionScope.roleiz == '5' || sessionScope.roleiz == '7'}">
                    <li>
                        <a href="" class="dropdown-toggle">
                            <i class="menu-icon fa fa-list-alt"></i>
                            <span class="menu-text"> Quản Lý Bài Viết </span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">
                            <li>
                                <a href="news.htm?url=news">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Danh Sách Bài Viết
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li>
                                <a href="news.htm?url=typefooter">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Danh Sách Bài Viết Footer
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li>
                                <a href="video.htm">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Danh Sách Video
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${sessionScope.roleiz=='4' || sessionScope.roleiz == '5' || sessionScope.roleiz == '7'}">
                    <li>
                        <a href="" class="dropdown-toggle">
                            <i class="menu-icon fa fa-list-alt"></i>
                            <span class="menu-text"> Quản Lý Email </span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">
                            <li>
                                <a href="EmailContent.htm">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Danh Sách Email
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${sessionScope.roleiz=='3' || sessionScope.roleiz == '7'}">
                    <li>
                        <a href="" class="dropdown-toggle">
                            <i class="menu-icon fa fa-list-alt"></i>
                            <span class="menu-text">Quản Lý Nội Dung</span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">
                            <li>
                                <a href="banner.htm?url=content">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Ảnh các phần
                                </a>    
                            </li>
                            <li class="">
                                <a href="banner.htm?url=banner">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Banner
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li>
                                <a href="news.htm?url=qna">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Danh Sách Q&A
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>    
                </c:if>
                <c:if test="${sessionScope.roleiz=='3' || sessionScope.roleiz == '7'}">
                    <li>
                        <a href="" class="dropdown-toggle">
                            <i class="menu-icon fa fa-list-alt"></i>
                            <span class="menu-text"> Quản Lý Lịch Sử </span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">
                            <li>
                                <a href="payment.htm?HistoryDeposit">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Lịch Sử Đặt Cọc
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li>
                                <a href="HistoryRefund.htm">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Lịch Sử Hoàn Tiền
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li>
                                <a href="HistoryWinBid.htm">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Danh sách Thắng Phiên
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>
                </c:if>
            </ul>
            <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
                   data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
            </div>
        </div><!-- /.nav-list -->
    </body>
</html>
