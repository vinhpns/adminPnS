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
                                               class="autosize-transition form-control" name="newPassword"
                                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                        <input id="txt_box" type="text" required="" placeholder="Nhập Mật Khẩu Mới" value="${user.password}"
                                               class="autosize-transition form-control" name="oldPassword" hidden=""
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
                    <button class="btn btn-primary btn-lg" type="submit" name="updatePassword">Thêm</button>
                    <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Đóng</button>
                </div>
            </div>
        </form>
    </div>
</html>
