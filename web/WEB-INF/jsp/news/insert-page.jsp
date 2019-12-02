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
    </head>
    <body>
        <div class="row">
            <div class="col-md-6">
                <div class="card-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Tiêu Đề</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                    </div>
                </div>
                <div class="card-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Mô tả</label>
                        <textarea class="form-control" rows="3" placeholder="Enter ..."></textarea>
                    </div>
                </div>
                <div class="card-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Ảnh Đại Diện</label>
                        <input type="file" />
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Tiêu Đề SEO</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                    </div>
                </div>
                <div class="card-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Từ Khóa</label>
                        <textarea class="form-control" rows="3" placeholder="Enter ..."></textarea>
                    </div>
                </div>
                <div class="card-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Mô tả SEO</label>
                        <textarea class="form-control" rows="3" placeholder="Enter ..."></textarea>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-12" id="summernote"></div>
        <div class="col-12">
            <button type="button" style="float: right;" class="btn btn-primary">Thêm Mới</button>
        </div>
        <script>
            $('#summernote').summernote({
                height: 300, // set editor height
                minHeight: null, // set minimum height of editor
                maxHeight: null, // set maximum height of editor
                focus: true
            });
        </script>
    </body>
</html>
