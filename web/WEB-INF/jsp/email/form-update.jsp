<%-- 
    Document   : from-update
    Created on : Oct 23, 2019, 9:41:05 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <form:form action="EmailContent.htm" method="post" enctype="multipart/form-data">
                    Tiêu Đề
                    <br>
                    <input id="txt_box" style="width: 865px" type="text" name="title" value="${email.title}"
                           placeholder="Tên tiêu đề"/>
                    <hr>
                    <input style="width: 865px" type="text" hidden="" name="id" value="${email.id}"
                           placeholder="Title..."/>
                    <textarea id="summernote" name="content">${email.content}</textarea>

                    <input class="btn btn-primary btn-lg" type="submit" name="update" value="Post"/>
                    <button class="btn btn-primary btn-lg">
                        <a style="color: white; text-decoration: none" href="EmailContent.htm">Quay Lại</a>
                    </button>
                </form:form>
            </div>
        </div>
    </div>
</html>
