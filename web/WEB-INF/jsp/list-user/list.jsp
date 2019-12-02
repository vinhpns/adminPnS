<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12">
        <div class="clearfix">
            <div class="pull-right tableTools-container"></div>
        </div>
        <c:if test="${url == 'admin'}">
            <div class="table-header" style="font-size: 20px">
                Danh sách nhân viên
            </div>
        </c:if>
        <c:if test="${url == 'customer'}">
            <div class="table-header" style="font-size: 20px">
                Danh sách khách hàng
            </div>
        </c:if>
        <div>
            <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                <c:if test="${url == 'admin'}">
                    <th>Họ Tên Nhân Viên</th>
                </c:if>
                <c:if test="${url == 'customer'}">
                    <th>Họ Tên Khách Hàng</th>
                </c:if>
                <th class="hidden-480">Email</th>
                <th class="">Số điện thoại</th>
                <th class="hidden-480">Vai trò</th>
                <th class="hidden-480">Tình trạng</th>
                <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="ind" value="0"/>
                <c:forEach var="user" items="${listUser}">
                    <c:set var="ind" value="${ind+1}"/>
                    <tr>
                        <td>${user.fullName}</td>
                        <td class="hidden-480">${user.email}</td>
                        <td class=""><a href="tel:${user.phone}">${user.phone}</a></td>

                        <td class="hidden-480">
                    <c:forEach var="role" items="${listRole}">
                        <c:if test="${role.id == user.roleId}">${role.name}</c:if>
                    </c:forEach>
                    </td>
                    <td class="hidden-480" style="text-align: center">
                    <c:if test="${user.active == true}">
                        <a href="?lock&id=${user.id}&status=${user.active}&url=${url}"
                           onclick="return confirm('Bạn có muốn khóa Tài khoản này không ?')"
                           data-toggle="tooltip" title="Khoá Tài Khoản">
                            <i class="fa fa-unlock bigger-150 button-lock"></i>
                        </a>
                    </c:if>
                    <c:if test="${user.active == false}">
                        <a href="?lock&id=${user.id}&status=${user.active}&url=${url}"
                           onclick="return confirm('Bạn có muốn mở khóa Tài khoản này không ?')"
                           data-toggle="tooltip" title="Mở Khoá Tài Khoản">
                            <i class="fa fa-lock bigger-150 button-lock"></i>
                        </a>
                    </c:if>
                    </td>
                    <td style="text-align: center">
                        <div class="hidden-sm hidden-xs btn-group">
                            <a class="blue" href="?get&id=${user.id}&url=${url}">
                                <i class="ace-icon fa fa-pencil bigger-130 button-edit"
                                   title="Chỉnh sửa" data-toggle="tooltip">
                                </i>
                            </a>
                            <a class="red" title="Xoá tài khoản"
                               onclick="return confirm('Bạn có muốn xóa Tài khoản này không ?')"
                               href="?delete&id=${user.id}&url=${url}">
                                <i class="fa fa-trash-o bigger-150"></i>
                            </a>
                            <a data-toggle="modal" data-target="#myModalUpdate_${user.id}">
                                <i class="ace-icon fa fa-random bigger-130 green"></i>
                            </a>
                        </div>
                        <div class="hidden-md hidden-lg" style="text-align: center">
                            <div class="inline pos-rel">
                                <button class="btn btn-minier btn-primary dropdown-toggle"
                                        data-toggle="dropdown" data-position="auto">
                                    <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                </button>

                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                    <li>
                                    <c:if test="${user.active == true}">
                                        <a href="?lock&id=${user.id}&status=${user.active}"
                                           onclick="return confirm('Bạn có muốn khóa Tài khoản này không ?')"
                                           data-toggle="tooltip" title="Khoá Tài Khoản">
                                            <i class="fa fa-unlock bigger-150 button-lock"></i>
                                        </a>
                                    </c:if>
                                    <c:if test="${user.active == false}">
                                        <a href="?lock&id=${user.id}&status=${user.active}"
                                           onclick="return confirm('Bạn có muốn mở khóa Tài khoản này không ?')"
                                           data-toggle="tooltip" title="Mở Khoá Tài Khoản">
                                            <i class="fa fa-lock bigger-150 button-lock"></i>
                                        </a>
                                    </c:if>
                                    </li>
                                    <li>
                                        <a class="green">
                                            <i class="ace-icon fa fa-pencil bigger-130"
                                               data-target="#modal-table${ind}"
                                               data-toggle="modal">
                                            </i>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="red"
                                           onclick="return confirm('Bạn có muốn xóa Tài khoản này không ?')"
                                           href="?delete&id=${user.id}">
                                            <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </td>
                    </tr>
                    <div class="modal fade" id="myModalUpdate_${user.id}" role="dialog">
                        <div class="modal-dialog">
                            <!-- Modal content-->
                            <form action="ListUser.htm" method="post" modelAttribute="account" class="form-horizontal"
                                  role="form" enctype="multipart/form-data">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Thay đổi mật khẩu</h4>
                                    </div>
                                    <div class="modal-body">
                                        <%@include file="update-modal.jsp" %>
                                    </div>
                                    <div class="modal-footer">
                                        <button class="btn btn-primary btn-lg" type="submit" name="updatePass">Cập nhập</button>
                                        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</html>
