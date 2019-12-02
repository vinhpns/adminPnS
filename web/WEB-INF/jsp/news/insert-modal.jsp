<%-- 
    Document   : insert-modal
    Created on : Oct 4, 2019, 10:29:05 AM
    Author     : SGDG Company
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <input value="${url}" name="url" type="hidden"/>
                    <div>
                        <label for="form-field-8">Tiêu đề</label>
                        <input type="text" id="txt_box" placeholder="Tiêu đề bài viết"
                               class="autosize-transition form-control" name="title"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <c:if test="${url == 'news'}">
                        <div>
                            <label for="form-field-11">Ảnh Sản Phẩm</label>
                            <input multiple="" name="avatar" type="file" id="id-input-file-1"/>

                        </div>
                    </c:if>
                    <c:if test="${url == 'typefooter'}">
                        <div style="display: none">
                            <label for="form-field-11">Ảnh Sản Phẩm</label>
                            <input multiple="" name="avatar" type="file" 
                                   id="id-input-file-1"/>
                            <input value="false" name="hot">
                        </div>
                    </c:if>
                    <div>
                        <label for="form-field-select-1">Loại bài viết</label>
                        <select id="form-field-1" class="autosize-transition form-control"
                                name="type">
                            <c:forEach var="type" items="${typenews}" varStatus="row">
                                <option value="${type.id}">${type.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <c:if test="${url == 'news'}">
                        <div class="form-check col-sm-6">
                            <input class="form-check-input" type="radio" name="hot"
                                   id="gridRadios1" value="true" checked>
                            <label class="form-check-label" for="gridRadios1">
                                Tin Hot
                            </label>
                        </div>
                        <div class="form-check col-sm-6">
                            <input class="form-check-input" type="radio" name="hot"
                                   id="gridRadios2" value="false">
                            <label class="form-check-label" for="gridRadios2">
                                Tin thường
                            </label>
                        </div>
                    </c:if>
                    <br>
                    <div>
                        <textarea id="summernote" name="content" style=""></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
