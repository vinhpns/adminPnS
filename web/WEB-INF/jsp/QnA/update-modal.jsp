<%-- 
    Document   : update-modal
    Created on : 11-Oct-2019, 15:59:51
    Author     : Kiet
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
                        <input type="text" id="form-field-11" value="${newById.title}"
                               placeholder="Tiêu đề bài viết"
                               class="autosize-transition form-control" name="title"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
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
                    <br>
                    <div class="col-xs-12 row">
                        <textarea id="summernote" name="content" style="">${newById.content}</textarea>
                    </div>
                    <br>
                </div>
            </div>
        </div>
    </div>
</html>
