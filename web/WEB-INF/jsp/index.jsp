<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="en">
    <jsp:include page="header.jsp"></jsp:include>
        <body class="hold-transition sidebar-mini">
            <div class="wrapper">
            <jsp:include page="navigation-bar.jsp"></jsp:include>
            <jsp:include page="menuPage.jsp"></jsp:include>
                <div class="content-wrapper">
                <jsp:include page="support/right-address.jsp"></jsp:include>
                <jsp:include page="index/main-index.jsp"></jsp:include>
                </div>
            <jsp:include page="footer.jsp"></jsp:include>
            <jsp:include page="loadScript.jsp"></jsp:include>
        </div>
    </body>
</html>
s