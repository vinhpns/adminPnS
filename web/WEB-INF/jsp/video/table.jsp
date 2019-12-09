<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr style="color: #fff; background-color: #17a2b8">
                <th style="width: 20px">STT</th>
                <th style="width: 200px">Title</th>
                <th style="width: 200px">Link</th>
                <th style="width: 50px">Thao Tác</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="video" items="${videoList}" varStatus="counter">
            <tr>
                <td>${counter.index + 1}</td>
                <td>${video.title}</td>
                <td>
                    <iframe src="${video.link}"></iframe>
                </td>
                <td>
            <c:if test="${video.active == true}">
                <a href="?changeStatus&id=${video.id}&status=${video.active}">
                    <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa Banner"></i>
                </a>
            </c:if>
            <c:if test="${video.active == false}">
                <a href="?changeStatus&id=${video.id}&status=${video.active}">
                    <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa Banner"></i>
                </a>
            </c:if>
            <a data-toggle="modal" data-target="#changInfo_${video.id}">
                <i class="fa fa-edit" style="color: blue; font-size: 16px" title="Chỉnh sửa"></i>
            </a>
            <a href="?delete&id=${video.id}">
                <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa Menu"></i>
            </a>
            </td>
            </tr>
            <input value="yes" name="sub" hidden="" />
            <input value="${video.id}" name="id" hidden=""/>
            <div class="modal fade" id="changInfo_${video.id}" role="dialog">
                <div class="modal-dialog">
                    Modal content
                    <form action="video.htm" method="post" modelAttribute="video" class="form-horizontal"
                          role="form" enctype="multipart/form-data">
                        <div class="modal-content">
                            <div class="modal-header" style="display: inline">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h3 class="modal-title">Chỉnh sửa Video</h3>
                            </div>
                            <div class="modal-body">
                                <%@include file="update-modal.jsp" %>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-primary btn-lg" type="submit" name="update">Cập Nhật</button>
                                <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </c:forEach>
    </tbody>
</table>
</html>
