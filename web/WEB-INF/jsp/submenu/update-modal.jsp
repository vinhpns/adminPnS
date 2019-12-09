<%-- 
    Document   : insert-model
    Created on : Dec 2, 2019, 6:45:22 PM
    Author     : hieuh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <div>
                        <div>
                            <label for="form-field-8">Tên Menu</label>
                            <input id="txt_box" type="text" required="" placeholder="Tên Menu"
                                   class="autosize-transition form-control" name="name" value="${menu.name}"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Thuộc Menu</label>
                            <select id="txt_box" type="select"
                                    class="autosize-transition form-control" name="parentId"
                                    style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                <c:forEach items="${menuFatherList}" var="menuFatherId">
                                    <option value="${menuFatherId.id}" ${menuFatherId.id == menu.parentId ? 'selected' : ''}>${menuFatherId.name}</option>
                                </c:forEach>
                            </select>
                            <input value="0" name="postion" hidden="">
                            <input value="${menu.id}" name="id" hidden=""/>
                            <input value="${menu.count}" name="count" hidden=""/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
