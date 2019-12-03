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
    <jsp:include page="header.jsp"></jsp:include>
        <body class="hold-transition sidebar-mini">
            <div class="wrapper">
            <jsp:include page="navigation-bar.jsp"></jsp:include>
            <jsp:include page="menuPage.jsp"></jsp:include>
                <div class="content-wrapper">
                    <section class="content-header">
                        <div class="container-fluid">
                            <div class="row mb-2">
                                <div class="col-sm-6">
                                    <h1>Menu</h1>
                                </div>
                                <div class="col-sm-6">
                                    <ol class="breadcrumb float-sm-right">
                                        <li class="breadcrumb-item"><a href="index.htm">Home</a></li>
                                        <li class="breadcrumb-item active">Menu</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section class="content">
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h3 class="card-title">Danh sách các mục Menu</h3>
                                    </div>
                                    <button type="button" style="font-size: 20px; width: 200px; margin-left: 25px; margin-top: 25px;" 
                                            class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Thêm Menu
                                    </button>
<!--                                    <div class="modal fade" id="myModal" role="dialog">
                                    <div class="modal-dialog">
                                         Modal content
                                        <form action="Menu.htm" method="post" modelAttribute="ban" class="form-horizontal"
                                              role="form" enctype="multipart/form-data">
                                            <div class="modal-content">
                                                <div class="modal-header" style="display: inline">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h3 class="modal-title">Thêm Menu</h3>
                                                </div>
                                                <div class="modal-body">
                                                
                                                </div>
                                                <div class="modal-footer">
                                                    <button class="btn btn-primary btn-lg" type="submit" name="update">Cập Nhật</button>
                                                    <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Close</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>-->
                                <div class="card-body">
                                    <%@include file="comment/table.jsp" %>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
            </div>
        <jsp:include page="loadScript.jsp"></jsp:include>
    </body>
</html>