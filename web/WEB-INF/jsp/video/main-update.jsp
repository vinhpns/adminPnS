<%-- 
    Document   : main-update
    Created on : Oct 21, 2019, 11:19:57 AM
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
                        <a href="#">Chỉnh sửa Video</a>
                    </li>
                </ul>
            </div>
            <div class="modal fade" id="myModalUpdate_${video.id}" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <form action="video.htm" method="post" modelAttribute="video" class="form-horizontal"
                          role="form" enctype="multipart/form-data">
                                <%@include file="form-update.jsp" %>
                        
                    </form>
                </div>
            </div>
        </div>
    </div>
</html>
