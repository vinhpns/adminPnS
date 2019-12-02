<%-- 
    Document   : main-update
    Created on : Oct 19, 2019, 5:21:38 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="index.htm">Trang chủ</a>
                    </li>
                    <li>
                        <a href="#">Chỉnh sửa Bài Viết</a>
                    </li>
                </ul>
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <form action="news.htm" method="post" modelAttribute="new" class="form-horizontal" role="form"
                              enctype="multipart/form-data">
                            <%@include file="form-update.jsp" %>
                            <div class="col-md-6">
                                <button style="float: right; border-radius: 10px" class="btn btn-primary btn-lg"
                                        type="submit" name="update">Cập nhập
                                </button>
                            </div>
                            <div class="col-md-6">
                                <button style="border-radius: 10px"
                                        class="btn btn-primary btn-lg" href="newsContent.htm">Quay Lại
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
