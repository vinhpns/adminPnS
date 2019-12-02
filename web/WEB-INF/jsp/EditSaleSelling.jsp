<%-- 
    Document   : index
    Created on : Aug 14, 2018, 12:08:57 PM
    Author     : ASUS
--%>
<%@page import="com.poly.bean.Bid_product" %>
<%@page import="com.poly.dao.Bid_productDao" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<%@include file="header.jsp" %>
<body class="no-skin">
<div class="main-container ace-save-state" id="main-container">
    <%@include file="menuPage.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="sale.htm">Home</a>
                    </li>
                    <li>
                        <a href="sale.htm">Đấu Giá</a>
                    </li>
                    <li class="active">Đăng Sản Phẩm</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <!-- /.ace-settings-container -->
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="modal-header no-padding">
                            <div class="table-header">
                                Chỉnh sửa Sản phẩm đấu giá
                            </div>
                        </div>
                        <div class="modal-body no-padding">
                            <div class="row">
                                <div class="col-xs-12" style="margin-left: 10px">
                                    <!-- PAGE CONTENT BEGINS -->
                                    <form action="Selling.htm" method="POST" class="form-horizontal"
                                          modelAttribute="saleProduct" role="form" enctype="multipart/form-data">
                                        <div hidden="" class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">
                                                ID </label>
                                            <div class="col-sm-9">
                                                <input value="${saleProduct.id}" name="id" type="text" id="form-field-1"
                                                       placeholder="ID" class="col-xs-10 col-sm-5 id"/>
                                            </div>
                                        </div>
                                        <div class="space-4"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3  control-label no-padding-right categoryId"
                                                   for="form-field-1"> Danh mục </label>
                                            <div class="col-sm-9">
                                                <select id="form-field-1" class="col-xs-10 col-sm-5 categoryId"
                                                        name="categoryId" style="width:300px;">
                                                    <c:forEach var="r" items="${idcategory}">
                                                        <option ${r.id == saleProduct.categoryId ? 'selected' : ''}
                                                                value="${r.id}">${r.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="space-4"></div>
                                        <div class="form-group" hidden="">
                                            <label class="col-sm-3 control-label no-padding-right name"
                                                   for="form-field-1"> Tên sản phẩm </label>
                                            <div class="col-sm-9">
                                                <input value="${saleProduct.createdBy}" name="createdBy" type="text"
                                                       id="form-field-1" style="width:300px;" placeholder="Tạo bởi"
                                                       class="col-xs-10 col-sm-5 createdBy"/>
                                            </div>
                                        </div>
                                        <div class="space-4"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right name"
                                                   for="form-field-1"> Tên sản phẩm </label>
                                            <div class="col-sm-9">
                                                <input value="${saleProduct.name}" name="name" type="text"
                                                       id="form-field-1" style="width:300px;" placeholder="Tên sản phẩm"
                                                       class="col-xs-10 col-sm-5 name"/>
                                            </div>
                                        </div>
                                        <div class="space-4"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">
                                                Thương hiệu </label>
                                            <div class="col-sm-9">
                                                <select id="form-field-1" class="col-xs-10 col-sm-5 brandId"
                                                        style="width:300px;" name="brandId">
                                                    <c:forEach var="r" items="${idbrand}">
                                                        <option value="${r.id}" ${r.id == saleProduct.brandId ? 'selected' : ''}>${r.name}</option>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                        </div>
                                        <div class="space-4"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">
                                                Gía </label>
                                            <div class="col-sm-9">
                                                <input value="${saleProduct.money}" name="money" type="number"
                                                       style="width:300px;" min="1" id="form-field-1-1"
                                                       placeholder="Gía ban đầu"
                                                       class="col-xs-10 col-sm-5 initalMoney"/>
                                            </div>
                                        </div>
                                        <div class="space-4"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-2">
                                                Số Lượng </label>
                                            <div class="col-sm-9">
                                                <input value="${saleProduct.quantity}" name="quantity" type="number"
                                                       style="width:300px;" min="1" id="form-field-2"
                                                       placeholder="Bước giá" class="col-xs-10 col-sm-5 priceStep"/>
                                            </div>
                                        </div>
                                        <div class="space-4"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-2">
                                                Mô tả </label>
                                            <div class="col-sm-9">
                                                        <textarea rows="4" cols="50" name="description" type="text"
                                                                  style="width:300px;" id="form-field-2"
                                                                  placeholder="Mô tả"
                                                                  class="col-xs-10 col-sm-5 description">
                                                            ${saleProduct.description}
                                                        </textarea>
                                            </div>
                                        </div>


                                        <div class="space-4"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-2">
                                                Trạng thái </label>
                                            <div class="col-sm-9">
                                                <input value="${saleProduct.status}" name="status" type="number"
                                                       style="width:300px;" id="form-field-2" placeholder="Trạng thái"
                                                       class="col-xs-10 col-sm-5 status" disabled/>
                                            </div>
                                        </div>
                                        <div class="space-4"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">
                                                Hình ảnh </label>
                                            <div class="col-sm-9">
                                                <img src="${saleProduct.image}" style="width:300px;height:300px"
                                                     id="pic1"/>
                                                <input value="" id="file-input" type="file" name="firstImage" size="50"
                                                       onchange="readURL1(this);"/>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">
                                                Hình ảnh 2</label>
                                            <div class="col-sm-9">
                                                <img src="${saleProduct.img1}" style="width:300px;height:300px"
                                                     id="pic2"/>
                                                <input value="" id="file-input" type="file" style="width:300px;"
                                                       name="secondImage" size="50" onchange="readURL2(this);"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">
                                                Hình ảnh 3</label>
                                            <div class="col-sm-9">
                                                <img src="${saleProduct.img2}" style="width:300px;height:300px"
                                                     id="pic3"/>
                                                <input value="" id="file-input" type="file" style="width:300px;"
                                                       name="thirdImage" size="50" onchange="readURL3(this);"/>
                                            </div>
                                        </div>


                                        <div class="space-4"></div>
                                        <input value="${saleProduct.isDel}" name="isDel" class="col-xs-1 isDel"
                                               type="hidden" id="form-field-5" placeholder=".col-xs-1"/>
                                        <div class="space-4"></div>
                                        <div class="form-group">
                                            <div class="col-md-offset-7 col-md-5" style="text-align: center">
                                                <button class="btn btn-info" type="submit" name="update">
                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                    Lưu
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                    <form action="Selling.htm" method="GET">
                                        <div class="form-group">
                                            <div class="col-md-offset-7 col-md-5" style="text-align: center">
                                                <button class="btn btn-info" type="submit" name="">
                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                    Quay Lại
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                    <span>${SUCCESS}</span>
                                </div><!-- /.modal-content -->
                            </div>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>


            <div class="footer">
                <div class="footer-inner">
                    <div class="footer-content">
                                <span class="bigger-120">
                                    <span class="blue bolder">Ace</span>
                                    Application &copy; 2013-2014
                                </span>

                        &nbsp; &nbsp;
                        <span class="action-buttons">
                                    <a href="#">
                                        <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
                                    </a>

                                    <a href="#">
                                        <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
                                    </a>

                                    <a href="#">
                                        <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
                                    </a>
                                </span>
                    </div>
                </div>
            </div>

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div>
        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript">
            if ('ontouchstart' in document.documentElement)
                document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
        </script>
        <script src="assets/js/bootstrap.min.js"></script>

        <!-- page specific plugin scripts -->
        <script src="assets/js/jquery.dataTables.min.js"></script>
        <script src="assets/js/jquery.dataTables.bootstrap.min.js"></script>
        <script src="assets/js/dataTables.buttons.min.js"></script>
        <script src="assets/js/buttons.flash.min.js"></script>
        <script src="assets/js/buttons.html5.min.js"></script>
        <script src="assets/js/buttons.print.min.js"></script>
        <script src="assets/js/buttons.colVis.min.js"></script>
        <script src="assets/js/dataTables.select.min.js"></script>

        <!-- ace scripts -->
        <script src="assets/js/ace-elements.min.js"></script>
        <script src="assets/js/ace.min.js"></script>
        <script type="text/javascript">
            jQuery(function ($) {
                //initiate dataTables plugin
                var myTable =
                    $('#dynamic-table')
                    //.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
                        .DataTable({
                            bAutoWidth: false,
                            "aoColumns": [
                                {"bSortable": false},
                                null, null, null, null, null,
                                {"bSortable": false}
                            ],
                            "aaSorting": [],
                            select: {
                                style: 'multi'
                            }
                        });
                $.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';
                new $.fn.dataTable.Buttons(myTable, {
                    buttons: [
                        {
                            "extend": "colvis",
                            "text": "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
                            "className": "btn btn-white btn-primary btn-bold",
                            columns: ':not(:first):not(:last)'
                        },
                        {
                            "extend": "copy",
                            "text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
                            "className": "btn btn-white btn-primary btn-bold"
                        },
                        {
                            "extend": "csv",
                            "text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
                            "className": "btn btn-white btn-primary btn-bold"
                        },
                        {
                            "extend": "excel",
                            "text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
                            "className": "btn btn-white btn-primary btn-bold"
                        },
                        {
                            "extend": "pdf",
                            "text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
                            "className": "btn btn-white btn-primary btn-bold"
                        },
                        {
                            "extend": "print",
                            "text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
                            "className": "btn btn-white btn-primary btn-bold",
                            autoPrint: false,
                            message: 'This print was produced using the Print button for DataTables'
                        }
                    ]
                });
                myTable.buttons().container().appendTo($('.tableTools-container'));

                //style the message box
                var defaultCopyAction = myTable.button(1).action();
                myTable.button(1).action(function (e, dt, button, config) {
                    defaultCopyAction(e, dt, button, config);
                    $('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
                });


                var defaultColvisAction = myTable.button(0).action();
                myTable.button(0).action(function (e, dt, button, config) {

                    defaultColvisAction(e, dt, button, config);


                    if ($('.dt-button-collection > .dropdown-menu').length == 0) {
                        $('.dt-button-collection')
                            .wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
                            .find('a').attr('href', '#').wrap("<li />")
                    }
                    $('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
                });

                ////

                setTimeout(function () {
                    $($('.tableTools-container')).find('a.dt-button').each(function () {
                        var div = $(this).find(' > div').first();
                        if (div.length == 1)
                            div.tooltip({container: 'body', title: div.parent().text()});
                        else
                            $(this).tooltip({container: 'body', title: $(this).text()});
                    });
                }, 500);


                myTable.on('select', function (e, dt, type, index) {
                    if (type === 'row') {
                        $(myTable.row(index).node()).find('input:checkbox').prop('checked', true);
                    }
                });
                myTable.on('deselect', function (e, dt, type, index) {
                    if (type === 'row') {
                        $(myTable.row(index).node()).find('input:checkbox').prop('checked', false);
                    }
                });


                /////////////////////////////////
                //table checkboxes
                $('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);

                //select/deselect all rows according to table header checkbox
                $('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function () {
                    var th_checked = this.checked;//checkbox inside "TH" table header

                    $('#dynamic-table').find('tbody > tr').each(function () {
                        var row = this;
                        if (th_checked)
                            myTable.row(row).select();
                        else
                            myTable.row(row).deselect();
                    });
                });

                //select/deselect a row when the checkbox is checked/unchecked
                $('#dynamic-table').on('click', 'td input[type=checkbox]', function () {
                    var row = $(this).closest('tr').get(0);
                    if (this.checked)
                        myTable.row(row).deselect();
                    else
                        myTable.row(row).select();
                });


                $(document).on('click', '#dynamic-table .dropdown-toggle', function (e) {
                    e.stopImmediatePropagation();
                    e.stopPropagation();
                    e.preventDefault();
                });


                //And for the first simple table, which doesn't have TableTools or dataTables
                //select/deselect all rows according to table header checkbox
                var active_class = 'active';
                $('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function () {
                    var th_checked = this.checked;//checkbox inside "TH" table header

                    $(this).closest('table').find('tbody > tr').each(function () {
                        var row = this;
                        if (th_checked)
                            $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
                        else
                            $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
                    });
                });

                //select/deselect a row when the checkbox is checked/unchecked
                $('#simple-table').on('click', 'td input[type=checkbox]', function () {
                    var $row = $(this).closest('tr');
                    if ($row.is('.detail-row '))
                        return;
                    if (this.checked)
                        $row.addClass(active_class);
                    else
                        $row.removeClass(active_class);
                });
                /********************************/
                //add tooltip for small view action buttons in dropdown menu
                $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

                //tooltip placement on right or left
                function tooltip_placement(context, source) {
                    var $source = $(source);
                    var $parent = $source.closest('table')
                    var off1 = $parent.offset();
                    var w1 = $parent.width();
                    var off2 = $source.offset();
                    //var w2 = $source.width();
                    if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
                        return 'right';
                    return 'left';
                }
            })

            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#pic')
                            .attr('src', e.target.result)
                            .width(150)
                            .height(150);
                    };
                    reader.readAsDataURL(input.files[0]);
                    console.log(input.files);
                }
            }

            function readURL1(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#pic1')
                            .attr('src', e.target.result)
                            .width(300)
                            .height(300);
                    };
                    reader.readAsDataURL(input.files[0]);
                    console.log(input.files);
                }
            }

            function readURL2(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#pic2')
                            .attr('src', e.target.result)
                            .width(300)
                            .height(300);
                    };
                    reader.readAsDataURL(input.files[0]);
                    console.log(input.files);
                }
            }

            function readURL3(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#pic3')
                            .attr('src', e.target.result)
                            .width(300)
                            .height(300);
                    };
                    reader.readAsDataURL(input.files[0]);
                    console.log(input.files);
                }
            }

            function readURL4(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#pic4')
                            .attr('src', e.target.result)
                            .width(300)
                            .height(300);
                    };
                    reader.readAsDataURL(input.files[0]);
                    console.log(input.files);
                }
            }

            $('#modal-table-add').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget); // Button that triggered the modal
                var endTime = button.data('endtime');
                var roomId = button.data('roomid');
                var image = button.data('image');
                console.log(image);
                var isDel = button.data('isdel');
                var createdBy = button.data('createdby');
                var createdTime = button.data('createdtime');
                var status = button.data('status');
                var priceStep = button.data('pricestep');
                var initalMoney = button.data('initalmoney');
                var categoryId = button.data('categoryid');
                var description = button.data('description');
                var brandId = button.data('brandid');
                var name = button.data('name');
                var id = button.data('id');
                // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
                // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
                var modal = $(this);
                modal.find('.modal-body .endTime').val(endTime);
                modal.find('.modal-body .roomId').val(roomId);
                modal.find('.modal-body #anh')
                    .attr('src', image)
                    .width(150)
                    .height(150);
                modal.find('.modal-body .isDel').val(isDel);
                modal.find('.modal-body .createdBy').val(createdBy);
                modal.find('.modal-body .createdTime').val(createdTime);
                modal.find('.modal-body .status').val(status);
                modal.find('.modal-body .priceStep').val(priceStep);
                modal.find('.modal-body .initalMoney').val(initalMoney);
                modal.find('.modal-body .categoryId').val(categoryId);
                modal.find('.modal-body .description').val(description);
                modal.find('.modal-body .brandId').val(brandId);
                modal.find('.modal-body .name').val(name);
                modal.find('.modal-body .id').val(id);
            })
        </script>
</body>

</html>