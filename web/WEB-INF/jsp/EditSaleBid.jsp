<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

    <!-- include summernote css/js -->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
    <body class="no-skin">
        <%@include file="header.jsp" %>
        <div class="main-container ace-save-state" id="main-container">
            <%@include file="menuPage.jsp" %>
            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="index.htm">Trang chủ</a>
                            </li>
                            <li>
                                <a href="#">Chỉnh sửa Sản Phẩm Đấu Giá</a>
                            </li>
                        </ul>
                    </div>
                    <div class="page-content">
                        <div class="row">
                            <div class="col-xs-12">
                                <form action="SaleBid.htm" method="post" modelAttribute="bidProduct" class="form-horizontal"
                                      role="form" enctype="multipart/form-data">
                                    <div class="widget-box">
                                        <div class="widget-body">
                                            <div class="widget-main">
                                                <div class="col-xs-12 row">
                                                    <div class="col-sm-4">
                                                        <input value="${bidProduct.writerApproved}" name="writerApproved"
                                                               hidden="">
                                                        <input value="${bidProduct.hrApproved}" name="hrApproved" hidden="">
                                                        <input value="${bidProduct.accApproved}" name="accApproved" hidden="">
                                                        <input value="${bidProduct.modApproved}" name="modApproved" hidden="">
                                                        <input value="${bidProduct.itApproved}" name="itApproved" hidden="">
                                                        <input value="${bidProduct.active}" name="active" hidden="">
                                                        <input value="${bidProduct.auction}" name="auction" hidden="">
                                                        <input value="${bidProduct.sale}" name="sale" hidden="">
                                                        <input value="${bidProduct.vip}" name="vip" hidden="">
                                                        <input value="${bidProduct.id}" name="id" hidden="">
                                                        <input type="hidden" value="${url}" name="url">
                                                        <div>
                                                            <label for="form-field-8">Tên Sản Phẩm</label>
                                                            <input type="text" value="${bidProduct.name}" id="form-field-11"
                                                                   placeholder="Tên sản phẩm"
                                                                   class="autosize-transition form-control" name="name"
                                                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                        </div>
                                                        <br>
                                                        <div>
                                                            <label for="form-field-9">Giá Ban Đầu</label>
                                                            <input style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;"
                                                                   value="${bidProduct.price}" name="price" type="number"
                                                                   min="1" id="form-field-1-1" placeholder="Gía ban đầu"
                                                                   class="autosize-transition form-control">
                                                        </div>
                                                        <br>
                                                        <div>
                                                            <label for="form-field-8">Bảo Hành</label>
                                                            <input value="${bidProduct.warranty} " id="form-field-11"
                                                                   placeholder="Bảo Hành Sản Phẩm"
                                                                   class="autosize-transition form-control" name="warranty"
                                                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                        </div>
                                                        <br>
                                                        <div>
                                                            <label for="form-field-8">Khu Vực</label>
                                                            <input value="${bidProduct.area}" id="form-field-11"
                                                                   placeholder="Khu vực"
                                                                   class="autosize-transition form-control" name="area"
                                                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                        </div>
                                                        <br>
                                                        <div>
                                                            <label for="form-field-8">Xuất Xứ</label>
                                                            <input id="form-field-11" placeholder="Xuất Xứ Sản Phẩm"
                                                                   class="autosize-transition form-control" name="origin"
                                                                   value="${bidProduct.origin}"
                                                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                        </div>
                                                        <br>
                                                        <div>
                                                            <label for="form-field-8">Tình Trạng</label>
                                                            <input id="form-field-11" placeholder="Tình Trạng sản phẩm"
                                                                   class="autosize-transition form-control"
                                                                   value="${bidProduct.state}" name="state"
                                                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                                                        </div>
                                                    </div><!-- /.span -->
                                                    <div class="col-sm-4">
                                                        <div class="widget-box">
                                                            <div class="widget-body">
                                                                <div class="widget-main">
                                                                    <label for="form-field-11">Ảnh sản phẩm</label>
                                                                    <div class="containerx">
                                                                        <img src="${img1}" alt="" id="blah"
                                                                             style="width: auto; height: 120px; float: left; margin-top:30px"/>
                                                                        <div class="buttonshow">
                                                                            <input type='file' accept="image/x-png,image/gif,image/jpeg"
                                                                                   multiple="" name="img1" onchange="readURL(this);"
                                                                                   style="float: left; margin-left: 170px"/>
                                                                        </div>
                                                                    </div>
                                                                    <br>
                                                                    <div class="containerx" style="margin-top: 90px">
                                                                        <img src="${img2}" alt="" id="blah3"
                                                                             style="width: auto; height: 120px; float: left"/>
                                                                        <div class="buttonshow1">
                                                                            <input type='file' multiple="" name="img2"
                                                                                   accept="image/x-png,image/gif,image/jpeg"
                                                                                   onchange="readURL3(this);"
                                                                                   style="float: left; margin-left: 170px"/>
                                                                        </div>
                                                                    </div>
                                                                    <br>
                                                                    <div class="containerx" style="margin-top: 90px">
                                                                        <img src="${img3}" alt="" id="blah4"
                                                                             style="width: auto; height: 120px; float: left;"/>
                                                                        <div class="buttonshow2">
                                                                            <input type='file' multiple="" name="img3"
                                                                                   accept="image/x-png,image/gif,image/jpeg"
                                                                                   onchange="readURL4(this);"
                                                                                   style="float: left; margin-left: 170px"/>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.span -->
                                                    <div class="col-sm-4">
                                                        <div class="widget-box">
                                                            <div class="widget-body">
                                                                <div class="widget-main">
                                                                    <div>
                                                                        <label for="form-field-select-1">Thương Hiệu</label>
                                                                        <select id="form-field-1" class="autosize-transition form-control"
                                                                                name="brandId">
                                                                            <c:forEach var="r" items="${brandId}">
                                                                                <option value="${r.id}" ${r.id == bidProduct.brandId ? 'selected' : ''}>${r.name}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                    <br>
                                                                    <div>
                                                                        <label for="form-field-select-1">Danh Mục</label>
                                                                        <select id="form-field-1" class="autosize-transition form-control"
                                                                                name="categoryId">
                                                                            <c:forEach var="r" items="${categoryId}">
                                                                                <option ${r.id == bidProduct.categoryId ? 'selected' : ''}
                                                                                    value="${r.id}">${r.name}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                    <hr>
                                                                    <div class="containerx">
                                                                        <img src="${img4}" alt="" id="blah2"
                                                                             style="width: auto; height: 120px; float: left;"/>
                                                                        <div class="buttonshow">
                                                                            <input type='file' multiple="" name="img4"
                                                                                   accept="image/x-png,image/gif,image/jpeg"
                                                                                   onchange="readURL2(this);"
                                                                                   style="float: left; margin-left: 170px"/>
                                                                        </div>
                                                                    </div>
                                                                    <hr>
                                                                    <div class="containerx">
                                                                        <img src="${img5}" alt="" id="blah1"
                                                                             style="width: auto; height: 120px; float: left;"/>
                                                                        <div class="buttonshow">
                                                                            <input type='file' multiple="" name="img5"
                                                                                   accept="image/x-png,image/gif,image/jpeg"
                                                                                   onchange="readURL1(this);"
                                                                                   style="float: left; margin-left: 170px"/>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                </div>
                                                <div class="col-sm-12">
                                                    <textarea id="summernote"
                                                              name="description">${bidProduct.description}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <button style="float: right; border-radius: 10px" class="btn btn-primary btn-lg"
                                                type="submit" name="update">Cập Nhật
                                        </button>
                                    </div>
                                    <div>
                                        <button style="border-radius: 10px" type="reset" value="Reset" class="btn btn-primary btn-lg">
                                            <a href="SaleBid.htm" style="color: white; text-decoration: none">Quay Lại</a>
                                        </button>
                                    </div>
                                </form>
                                <%@include file="footer.jsp" %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
        $(document).ready(function () {
            $('#summernote').summernote();
        });
        $('#summernote').summernote({
            height: 350, // set editor height
            minHeight: 350, // set minimum height of editor
            maxHeight: 350, // set maximum height of editor
            focus: true                  // set focus to editable area after initializing summernote
        });
    </script>
    <jsp:include page="loadScript.jsp"></jsp:include>
    <script src="assets/js/loadImg.js"></script>
</html>