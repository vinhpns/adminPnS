<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <p>Tất cả các trường có dấu * đều phải nhập</p>
                    <div>
                        <label for="form-field-8">* Họ và Tên</label>
                        <input id="txt_box" type="text" required="" placeholder="Tên nhân viên"
                               class="autosize-transition form-control" name="fullName"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-9">* Email</label>
                        <input id="txt_box1" required=""
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;"
                               name="email" type="email" min="1" placeholder="Email khách hàng"
                               class="autosize-transition form-control">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-9">* Mật khẩu (Phải có ít nhất 1 chữ hoa, chữ
                            thường, 1 ký tự đặc biệt)</label>
                        <input required="" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                               style="overflow: hidden;  overflow-wrap: break-word; resize: horizontal; height: 40px;"
                               name="password" type="password" min="1" id="form-field-1-1"
                               placeholder="Mật khẩu" class="autosize-transition form-control">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-9">* Số điện thoại (Nhập 10 số)</label>
                        <input required=""
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;"
                               name="phone" type="text" id="form-field-1-1" pattern="[0-9]{10}"
                               placeholder="Phone" class="autosize-transition form-control" onkeypress='return restrictAlphabets(event)'/>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">* Số căn cước công dân</label>
                        <input id="form-field-11" type="number" placeholder="CMND"
                               class="autosize-transition form-control" name="socialIdNumber"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">* Ngày tháng năm sinh</label>
                        <input required="" id="form-field-11" type="date"
                               placeholder="MM-DD-YYYY" class="autosize-transition form-control"
                               name="dob"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">* Địa chỉ</label>
                        <input required="" id="txt_box6" placeholder="Địa chỉ nhà"
                               class="autosize-transition form-control" name="address"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                </div>
                <div class="widget-main">
                    <div>
                        <label for="form-field-11"> Ảnh Đại Diện</label>
                        <img src="">
                        <input multiple="" name="avatar" type="file" id="id-input-file-3"/>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-11">* Ảnh căn cước công dân trước</label>
                        <input multiple="" name="backIdCard" type="file" required=""
                               id="id-input-file-1"/>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-11">* Ảnh căn cước công dân sau</label>
                        <input multiple="" name="frontIdCard" type="file" required=""
                               id="id-input-file-2"/>
                    </div>
                    <br>
                    <div class="row">
                        <label class="col-form-label col-sm-5 pt-0">* Giới Tính: </label>
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
                    </div>
                </div>
                <div class="widget-main">
                    <div>
                        <label for="form-field-select-1">* Loại tài khoản</label>
                        <select id="form-field-1" class="autosize-transition form-control"
                                name="roleId">
                            <c:forEach var="r" items="${listRole}">
                                <option value="${r.id}">${r.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Số tài khoản ngân hàng</label>
                        <input id="txt_box2" type="number" placeholder="STK"
                               class="autosize-transition form-control" name="bankNumber"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Tại ngân hàng</label>
                        <input id="txt_box3" placeholder="Tên ngân hàng"
                               class="autosize-transition form-control" name="bankName"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Chủ tài khoản</label>
                        <input id="txt_box4" placeholder="Tên chủ tài khoản"
                               class="autosize-transition form-control" name="bankNameHolder"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <br>
                    <div>
                        <label for="form-field-8">Chi nhánh</label>
                        <input id="txt_box5" placeholder="Chi nhánh ngân hàng"
                               class="autosize-transition form-control" name="bankBranch"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <input name="url" value="${url}" hidden=""/>
                </div>
            </div>
        </div>
    </div>
</html>
