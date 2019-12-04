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
            <td><a href="news.htm?viewById&userId=${user.id}">3</a></td>
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
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <form action="ListUser.htm" method="post" class="form-horizontal"
                          role="form" enctype="multipart/form-data">
                        <div class="modal-content">
                            <div class="modal-header" style="display: inline">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h3 class="modal-title">Cập Nhật Thông Tin Tài Khoản</h3>
                            </div>
                            <div class="modal-body">
                                <div class="col-xs-12 col-sm-12">
                                    <div class="widget-box">
                                        <div class="widget-body">
                                            <div class="widget-main">
                                                <div>
                                                    <label for="form-field-8">Họ Và Tên *</label>
                                                    <input id="txt_box" type="text" required="" placeholder="Họ và Tên" value="${user.fullName}"
                                                           class="autosize-transition form-control" name="fullName"
                                                           style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;" requires>
                                                </div>
                                                <br>
                                                <div>
                                                    <label for="form-field-8">Email *</label>
                                                    <input id="txt_box" type="Email" required="" placeholder="Email"
                                                           class="autosize-transition form-control" name="email" value="${user.email}"
                                                           style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;" requires>
                                                </div>
                                                <br>
                                                <div>
                                                    <label for="form-field-8">Tên Đăng Nhập *</label>
                                                    <input id="txt_box" type="text" required="" placeholder="UserName"
                                                           class="autosize-transition form-control" name="userName" value="${user.userName}"
                                                           style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;" requires>
                                                </div>
                                                <br>
                                                <div>
                                                    <label for="form-field-8">Giới Tinh *</label>
                                                    <select id="txt_box" type="select" required="" placeholder="Giới Tính"
                                                            class="autosize-transition form-control" name="gender"
                                                            style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                        <option ${user.gender == true ? 'selected' : ''}
                                                            value="true" >Nam</option>
                                                        <option ${user.gender == false ? 'selected' : ''}
                                                            value="false" >Nữ</option>
                                                    </select>
                                                </div>
                                                <br>
                                                <div>
                                                    <label for="form-field-8">Vai Trò *</label>
                                                    <select id="txt_box" type="select" placeholder="Vai Trò"
                                                            class="autosize-transition form-control" name="role"
                                                            style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                        <option ${user.role == 3 ? 'selected' : ''} 
                                                            value="3">Admin</option>
                                                        <option ${user.role == 2 ? 'selected' : ''} 
                                                            value="2">Mod</option>
                                                        <option ${user.role == 1 ? 'selected' : ''} 
                                                            value="1">Writer</option>
                                                    </select>
                                                </div>
                                                <br>
                                                <div>
                                                    <label for="form-field-8">Số Điện Thoại</label>
                                                    <input id="number" type="number" placeholder="Số Điện Thoại"
                                                           class="autosize-transition form-control" name="phone" value="${user.phone}"
                                                           style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                </div>
                                                <br>
                                                <div>
                                                    <label for="form-field-8">Địa Chỉ</label>
                                                    <input id="txt_box" type="text" placeholder="Địa Chỉ"
                                                           class="autosize-transition form-control" name="address" value="${user.address}"
                                                           style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                </div>
                                                <br>
                                                <div>
                                                    <label for="form-field-8">Ngày Tháng Năm Sinh</label>
                                                    <input id="start" type="date" placeholder="Ngày Tháng Năm Sinh" min="1990-01-01" max="2020-12-31"
                                                           class="autosize-transition form-control" name="dob" value="${user.dob}"
                                                           style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-primary btn-lg" type="submit" name="update">Thêm</button>
                                <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Đóng</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal fade" id="changPass_${user.id}" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <form action="ListUser.htm" method="post" class="form-horizontal"
                          role="form" enctype="multipart/form-data">
                        <div class="modal-content">
                            <div class="modal-header" style="display: inline">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h3 class="modal-title">Cập Nhật Mật Khẩu</h3>
                            </div>
                            <div class="modal-body">
                                <div class="col-xs-12 col-sm-12">
                                    <div class="widget-box">
                                        <div class="widget-body">
                                            <div class="widget-main">
                                                <div>
                                                    <label for="form-field-8">Mật Khẩu Mới</label>
                                                    <input id="txt_box" type="password" required="" placeholder="Nhập Mật Khẩu Mới"
                                                           class="autosize-transition form-control" name="oldPassword"
                                                           style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                    <input id="txt_box" type="text" required="" placeholder="Nhập Mật Khẩu Mới" value="${user.password}"
                                                           class="autosize-transition form-control" name="newPassword" hidden=""
                                                           style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                    <input id="txt_box" type="text" required="" placeholder="Nhập Mật Khẩu Mới"
                                                           class="autosize-transition form-control" name="id" hidden="" value="${user.id}"
                                                           style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-primary btn-lg" type="submit" name="password">Thêm</button>
                                <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Đóng</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </c:forEach>
    </tbody>
</table>
</html>
