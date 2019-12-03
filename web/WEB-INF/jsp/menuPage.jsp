<%-- 
    Document   : menuPage
    Created on : Jan 4, 2019, 9:56:56 PM
    Author     : VinhNT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <a href="index3.html" class="brand-link">
            <img src="http://daotaomamnon.com/wp-content/uploads/2019/03/logo-trung-cap-sai-gon.jpeg" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">Trung cấp Sài Gòn</span>
        </a>
        <div class="sidebar">
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="assets/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">${sessionScope.loginName}</a>
                </div>
            </div>
            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fa fa-pie-chart"></i>
                            <p>
                                Tài Khoản
                                <i class="right fa fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="ListUser.htm" class="nav-link">
                                    <i class="fa fa-circle-o nav-icon"></i>
                                    <p>Danh sách tài khoản</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fa fa-tree"></i>
                            <p>
                                Menu
                                <i class="fa fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="menu.htm" class="nav-link">
                                    <i class="fa fa-circle-o nav-icon"></i>
                                    <p>Danh sách Menu</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fa fa-edit"></i>
                            <p>
                                Bài Viết
                                <i class="fa fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="news.htm?type=1" class="nav-link">
                                    <i class="fa fa-circle-o nav-icon"></i>
                                    <p>Menu</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="news.htm?type=2" class="nav-link">
                                    <i class="fa fa-circle-o nav-icon"></i>
                                    <p>Tin Tức</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="news.htm?type=3" class="nav-link">
                                    <i class="fa fa-circle-o nav-icon"></i>
                                    <p>Sự Kiện</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="news.htm?type=4" class="nav-link">
                                    <i class="fa fa-circle-o nav-icon"></i>
                                    <p>Footer</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fa fa-table"></i>
                            <p>
                                Nội Dung Web
                                <i class="fa fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="pages/tables/simple.html" class="nav-link">
                                    <i class="fa fa-circle-o nav-icon"></i>
                                    <p>Banner</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-header" style="font-size: 18px">Comment</li>
                    <li class="nav-item">
                        <a href="comment.htm" class="nav-link">
                            <i class="nav-icon fa fa-calendar"></i>
                            <p>
                                Comment
                                <span class="badge badge-info right">${sessionScope.commentNotRead}</span>
                            </p>
                        </a>
                    </li>
                    <li class="nav-header" style="font-size: 18px">Học Viên</li>
                    <li class="nav-item">
                        <a href="register.htm" class="nav-link">
                            <i class="nav-icon fa fa-file"></i>
                            <p>Danh sách đăng ký
                                <span class="badge badge-info right">2</span>
                            </p>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
</html>
