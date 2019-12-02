/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
