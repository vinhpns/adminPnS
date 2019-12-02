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
                Danh sách các sản phẩm
            </div>
            <div>
                <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th class="hidden-480">STT</th>
                            <th>Tên Sản Phẩm</th>
                            <th class="hidden-480">Giá Bán</th>
                            <th class="hidden-480">Tình Trạng</th>
                            <th>Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="saleProducts" items="${saleProduct}" varStatus="counter">
                            <tr>
                                <td class="hidden-480">${counter.index + 1}</td>
                                <td class="hidden-480">${saleProducts.name}</td>
                                <td><fmt:formatNumber value="${saleProducts.price}"/></td>
                                <td>
                                    <div class="form-check">
                                        <c:if test="${saleProducts.hrApproved == true}">
                                            <input type="checkbox" class="form-check-input" onClick="this.checked = !this.checked;" id="materialUnchecked" checked>
                                        </c:if>
                                        <c:if test="${saleProducts.hrApproved == false}">
                                            <input type="checkbox" class="form-check-input" onClick="this.checked = !this.checked;" id="materialUnchecked">
                                        </c:if>
                                        <label class="form-check-label" for="materialUnchecked">HR duyệt</label>
                                    </div>
                                    <div class="form-check">
                                        <c:if test="${saleProducts.accApproved == true}">
                                            <input type="checkbox" class="form-check-input" onClick="this.checked = !this.checked;" id="materialUnchecked" checked>
                                        </c:if>
                                        <c:if test="${saleProducts.accApproved == false}">
                                            <input type="checkbox" class="form-check-input" onClick="this.checked = !this.checked;" id="materialUnchecked">
                                        </c:if>
                                        <label class="form-check-label" for="materialUnchecked">Kế toán duyệt</label>
                                    </div>
                                    <div class="form-check">
                                        <c:if test="${saleProducts.writerApproved == true}">
                                            <input type="checkbox" class="form-check-input" onClick="this.checked = !this.checked;" id="materialUnchecked" checked>
                                        </c:if>
                                        <c:if test="${saleProducts.writerApproved == false}">
                                            <input type="checkbox" class="form-check-input" onClick="this.checked = !this.checked;" id="materialUnchecked">
                                        </c:if>
                                        <label class="form-check-label" for="materialUnchecked">Content duyệt</label>
                                    </div>
                                    <div class="form-check">
                                        <c:if test="${saleProducts.modApproved == true}">
                                            <input type="checkbox" class="form-check-input" onClick="this.checked = !this.checked;" id="materialUnchecked" checked>
                                        </c:if>
                                        <c:if test="${saleProducts.modApproved == false}">
                                            <input type="checkbox" class="form-check-input" onClick="this.checked = !this.checked;" id="materialUnchecked">
                                        </c:if>
                                        <label class="form-check-label" for="materialUnchecked">Mod duyệt</label>
                                    </div>
                                </td>
                                <td>
                                    <div class="hidden-sm hidden-xs action-buttons">
                                        <a href="?editProduct&id=${saleProducts.id}&url=SaleProduct.htm">
                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                        </a>
                                        <a class="green" href="SaleProduct.htm?approved&id=${saleProducts.id}">
                                            <i title="Duyệt sản phẩm" class="ace-icon fa fa-check-circle bigger-130"></i>
                                        </a>
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
