<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="row">
        <div class="col-xs-12">
            <div class="clearfix">
                <div class="pull-right tableTools-container"></div>
            </div>
            <div class="table-header">
                Danh Sách Các Thương Hiệu đã xoá
            </div>
            <div>
                <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên Thương Hiệu</th>
                            <th>Logo Thương Hiệu</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:set var="index" value="-1"/>
                    <c:forEach var="brandList" items="${brands}">
                        <c:set var="index" value="${index + 1}"/>
                        <tr>
                            <td>${index+1}</td>
                            <td>${brandList.name}</td>
                            <td style="text-align: center">
                                <img class="hidden-sm hidden-xs action-buttons"
                                     src="${brandList.image}" width="200" height="80">
                                <img class="hidden-md hidden-lg" src="${brandList.image}"
                                     width="100" height="40">
                            </td>
                            
                            <td>
                             <div class="hidden-sm hidden-xs action-buttons">
                                    <a class="green" href="?action&id=${brandList.id}&url=reup">
                                        <i class="aec-icon fa fa-repeat bigger-130"></i>
                                    </a>
                                    <c:if test="${sessionScope.roleiz=='9'|| sessionScope.roleiz=='6'}">
                                        <a class="red" href="brandpages.htm?action&id=${brandList.id}&url=delete"
                                           onclick="return confirm('Bạn có chắc chắn muốn xóa không')">
                                            <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                        </a>
                                    </c:if>   
                                </div>
                                <div class="hidden-md hidden-lg">
                                    <div class="inline pos-rel">
                                        <button class="btn btn-minier btn-primary dropdown-toggle"
                                                data-toggle="dropdown" data-position="auto">
                                            <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                        </button>
                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                            <li>
                                                <a href="brandpages.htm?get&id=${brandList.id}"
                                                   class="green">
                                                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                </a>
                                            </li>
                                            <li>
                                            <c:if test="${brandList.active == 'false'}"><a
                                                    href="brandpages.htm?lock&id=${brandList.id}&status=${brandList.active}"><i
                                                        class="fa fa-lock bigger-150"></i></a></c:if>
                                            <c:if test="${brandList.active == 'true'}"><a
                                                    href="brandpages.htm?lock&id=${brandList.id}&status=${brandList.active}"><i
                                                        class="fa fa-unlock bigger-150"></i></a></c:if>
                                            </li>
                                            <li>
                                                <a class="red"
                                                   href="brandpages.htm?delete&id=${brandList.id}"
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
                        <div class="modal fade" id="myModalUpdate_${brandList.id}" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <form action="brandpages.htm" method="post" modelAttribute="ban" class="form-horizontal"
                                      role="form" enctype="multipart/form-data">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Chỉnh sửa Thương Hiệu</h4>
                                        </div>
                                        <div class="modal-footer">
                                            <button class="btn btn-primary btn-lg" type="submit" name="insert">Cập nhập</button>
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
