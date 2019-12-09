<%-- 
    Document   : index
    Created on : Aug 14, 2018, 12:08:57 PM
    Author     : ASUS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="header.jsp"></jsp:include>
        <body class="hold-transition sidebar-mini">
            <div class="wrapper">
            <jsp:include page="navigation-bar.jsp"></jsp:include>
            <jsp:include page="menuPage.jsp"></jsp:include>
                <div class="content-wrapper">
                    <section class="content-header">
                        <div class="container-fluid">
                            <div class="row mb-2">
                                <div class="col-sm-6">
                                    <h1>Bài Viết</h1>
                                </div>
                                <div class="col-sm-6">
                                    <ol class="breadcrumb float-sm-right">
                                        <li class="breadcrumb-item"><a href="index.htm">Home</a></li>
                                        <li class="breadcrumb-item active">Tin Tức</li>
                                    </ol>
                                </div>
                            </div>
                        </div><!-- /.container-fluid -->
                    </section>
                    <section class="content">
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h3 class="card-title">Danh sách các bài viết</h3>
                                    </div>
                                    <button type="button" style="font-size: 20px; width: 200px; margin-left: 25px; margin-top: 25px; background-color: black" class="btn btn-info btn-lg" data-toggle="modal">
                                        <a href="?insert&type=${type}">Thêm bài viết</a>
                                </button>
                                <div class="card-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr style="color: #fff; background-color: #17a2b8">
                                                <th style="width:80px">Tiêu Đề</th>
                                                <th style="width:80px">Tác Giả</th>
                                                <th style="width:125px">Chuyên Mục</th>
                                                <th style="max-width: 200px">Ảnh Đại Diện</th>
                                                <th style="width:80px">Lượt Xem</th>
                                                <th style="width:80px">Thao tác</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="news" items="${newsList}">
                                                <tr>
                                                    <td>${news.title}</td>
                                                    <td>${news.createdBy}</td>
                                                    <td>
                                                        <c:if test="${news.type == 1}">Menu</c:if>
                                                        <c:if test="${news.type == 2}">Tin Tức</c:if>
                                                        <c:if test="${news.type == 3}">Event</c:if>
                                                        <c:if test="${news.type == 4}">Footer</c:if>
                                                        </td>
                                                        <td style="text-align: center"><img src="${news.avatar}" style="width: 20%"></td>
                                                    <td>${news.view}</td>
                                                    <td>
                                                        <c:if test="${news.active == true}">
                                                            <a href="?changeStatus&id=${news.id}&status=${news.active}">
                                                                <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa tài khoản"></i>
                                                            </a>
                                                        </c:if>
                                                        <c:if test="${news.active == false}">
                                                            <a href="?id=${news.id}&status=${news.active}">
                                                                <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa tài khoản"></i>
                                                            </a>
                                                        </c:if>
                                                        <a href="?edit&id=${news.id}">
                                                            <i class="fa fa-edit" style="color: blue; font-size: 16px" title="Chỉnh sửa"></i>
                                                        </a>
                                                        <a href="?delete&id=${news.id}">
                                                            <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa tài khoản"></i>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
            </div>
        <jsp:include page="loadScript.jsp"></jsp:include>
    </body>
</html>