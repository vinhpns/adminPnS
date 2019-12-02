<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css" rel="stylesheet">
    <body class="no-skin">
        <%@include file="header.jsp" %>
        <div class="main-container ace-save-state" id="main-container">
            <%@include file="menuPage.jsp" %>
            <%@include file="e-commerce/main.jsp" %>
            <%@include file="footer.jsp" %>
        </div>
        <jsp:include page="loadScript.jsp"></jsp:include>
    </body>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
    <script>
        $(document).ready(function () {
            $('#summernote').summernote();
        });
        $('#summernote').summernote({
            height: 250, // set editor height
            minHeight: 250, // set minimum height of editor
            maxHeight: 250, // set maximum height of editor
            focus: true                  // set focus to editable area after initializing summernote
        });
        var loadFile = function (event) {
            var output = document.getElementById('output');
            output.src = URL.createObjectURL(event.target.files[0]);
        };
    </script>
</html>