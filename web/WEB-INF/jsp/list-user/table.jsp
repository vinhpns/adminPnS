<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr style="color: #fff; background-color: #17a2b8">
                <th>Tên người dùng</th>
                <th>Tên</th>
                <th>Email</th>
                <th>Vai trò</th>
                <th>Bài viết</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td class="d-none d-md-block">${user.userName}</td>
                <td>${user.fullName}</td>
                <td>${user.email}</td>
                <td>
            <c:forEach var="role" items="${listRole}">
                <c:if test="${role.id == user.role}">${role.name}</c:if>
            </c:forEach>
            </td>
            <td><a href="news.htm?viewByAccountId&userId=${user.id}">${user.post}</a></td>
            <td>
            <c:if test="${user.active == true}">
                <a href="?changeStatus&id=${user.id}&status=${user.active}">
                    <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa tài khoản"></i>
                </a>
            </c:if>
            <c:if test="${user.active == false}">
                <a href="?changeStatus&id=${user.id}&status=${user.active}">
                    <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa tài khoản"></i>
                </a>
            </c:if>
            <a data-toggle="modal" data-target="#changInfo_${user.id}">
                <i class="fa fa-edit" style="color: blue; font-size: 16px" title="Chỉnh sửa"></i>
            </a>
            <a href="?delete&id=${user.id}">
                <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa tài khoản"></i>
            </a>
            <a data-toggle="modal" data-target="#changPass_${user.id}">
                <i class="fa fa-random" style="color: orange; font-size: 16px" title="Đổi mật khẩu"></i>
            </a>
            </td>
            </tr>
            <div class="modal fade" id="changInfo_${user.id}" role="dialog">
                <%@include file="update-info.jsp" %>
            </div>
            <div class="modal fade" id="changPass_${user.id}" role="dialog">
                <%@include file="update-pass.jsp" %>
            </div>
        </c:forEach>
    </tbody>
</table>
</html>
