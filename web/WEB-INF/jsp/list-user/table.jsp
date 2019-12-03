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
                <td class="d-none d-md-block">${user.email}</td>
                <td>${user.fullName}</td>
                <td>${user.email}</td>
                <td>
            <c:forEach var="role" items="${listRole}">
                <c:if test="${role.id == user.role}">${role.name}</c:if>
            </c:forEach>
            </td>
            <td><a href="news.htm?viewById&userId=${user.id}">3</a></td>
            <td>
            <c:if test="${user.active == true}">
                <a href="?changeStatus&id=${user.id}&status=${user.active}">
                    <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa tài khoản"></i>
                </a>
            </c:if>
            <c:if test="${user.active == false}">
                <a href="?id=${user.id}&status=${user.active}">
                    <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa tài khoản"></i>
                </a>
            </c:if>
            <a href="?edit&id=${user.id}">
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
            <div class="modal fade" id="changPass_${user.id}" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <form action="ListFooterNews.htm" method="post" modelAttribute="ban" class="form-horizontal"
                          role="form" enctype="multipart/form-data">
                        <div class="modal-content">
                            <div class="modal-header" style="display: inline">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h3 class="modal-title">Đổi Mật Khẩu</h3>
                            </div>
                            <div class="modal-body">

                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-primary btn-lg" type="submit" name="update">Cập Nhật</button>
                                <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </c:forEach>
    </tbody>
</table>
</html>
