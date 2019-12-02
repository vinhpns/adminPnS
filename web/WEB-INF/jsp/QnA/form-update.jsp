<%-- 
    Document   : form-update
    Created on : Oct 19, 2019, 5:39:22 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-6">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <input value="${newById.id}" name="id" type="hidden"/>
                    <div>
                        <label for="form-field-8">Tiêu đề</label>
                        <input type="text" id="txt_box" value="${newById.title}"
                               placeholder="Tiêu đề bài viết"
                               class="autosize-transition form-control" name="title"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-sm-6">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <div>
                    </div>
                    <div>
                        <label for="form-field-select-1">Loại bài viết</label>
                        <select id="form-field-1" class="autosize-transition form-control"
                                name="type">
                            <c:forEach var="type" items="${typeNews}" varStatus="row">
                                <option ${type.id == newById.type ? 'selected' : ''}
                                    value="${type.id}">${type.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xs-12 row">
        <textarea id="summernote" name="content" style="">${newById.content}</textarea>
    </div>
</html>
