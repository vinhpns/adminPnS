<%-- 
    Document   : table
    Created on : Oct 7, 2019, 10:42:41 AM
    Author     : SGDG Company
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div>
        <table id="dynamic-table" class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th class="hidden-480">STT</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá khởi điểm</th>
                    <th class="hidden-480">Tình trạng</th>
                    <th>Thao Tác</th>
                </tr>
            </thead>
            <tbody>
            <c:set var="index" value="0"/>
            <c:forEach var="bid" items="${bidProducts}">
                <c:set var="index" value="${index + 1}"/>
                <tr>
                    <td class="hidden-480">${index}</td>
                    <td>${bid.name}</td>
                    <td> 
                        <fmt:formatNumber value="${bid.price}"/>
                    </td>
                    <td class="hidden-480">
                        <div class="form-check">
                            <c:if test="${bid.hrApproved == true}">
                                <input type="checkbox" class="form-check-input"
                                       onClick="this.checked = !this.checked;"
                                       id="materialUnchecked" checked>
                            </c:if>
                            <c:if test="${bid.hrApproved == false}">
                                <input type="checkbox" class="form-check-input"
                                       onClick="this.checked = !this.checked;"
                                       id="materialUnchecked">
                            </c:if>
                            <label class="form-check-label" for="materialUnchecked">HR duyệt</label>
                        </div>
                        <div class="form-check">
                            <c:if test="${bid.accApproved == true}">
                                <input type="checkbox" class="form-check-input"
                                       onClick="this.checked = !this.checked;"
                                       id="materialUnchecked" checked>
                            </c:if>
                            <c:if test="${bid.accApproved == false}">
                                <input type="checkbox" class="form-check-input"
                                       onClick="this.checked = !this.checked;"
                                       id="materialUnchecked">
                            </c:if>
                            <label class="form-check-label" for="materialUnchecked">Kế toán
                                duyệt</label>
                        </div>
                        <div class="form-check">
                            <c:if test="${bid.writerApproved == true}">
                                <input type="checkbox" class="form-check-input"
                                       onClick="this.checked = !this.checked;"
                                       id="materialUnchecked" checked>
                            </c:if>
                            <c:if test="${bid.writerApproved == false}">
                                <input type="checkbox" class="form-check-input"
                                       onClick="this.checked = !this.checked;"
                                       id="materialUnchecked">
                            </c:if>
                            <label class="form-check-label" for="materialUnchecked">Content
                                duyệt</label>
                        </div>
                        <div class="form-check">
                            <c:if test="${bid.modApproved == true}">
                                <input type="checkbox" class="form-check-input"
                                       onClick="this.checked = !this.checked;"
                                       id="materialUnchecked" checked>
                            </c:if>
                            <c:if test="${bid.modApproved == false}">
                                <input type="checkbox" class="form-check-input"
                                       onClick="this.checked = !this.checked;"
                                       id="materialUnchecked">
                            </c:if>
                            <label class="form-check-label" for="materialUnchecked">Mod
                                duyệt</label>
                        </div>
                    </td>
                    <td>
                        <div class="hidden-sm hidden-xs action-buttons">
                            <a href="?get&id=${bid.id}">
                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                            </a>
                            <a class="green" href="SaleBid.htm?approved&id=${bid.id}">
                                <i title="Duyệt sản phẩm"
                                   class="ace-icon fa fa-check-circle bigger-130"></i>
                            </a>
                            <c:if test="${sessionScope.roleiz == 5 || sessionScope.roleiz == 6 || sessionScope.roleiz == 7}">
                                <a class="red" href="SaleBid.htm?returnStatus&id=${bid.id}">
                                    <i title="Yêu cầu sửa" class="ace-icon fa fa-undo bigger-130"></i>
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
                                        <a href="?get&id=${bid.id}">
                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="green" href="SaleBid.htm?approved&id=${bid.id}">
                                            <i title="Duyệt sản phẩm"
                                               class="ace-icon fa fa-check-circle bigger-130"></i>
                                        </a>
                                    </li>
                                    <c:if test="${sessionScope.roleiz == 5 || sessionScope.roleiz == 6 || sessionScope.roleiz == 7}">
                                        <a class="red" href="SaleBid.htm?returnStatus&id=${bid.id}">
                                            <i title="Yêu cầu sửa" class="ace-icon fa fa-undo bigger-130"></i>
                                        </a>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</html>
