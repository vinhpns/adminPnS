<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
    <link rel="stylesheet" href="assets/css/loadImg.css"/>
    <link rel="icon" href="assets/images/favicon.png" type="image/png" sizes="32x32">
    <body class="no-skin">
        <%@include file="header.jsp" %>
        <div class="main-container ace-save-state" id="main-container" style="font-size:15px">
            <%@include file="menuPage.jsp" %>
            <%@include file="customer/main.jsp" %>
            <%@include file="footer.jsp" %>
        </div>
        <jsp:include page="loadScript.jsp"></jsp:include>
        <script src="assets/js/checkPass.js"></script>
    </body>
</html>