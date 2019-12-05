<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr style="color: #fff; background-color: #17a2b8">
                <th>Tên Menu</th>
                <th>Sub Menu</th>
                <th>Vị Trí</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="menu" items="${menuList}">
            <tr>
                <td>${menu.name}</td>
                <td><a href="?getSubMenu&id=${menu.id}">${menu.count}</a></td>
                <td>${menu.position}</td>
                <td>
            <c:if test="${menu.active == true}">
                <a href="?changeStatus&id=${menu.id}&status=${menu.active}">
                    <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa tài khoản"></i>
                </a>
            </c:if>
            <c:if test="${menu.active == false}">
                <a href="?changeStatus&id=${menu.id}&status=${menu.active}">
                    <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa tài khoản"></i>
                </a>
            </c:if>
            <a href="?edit&id=${menu.id}">
                <i class="fa fa-edit" style="color: blue; font-size: 16px" title="Chỉnh sửa"></i>
            </a>
            <a href="?delete&id=${menu.id}">
                <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa tài khoản"></i>
            </a>
            </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</html>
