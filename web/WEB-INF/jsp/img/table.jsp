<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr style="color: #fff; background-color: #17a2b8">
                <th style="width:50px">STT</th>
                <th style="max-width: 200px">Ảnh Đại Diện</th>
                <th style="width:100px">Lượt Xem</th>
                <th style="width:100px">Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="img" items="${list}" varStatus="counter">
                <tr>
                    <td>${counter.index + 1}</td>
                    <td style="text-align: center"><img src="${img.link}" style="width: 50%"></td>
                    <td>${img.view}</td>
                    <td>
                        <c:if test="${img.status == true}">
                            <a href="?updateStatus&id=${img.id}&status=false&type=${type}">
                                <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa hình ảnh"></i>
                            </a>
                        </c:if>
                        <c:if test="${img.status == false}">
                            <a href="?changeStatus&id=${img.id}&status=true&type=${type}">
                                <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa"></i>
                            </a>
                        </c:if>
                        <a href="?delete&id=${img.id}&type=${type}">
                            <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa hình ảnh"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</html>
