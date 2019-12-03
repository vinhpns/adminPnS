<%-- 
    Document   : insert-modal.jsp
    Created on : Dec 2, 2019, 6:13:21 PM
    Author     : hieuh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <div>
                        <label for="form-field-8">Họ Và Tên *</label>
                        <input id="txt_box" type="text" required="" placeholder="Họ và Tên"
                               class="autosize-transition form-control" name="fullName"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;" requires>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Email *</label>
                        <input id="txt_box" type="Email" required="" placeholder="Email"
                               class="autosize-transition form-control" name="email"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;" requires>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Tên Đăng Nhập *</label>
                        <input id="txt_box" type="text" required="" placeholder="UserName"
                               class="autosize-transition form-control" name="userName"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;" requires>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Mật Khẩu *</label>
                        <input id="txt_box" type="password" required="" placeholder="Mật Khẩu"
                               class="autosize-transition form-control" name="password"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;" requires>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Giới Tinh *</label>
                        <select id="txt_box" type="select" required="" placeholder="Giới Tính"
                                class="autosize-transition form-control" name="gender"
                                style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                            <option value="true">Nam</option>
                            <option value="false">Nữ</option>
                        </select>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Vai Trò *</label>
                         <select id="txt_box" type="select" placeholder="Vai Trò"
                                class="autosize-transition form-control" name="role"
                                style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                            <option value="Admin">Admin</option>
                            <option value="Writer">Writer</option>
                            <option value="Moder">Moder</option>
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
</html>
