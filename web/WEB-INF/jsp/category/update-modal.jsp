<%-- 
    Document   : update-modal
    Created on : Oct 11, 2019, 12:32:36 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <input value="${category.id}" name="id" hidden="">
                    <input value="${category.active}" name="active" hidden="">
                    <input value="${url}" name="url" hidden="">
                    <div>
                        <label for="form-field-8">Tên Danh Mục</label>
                        <input value="${category.name}" required="" id="txt_box" placeholder="Danh mục"
                               class="autosize-transition form-control" name="name"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                </div>
            </div>
        </div>
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <div>
                        <label for="form-field-11">Loại ngành hàng</label>
                        <select id="form-field-1" class="autosize-transition form-control"
                                name="parentId">
                            <c:forEach var="r" items="${listcategorytypes}">
                                <option value="${r.id}" ${r.id == category.parentId ? 'selected' : ''}>${r.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <c:if test="${url == 'cate'}">
                    <div style="display: none">
                        <label for="form-field-11">Ảnh Sản Phẩm</label>
                        <img src="${newById.avatar}" alt="" id="blah"
                             style="width: auto; height: 80px; float: left; margin-top:30px"/>
                        <div class="buttonshow">
                            <input type='file' accept="image/x-png,image/gif,image/jpeg"
                                   multiple="" name="icon" onchange="readURL(this);"
                                   style="margin-left: 200px"/>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</html>
