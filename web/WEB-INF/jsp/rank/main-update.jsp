<%-- 
    Document   : main-update
    Created on : Oct 23, 2019, 1:32:25 PM
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
                        <a href="RankList.htm">Quản Lý danh hiệu</a>
                    </li>
                    <li class="active">Chỉnh sửa danh hiệu</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <!-- /.ace-settings-container -->
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="modal-header no-padding">
                            <div class="table-header">
                                Chỉnh sửa danh hiệu
                            </div>
                        </div>
                        <form action="RankList.htm" method="post" class="form-horizontal" role="form"
                              enctype="multipart/form-data">
                            <%@include file="form-update.jsp" %>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
        </div>
    </div>
</html>
