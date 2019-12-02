<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
    <body class="no-skin">
        <%@include file="header.jsp" %>
        <div class="main-container ace-save-state" id="main-container">
            <%@include file="menuPage.jsp" %>
            <%@include file="rank/main.jsp" %>
            <%@include file="footer.jsp" %>
        </div>
        <%@include file="loadScript.jsp" %>
    </body>
    <script src="assets/js/checkinput.js"></script>
    <script src="assets/js/loadImg.js"></script>
</html>

