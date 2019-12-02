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
<link rel="icon" href="assets/images/favicon.png" type="image/png" sizes="32x32">
<%@include file="header.jsp" %>
<body class="no-skin">
<div class="main-container ace-save-state" id="main-container">
    <%@include file="menuPage.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="index.htm">Home</a>
                    </li>
                    <li>
                        <a href="room.htm">Quản Lý phòng đấu giá</a>
                    </li>
                    <li class="active">Thêm phòng đấu</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <!-- /.ace-settings-container -->
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="modal-header no-padding">
                            <div class="table-header">
                                Chỉnh sửa phòng
                            </div>
                        </div>
                        <form action="room.htm" method="post" modelAttribute="room" class="form-horizontal" role="form"
                              enctype="multipart/form-data">
                            <div class="col-xs-12 col-sm-4">
                                <div class="widget-box">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div>
                                                <input type="hidden" value="${roomDetail.id}" name="id"/>
                                                <label for="form-field-8">Tên phòng</label>
                                                <input value="${roomDetail.name}" type="text" id="txt_box"
                                                       placeholder="Nhập tên" class="autosize-transition form-control"
                                                       name="name"
                                                       style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- /.span -->
                            <div class="col-xs-12 col-sm-4">
                                <div class="widget-box">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div>
                                                <label for="form-field-8">Thời gian đấu tối đa</label>
                                                <input value="${roomDetail.duration}" type="number" id="form-field-11"
                                                       placeholder="Nhập bao nhiêu giờ"
                                                       class="autosize-transition form-control" name="duration"
                                                       style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- /.span -->
                            <div class="col-xs-12 col-sm-4">
                                <div class="widget-box">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div>
                                                <label for="form-field-8">Số tiền tối thiểu</label>
                                                <input value="${roomDetail.min}" type="number" id="form-field-11"
                                                       placeholder="Nhập số tiền"
                                                       class="autosize-transition form-control" name="min"
                                                       style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-4">
                                <div class="widget-box">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div>
                                                <label for="form-field-8">Số tiền tối đa</label>
                                                <input value="${roomDetail.max}" type="number" id="form-field-11"
                                                       placeholder="Nhập số tiền"
                                                       class="autosize-transition form-control" name="max"
                                                       style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-4">
                                <div class="widget-box">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div>
                                                <label for="form-field-8">Bước giá</label>
                                                <input value="${roomDetail.step}" type="number" id="form-field-11"
                                                       placeholder="Nhập bước giá"
                                                       class="autosize-transition form-control" name="step"
                                                       style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-4">
                                <div class="widget-box">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <br>
                                            <div class="col-md-6">
                                                <button style="float: right; border-radius: 10px"
                                                        class="btn btn-primary btn-lg" type="submit" name="updateRoom">
                                                    Cập nhật
                                                </button>
                                            </div>
                                            <div>
                                                <button style="border-radius: 10px" type="reset" value="Reset"
                                                        onclick="goBack()" class="btn btn-primary btn-lg">Quay Lại
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </div>
</div>
<jsp:include page="loadScript.jsp"></jsp:include>
<script src="assets/js/loadImg.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="assets/js/checkinput.js"></script>
</body>
</html>
