<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="en">
    <link rel="icon" href="assets/images/favicon.png" type="image/png" sizes="32x32">
    <jsp:include page="header.jsp"></jsp:include>
        <body class="hold-transition sidebar-mini">
            <div class="wrapper">
            <jsp:include page="navigation-bar.jsp"></jsp:include>
            <jsp:include page="menuPage.jsp"></jsp:include>
                <div class="content-wrapper">
                    <div class="content-header">
                        <div class="container-fluid">
                            <div class="row mb-2">
                                <div class="col-sm-6">
                                    <h1 class="m-0 text-dark">Thêm Tin Mới</h1>
                                </div>
                                <div class="col-sm-6">
                                    <ol class="breadcrumb float-sm-right">
                                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                                        <li class="breadcrumb-item active">Tin Tức</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                <jsp:include page="news/insert-page.jsp"></jsp:include>
                </div>
            <jsp:include page="footer.jsp"></jsp:include>
            <jsp:include page="loadScript.jsp"></jsp:include>
        </div>
    </body>
</html>
