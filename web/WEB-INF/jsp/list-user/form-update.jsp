<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="row">
        <div class="col-xs-12 col-sm-4">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <input id="form-field-11" value="${AccountInfo.id}" type="hidden" name="id">
                        <input id="form-field-11" value="${AccountInfo.active}" type="hidden" name="active">
                        <input id="form-field-11" value="${AccountInfo.password}" type="hidden" name="password">
                        <input id="form-field-11" value="${customerInfo.rankId}" type="hidden" name="rankId">
                        <input id="form-field-11" value="${customerInfo.point}" type="hidden"  name="point">
                        <input id="form-field-11" value="${url}" type="hidden" name="url">
                        <div>
                            <label for="form-field-8">Họ và Tên</label>
                            <input id="txt_box" value="${AccountInfo.fullName}" type="text"
                                   required="" placeholder="Tên khách hàng"
                                   class="autosize-transition form-control" name="fullName"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Email</label>
                            <input id="txt_box1" value="${AccountInfo.email}"
                                   required="" class="autosize-transition form-control"
                                   name="email" type="email" min="1" placeholder="Email khách hàng"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div class="row">
                            <c:if test="${AccountInfo.gender == true}">
                                <label class="col-form-label col-sm-5 pt-0">Giới Tính: </label>
                                <div class="col-sm-7">
                                    <div class="form-check col-sm-6">
                                        <input class="form-check-input" type="radio" name="gender"
                                               id="gridRadios1" value="true" checked>
                                        <label class="form-check-label" for="gridRadios1">
                                            Nam
                                        </label>
                                    </div>
                                    <div class="form-check col-sm-6">
                                        <input class="form-check-input" type="radio" name="gender"
                                               id="gridRadios2" value="false">
                                        <label class="form-check-label" for="gridRadios2">
                                            Nữ
                                        </label>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${AccountInfo.gender == false}">
                                <label class="col-form-label col-sm-5 pt-0">Giới Tính: </label>
                                <div class="col-sm-7">
                                    <div class="form-check col-sm-6">
                                        <input class="form-check-input" type="radio" name="gender"
                                               id="gridRadios1" value="false">
                                        <label class="form-check-label" for="gridRadios1">
                                            Nam
                                        </label>
                                    </div>
                                    <div class="form-check col-sm-6">
                                        <input class="form-check-input" type="radio" name="gender"
                                               id="gridRadios2" value="true" checked>
                                        <label class="form-check-label" for="gridRadios2">
                                            Nữ
                                        </label>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                        <br>
                        <div>
                            <label for="form-field-9">Số điện thoại</label>
                            <input required="" value="${AccountInfo.phone}"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;"
                                   name="phone" type="number" id="form-field-1-1"
                                   placeholder="Số điện thoại"
                                   class="autosize-transition form-control">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Số căn cước công dân</label>
                            <input id="form-field-11" value="${customerInfo.socialIdNumber}"
                                   type="text" placeholder="CMND"
                                   class="autosize-transition form-control" name="socialIdNumber"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Ngày tháng năm sinh</label>
                            <input id="form-field-11" value="${AccountInfo.dob}" type="date"
                                   placeholder="YYYY-DD-MM" class="autosize-transition form-control"
                                   name="dob"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Địa chỉ</label>
                            <input id="txt_box2" value="${AccountInfo.address}"
                                   placeholder="Địa chỉ nhà"
                                   class="autosize-transition form-control" name="address"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /.span -->
        <div class="col-xs-12 col-sm-4">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <div class="containerx">
                            <label for="form-field-11">Ảnh đại diện</label>
                            <br>
                            <img src="${customerInfo.avatar}" alt="" id="blah"
                                 style="width: auto; height: 130px; float: left; margin-top:30px"/>
                            <div class="buttonshow">
                                <input type='file' accept="image/x-png,image/gif,image/jpeg"
                                       multiple="" name="avatar" onchange="readURL(this);"
                                       style="float: left;"/>
                            </div>
                        </div>
                        <br>
                        <div class="containerx" style="margin-top: 120px">
                            <label for="form-field-11">Ảnh căn cước công dân trước</label>
                            <img src="${customerInfo.frontIdCard}" alt="" id="blah2"
                                 style="width: auto; height: 130px; float: left"/>
                            <div class="buttonshow1">
                                <input type='file' multiple="" name="frontIdCard"
                                       accept="image/x-png,image/gif,image/jpeg"
                                       onchange="readURL2(this);"
                                       style="float: left;"/>
                            </div>
                        </div>
                        <br>
                        <div class="containerx" style="margin-top: 120px">
                            <label for="form-field-11">Ảnh căn cước công dân sau</label>
                            <img src="${customerInfo.backIdCard}" alt="" id="blah1"
                                 style="width: auto; height: 130px; float: left;"/>
                            <div class="buttonshow2">
                                <input type='file' multiple="" name="backIdCard"
                                       accept="image/x-png,image/gif,image/jpeg"
                                       onchange="readURL1(this);"
                                       style="float: left;"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /.span -->
        <div class="col-xs-12 col-sm-4">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <div>
                            <label for="form-field-select-1">Loại tài khoản</label>
                            <select id="form-field-1" class="autosize-transition form-control"
                                    name="roleId">
                                <c:forEach var="r" items="${listRole}">
                                    <option ${r.id == AccountInfo.roleId ? 'selected' : ''}
                                        value="${r.id}">${r.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Số tài khoản ngân hàng</label>
                            <input id="txt_box3" type="number" value="${customerInfo.bankNumber}"
                                   placeholder="STK" class="autosize-transition form-control"
                                   name="bankNumber"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Tại ngân hàng</label>
                            <input id="txt_box4" value="${customerInfo.bankName}"
                                   placeholder="Tên ngân hàng"
                                   class="autosize-transition form-control" name="bankName"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Chủ tài khoản</label>
                            <input id="txt_box5" value="${customerInfo.bankNameHolder}"
                                   placeholder="Tên chủ tài khoản"
                                   class="autosize-transition form-control" name="bankHolder"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Chi nhánh</label>
                            <input id="txt_box6" value="${customerInfo.bankBranch}"
                                   placeholder="Chi nhánh ngân hàng"
                                   class="autosize-transition form-control" name="bankBranch"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div class="col-md-6">
                            <button style="float: right; border-radius: 10px"
                                    class="btn btn-primary btn-lg" type="submit" name="update">
                                Cập Nhập
                            </button>
                        </div>
                        <div>
                            <button class="btn btn-primary btn-lg" style="border-radius: 10px;">
                                <a style="color: white; text-decoration: none " href="ListUser.htm?url=${url}" >Quay Lại</a>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /.span -->

</html>
