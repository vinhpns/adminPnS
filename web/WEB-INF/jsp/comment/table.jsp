<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr style="color: #fff; background-color: #17a2b8">
                <th>STT</th>
                <th>Tên Khách Hàng</th>
                <th>Số Điện Thoại</th>
                <th>Email</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="comment" items="${commentList}" varStatus="counter">
                <tr>
                    <td>${counter.index + 1}</td>
                    <td>${comment.name}</td>
                    <td>${comment.phone}</td>
                    <td>${comment.email}</td>
                    <td>
                        <c:if test="${comment.active == true}">
                            <a href="?updateStatus&id=${comment.id}&active=${comment.active}">
                                <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa Comment"></i>
                            </a>
                        </c:if>
                        <c:if test="${comment.active == false}">
                            <a href="?updateStatus&id=${comment.id}&active=${comment.active}">
                                <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa Comment"></i>
                            </a>
                        </c:if>
                        <c:if test="${comment.isReply == false}">
                            <i class="fa fa-eye" data-toggle="modal" data-target="#myModalUpdate_${comment.id}" style="color: blue"></i>
                        </c:if>
                        <c:if test="${comment.isReply == true}">
                            <a data-toggle="modal" data-target="#edit_${comment.id}">
                                <i class="fa fa-edit" style="color: orange; font-size: 16px" title="Chỉnh sửa nội dung câu trả lời"></i>
                            </a>
                        </c:if>
                        <a href="?delete&id=${comment.id}">
                            <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa Menu"></i>
                        </a>
                    </td>
                </tr>
            <div class="modal fade" id="myModalUpdate_${comment.id}" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <form action="comment.htm" method="post" modelAttribute="ban" class="form-horizontal"
                              role="form" enctype="multipart/form-data">
                            <div class="modal-content">
                                <div class="modal-header" style="display: inline">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h3 class="modal-title">Nội Dung Comment</h3>
                                </div>
                                <div class="modal-body">
                                    <%@include file="reply.jsp" %> 
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary btn-lg" type="submit" name="update">Trả Lời</button>
                                    <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="edit_${comment.id}" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <form action="comment.htm" method="post" modelAttribute="ban" class="form-horizontal"
                              role="form" enctype="multipart/form-data">
                            <div class="modal-content">
                                <div class="modal-header" style="display: inline">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h3 class="modal-title">Nội Dung Comment</h3>
                                </div>
                                <div class="modal-body">
                                    <%@include file="fixReply.jsp" %> 
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary btn-lg" type="submit" name="update">Trả Lời</button>
                                    <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </tbody>
</table>
</html>
