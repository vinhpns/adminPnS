<%-- 
    Document   : form-update
    Created on : Oct 24, 2019, 2:39:45 PM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 row">
        <div class="col-sm-7">
            <div class="row">
                <div class="widget-box">
                    <div class="widget-body">
                        <div class="widget-main">
                            <div>
                                <label for="form-field-8">Tiêu đề</label>
                                <input type="text" value="${video.title} " id="txt_box"
                                       placeholder="Nhập tên danh hiệu"
                                       class="autosize-transition form-control" name="title"
                                       style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                            </div>
                            </br>
                            <div>
                                <input value="${video.id}" name="id" hidden="">
                                <input value="${video.active}" name="active" hidden="">
                                <label for="form-field-8">Link Video</label>
                                <input type="url" id="form-field-11" value="${video.link}"
                                       placeholder="Link Video" class="autosize-transition form-control"
                                       name="link"
                                       style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                            </div>
                            <br>
                            <div>
                                <label for="form-field-select-1">Loại Video</label>
                                <select id="form-field-1" class="autosize-transition form-control"
                                        name="typeId">
                                    <c:forEach var="r" items="${typeVideo}">
                                        <option value="${r.id}" ${r.id == video.type ? 'selected' : ''}>${r.name}</option>
                                    </c:forEach>
                                </select>
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
        </div>
        <div class="col-sm-5">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <img src="${video.image}" alt="" id="blah3"
                             style="width: auto; height: 230px; float: left;"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-12" style="text-align: center; margin-top: 50px">
            <button style="border-radius: 10px" class="btn btn-primary btn-lg"
                    type="submit" name="update">Cập Nhập
            </button>
            <button style="border-radius: 10px; margin-left: 30px" type="reset" value="Reset"
                    class="btn btn-primary btn-lg">
                <a style="color: white; text-decoration: none" href="video.htm">Quay Lại</a>
            </button>
        </div>
    </div>
</html>
