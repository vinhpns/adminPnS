<%-- 
    Document   : insert-modal.jsp
    Created on : Dec 2, 2019, 6:13:21 PM
    Author     : hieuh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
        <style>
            .btn-file {
                position: relative;
                overflow: hidden;
            }
            .btn-file input[type=file] {
                position: absolute;
                top: 0;
                right: 0;
                min-width: 100%;
                min-height: 100%;
                font-size: 100px;
                text-align: right;
                filter: alpha(opacity=0);
                opacity: 0;
                outline: none;
                background: white;
                cursor: inherit;
                display: block;
            }

            #img-upload{
                width: 30%;
            }
        </style>
    </head>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <div>
                        <label for="form-field-8">Vị Trí</label>
                        <select id="txt_box" type="select" placeholder="Vai Trò"
                                class="autosize-transition form-control" name="role"
                                style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                            <option value="1">Banner Chính</option>
                            <option value="2">Banner Sub Chính</option>
                            <option value="3">Banner Trên Phải Trang Chủ</option>
                            <option value="4">Banner Giữa Trang Chủ</option>
                            <option value="5">Banner Cuối Phải Trang Chủ</option>
                            <option value="6">Banner Trên Phải List Tin</option>
                            <option value="7">Banner Cuối Phải List Tin</option>
                            <option value="8">Banner Trên Phải Trang Bài Viết</option>
                            <option value="9">Banner Cuối Phải Trang Bài Viết</option>
                            <option value="10">Banner Cuối Trang Bài Viết</option>
                        </select>
                    </div>
                    <br>
                    <div>
                        <label>Ảnh Banner</label>
                        <div class="input-group">
                            <span class="input-group-btn">
                                <span class="btn btn-default btn-file">
                                    Nhấn Chon… <input type="file" id="imgInp">
                                </span>
                            </span>
                            <input type="text" class="form-control" readonly>
                        </div>
                        <br>
                        <img id='img-upload'/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $(document).on('change', '.btn-file :file', function () {
                var input = $(this),
                        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
                input.trigger('fileselect', [label]);
            });

            $('.btn-file :file').on('fileselect', function (event, label) {

                var input = $(this).parents('.input-group').find(':text'),
                        log = label;

                if (input.length) {
                    input.val(log);
                } else {
                    if (log)
                        alert(log);
                }

            });
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#img-upload').attr('src', e.target.result);
                    }

                    reader.readAsDataURL(input.files[0]);
                }
            }

            $("#imgInp").change(function () {
                readURL(this);
            });
        });
    </script>
</html>
