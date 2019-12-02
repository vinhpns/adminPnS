<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <input value="${user.id}" hidden="" name="id"/>
                    <input value="${user.password}" hidden=""  name="oldPassword"/>
                    <input value="${url}" hidden=""  name="url"/>
                    <div>
                        <label for="form-field-8">Mật khẩu mới</label>
                        <input type="password" id="reg_pass" minlength=1 required
                               placeholder="Mật khẩu" class="autosize-transition form-control"
                               name="newPassword"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <hr>
                    <div>
                        <label for="form-field-8">Nhập lại Mật khẩu mới</label>
                        <input type="password" id="reg_confirm_pass" minlength=1 required
                               placeholder="Xác nhận mật khẩu"
                               class="autosize-transition form-control" name="reNewPassword"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>