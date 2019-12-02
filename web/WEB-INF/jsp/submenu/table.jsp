<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr style="color: #fff; background-color: #17a2b8">
                <th>Tên Menu</th>
                <th>Thuộc Menu</th>
                <th>Số bài viết</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
        <td>3</td>
        <td>3</td>
        <td>3</td>
        <td>
        <c:if test="${menu.active == true}">
            <a href="?changeStatus&id=${menu.id}&status=${menu.active}">
                <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa Menu"></i>
            </a>
        </c:if>
        <c:if test="${menu.active == false}">
            <a href="?id=${menu.id}&status=${menu.active}">
                <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa Menu"></i>
            </a>
        </c:if>
        <a data-toggle="modal" data-target="#changeMenuInfo_${menu.id}">
            <i class="fa fa-edit" style="color: orange; font-size: 16px" title="Chỉnh sửa Menu"></i>
        </a>
        <a href="?delete&id=${menu.id}">
            <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa Menu"></i>
        </a>
    </td>
    <!--        <tbody>
                <c:forEach var="menu" items="${listMenu}">
                    <tr>
                        <td>s</td>
                        <td>3
                            <a href="?getSubMenu&id=${menu.id}">3
                            </a>
                        </td>
                        <td>
                    <c:if test="${menu.active == true}">
                        <a href="?changeStatus&id=${menu.id}&status=${menu.active}">
                            <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa Menu"></i>
                        </a>
                    </c:if>
                    <c:if test="${menu.active == false}">
                        <a href="?id=${menu.id}&status=${menu.active}">
                            <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa Menu"></i>
                        </a>
                    </c:if>
                    <a data-toggle="modal" data-target="#changeMenuInfo_${menu.id}">
                        <i class="fa fa-edit" style="color: orange; font-size: 16px" title="Chỉnh sửa Menu"></i>
                    </a>
                    <a href="?delete&id=${menu.id}">
                        <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa Menu"></i>
                    </a>
                    </td>
                    </tr>
                    <div class="modal fade" id="changPass_${menu.id}" role="dialog">
                        <div class="modal-dialog">
                             Modal content
                            <form action="ListFooterNews.htm" method="post" modelAttribute="ban" class="form-horizontal"
                                  role="form" enctype="multipart/form-data">
                                <div class="modal-content">
                                    <div class="modal-header" style="display: inline">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h3 class="modal-title">Chỉnh sửa Menu</h3>
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
                    </div>
                </c:forEach>
            </tbody>-->
</table>
</html>
