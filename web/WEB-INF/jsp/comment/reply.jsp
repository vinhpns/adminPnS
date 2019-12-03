<%-- 
    Document   : reply
    Created on : Dec 3, 2019, 12:38:29 PM
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
                        <label for="form-field-8">Nội Dung</label>
                        <input readonly="" id="txt_box" type="text" required="" placeholder="Tên Menu"
                               class="autosize-transition form-control" name="Menuname" value="${comment.content}"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Nội Dung</label>
                        <textarea class="form-control" rows="3" placeholder="Enter ..."></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
