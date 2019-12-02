<%-- 
    Document   : customerList
    Created on : Jan 4, 2019, 8:35:22 PM
    Author     : VinhNT
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
                    <li class="active">
                        <a href="HistoryRefund.htm">Hoàn tiền</a>
                    </li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <!-- /.ace-settings-container -->
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="clearfix">
                                    <div class="pull-right tableTools-container"></div>
                                </div>
                                <div class="table-header">
                                    Danh Sách Người cần hoàn tiền
                                </div>
                                <div>
                                    <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>STT</th>
                                            <th>Mã phiên</th>
                                            <th>Họ tên khách hàng</th>
                                            <th>Số tiền</th>
                                            <th>Status</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="a" items="${refundDetail}" varStatus="count">
                                            <tr>
                                                <td>${count.index + 1}</td>
                                                <td>${a.biddingOrderCode}</td>
                                                <td>${a.fullName}</td>
                                                <td>${a.money}</td>
                                                <td class="hidden-480">
                                                    <c:if test="${a.paid == true}"><span
                                                            class="label label-sm label-warning">Đã Thanh Toán</span></c:if>
                                                    <c:if test="${a.paid == false}">
                                                        <a href="?paid&id=${a.biddingOrderCode}&accountId=${a.customerAccountId}">
                                                            <span class="label label-sm label-warning">Chưa Thanh Toán</span>
                                                        </a>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
    <%@include file="footer.jsp" %>
</div>
<%@include file="loadScript.jsp" %>
</body>
</html>
