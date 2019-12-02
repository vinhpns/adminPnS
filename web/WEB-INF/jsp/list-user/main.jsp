<%-- 
    Document   : main
    Created on : Sep 29, 2019, 11:30:08 AM
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
                    <li class="active">Danh sách tài khoản</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Thêm Tài Khoản</button>
                        <!-- Modal -->
                        <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <form action="ListUser.htm" method="post" modelAttribute="account" class="form-horizontal"
                                      role="form" enctype="multipart/form-data">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Thêm Tài Khoản</h4>
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
                        <div class="row">
                            <%@include file="list.jsp" %>
                        </div>
                    </div>
                </div>
                <!-- PAGE CONTENT ENDS -->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</html>
