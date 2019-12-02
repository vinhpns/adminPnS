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
                    <li class="active"><a href="Selling.htm">Đấu giá</a></li>
                    <li>Hàng đang bán</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="page-header">
                    <h1>
                        Danh sách sản phẩm
                    </h1>
                </div><!-- /.page-header <!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="clearfix">
                            <div class="pull-right tableTools-container"></div>
                        </div>
                        <div class="table-header">
                            Danh sách sản phẩm đang bán
                        </div>
                        <div>
                            <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="hidden-480">STT</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Mã phiên</th>
                                    <th>Giá đấu</th>
                                    <th class="hidden-480">Loại phiên</th>
                                    <th>Thao Tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:set var="index" value="0"/>
                                <c:forEach var="sell" items="${sellProducts}">
                                    <c:set var="index" value="${index + 1}"/>
                                    <tr>
                                        <td class="hidden-480">${index}</td>
                                        <td>${sell.name}</td>
                                        <td>${sell.orderCode}</td>
                                        <td>${sell.maxMoney}</td>
                                        <td>
                                            <div class="form-check">
                                                <input type="checkbox" class="form-check-input" id="materialUnchecked"
                                                       checked onClick="this.checked = !this.checked;">
                                                <c:if test="${sell.vip == true}">
                                                    <label class="form-check-label" for="materialUnchecked">Vip</label>
                                                </c:if>
                                                <c:if test="${sell.vip == false}">
                                                    <label class="form-check-label"
                                                           for="materialUnchecked">Thường</label>
                                                </c:if>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a href="Selling.htm?editSale&ordercode=${sell.orderCode}&url=Selling.htm">
                                                    <i title="Chỉnh sửa" class="ace-icon fa fa-pencil bigger-130"></i>
                                                </a>
                                                <a class="red"
                                                   href="Selling.htm?deleteSelling&ordercode=${sell.orderCode}">
                                                    <i title="Huỷ phiên" class="ace-icon fa fa-trash bigger-130"></i>
                                                </a>                                                
                                            </div>
                                        </td>
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