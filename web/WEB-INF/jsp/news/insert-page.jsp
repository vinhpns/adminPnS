<%-- 
    Document   : insert-page
    Created on : Dec 2, 2019, 7:35:37 PM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <!--<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">-->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
        <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
        <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>-->
    </head>
    <body>
        <form action="news.htm" method="post" modelAttribute="ban" class="form-horizontal"
              role="form" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-6">
                    <div class="card-body">
                        <c:if test="${menuList == '0'}">
                            <input  value="${menuList}" name="menuId"/>
                        </c:if>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Tiêu Đề</label>
                            <input name="title" type="text" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Mô tả</label>
                            <textarea name="description" class="form-control" rows="3" placeholder="Enter ..."></textarea>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Ảnh Đại Diện</label>
                            <input type='file' id="imgInp" name="avatar"/>
                            <img id="blah" src="#" style="width: 30%; height: 30%" alt="your image" />
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Tiêu Đề SEO</label>
                            <input type="text" name="titleWeb" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Từ Khóa</label>
                            <textarea class="form-control" name="meta" rows="3" placeholder="Enter ..."></textarea>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Mô tả SEO</label>
                            <textarea class="form-control" name="metaDescription" rows="3" placeholder="Enter ..."></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <input name="type" value="${type}" hidden="">
                <textarea id="summernote" name="content" style=""></textarea>
            </div>
            <div class="col-12">
                <button type="submit" name="insertNews" style="float: right;" class="btn btn-primary">Thêm Mới</button>
            </div>
        </form>
        <script>
            $('#summernote').summernote({
                height: 300, // set editor height
                minHeight: null, // set minimum height of editor
                maxHeight: null, // set maximum height of editor
                focus: true
            });
        </script>
        <script>
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#blah').attr('src', e.target.result);
                    }

                    reader.readAsDataURL(input.files[0]);
                }
            }

            $("#imgInp").change(function () {
                readURL(this);
            });
        </script>
    </body>
</html>
