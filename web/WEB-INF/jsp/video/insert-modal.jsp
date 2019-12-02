<%-- 
    Document   : insert-modal
    Created on : Oct 3, 2019, 1:04:53 PM
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
                        <label for="form-field-8">Tiêu Đề</label>
                        <input type="text" id="form-field-11" placeholder="Tiêu Đề"
                               class="autosize-transition form-control" name="title"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Link Video</label>
                        <input type="url" id="form-field-11" placeholder="Link Video"
                               class="autosize-transition form-control" name="link"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-11">Ảnh Đại Diện</label>
                        <input multiple="" name="images" type="file" id="id-input-file-1"/>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-select-1">Loại Video</label>
                        <select id="form-field-1" class="autosize-transition form-control"
                                name="typeId">
                            <c:forEach var="type" items="${typeVideo}">
                                <option value="${type.id}">${type.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                </div>
            </div>
        </div>
    </div>
</html>
