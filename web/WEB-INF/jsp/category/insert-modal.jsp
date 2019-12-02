<%-- 
    Document   : insert-modal
    Created on : Oct 4, 2019, 2:19:07 PM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <input value="${url}" hidden="" name="url"/>
                <div class="widget-main">
                    <div>
                        <label for="form-field-8">Tên Danh Mục</label>
                        <input  required="" id="txt_box" placeholder="Danh mục"
                                class="autosize-transition form-control" name="name"
                                style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                </div>
            </div>
        </div>
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <c:if test="${url == 'cate'}">
                        <div>
                            <label for="form-field-11">Loại Ngành Hàng</label>
                            <select id="form-field-1" class="autosize-transition form-control"
                                    name="parentId">
                                <c:forEach var="r" items="${listcategorytypes}">
                                    <option value="${r.id}">${r.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input multiple="" name="icon" type="file" style="display: none"/>
                        <br>
                    </c:if>
                    <c:if test="${url == 'type'}">
                        <div>
                            <label for="form-field-11">Icon danh hiệu</label>
                            <input multiple="" name="icon" type="file" id="id-input-file-3"/>
                        </div>
                        <input name="parentId" value="0"/>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</html>