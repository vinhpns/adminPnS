<%-- 
    Document   : update-pass
    Created on : Dec 5, 2019, 1:38:39 PM
    Author     : hieuh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="modal-dialog">
        <!-- Modal content-->
        <form action="ListUser.htm" method="post" class="form-horizontal"
              role="form" enctype="multipart/form-data" modelAttribute="account">
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
                                    <div class="widget-main">
                                        <div>
                                            <input value="${user.id}" name="id"/>
                                            <label for="form-field-8">Họ Và Tên *</label>
                                            <input id="txt_box" type="text" required="" placeholder="Họ và Tên"
                                                   class="autosize-transition form-control" name="fullName" value="${user.fullName}"
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
                                                   class="autosize-transition form-control" name="phone"
                                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                        </div>
                                        <br>
                                        <div>
                                            <label for="form-field-8">Địa Chỉ</label>
                                            <input id="txt_box" type="text" placeholder="Địa Chỉ"
                                                   class="autosize-transition form-control" name="address"
                                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                        </div>
                                        <br>
                                        <div>
                                            <label for="form-field-8">Ngày Tháng Năm Sinh</label>
                                            <input id="start" type="date" placeholder="Ngày Tháng Năm Sinh" value="2020-12-31"  min="1990-01-01" max="2020-12-31"
                                                   class="autosize-transition form-control" name="dob"
                                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                        </div>
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
</html>
