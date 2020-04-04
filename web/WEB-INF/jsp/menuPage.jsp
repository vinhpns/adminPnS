<%-- 
    Document   : menuPage
    Created on : Jan 4, 2019, 9:56:56 PM
    Author     : 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <a href="index.htm" class="brand-link">
            <img src="${sessionScope.info.logo}" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
                 style="opacity: .8; width:22%">
            <span class="brand-text font-weight-light" style="white-space: normal">${sessionScope.info.name}</span>
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
                    <jsp:include page="menu/account.jsp"></jsp:include>
                    <jsp:include page="menu/news.jsp"></jsp:include>
                    <jsp:include page="menu/content.jsp"></jsp:include>
                    <jsp:include page="menu/img.jsp"></jsp:include>
                    <jsp:include page="menu/info.jsp"></jsp:include>
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
                </ul>
            </nav>
        </div>
    </aside>
</html>
