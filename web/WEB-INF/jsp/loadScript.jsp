<%-- 
    Document   : loadScript
    Created on : May 18, 2019, 1:59:58 PM
    Author     : VinhNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>

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
<script src="assets/js/ace.min.js"></script>
<script src="assets/js/ace-elements.min.js"></script>
<!-- inline scripts related to this page -->
<script type="text/javascript">
    $(document).ready(function () {
        var myTable = $('#dynamic-table').DataTable();

        $.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';

        new $.fn.dataTable.Buttons(myTable, {
            buttons: [
                {
                    "extend": "copy",
                    "text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy bản ghi trong bảng</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "csv",
                    "text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Xuất file CSV</span>",
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
                    "text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>In</span>",
                    "className": "btn btn-white btn-primary btn-bold",
                    autoPrint: false,
                    message: 'This print was produced using the Print button for DataTables'
                }
            ]
        });
        myTable.buttons().container().appendTo($('.tableTools-container'));
    });
</script>
<script>
    $('#id-input-file-1 , #id-input-file-2, #id-input-file-4').ace_file_input({
        no_file: 'No File ...',
        btn_choose: 'Choose',
        btn_change: 'Change',
        droppable: false,
        onchange: null,
        thumbnail: false //| true | large
        //whitelist:'gif|png|jpg|jpeg'
        //blacklist:'exe|php'
        //onchange:''
        //
    });
    //pre-show a file name, for example a previously selected file
    //$('#id-input-file-1').ace_file_input('show_file_list', ['myfile.txt'])


    $('#id-input-file-3').ace_file_input({
        style: 'well',
        btn_choose: 'Drop files here or click to choose',
        btn_change: null,
        no_icon: 'ace-icon fa fa-cloud-upload',
        droppable: true,
        thumbnail: 'small'//large | fit
        //,icon_remove:null//set null, to hide remove/reset button
        /**,before_change:function(files, dropped) {
                         //Check an example below
                         //or examples/file-upload.html
                         return true;
                         }*/
        /**,before_remove : function() {
                         return true;
                         }*/
        ,
        preview_error: function (filename, error_code) {
            //name of the file that failed
            //error_code values
            //1 = 'FILE_LOAD_FAILED',
            //2 = 'IMAGE_LOAD_FAILED',
            //3 = 'THUMBNAIL_FAILED'
            //alert(error_code);
        }

    }).on('change', function () {
        //console.log($(this).data('ace_input_files'));
        //console.log($(this).data('ace_input_method'));
    });

    $('#id-file-format').removeAttr('checked').on('change', function () {
        var whitelist_ext, whitelist_mime;
        var btn_choose
        var no_icon
        if (this.checked) {
            btn_choose = "Drop images here or click to choose";
            no_icon = "ace-icon fa fa-picture-o";

            whitelist_ext = ["jpeg", "jpg", "png", "gif", "bmp"];
            whitelist_mime = ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"];
        } else {
            btn_choose = "Drop files here or click to choose";
            no_icon = "ace-icon fa fa-cloud-upload";

            whitelist_ext = null;//all extensions are acceptable
            whitelist_mime = null;//all mimes are acceptable
        }
        var file_input = $('#id-input-file-3');
        file_input
            .ace_file_input('update_settings',
                {
                    'btn_choose': btn_choose,
                    'no_icon': no_icon,
                    'allowExt': whitelist_ext,
                    'allowMime': whitelist_mime
                })
        file_input.ace_file_input('reset_input');

        file_input
            .off('file.error.ace')
            .on('file.error.ace', function (e, info) {
            });
        $('.date-picker').datepicker({
            autoclose: true,
            todayHighlight: true
        })
        //show datepicker when clicking on the icon
            .next().on(ace.click_event, function () {
            $(this).prev().focus();
        });

        //or change it into a date range picker
        $('.input-daterange').datepicker({autoclose: true});


        //to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
        $('input[name=date-range-picker]').daterangepicker({
            'applyClass': 'btn-sm btn-success',
            'cancelClass': 'btn-sm btn-default',
            locale: {
                applyLabel: 'Apply',
                cancelLabel: 'Cancel',
            }
        })
            .prev().on(ace.click_event, function () {
            $(this).next().focus();
        });


    });
</script>
</body>
</html>
