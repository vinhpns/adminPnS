<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <li class="active">Banner</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="page-header">
                    <h1>
                        Danh sách Banner
                    </h1>
                </div><!-- /.page-header <!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${sessionScope.roleiz=='9'}">
                            <h4>
                                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Thêm Banner</button>
                                <!-- Modal -->
                                <div class="modal fade" id="myModal" role="dialog">
                                    <div class="modal-dialog">
                                        <!-- Modal content-->
                                        <form action="banner.htm" method="post" modelAttribute="account" class="form-horizontal"
                                              role="form" enctype="multipart/form-data">

                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Thêm Banner</h4>
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
                        </c:if>
                        <div class="clearfix">
                            <div class="pull-right tableTools-container"></div>
                        </div>
                        <div class="table-header">
                            Danh sách banner
                        </div>
                        <%@include file="table.jsp" %>
                    </div>
                </div>
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div><!-- /.main-content -->
</html>
