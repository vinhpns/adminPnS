<%-- 
    Document   : form-update
    Created on : Oct 23, 2019, 10:11:30 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 row">
        <div class=" col-sm-7">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <div>
                            <input value="${brand.id}" name="id" hidden="">
                            <input value="${brand.active}" name="active" hidden="">
                            <label for="form-field-8">Tên Thương Hiệu</label>
                            <input id="txt_box" placeholder="Thương Hiệu" value="${brand.name}"
                                   placeholder="Thương Hiệu" class="autosize-transition form-control"
                                   name="brandName"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <label for="form-field-11">Ảnh Thương Hiệu</label>
                        <div class="buttonshow2">
                            <input id="id-input-file-1" type='file' multiple="" name="images"
                                   accept="image/x-png,image/gif,image/jpeg"
                                   onchange="readURL3(this);"
                                   style="float: left;"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <div>
                            <img src="${brand.image}" alt="" id="blah3"
                                 style="width: auto; height: 230px; float: left;"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-12" style="text-align: center; margin-top: 50px">
            <button style="border-radius: 10px" class="btn btn-primary btn-lg"
                    type="submit" name="update">Cập Nhập
            </button>
            <button style="border-radius: 10px; margin-left: 30px" type="reset" value="Reset"
                    class="btn btn-primary btn-lg">
                <a style="color: white; text-decoration: none" href="brandpages.htm">Quay Lại</a>
            </button>
        </div>
    </div>
</form>
</html>
