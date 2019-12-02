<%-- 
    Document   : main-update
    Created on : Oct 23, 2019, 9:48:29 AM
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
                        <c:if test="${url =='content'}">
                            <a href="banner.htm">Quản Lý Nội Dung</a>
                        </c:if>
                        <c:if test="${url =='banner'}">
                            <a href="banner.htm">Quản Lý Banner</a>
                        </c:if>
                    </li>
                    <c:if test="${url == 'content'}">
                        <li class="active">Chỉnh sửa Nội dung</li>
                        </c:if>
                        <c:if test="${url == 'banner'}">
                        <li class="active">Chỉnh sửa Banner</li>
                        </c:if>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="modal-header no-padding">
                            <div class="table-header">
                                <c:if test="${url == 'banner'}">
                                    Sửa thông tin banner
                                </c:if>
                            </div>
                            <div class="table-header">
                                <c:if test="${url == 'content'}">
                                    Sửa thông tin nội dung
                                </c:if>
                            </div>
                        </div>
                        <form action="banner.htm" method="post" modelAttribute="ban" class="form-horizontal" role="form"
                              enctype="multipart/form-data">
                            <%@include file="form-update.jsp" %>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
        </div>
    </div>
</html>
