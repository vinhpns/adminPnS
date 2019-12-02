<%-- 
    Document   : form-update
    Created on : Oct 23, 2019, 6:18:27 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12">
        <div class="col-sm-6">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main"> 
                        <div>
                            <input value="${category.id}" name="id" hidden="">
                            <input value="${category.active}" name="active" hidden="">
                            <input value="${url}" name="url" hidden="">
                            <input value="${category.parentId}" name="parentId" hidden="">
                            <label for="form-field-8">Tên Ngành Hàng</label>
                            <input id="txt_box" placeholder="danh mục" value="${category.name}"
                                   class="autosize-transition form-control" name="name"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <div>
                                <c:if test= "${url == 'cate'}">
                                    <div class="buttonshow">
                                        <label for="form-field-11">Loại Ngành Hàng</label>
                                        <select id="form-field-1" class="autosize-transition form-control"
                                                name="parentId">
                                            <c:forEach var="r" items="${categorytype}">
                                                <option value="${r.id}" ${r.id == category.parentId ? 'selected' : ''}>${r.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </c:if>
                                <c:if test="${ url == 'type'}">
                                    <label for="form-field-11">Ảnh đại diện</label>
                                    <div class="buttonshow">
                                        <input type='file' accept="image/x-png,image/gif,image/jpeg"
                                               multiple="" id="id-input-file-1" name="icon" onchange="readURL2(this);"/>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <br>
                    </div>
                </div>
            </div>
        </div>
        <img src="${category.icon}" alt="" id="blah2"
             style="width: auto; height: 130px; margin-top:30px"/>
        <br>
        <div>
            <div class="col-sm-12" style="margin-top: 20px ; text-align: center">
                <button style="border-radius: 50px" class="btn btn-primary btn-lg" 
                        type="submit" name="update">Cập Nhập
                </button>
                <button style="border-radius: 50px" type="reset" value="Reset" class="btn btn-primary btn-lg">
                    <a style="color: white; text-decoration: none" class="" href="category.htm?url=${url}">Quay Lại</a>
                </button>
            </div>
        </div>
</html>
