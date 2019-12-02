<%-- 
    Document   : main-update
    Created on : Oct 23, 2019, 10:02:52 AM
    Author     : ADMIN
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
                        <a href="index.htm">Home</a>
                    </li>
                    <li>
                        <a href="brandpages.htm">Quản Lý Thương Hiệu</a>
                    </li>
                    <li class="active">Thương Hiệu</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <!-- /.ace-settings-container -->
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="modal-header no-padding">
                            <div class="table-header">
                                Cập nhập Thương Hiệu
                            </div>
                        </div>
                        <form action="brandpages.htm" method="post" class="form-horizontal" role="form"
                              enctype="multipart/form-data">
                            <%@include file="form-update.jsp" %>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
        </div>
    </div>
</html>
