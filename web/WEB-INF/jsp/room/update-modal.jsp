<%-- 
    Document   : update-moda
    Created on : Oct 10, 2019, 2:13:08 PM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <input value="${a.id}" hidden="" name="id">
                    <div>
                        <label for="form-field-8">Tên phòng</label>
                        <input value="${a.name}"type="text" id="txt_box" placeholder="Nhập tên"
                               class="autosize-transition form-control" name="name"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Thời gian đấu tối đa</label>
                        <input value="${a.duration}"type="number" id="form-field-11" placeholder="Nhập bao nhiêu giờ"
                               class="autosize-transition form-control" name="duration"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Số tiền tối thiểu</label>
                        <input value="${a.min}"type="number" id="form-field-11" placeholder="Nhập số tiền"
                               class="autosize-transition form-control" name="min"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Số tiền tối đa</label>
                        <input value="${a.max}"type="number" id="form-field-11" placeholder="Nhập số tiền"
                               class="autosize-transition form-control" name="max"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Bước giá</label>
                        <input value="${a.step}"type="number" id="form-field-11" placeholder="Nhập bước giá"
                               class="autosize-transition form-control" name="step"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                </div>
            </div>
        </div>
    </div>
</html>