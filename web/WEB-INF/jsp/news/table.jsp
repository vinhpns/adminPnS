<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr style="color: #fff; background-color: #17a2b8">
                <th style="width:200px">Tiêu Đề</th>
                <th style="width:200px">Tác Giả</th>
                <th style="max-width: 200px">Ảnh Đại Diện</th>
                <th style="width:50px">Trạng Thái</th>
                <th style="width:50px">Lượt Xem</th>
                <th style="width:50px">Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="news" items="${newsList}">
                <tr>
                    <td>${news.title}</td>
                    <td>${news.createdByName}</td>
                    <td style="text-align: center"><img src="${news.avatar}" style="width: 80%"></td>
                    <td>
                        <c:if test="${news.save == true}">
                            Lưu Nháp
                        </c:if>
                        <c:if test="${news.save == false}">
                            Công Khai
                        </c:if>
                    </td>
                    <td>${news.view}</td>
                    <td>
                        <c:if test="${news.active == true}">
                            <a href="?changeStatus&id=${news.id}&status=false">
                                <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa bài viết"></i>
                            </a>
                        </c:if>
                        <c:if test="${news.active == false}">
                            <a href="?changeStatus&id=${news.id}&status=true">
                                <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa"></i>
                            </a>
                        </c:if>
                        <a href="?viewById&id=${news.id}">
                            <i class="fa fa-edit" style="color: blue; font-size: 16px" title="Chỉnh sửa"></i>
                        </a>
                        <a href="?delete&id=${news.id}">
                            <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa bài viết"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</html>
