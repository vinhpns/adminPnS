<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
    <%@include file="header.jsp" %>
    <body class="no-skin">
        <div class="main-container ace-save-state" id="main-container">
            <%@include file="menuPage.jsp" %>
            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="index.htm">Home</a>
                            </li>
                            <li>
                                <a href="video.htm">Quản Lý Video</a>
                            </li>
                            <li class="active">Đăng Video</li>
                        </ul><!-- /.breadcrumb -->
                    </div>
                    <div class="page-content">
                        <!-- /.ace-settings-container -->
                        <div class="row">
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                <div class="modal-header no-padding">
                                    <div class="table-header">
                                        Chỉnh Sửa Video
                                    </div>
                                </div>
                                <form action="video.htm" method="post" modelAttribute="video" class="form-horizontal"
                                      role="form" enctype="multipart/form-data">
                                    <%@include file="video/form-update.jsp" %>
                                </form>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal-dialog -->
                    </div>
                    <%@include file="footer.jsp" %>
                </div>
            </div>
        </div>
    </body>
    <%@include file="loadScript.jsp" %>
    <script src="assets/js/loadImg.js"></script>
</html>
