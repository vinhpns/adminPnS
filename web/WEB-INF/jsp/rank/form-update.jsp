<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12">
        <div class="col-sm-6">
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main">
                        <input id="form-field-11" value="${rank.id}" type="hidden" name="id">
                        <div>
                            <label for="form-field-8">Tên danh hiệu</label>
                            <input type="text" value="${rank.name} " id="txt_box"
                                   placeholder="Nhập tên danh hiệu"
                                   class="autosize-transition form-control" name="name"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-11">Điểm số</label>
                            <input type="number" value="${rank.requirePoint}" required=""
                                   id="form-field-11" placeholder="Nhập điểm số"
                                   class="autosize-transition form-control" name="requirePoint"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <label for="form-field-11">Ảnh Đại Diện</label>
                        <input multiple="" name="icon" type="file" id="id-input-file-1"/> 
                    </div>
                </div>
            </div>
        </div>
        <div class="col-12" style="margin-top: 20px">
            <div class="col-sm-6">
                <img src="${rank.icon}" id="preview" class="img-up" style="width:70%">
            </div>
        </div>
        <div class="col-sm-12" style="text-align: center">
            <button style="border-radius: 10px" class="btn btn-primary btn-lg"
                    type="submit" name="update">Cập Nhập
            </button>
            <button style="border-radius: 10px" class="btn btn-primary btn-lg">
                <a style="color: white; text-decoration: none" href="RankList.htm">Quay Lại</a>
            </button>
        </div>
    </div>
</html>
