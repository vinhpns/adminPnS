<%-- 
    Document   : list
    Created on : Oct 2, 2019, 11:17:14 PM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="row">
        <div class="col-xs-12">
            <div class="clearfix">
                <div class="pull-right tableTools-container"></div>
            </div>
            <div class="table-header">
                Danh sách danh hiệu
            </div>
            <div>
                <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên danh hiệu</th>
                            <th>Điểm đổi danh hiệu</th>
                            <th>Icon</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="rank" items="${rank}" varStatus="counter">
                        <tr>
                            <td>${counter.index + 1}</td>
                            <td>${rank.name}</td>
                            <td>${rank.requirePoint}</td>
                            <td style="text-align: center">
                                <img class="hidden-sm hidden-xs action-buttons" src="${rank.icon}"
                                     width="200" height="160">
                                <img class="hidden-md hidden-lg" src="${rank.icon}" width="100"
                                     height="40">
                            </td>
                            <td>
                                <a class="blue" href="?get&id=${rank.id}">
                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                            </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</html>
