<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<link rel="icon" href="assets/images/favicon.png" type="image/png" sizes="32x32">
<body class="no-skin">
<%@include file="header.jsp" %>
<div class="main-container ace-save-state" id="main-container">
    <%@include file="menuPage.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="index.htm">Trang chủ</a>
                    </li>
                    <li class="active"><a href="SaleBid.htm">Đấu giá</a></li>
                    <li>Phiên đang đấu</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="page-header">
                    <h1>
                        Danh sách phiên đang đấu
                    </h1>
                </div><!-- /.page-header <!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="clearfix">
                            <div class="pull-right tableTools-container"></div>
                        </div>
                        <div class="table-header">
                            Danh sách phiên người đang đấu
                        </div>
                        <div>
                            <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="hidden-480">STT</th>
                                    <th>Mã phiên</th>
                                    <th>Người đấu</th>
                                    <th>Giá hiện tại</th>
                                    <th>Hạng</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:set var="index" value="0"/>
                                <c:forEach var="bid" items="${bidProducts}">
                                    <c:set var="index" value="${index + 1}"/>
                                    <tr>
                                        <td class="hidden-480">${index}</td>
                                        <td>${bid.biddingOrderCode}</td>
                                        <td>${bid.customerName}</td>
                                        <td>${bid.money}</td>
                                        <td>${bid.rank}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div><!-- /.main-content -->
    <%@include file="footer.jsp" %>
</div>
<jsp:include page="loadScript.jsp"></jsp:include>
</body>
</html>