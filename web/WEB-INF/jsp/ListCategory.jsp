<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<body class="no-skin">
<%@include file="header.jsp" %>
<div class="main-container ace-save-state" id="main-container">
    <%@include file="menuPage.jsp" %>
    <%@include file="category/main.jsp" %>
    <%@include file="footer.jsp" %>
</div>
<%@include file="loadScript.jsp" %>
</body>
</html>