<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div>
        <table id="dynamic-table" class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th class="hidden-480">STT</th>
                    <th>Tiêu đề</th>
                    <th>Thao Tác</th>
                </tr>
            </thead>
            <tbody>
            <c:set var="index" value="0"/>
            <c:forEach var="a" items="${listEmail}">
                <c:set var="index" value="${index + 1}"/>
                <tr>
                    <td class="hidden-480">${index}</td>
                    <td>${a.title}</td>
                    <td>
                        <div class="hidden-sm hidden-xs action-buttons">
                            <a class="green" href="?get&id=${a.id}">
                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                            </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</html>
