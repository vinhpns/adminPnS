<%-- 
    Document   : main-index
    Created on : Dec 1, 2019, 12:32:22 PM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
        <body class="hold-transition sidebar-mini">
            <div class="wrapper">
            <jsp:include page="navigation-bar.jsp"></jsp:include>
            <jsp:include page="menuPage.jsp"></jsp:include>
                <div class="content-wrapper">
                <jsp:include page="support/right-address.jsp"></jsp:include>
                    <form action="type.htm" method="post" class="form-horizontal"
                          role="form" enctype="multipart/form-data" modelAttribute="type">
                        <div class="row col-12">
                        <jsp:include page="type/form-input.jsp"></jsp:include>
                            <button type="submit" name="update" style="float: right;" class="btn btn-primary">Cập Nhật</button>
                        </div>
                    </form>
                </div>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <jsp:include page="loadScript.jsp"></jsp:include>
    </div>
</body>
<script src="assets/js/uploadImg.js"></script>
</html>
