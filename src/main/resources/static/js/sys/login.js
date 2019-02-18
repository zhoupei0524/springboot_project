$(function () {
    $('#btn_login').click(function () {
        userLogin();
    });
});

function userLogin() {
    var username = $('#username').val();
    var password = $('#password').val();
    //验证
    if ("" == username || "" == password) {
        layer.msg("请输入用户登录信息！");
        return false;
    }
    $.ajax({
        url: $('#absolutePath').val() + 'user/login',
        data: {'username': username, 'password': password},
        dataType: 'json',
        type: 'post',
        async: false,
        success: function (data) {
            if (data.msg) {
                layer.msg(data.message, {time: 500}, function () {
                    location.href = $('#absolutePath').val() + 'welcome';
                });
            } else {
                layer.alert(data.message, {
                        closeBtn: 1
                    }, function () {
                        layer.closeAll();
                    }
                );
            }
        }
    })
}