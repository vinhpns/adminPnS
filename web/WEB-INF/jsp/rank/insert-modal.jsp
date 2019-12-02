<%-- 
    Document   : insert-model
    Created on : Oct 2, 2019, 11:17:22 PM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <div>
                        <label for="form-field-8">Tên danh hiệu</label>
                        <input type="text" required="" id="txt_box"
                               placeholder="Nhập tên danh hiệu"
                               class="autosize-transition form-control" name="name"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-11">Icon danh hiệu</label>
                        <input multiple="" name="icon" type="file" id="id-input-file-1"/>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-11">Điểm số</label>
                        <input type="number" required="" id="txt_box2"
                               placeholder="Nhập điểm danh hiệu"
                               class="autosize-transition form-control" name="requirePoint"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
