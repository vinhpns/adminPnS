<%-- 
    Document   : table
    Created on : Oct 3, 2019, 12:38:01 PM
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
                Danh sách các Video
            </div>
            <div>
                <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tiêu Đề</th>
                            <th>Loại</th>
                            <th>Ảnh Video</th>
                            <th class="hidden-480">Trạng Thái</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="video" items="${videoList}" varStatus="counter">
                        <tr>
                            <td>${counter.index +1}</td>
                            <td>${video.title}</td>
                            <td>
                        <c:forEach var="r" items="${typeVideo}">
                            <c:if test="${r.id == video.type}">${r.name}</c:if>
                        </c:forEach>
                        </td>
                        <td style="text-align: center">
                            <img class="hidden-sm hidden-xs action-buttons" src="${video.image}"
                                 width="200" height="80">
                            <img class="hidden-md hidden-lg" src="${video.image}" width="100"
                                 height="40">
                        </td>
                        <td class="text-center hidden-480">
                            <span class="status_active">
                                <c:if test="${video.active == true}">
                                    <a href="video.htm?lock&id=${video.id}&status=${video.active}">
                                        <i class="fa fa-unlock  bigger-150 blue"></i>
                                    </a>
                                </c:if>
                                <c:if test="${video.active == false}">
                                    <a href="video.htm?lock&id=${video.id}&status=${video.active}">
                                        <i class="fa fa-lock bigger-150 blue"></i>
                                    </a>
                                </c:if>
                            </span>
                        </td>
                        <td>
                            <div class="hidden-sm hidden-xs action-buttons">
                                <a class="green" href="?get&id=${video.id}">
                                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                                </a>
                                <a class="red" href="video.htm?delete&id=${video.id}"
                                   onclick="return confirm('Bạn có chắc chắn muốn xóa không')">
                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                </a>
                            </div>
                            <div class="hidden-md hidden-lg">
                                <div class="inline pos-rel">
                                    <button class="btn btn-minier btn-primary dropdown-toggle"
                                            data-toggle="dropdown" data-position="auto">
                                        <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                    </button>
                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                        <li>
                                            <a class="green" href="?get&id=${video.id}">
                                               <i class="ace-icon fa fa-pencil bigger-130">
                                               </i>
                                            </a>
                                        </li>
                                        <li>
                                        <c:if test="${video.active == true}">
                                            <a href="video.htm?lock&id=${video.id}&status=${video.active}">
                                                <i class="fa fa-unlock  bigger-150 blue"></i>
                                            </a>
                                        </c:if>
                                        <c:if test="${video.active == false}">
                                            <a href="video.htm?lock&id=${video.id}&status=${video.active}">
                                                <i class="fa fa-lock bigger-150 blue"></i>
                                            </a>
                                        </c:if>
                                        </li>
                                        <li>
                                            <a class="red"
                                               href="video.htm?delete&id=${video.id}"
                                               onclick="return confirm('Bạn có chắc chắn muốn xóa không')">
                                                <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                            </a>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</html>
