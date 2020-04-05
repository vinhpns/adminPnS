<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr style="color: #fff; background-color: #17a2b8">
                <th>STT</th>
                <th>Họ Và Tên</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Ngành</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="register" items="${registerList}" varStatus="counter">
            <tr>
                <td>${counter.index + 1}</td>
                <td>${register.fullName}</td>
                <td>${register.email}</td>
                <td>${register.phone}</td>
                <td>${register.speciaization}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</html>
