$("#reg_confirm_pass").blur(function () {
    var user_pass = $("#reg_pass").val();
    var user_pass2 = $("#reg_confirm_pass").val();
    //var enter = $("#enter").val();

    if (user_pass.length == 0) {
        $("#divCheckPasswordMatch").html("Vui lòng nhập mật khẩu");
        $("#submit").prop('disabled', true)//use prop()
    }
    if (user_pass2.length == 0) {
        $("#divCheckPasswordMatch").html("Vui lòng nhập mật khẩu 2 lần");
        $("#submit").prop('disabled', true)//use prop()
    } else if (user_pass == user_pass2) {
        $("#submit").prop('disabled', false)//use prop()
        $("#divCheckPasswordMatch").html("Nhấn Cập nhật để thay mật khẩu");
    } else {
        $("#submit").prop('disabled', true)//use prop()
        $("#divCheckPasswordMatch").html("Mật khẩu không trùng khớp");
    }

});

function goBack() {
    window.history.back();
}
