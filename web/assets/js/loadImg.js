/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah')
                    .attr('src', e.target.result)
                    .width(auto)
                    .height(150);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

function readURL1(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah1')
                    .attr('src', e.target.result)
                    .width(auto)
                    .height(150);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

function readURL2(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah2')
                    .attr('src', e.target.result)
                    .width(150)
                    .height(150);
            $('#id-input-file-4')
                    .append('icon', this.selectedFile, this.selectedFile.name);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

function readURL3(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah3')
                    .attr('src', e.target.result)
                    .width(auto)
                    .height(100);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

function readURL4(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah4')
                    .attr('src', e.target.result)
                    .width(auto)
                    .height(150);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

function goBack() {
    window.history.back();
}

$(document).on("click", ".browse", function () {
    var file = $(this).parents().find(".file");
    file.trigger("click");
});
$('input[type="file"]').change(function (e) {
    var fileName = e.target.files[0].name;
    $("#file").val(fileName);

    var reader = new FileReader();
    reader.onload = function (e) {
        // get loaded data and render thumbnail.
        document.getElementById("preview").src = e.target.result;
    };
    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
});