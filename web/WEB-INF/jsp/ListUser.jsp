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
    <body class="no-skin">
        <%@include file="header.jsp" %>
        <div class="main-container ace-save-state" id="main-container" style="font-size:15px">
            <%@include file="menuPage.jsp" %>
            <%@include file="list-user/main.jsp" %>
            <%@include file="footer.jsp" %>
        </div>
        <jsp:include page="loadScript.jsp"></jsp:include>
        <script src="assets/js/checkPass.js"></script>
        <script src="assets/js/checkinput.js"></script>
    </body>
</html>