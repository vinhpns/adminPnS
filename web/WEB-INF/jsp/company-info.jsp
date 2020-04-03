<%-- 
    Document   : main-index
    Created on : Dec 1, 2019, 12:32:22 PM
    Author     : SGDG Company
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
        <body class="hold-transition sidebar-mini">
            <div class="wrapper">
            <jsp:include page="navigation-bar.jsp"></jsp:include>
            <jsp:include page="menuPage.jsp"></jsp:include>
                <div class="content-wrapper">
                    <div class="content-header">
                        <div class="container-fluid">
                            <div class="row mb-2">
                                <div class="col-sm-6">
                                    <h1 class="m-0 text-dark">Thông Tin Công Ty</h1>
                                </div>
                                <div class="col-sm-6">
                                    <ol class="breadcrumb float-sm-right">
                                        <li class="breadcrumb-item"><a href="index.htm">Home</a></li>
                                        <li class="breadcrumb-item active">Info</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                    <form action="company.htm" method="post" class="form-horizontal"
                          role="form" enctype="multipart/form-data" modelAttribute="company">
                        <div class="row col-12">
                            <div class="col">
                                <input hidden="" name="id" value="${company.id}" />
                                <input hidden="" name="phone" value="${company.phone}" />
                                <input hidden="" name="address" value="${company.address}" />
                                <input hidden="" name="alias" value="${company.alias}" />
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Tên Công Ty</label>
                                    <input type="text" value="${company.name}" name="name" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Tiêu Đề SEO</label>
                                    <input type="text" name="titleSeo" value="${company.titleSeo}"class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Giới Thiệu 1</label>
                                    <input type="text" value="${company.titleOne}" name="titleOne" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Giới Thiệu 2</label>
                                    <input type="text" value="${company.titleTwo}" name="titleTwo" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Giới Thiệu 3</label>
                                    <input type="text" value="${company.titleThree}" name="titleThree" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Logo Công Ty</label>
                                    <input type='file' value="${company.logo}" id="imgInp" name="avatar"/>
                                    <img id="blah" src="${company.logo}" style="width: 50%; height: 50%" alt="your image" />
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Từ Khóa</label>
                                    <textarea class="form-control" name="metaSeo" rows="3" placeholder="Enter ...">${company.metaSeo}</textarea>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Mô tả SEO</label>
                                    <textarea class="form-control" name="descriptionSeo" rows="3" placeholder="Enter ...">${company.descriptionSeo}</textarea>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Mô tả Giới Thiệu 1</label>
                                    <textarea class="form-control" name="descriptionOne" rows="3" placeholder="Enter ...">${company.descriptionOne}</textarea>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Mô tả Giới Thiệu 2</label>
                                    <textarea class="form-control" name="descriptionTwo" rows="3" placeholder="Enter ...">${company.descriptionTwo}</textarea>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Mô tả Giới Thiệu 3</label>
                                    <textarea class="form-control" name="descriptionThree" rows="3" placeholder="Enter ...">${company.descriptionThree}</textarea>
                                </div>
                                <button type="submit" name="updateCompany" style="float: right;" class="btn btn-primary">Cập Nhật</button>
                            </div>
                        </div>
                    </form>
                </div>
            <jsp:include page="footer.jsp"></jsp:include>
            <jsp:include page="loadScript.jsp"></jsp:include>
        </div>
    </body>
    <script>
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#blah').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }

        $("#imgInp").change(function () {
            readURL(this);
        });
    </script>
</html>
