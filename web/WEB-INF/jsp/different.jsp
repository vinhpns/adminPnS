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
                                    <h1 class="m-0 text-dark">Lý do chọn Bsi Lê Quý</h1>
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
                    <form action="different.htm" method="post" class="form-horizontal"
                          role="form" enctype="multipart/form-data" modelAttribute="different">
                        <div class="row col-12">
                            <div class="col">
                                <input hidden="" name="id" value="${diff.id}" />
                            <input hidden="" name="companyId" value="${diff.companyId}" />
                            <div class="form-group">
                                <label for="exampleInputEmail1">Khác biệt 1</label>
                                <input type="text" value="${diff.titleOne}" name="titleOne" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Mô tả</label>
                                <textarea class="form-control" name="descriptionOne" rows="3" placeholder="Enter ...">${diff.descriptionOne}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Khác Biệt 2</label>
                                <input type="text" name="titleTwo" value="${diff.titleTwo}"class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Mô tả</label>
                                <textarea class="form-control" name="descriptionTwo" rows="3" placeholder="Enter ...">${diff.descriptionTwo}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Khác Biệt 3</label>
                                <input type="text" value="${diff.titleThree}" name="titleThree" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Mô tả</label>
                                <textarea class="form-control" name="descriptionThree" rows="3" placeholder="Enter ...">${diff.descriptionThree}</textarea>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Khác biệt 4</label>
                                <input type="text" value="${diff.titleFour}" name="titleFour" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Mô tả</label>
                                <textarea class="form-control" name="descriptionFour" rows="3" placeholder="Enter ...">${diff.descriptionFour}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Khác Biệt 5</label>
                                <input type="text" name="titleFive" value="${diff.titleFive}"class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Mô tả</label>
                                <textarea class="form-control" name="descriptionFive" rows="3" placeholder="Enter ...">${diff.descriptionFive}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Khác Biệt 6</label>
                                <input type="text" value="${diff.titleSix}" name="titleSix" class="form-control" id="exampleInputEmail1" placeholder="Nhập tiêu đề">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Mô tả</label>
                                <textarea class="form-control" name="descriptionSix" rows="3" placeholder="Enter ...">${diff.descriptionSix}</textarea>
                            </div>
                            <button type="submit" name="update" style="float: right;" class="btn btn-primary">Cập Nhật</button>
                        </div>
                    </div>
                </form>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
            <jsp:include page="loadScript.jsp"></jsp:include>
        </div>
    </body>
</html>
