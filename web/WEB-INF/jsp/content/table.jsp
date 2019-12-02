<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div>
        <table id="dynamic-table" class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Phần Nội Dung</th>
                    <th>Ảnh Nội Dung</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="banner" items="${list}" varStatus="counter">
                <tr>
                    <td>${counter.index +1}</td>
                    <td>
                <c:forEach var="r" items="${type}">
                    <c:if test="${r.id == banner.type}">${r.name}</c:if>
                </c:forEach>
                </td>
                <td style="text-align: center">
                    <img class="hidden-sm hidden-xs action-buttons"
                         src="${banner.image}" width="200" height="80">
                    <img class="hidden-md hidden-lg" src="${banner.image}" width="100"
                         height="40">
                </td>
                <td>
                    <div class="hidden-sm hidden-xs action-buttons">
                        <a class="green" href="?get&id=${banner.id}&url=${url}">
                            <i class="aec-icon fa fa-pencil bigger-130"></i>
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
                                    <a data-toggle="modal" data-target="#myModalUpdate_${banner.id}">
                                        <i class="aec-icon fa fa-pencil bigger-130"></i>
                                    </a>
                                </li>
                                <li>
                                    <a class="red"
                                       href="banner.htm?delete&id=${banner.id}"
                                       onclick="return confirm('Bạn có chắc chắn muốn xóa không')">
                                        <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </td>
                </tr>
                <div class="modal fade" id="myModalUpdate_${banner.id}" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <form action="banner.htm" method="post" class="form-horizontal"
                              role="form" enctype="multipart/form-data">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Chỉnh sửa banner</h4>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary btn-lg" type="submit" name="update">Cập nhật</button>
                                    <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Đóng</button>
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
