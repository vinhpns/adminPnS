<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr style="color: #fff; background-color: #17a2b8">
                <th style="width: 20px">STT</th>
                <th style="width: 200px">Vị Trí</th>
                <th style="width: 500px">Ảnh</th>
                <th style="width: 50px">Thao Tác</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="banner" items="${bannerList}" varStatus="counter">
            <tr>
                <td>${counter.index + 1}</td>
                <td>Name</td>
                <td style="text-align: center"><img src="${banner.img}" style="width: 60%; height: 80%"></td>
                <td>
            <c:if test="${banner.active == true}">
                <a href="?changeStatus&id=${banner.id}&status=${banner.active}">
                    <i class="fa fa-unlock" style="color: green; font-size: 16px" title="Khóa Banner"></i>
                </a>
            </c:if>
            <c:if test="${banner.active == false}">
                <a href="?changeStatus&id=${banner.id}&status=${banner.active}">
                    <i class="fa fa-lock" style="color: green; font-size: 16px" title="Mở Khóa Banner"></i>
                </a>
            </c:if>
            <a href="?edit&id=${banner.id}">
                <i class="fa fa-edit" style="color: blue; font-size: 16px" title="Chỉnh sửa"></i>
            </a>
            <a href="?deleteMenu&id=${banner.id}">
                <i class="fa fa-remove" style="color: red; font-size: 16px" title="Xóa Menu"></i>
            </a>
            </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</html>
