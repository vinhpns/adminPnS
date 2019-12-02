<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
<body class="no-skin">
<%@include file="header.jsp" %>
<div class="main-container ace-save-state" id="main-container">
    <%@include file="menuPage.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="index.htm">Trang chủ</a>
                    </li>
                    <li>
                        <a href="#">Thêm Bài Viết</a>
                    </li>
                </ul>
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <c:forEach var="sa" items="${listnewsdt}">
                            <div class="table-header">
                                Chỉnh sửa bài viết
                                    ${sa.title}
                            </div>
                            <form:form action="newsedit.htm" modelAttribute="newso" method="post"
                                       enctype="multipart/form-data">
                                Tiêu Đề
                                <br>
                                <input type="hidden" name="topicidd" value="${sa.id}"/>
                                <input style="width: 865px" type="text" value="${sa.title}" name="title"
                                       placeholder="Title..."/><br>
                                Ảnh đại diện
                                <br>
                                <input type="file" name="avas" id="avz" onchange="validateFileType();loadFile(event);"
                                       value="Insert Image" onchange="loadFile(event);" accept=".jpg,.jpeg,.png"/>
                                <br>
                                <img width="500px" height="200px" src="${sa.ava}" id="output"/><br>
                                <script>
                                    var loadFile = function (event) {
                                        var output = document.getElementById('output');
                                        output.src = URL.createObjectURL(event.target.files[0]);
                                    };
                                </script>
                                Loại bài viết
                                <br>
                                <select name="news_list">
                                    <c:forEach var="ni" items="${news_item}" varStatus="row">
                                        <option
                                                <c:if test="${ni.typeid==sa.typeid}">selected</c:if>
                                                value="${ni.typeid}">${ni.typename}</option>
                                    </c:forEach>
                                </select><br>
                                <br>
                                <textarea id="summernote" name="content">${sa.content}</textarea>
                                <a class="btn btn-info" href="news.htm" value="Back"/>Hủy chỉnh sửa</a>
                                <input class="btn btn-info" type="submit" name="Update" value="Lưu bài viết"/>
                                ${notice}
                            </form:form>
                        </c:forEach>
                        <%@include file="footer.jsp" %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement)
        document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>

<!-- ace scripts -->
<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>
<script>
    $(document).ready(function () {
        $('#summernote').summernote();
    });
    $('#summernote').summernote({
        height: 350, // set editor height
        minHeight: 350, // set minimum height of editor
        maxHeight: 350, // set maximum height of editor
        focus: true                  // set focus to editable area after initializing summernote
    });

    function validateFileType() {
        var fileName = document.getElementById("avz").value;
        var idxDot = fileName.lastIndexOf(".") + 1;
        var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
        if (extFile == "jpg" || extFile == "jpeg" || extFile == "png") {
            //TO DO
        } else {
            alert("Only jpg/jpeg and png files are allowed!");
            document.getElementById("avz").value = "";
        }
    }
</script>
</html>