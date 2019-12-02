<%-- 
    Document   : index
    Created on : Aug 14, 2018, 12:08:57 PM
    Author     : ASUS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
    <link rel="icon" href="assets/images/favicon.png" type="image/png" sizes="32x32">
    <link rel="stylesheet" href="assets/css/loadImg.css"/>
    <%@include file="header.jsp" %>
    <body class="no-skin">
        <div class="main-container ace-save-state" id="main-container">
            <%@include file="menuPage.jsp" %>
            <%@include file="rank/main-update.jsp" %>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <%@include file="loadScript.jsp" %>
    <script src="assets/js/loadImg.js"></script>
</html>