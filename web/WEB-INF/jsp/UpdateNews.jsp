<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body class="no-skin">
<%@include file="header.jsp" %>
<div class="main-container ace-save-state" id="main-container">
    <%@include file="menuPage.jsp" %>
    <%@include file="news/main-update.jsp" %>
    <%@include file="footer.jsp" %>
</div>
</body>
<jsp:include page="loadScript.jsp"></jsp:include>
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
<script src="assets/js/loadImg.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#summernote').summernote();
    });
    $('#summernote').summernote({
        height: 500, // set editor height
        minHeight: 500, // set minimum height of editor
        maxHeight: 500, // set maximum height of editor
        focus: true                  // set focus to editable area after initializing summernote
    });
    var loadFile = function (event) {
        var output = document.getElementById('output');
        output.src = URL.createObjectURL(event.target.files[0]);
    };
</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="assets/js/checkinput.js"></script>
</html>