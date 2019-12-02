<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
                            <li class="active">Menu</li>
                        </ul><!-- /.breadcrumb -->
                    </div>
                    <div class="page-content">
                        <div class="page-header">
                            <h1>
                                Danh sách Menu
                            </h1>
                        </div><!-- /.page-header <!-- /.page-header -->
                        <div class="row">
                            <div class="col-xs-12">
                                <c:if test="${sessionScope.roleiz=='9'}">
                                    <h4>
                                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Thêm Menu</button>
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
                                <div>
                                    <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>Menu</th>
                                                <th><a href ="MenuList.html">Số danh mục con</a></th>                 
                                                <th class="hidden-480">Trạng Thái</th>
                                                <th>Thao tác</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="menu" items="${menulist}" varStatus="counter">
                                                <tr>
                                                    <td>${counter.index +1}</td>
                                                    <td>
                                                        <c:forEach var="r" items="${type}">
                                                            <c:if test="${r.id == banner.type}">${r.name}</c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td style="text-align: center">
                                                        <img class="hidden-sm hidden-xs action-buttons"
                                                             src="${banner.image}" width="200" height="80">
                                                        <img class="hidden-md hidden-lg" src="${banner.image}" width="100"
                                                             height="40">
                                                    </td>
                                                    <td class="text-center hidden-480">
                                                        <span class="status_active">
                                                            <c:if test="${banner.active == true}">
                                                                <a href="banner.htm?lock&id=${banner.id}&status=${banner.active}">
                                                                    <i class="fa fa-unlock  bigger-150 blue"></i>
                                                                </a>
                                                            </c:if>
                                                            <c:if test="${banner.active == false}">
                                                                <a href="banner.htm?lock&id=${banner.id}&status=${banner.active}">
                                                                    <i class="fa fa-lock bigger-150 blue"></i>
                                                                </a>
                                                            </c:if>
                                                        </span>
                                                    </td>
                                                    <td>
                                                        <div class="hidden-sm hidden-xs action-buttons">
                                                            <a class="green" href="?get&id=${banner.id}&url=${url}">
                                                                <i class="aec-icon fa fa-pencil bigger-130"></i>
                                                            </a>
                                                        </div>
                                                        <div class="hidden-md hidden-lg">
                                                            <div class="inline pos-rel">
                                                                <button class="btn btn-minier btn-primary dropdown-toggle"
                                                                        data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                                </button>
                                                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                    <li>
                                                                        <a data-toggle="modal" data-target="#myModalUpdate_${banner.id}">
                                                                            <i class="aec-icon fa fa-pencil bigger-130"></i>
                                                                        </a>
                                                                    </li>
                                                                    <li>
                                                                        <a class="red"
                                                                           href="banner.htm?delete&id=${banner.id}"
                                                                           onclick="return confirm('Bạn có chắc chắn muốn xóa không')">
                                                                            <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                                        </a>
                                                                        </a>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                            <div class="modal fade" id="myModalUpdate_${banner.id}" role="dialog">
                                                <div class="modal-dialog">
                                                    <!-- Modal content-->
                                                    <form action="banner.htm" method="post" class="form-horizontal"
                                                          role="form" enctype="multipart/form-data">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                <h4 class="modal-title">Chỉnh sửa banner</h4>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button class="btn btn-primary btn-lg" type="submit" name="update">Cập nhật</button>
                                                                <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Đóng</button>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.page-content -->
            </div><!-- /.main-content -->
            <%@include file="footer.jsp" %>
        </div>
        <%@include file="loadScript.jsp" %>
    </body>
</html>