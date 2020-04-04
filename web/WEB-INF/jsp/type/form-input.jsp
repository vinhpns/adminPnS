<%-- 
    Document   : form-input
    Created on : Mar 5, 2020, 4:18:58 PM
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col">
        <input hidden="" name="id" value="${type.id}" />
        <input hidden="" name="companyId" value="${type.companyId}" />
        <input hidden="" name="type" value="${type.type}" />
        <div class="form-group">
            <label for="exampleInputEmail1">Tên mục</label>
            <input type="text" value="${type.title}" name="title" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Mô tả tiêu đề</label>
            <input type="text" name="titleDescription" value="${type.titleDescription}"class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Giới Thiệu </label>
            <input type="text" value="${type.shortTitle}" name="shortTitle" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Mô tả Phương Pháp</label>
            <input type="text" value="${type.shortDescription}" name="shortDescription" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Lý do 1</label>
            <input type="text" value="${type.reasonOne}" name="reasonOne" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Mô tả SEO</label>
            <textarea class="form-control" name="descriptionOne" rows="3" placeholder="Enter ...">${type.descriptionOne}</textarea>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Lý do 2</label>
            <input type="text" value="${type.reasonTwo}" name="reasonTwo" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Mô tả SEO</label>
            <textarea class="form-control" name="descriptionTwo" rows="3" placeholder="Enter ...">${type.descriptionTwo}</textarea>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Lý do 3</label>
            <input type="text" value="${type.reasonThree}" name="reasonThree" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Mô tả SEO</label>
            <textarea class="form-control" name="descriptionThree" rows="3" placeholder="Enter ...">${type.descriptionThree}</textarea>
        </div>
    </div>
    <div class="col">
        <div class="form-group">
            <label for="exampleInputEmail1">Ảnh Đại Diện</label>
            <input type='file' value="${type.picMain}" id="imgInp" name="picMain"/>
            <img id="blah" src="${type.picMain}" style="width: 50%; height: 50%" alt="your image" />
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">Ảnh 1</label>
            <input type='file' value="${type.picOne}" id="imgInp1" name="picOne"/>
            <img id="blah1" src="${type.picOne}" style="width: 50%; height: 50%" alt="your image" />
        </div>
        <div class="form-group">
            <label for="exampleInputEmail3">Ảnh 2</label>
            <input type='file' value="${type.picTwo}" id="imgInp2" name="picTwo"/>
            <img id="blah2" src="${type.picTwo}" style="width: 50%; height: 50%" alt="your image" />
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">Ảnh 3</label>
            <input type='file' value="${type.picThree}" id="imgInp3" name="picThree"/>
            <img id="blah3" src="${type.picThree}" style="width: 50%; height: 50%" alt="your image" />
        </div>
</html>
