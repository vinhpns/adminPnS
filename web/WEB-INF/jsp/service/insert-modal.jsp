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
                        <label for="form-field-8">Tên Dịch Vụ</label>
                        <input id="txt_box" type="text" required="" placeholder="Vui lòng nhập"
                               class="autosize-transition form-control" name="title"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Chi Phí</label>
                        <input id="number" type="number" placeholder="Vui lòng nhập"
                               class="autosize-transition form-control" name="money"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <input type="checkbox" id="vehicle1" name="isMenu" value="false">
                        <label for="vehicle1"> Thuộc Menu</label><br>
                    </div>
                    <br>
                    <div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Ảnh Đại Diện</label>
                            <input type='file' value="${service.avatar}" id="imgInp" name="avatar"/>
                            <img id="blah" src="${service.avatar}" style="width: 50%; height: 50%" alt="your image" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
