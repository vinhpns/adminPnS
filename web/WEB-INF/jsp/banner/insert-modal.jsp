    <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <div>
                        <label for="form-field-8">Link Banner</label>
                        <input required="" type="url" id="form-field-11" placeholder="Link Banner"
                               class="autosize-transition form-control" name="link"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <div>
                        <label for="form-field-11">Ảnh Sản Phẩm</label>
                        <input required="" multiple="" name="images" type="file" id="id-input-file-1"/>
                    </div>
                    <div>
                        <label for="form-field-select-1">Loại Banner</label>
                        <select id="form-field-1" class="autosize-transition form-control"
                                name="typeId">
                            <c:forEach var="typebanner" items="${sessionScope.type}">
                                <option value="${typebanner.id}">${typebanner.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
