<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
    <link rel="icon" href="assets/images/favicon.png" type="image/png" sizes="32x32">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css" rel="stylesheet">
    <body class="no-skin">
        <%@include file="header.jsp" %>
        <div class="main-container ace-save-state" id="main-container">
            <%@include file="menuPage.jsp" %>
            <!-- /.main-content -->
            <%@include file="email/main.jsp" %>
            <%@include file="footer.jsp" %>
        </div>
        <%@include file="loadScript.jsp" %>
    </body>
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