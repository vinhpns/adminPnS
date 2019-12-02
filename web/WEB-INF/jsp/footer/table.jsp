<%-- 
    Document   : table
    Created on : Oct 4, 2019, 10:26:35 AM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div>
        <table id="dynamic-table" class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Tiêu đề</th>
                    <th>Chuyên Mục</th>
                    <!--<th class="hidden-480">Mật khẩu</th>-->
                    <th class="hidden-480">Tình trạng</th>
                    <th>Thao Tác</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="news" items="${news}" varStatus="counter">
                <tr>
                    <td>${counter.index + 1}</td>
                    <td>${news.title}</td>
                    <td>
                <c:forEach var="r" items="${typeNews}">
                    <c:if test="${r.id == news.type}">${r.name}</c:if>
                </c:forEach>
                </td>
                <td class="text-center hidden-480">
                    <span class="status_active">
                        <c:if test="${news.active == true}">
                            <a href="ListFooterNews.htm?lock&id=${news.id}&status=${news.active}">
                                <i class="fa fa-unlock bigger-150 blue"></i>
                            </a>
                        </c:if>
                        <c:if test="${news.active == false}">
                            <a href="ListFooterNews.htm?lock&id=${news.id}&status=${news.active}">
                                <i class="fa fa-lock bigger-150 blue"></i>
                            </a>
                        </c:if>
                    </span>
                </td>
                <td>
                    <div class="hidden-sm hidden-xs action-buttons">
                        <a class="green" href="?get&id=${news.id}">
                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                        </a>
                        <a class="red" href="ListFooterNews.htm?delete&id=${news.id}"
                           onclick="return confirm('Bạn có chắc chắn muốn xóa không')">
                            <i class="ace-icon fa fa-trash bigger-130"></i>
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
                                    <a data-toggle="modal" data-target="#myModalUpadte_${news.id}">
                                        <i class="ace-icon fa fa-pencil bigger-130">
                                        </i>
                                    </a>
                                </li>
                                <li>
                                <c:if test="${news.active == true}">
                                    <a href="ListFooterNews.htm?lock&id=${news.id}&status=${news.active}">
                                        <i class="fa fa-unlock  bigger-150 blue"></i>
                                    </a>
                                </c:if>
                                <c:if test="${news.active == false}">
                                    <a href="ListFooterNews.htm?lock&id=${news.id}&status=${news.active}">
                                        <i class="fa fa-lock bigger-150 blue"></i>
                                    </a>
                                </c:if>
                                </li>
                                <li>
                                    <a class="red" href="ListFooterNews.htm?delete&id=${news.id}"
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
                <div class="modal fade" id="myModalUpadte_${news.id}" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <form action="ListFooterNews.htm" method="post" modelAttribute="ban" class="form-horizontal"
                              role="form" enctype="multipart/form-data">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Thêm Footer</h4>
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
    </div>
</html>
