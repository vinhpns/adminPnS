<%-- 
    Document   : main
    Created on : Oct 9, 2019, 6:36:27 PM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="index.htm">Trang chủ</a>
                    </li>
                    <li class="active">Mua Bán</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="page-header">
                    <h1>
                        Quản Lý Các Sản Phẩm Bán
                    </h1>
                </div><!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12">
                        <h4>
                            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Thêm Sản Phẩm</button>
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <form action="SaleProduct.htm" method="post" modelAttribute="account" class="form-horizontal"
                                          role="form" enctype="multipart/form-data">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title">Thêm Sản Phẩm</h4>
                                            </div>
                                            <div class="modal-body">
                                                <%@include file="insert-modal.jsp" %>
                                            </div>
                                            <div class="modal-footer">
                                                <button class="btn btn-primary btn-lg" type="submit" name="insert">Thêm Mới</button>
                                                <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </h4>
                        <%@include file="table.jsp" %>
                    </div><!-- /.page-content -->
                </div>
            </div><!-- /.page-content -->
        </div>
    </div>
</html>
