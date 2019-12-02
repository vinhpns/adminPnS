<%-- 
    Document   : insert-modal
    Created on : Oct 7, 2019, 10:43:56 AM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="row">
        <div class="col-xs-12 col-sm-12">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <div>
                            <label for="form-field-8">Tên Sản Phẩm</label>
                            <input id="txt_box" required="" placeholder="Tên sản phẩm"
                                   class="autosize-transition form-control" name="name"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-9">Giá Bán</label>
                            <input required=""
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;"
                                   name="price" type="number" min="1" id="form-field-1-1"
                                   placeholder="Giá ban đầu"
                                   class="autosize-transition form-control">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-11">Ảnh Đại Diện</label>
                            <img src="">
                            <input required="" multiple="" name="fristImg" type="file"
                                   id="id-input-file-3"/>
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Bảo Hành</label>
                            <input id="txt_box1" placeholder="Bảo Hành Sản Phẩm"
                                   class="autosize-transition form-control" name="warranty"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div class="row">
                            <label class="col-form-label col-sm-5 pt-0">Loại Sản phẩm </label>
                            <div class="col-sm-7">
                                <div class="form-check col-sm-6">
                                    <input class="form-check-input" type="radio" name="vip"
                                           id="gridRadios1" value="true" checked>
                                    <label class="form-check-label" for="gridRadios1">
                                        Vip
                                    </label>
                                </div>
                                <div class="form-check col-sm-6">
                                    <input class="form-check-input" type="radio" name="vip"
                                           id="gridRadios2" value="false">
                                    <label class="form-check-label" for="gridRadios2">
                                        Thường
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /.span -->
        <div class="col-xs-12 col-sm-12">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <div>
                            <label for="form-field-11">Ảnh Sản Phẩm</label>
                            <input multiple="" name="secondImg" type="file"
                                   id="id-input-file-1"/>
                        </div>
                        <br>
                        <div>
                            <input multiple="" name="thirdImg" type="file"
                                   id="id-input-file-2"/>
                        </div>
                        <br>
                        <div>
                            <input multiple="" name="fourImg" type="file" id="id-input-file-4"/>
                        </div>
                        <br>
                        <div>
                            <input multiple="" name="fiveImg" type="file" id="id-input-file-4"/>
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Khu Vực</label>
                            <input id="txt_box4" placeholder="Khu vực"
                                   class="autosize-transition form-control" name="area"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /.span -->
        <div class="col-xs-12 col-sm-12">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <div>
                            <label for="form-field-select-1">Thương Hiệu</label>
                            <select id="form-field-1" class="autosize-transition form-control"
                                    name="brandId">
                                <c:forEach var="r" items="${brandId}">
                                    <option value="${r.id}">${r.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <hr>
                        <div>
                            <label for="form-field-select-1">Danh Mục</label>
                            <select id="form-field-1" class="autosize-transition form-control"
                                    name="categoryId">
                                <c:forEach var="r" items="${categoryId}">
                                    <option value="${r.id}">${r.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <hr>
                        <div>
                            <label for="form-field-8">Xuất Xứ</label>
                            <input id="txt_box2" placeholder="Xuất Xứ Sản Phẩm" name="origin"
                                   class="autosize-transition form-control" name=""
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <hr>
                        <div>
                            <label for="form-field-8">Tình Trạng</label>
                            <input id="txt_box3.1" placeholder="Tình Trạng sản phẩm"
                                   class="autosize-transition form-control" name="state"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <textarea id="summernote" name="description"></textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
        </div>
    </div>
</html>
