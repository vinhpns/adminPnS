<%-- 
    Document   : update-modal
    Created on : 11-Oct-2019, 13:09:33
    Author     : Kiet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css" rel="stylesheet">
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <input value="${url}" name="url" />
                    <input value="${newById.id}" name="id" type="hidden"/>
                    <input value="${newById.hot}" name="hot" type="hidden"/>
                    <div>
                        <label for="form-field-8">Tiêu đề</label>
                        <input type="text" value="${newById.title} " id="txt_box"
                               placeholder="Tiêu đề bài viết"
                               class="autosize-transition form-control" name="title"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <div>
                        <label for="form-field-11">Ảnh Sản Phẩm</label>
                        <img src="${newById.avatar}" alt="" id="blah"
                             style="width: auto; height: 80px; float: left; margin-top:30px"/>
                        <div class="buttonshow">
                            <input type='file' accept="image/x-png,image/gif,image/jpeg"
                                   multiple="" name="avatar" onchange="readURL(this);"
                                   style="margin-left: 200px"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <div>
                    </div>
                    <div>
                        <label for="form-field-select-1">Loại bài viết</label>
                        <select id="form-field-1" class="autosize-transition form-control"
                                name="type">
                            <c:forEach var="r" items="${typenews}" varStatus="row">
                                <option value="${r.id}" ${r.id == newById.type ? 'selected' : ''}>${r.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <div class="col-xs-12 row" style="margin-top:10px">
        <textarea id="summernote" name="content" style="">${newById.content}</textarea>
    </div>
</html>
