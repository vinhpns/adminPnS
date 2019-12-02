<%-- 
    Document   : form-update
    Created on : Oct 19, 2019, 5:22:57 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="widget-box">
        <div class="widget-body">
            <div class="widget-main">
                <div class="col-xs-12">
                    <div class=" col-sm-5">
                        <input value="${url}" name="url" type="hidden"/>
                        <input value="${newById.id}" name="id" type="hidden"/>
                        <input value="${newById.hot}" name="hot" type="hidden"/>
                        <div>
                            <label for="form-field-8">Tiêu đề</label>
                            <input type="text" value="${newById.title} " id="txt_box"
                                   placeholder="Tiêu đề bài viết"
                                   class="autosize-transition form-control" name="title"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-select-1">Loại bài viết</label>
                            <select id="form-field-1" class="autosize-transition form-control"
                                    name="type">
                                <c:forEach var="r" items="${typenews}" varStatus="row">
                                    <option value="${r.id}" ${r.id == newById.type ? 'selected' : ''}>${r.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <div>
                            <label for="form-field-11">Ảnh Sản Phẩm</label>
                            <br>
                            <div class="buttonshow2" >
                                <input id="id-input-file-1" type='file' multiple="" name="avatar"
                                       accept="image/x-png,image/gif,image/jpeg"
                                       onchange="readURL3(this);"
                                       style="float: left;"/>
                            </div>
                            <br>
                            <img src="${newById.avatar}" alt="" id="blah3"
                                 style="width: auto; height: 300px; float: left;"/>
                        </div>
                    </div>
                    <div class="col-sm-7">
                        <textarea id="summernote" name="content" style="">${newById.content}</textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
