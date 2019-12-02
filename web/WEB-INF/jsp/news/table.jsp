<%-- 
    Document   : table
    Created on : Oct 4, 2019, 10:26:35 AM
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
                Danh sách bài viết
            </div>
            <div>
                <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tiêu đề</th>
                            <th>Chuyên Mục</th>
                            <c:if test="${url == 'news'}">
                            <th>Ảnh đại diện</th>
                            </c:if>
                            <th class="hidden-480">Tình trạng</th>
                            <th>Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="news" items="${listnews}" varStatus="counter">
                        <tr>
                            <td>${counter.index + 1}</td>
                            <td>${news.title}</td>
                            <td>
                        <c:forEach var="r" items="${typenews}">
                            <c:if test="${r.id == news.type}">${r.name}</c:if>
                        </c:forEach>
                        </td>
                        <c:if test="${url == 'news'}">
                        <td style="text-align: center">
                            <img class="hidden-sm hidden-xs action-buttons" src="${news.avatar}"
                                 width="200" height="80">
                            <img class="hidden-md hidden-lg" src="${news.avatar}" width="100"
                                 height="40">
                        </td>
                        </c:if>
                        <td class="text-center hidden-480">
                            <span class="status_active">
                                <c:if test="${news.active == true}">
                                    <a href="news.htm?lock&id=${news.id}&status=${news.active}&url=${url}">
                                        <i class="fa fa-unlock bigger-150 blue"></i>
                                    </a>
                                </c:if>
                                <c:if test="${news.active == false}">
                                    <a href="news.htm?lock&id=${news.id}&status=${news.active}&url=${url}">
                                        <i class="fa fa-lock bigger-150 blue"></i>
                                    </a>
                                </c:if>
                            </span>
                        </td>
                        <td>
                            <div class="hidden-sm hidden-xs action-buttons">
                                <a class="red" href="news.htm?delete&id=${news.id}&url=${url}"
                                   onclick="return confirm('Bạn có chắc chắn muốn xóa không')">
                                    <i class="ace-icon fa fa-trash bigger-150"></i>
                                </a>
                                <a class="green" href="?get&id=${news.id}&url=${url}">
                                    <i class="ace-icon fa fa-pencil bigger-150"></i>
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
                                            <a class="green">
                                                <i class="ace-icon fa fa-pencil bigger-130">
                                                </i>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</html>
