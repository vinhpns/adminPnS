<%-- 
    Document   : form-input
    Created on : Mar 5, 2020, 4:18:58 PM
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <div class="col">
        <input hidden="" name="id" value="${service.id}" />
        <input hidden="" name="companyId" value="${service.companyId}" />
        <input hidden="" name="updatedBy" value="${sessionScope.accountId}"/>
        <div class="form-group">
            <label for="exampleInputEmail1">Tên Dịch Vụ</label>
            <input type="text" value="${service.title}" name="title" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Chi Phí</label>
            <input type="number" name="money" value="${service.money}"class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
        </div>
        <c:if test="${service.isMenu == true}">
            <div class="form-group">
                <input type="checkbox" checked="" id="vehicle1" name="isMenu" value="true">
                <label for="vehicle1"> Thuộc Menu</label><br>
            </div>
        </c:if>
        <c:if test="${service.isMenu == false}">
            <div class="form-group">
                <input type="checkbox" id="vehicle1" name="isMenu" value="false">
                <label for="vehicle1"> Thuộc Menu</label><br>
            </div>
        </c:if>
    </div>
    <div class="col">
        <div class="form-group">
            <label for="exampleInputEmail1">Ảnh Đại Diện</label>
            <input type='file' value="${service.avatar}" id="imgInp" name="avatar"/>
            <img id="blah" src="${service.avatar}" style="width: 50%; height: 50%" alt="your image" />
        </div>
    </div>
    <div class="col-12">
        <button type="submit" name="update" style="float: right;" class="btn btn-primary">Cập Nhật</button>
    </div>
</html>
