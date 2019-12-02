<%-- 
    Document   : insert-model
    Created on : Oct 8, 2019, 11:19:34 AM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css" rel="stylesheet">
    <div class="row">
        <div class="col-xs-12 col-sm-12">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <div>
                            <label for="form-field-8">Tiêu đề</label>
                            <input value="${a.title}"required="" type="text" id="form-field-11" placeholder="Tiêu đề"
                                   class="autosize-transition form-control" name="title"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <textarea id="summernote" name="content"></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $('#summernote').summernote();
        });
        $('#summernote').summernote({
            height: 300, // set editor height
            minHeight: 300, // set minimum height of editor
            maxHeight: 300, // set maximum height of editor
            focus: true                  // set focus to editable area after initializing summernote
        });
        var loadFile = function (event) {
            var output = document.getElementById('output');
            output.src = URL.createObjectURL(event.target.files[0]);
        };
    </script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
</html>
