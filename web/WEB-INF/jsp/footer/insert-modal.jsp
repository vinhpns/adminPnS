<%-- 
    Document   : insert-modal
    Created on : Oct 4, 2019, 10:29:05 AM
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
                        <label for="form-field-8">Tiêu đề</label>
                        <input type="text" id="txt_box" placeholder="Tiêu đề bài viết"
                               class="autosize-transition form-control" name="title"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-select-1">Loại bài viết</label>
                        <select id="form-field-1" class="autosize-transition form-control"
                                name="type">
                            <c:forEach var="type" items="${typeNews}" varStatus="row">
                                <option value="${type.id}">${type.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <div>
                        <textarea id="summernote" name="content" style=""></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
