<%-- 
    Document   : table
    Created on : Oct 4, 2019, 1:41:05 PM
    Author     : SGDG Company
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="row">
        <div class="col-xs-12">
            <div class="clearfix">
                <div class="pull-right tableTools-container"></div>
            </div>
            <div class="table-header">
                Danh sách các ngành hàng
            </div>
            <div>
                <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên Danh Mục</th>
                                <c:if test="${ url == 'cate'}">
                                <th>Ngành Hàng</th>
                                </c:if>
                                <c:if test="${ url == 'type'}">
                                <th>Icon</th>
                                </c:if>
                            <th class="hidden-480">Trạng Thái</th>
                            <th>Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="category" items="${listcategory}" varStatus="counter">
                            <tr>
                                <td>${counter.index + 1}</td>
                                <td>${category.name}</td>
                                <c:if test="${url == 'cate'}">
                                    <td>
                                        <c:forEach var="type" items="${listcategorytypes}" >
                                            <c:if test="${type.id == category.parentId}">${type.name}</c:if>
                                        </c:forEach>
                                    </td>
                                </c:if>
                                <c:if test="${url == 'type'}">
                                    <td style="text-align: center">
                                        <img class="hidden-sm hidden-xs action-buttons"
                                             src="${category.icon}" width="100" height="80">
                                        <img class="hidden-md hidden-lg" src="${category.icon}"
                                             width="50" height="40">
                                    </td>
                                </c:if>
                                <td class="text-center hidden-480">
                                    <span class="status_active">
                                        <c:if test="${category.active == true}">
                                            <a href="?lock&id=${category.id}&status=${category.active}&url=${url}"
                                               onclick="return confirm('Bạn có muốn khóa lựa chọn này không ?')">
                                                <i class="fa fa-unlock bigger-150"></i>
                                            </a>
                                        </c:if>
                                        <c:if test="${category.active == false}">
                                            <a href="?lock&id=${category.id}&status=${category.active}&url=${url}"
                                               onclick="return confirm('Bạn có muốn mở khóa lựa chọn này không ?')">
                                                <i class="fa fa-lock bigger-150"></i>
                                            </a>
                                        </c:if>
                                    </span>
                                </td>
                                <td>
                                    <div class="hidden-sm hidden-xs action-buttons">
                                        <c:if test="${url == 'cate'}">
                                            <i class="ace-icon fa fa-pencil bigger-130 green" data-toggle="modal" data-target="#myModalUpdate_${category.id}"></i>
                                            <a class="red" href="?delete&id=${category.id}&url=${url}"
                                               onclick="return confirm('Bạn có chắc chắn muốn xóa không')">
                                                <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                            </a>
                                        </c:if>
                                        <c:if test="${sessionScope.roleiz == 9 && url != 'cate'}">
                                            <a class="red" href="?delete&id=${category.id}&url=${url}"
                                               onclick="return confirm('Bạn có chắc chắn muốn xóa không')">
                                                <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                            </a>
                                        </c:if>
                                        <c:if test="${url == 'type'}">
                                            <a class="green" href="?get&id=${category.id}&url=${url}">
                                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                                            </a>
                                        </c:if>

                                    </div>
                                    <div class="hidden-md hidden-lg">
                                        <div class="inline pos-rel">
                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                    data-toggle="dropdown" data-position="auto">
                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                            </button>
                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                <li>
                                                    <c:if test="${category.active == true}">
                                                        <a href="?lock&id=${category.id}&status=${category.active}&url=${url}"
                                                           onclick="return confirm('Bạn có muốn khóa lựa chọn này không ?')">
                                                            <i class="fa fa-unlock bigger-150"></i>
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${category.active == false}">
                                                        <a href="?lock&id=${category.id}&status=${category.active}&url=${url}"
                                                           onclick="return confirm('Bạn có muốn mở khóa lựa chọn này không ?')">
                                                            <i class="fa fa-lock bigger-150"></i>
                                                        </a>
                                                    </c:if>
                                                </li>
                                                <li>
                                                    <c:if test="${url == 'cate'}">
                                                        <i class="ace-icon fa fa-pencil bigger-130 green" data-toggle="modal" data-target="#myModalUpdate_${category.id}"></i>
                                                    </c:if>
                                                    <c:if test="${url == 'type'}">
                                                        <a class="green" href="?get&id=${category.id}&url=${url}">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                        </a>
                                                    </c:if>
                                                </li>
                                                <li>
                                                    <a class="red" href="?delete&id=${category.id}&url=${url}"
                                                       onclick="return confirm('Bạn có chắc chắn muốn xóa không')">
                                                        <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        <div class="modal fade" id="myModalUpdate_${category.id}" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <form action="category.htm" method="post" modelAttribute="account" class="form-horizontal"
                                      role="form" enctype="multipart/form-data">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Chỉnh sửa danh mục</h4>
                                        </div>
                                        <div class="modal-body">
                                            <%@include file="update-modal.jsp" %>
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
</html>
