<%-- 
    Document   : table
    Created on : Apr 6, 2020, 3:49:50 AM
    Author     : PnS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <div class="card-body">
        <table id="example1" class="table table-bordered table-striped">
            <thead>
                <tr style="color: #fff; background-color: #17a2b8">
                    <th>STT</th>
                    <th style="width: 200px">Tiêu Đề</th>
                    <th style="max-width: 200px">Ảnh Đại Diện</th>
                    <th style="width:80px">Giá Dịch Vụ</th>
                    <th style="width:80px">Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="service" items="${listService}" varStatus="counter">
                    <tr>
                        <td>${counter.index + 1}</td>
                        <td>${service.title}</td>
                        <td style="text-align: center"><img src="${service.avatar}" style="width: 80%"></td>
                        <td><fmt:formatNumber type = "number" 
                                          maxFractionDigits  = "3" value = "${service.money}" /> VNĐ</td>
                        <td>
                            <c:if test="${service.isActive == true}">
                                <a href="?changeStatus&id=${service.id}&status=false">
                                    <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa Dịch Vụ"></i>
                                </a>
                            </c:if>
                            <c:if test="${service.isActive == false}">
                                <a href="?changeStatus&id=${service.id}&status=true">
                                    <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa Dịch Vụ"></i>
                                </a>
                            </c:if>
                            <a href="?edit&id=${service.id}">
                                <i class="fa fa-edit" style="color: blue; font-size: 16px" title="Chỉnh sửa"></i>
                            </a>
                            <a href="?delete&id=${service.id}">
                                <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa Dịch Vụ"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</html>
