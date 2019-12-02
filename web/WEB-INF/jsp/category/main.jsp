<%-- 
    Document   : main
    Created on : Oct 4, 2019, 1:40:27 PM
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
                     <c:if test="${url == 'type'}">
                    <li class="active">Ngành Hàng</li>
                     </c:if>
                    <c:if test="${url == 'cate'}">
                        <li class="active">Danh Mục</li>
                    </c:if>
                </ul>
            </div>
            <div class="page-content">
                <div class="page-header">
                    <c:if test="${url == 'type'}">
                        <h1>
                            Danh sách ngành hàng
                        </h1>
                    </c:if>
                    <c:if test="${url == 'cate'}">
                        <h1>
                            Danh sách danh mục
                        </h1>
                    </c:if>
                </div><!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${sessionScope.roleiz == 9 || url == 'cate'}">
                            <h4>
                                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Thêm Danh Mục</button>
                                <!-- Modal -->
                                <div class="modal fade" id="myModal" role="dialog">
                                    <div class="modal-dialog">
                                        <!-- Modal content-->
                                        <form action="category.htm" method="post" modelAttribute="account" class="form-horizontal"
                                              role="form" enctype="multipart/form-data">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Thêm Danh Mục</h4>
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
                        <%@include file="table.jsp" %>
                    </div>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div>
</html>
