<%-- 
    Document   : form-update
    Created on : Oct 23, 2019, 9:48:42 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12">
        <div class="col-sm-6">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <div>
                            <input value="${banner.id}" name="id" hidden="">
                            <input value="${url}" name="url" hidden="">
                            <input value="${banner.active}" name="active" hidden="">
                            <c:if test="${url == 'content'}">
                            <label for="form-field-8">Link Nội dung</label>
                            <input type="url" id="form-field-11" value="${banner.link}"
                                   placeholder="Link nội dung"
                                   class="autosize-transition form-control" name="link"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                            </c:if>
                            <c:if test="${url == 'banner'}">
                                 <label for="form-field-8">Link Banner</label>
                            <input type="url" id="form-field-11" value="${banner.link}"
                                   placeholder="Link Banner"
                                   class="autosize-transition form-control" name="link"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                            </c:if>
                            </div>
                        <br>
                        <div>
                            <c:if test="${url =='content'}">
                            <label for="form-field-select-1">Nội dung</label>
                            <select id="form-field-1" class="autosize-transition form-control"
                                    name="typeId">
                                <c:forEach var="r" items="${sessionScope.type}">
                                    <option value="${r.id}" ${r.id == banner.type ? 'selected' : ''}>${r.name}</option>
                                </c:forEach>
                            </select>
                            </c:if>
                            
                        </div>
                        <div>
                            <c:if test="${url =='banner'}">
                            <label for="form-field-select-1">Loại Banner</label>
                            <select id="form-field-1" class="autosize-transition form-control"
                                    name="typeId">
                                <c:forEach var="r" items="${sessionScope.type}">
                                    <option value="${r.id}" ${r.id == banner.type ? 'selected' : ''}>${r.name}</option>
                                </c:forEach>
                            </select>
                            </c:if>
                        </div>
                        <br>
                        <label for="form-field-11">Ảnh Đại Diện</label><br>
                        <div class="buttonshow2">
                            <input id="id-input-file-1" type='file' multiple="" name="images"
                                   accept="image/x-png,image/gif,image/jpeg"
                                   onchange="readURL3(this);"
                                   style="float: left;"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6" style="margin-top: 20px">
            <div>
                <img src="${banner.image}" alt="" id="blah3"
                     style="width: auto; height: 230px; float: left;"/>
            </div>
        </div>
        <div class="col-sm-12" style="text-align: center; margin-top: 50px">
            <button style="border-radius: 10px" class="btn btn-primary btn-lg"
                    type="submit" name="update">Cập Nhập
            </button>
            <button style="border-radius: 10px" class="btn btn-primary btn-lg">
                <a style="color: white; text-decoration: none" href="banner.htm?url=${url}">Quay Lại</a>
            </button>
        </div>
    </div>
</html>
