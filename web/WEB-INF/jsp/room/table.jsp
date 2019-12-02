<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="row">
        <div class="col-xs-12">
            <div class="clearfix">
                <div class="pull-right tableTools-container"></div>
            </div>
            <div class="table-header">
                Danh sách phòng đấu giá
            </div>
            <div>
                <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th class="hidden-480">STT</th>
                            <th>Tên phòng</th>
                            <th class="hidden-480">Gía tiền thấp nhất</th>
                            <th class="hidden-480">Gía tiền cao nhất</th>
                            <th>Bước Giá</th>
                            <th class="hidden-480">Thời gian đấu</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:set var="index" value="0"/>
                    <c:forEach var="a" items="${rooms}">
                        <c:set var="index" value="${index + 1}"/>
                        <tr>
                            <td class="hidden-480">${index}</td>
                            <td>${a.name}</td>
                            <td class="hidden-480"><fmt:formatNumber value="${a.min}"/> đồng</td>
                            <td class="hidden-480"><fmt:formatNumber value="${a.max}"/> đồng</td>
                            <td><fmt:formatNumber value="${a.step}"/> đồng</td>
                            <td>${a.duration} tiếng</td>
                            <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a class="red" href="?delete&id=${a.id}"
                                       onclick="return confirm('Bạn có muốn xóa nhân viên này ?')">
                                        <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                    </a>
                                    <a data-toggle="modal" data-target="#myModalUpadte_${a.id}"><i class="ace-icon fa fa-pencil bigger-130"></i></a>
                                </div>
                                <div class="hidden-md hidden-lg">
                                    <div class="inline pos-rel">
                                        <button class="btn btn-minier btn-primary dropdown-toggle"
                                                data-toggle="dropdown" data-position="auto">
                                            <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                        </button>
                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                            <li>
                                                <a class="green">
                                                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a class="red" href="?delete&id=${a.id}"
                                                   onclick="return confirm('Bạn có muốn xóa nhân viên này ?')">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <div class="modal fade" id="myModalUpadte_${a.id}" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <form action="room.htm" method="post" modelAttribute="ban" class="form-horizontal"
                                      role="form" enctype="multipart/form-data">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Thêm Phòng</h4>
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
        </div>
    </div>
</html>
