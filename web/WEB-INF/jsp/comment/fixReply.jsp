<%-- 
   Document   : fixReply
   Created on : Dec 3, 2019, 12:42:55 PM
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
                        <input value="${comment.id}" name="id" hidden="">
                        <label for="form-field-8">Nội Dung</label>
                        <input readonly="" id="txt_box" type="text" required="" placeholder="Nội dung"
                               class="autosize-transition form-control" name="comment" value="${comment.content}"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Câu Trả Lời</label>
                        <input readonly="" value="${comment.reply}" class="form-control" rows="5"></textarea>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Câu Trả Lời Mới</label>
                        <textarea class="form-control" name="reply" rows="3" placeholder="Enter ..."></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
