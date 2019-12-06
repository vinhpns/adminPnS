<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr style="color: #fff; background-color: #17a2b8">
                <th style="width:80px">Tiêu Đề</th>
                <th style="width:80px">Tác Giả</th>
                <th style="width:125px">Chuyên Mục</th>
                <th style="max-width: 200px">Ảnh Đại Diện</th>
                <th style="width:80px">Lượt Xem</th>
                <th style="width:80px">Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="news" items="${newsList}">
                <tr>
                    <td>${news.title}</td>
                    <td>${news.createdBy}</td>
                    <td>
                        <c:if test="${news.type == 1}">Menu</c:if>
                        <c:if test="${news.type == 2}">Tin Tức</c:if>
                        <c:if test="${news.type == 3}">Event</c:if>
                        <c:if test="${news.type == 4}">Footer</c:if>
                        </td>
                        <td style="text-align: center"><img src="${news.avatar}" style="width: 20%"></td>
                    <td>${news.view}</td>
                    <td>
                        <c:if test="${news.active == true}">
                            <a href="?changeStatus&id=${news.id}&status=${news.active}">
                                <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa tài khoản"></i>
                            </a>
                        </c:if>
                        <c:if test="${news.active == false}">
                            <a href="?id=${news.id}&status=${news.active}">
                                <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa tài khoản"></i>
                            </a>
                        </c:if>
                        <a href="?edit&id=${news.id}">
                            <i class="fa fa-edit" style="color: blue; font-size: 16px" title="Chỉnh sửa"></i>
                        </a>
                        <a href="?delete&id=${news.id}">
                            <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa tài khoản"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</html>
