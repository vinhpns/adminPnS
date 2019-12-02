<%-- 
    Document   : insert-modal
    Created on : Oct 3, 2019, 2:21:55 PM
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
                        <label for="form-field-8">Tên Thương Hiệu</label>
                        <input required="" id="txt_box" placeholder="Thương Hiệu"
                               class="autosize-transition form-control" name="brandName"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <div>
                        <label for="form-field-11">Ảnh Thương Hiệu</label>
                        <input multiple="" required="" name="images" type="file"
                               id="id-input-file-3"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
