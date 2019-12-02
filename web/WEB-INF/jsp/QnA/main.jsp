<%-- 
    Document   : newjsp
    Created on : Oct 4, 2019, 10:23:35 AM
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
                    <li class="active">Tin Tức</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="page-header">
                    <h1>
                        Danh sách bài viết
                    </h1>
                </div><!-- /.page-header <!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12">
                        <h4>
                            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Thêm Tin Tức</button>
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <form action="ListNews.htm" method="post" modelAttribute="account" class="form-horizontal"
                                          role="form" enctype="multipart/form-data">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title">Thêm Tin Tức</h4>
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
                        <div class="clearfix">
                            <div class="pull-right tableTools-container"></div>
                        </div>
                        <div class="table-header">
                            Danh sách tin tức và bài viết
                        </div>
                        <%@include file="table.jsp" %>
                    </div>
                </div>
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div><!-- /.main-content -->
</html>
