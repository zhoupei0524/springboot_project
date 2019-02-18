layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    var rootPath = $('#absolutePath').val();

    //熟新头部
    form.render();
    /*搜索栏商品类型下拉框*/
    // $.ajax({
    //     url: "dep/queryDep",
    //     dataType: 'json',
    //     success: function (data) {
    //         var html = '';
    //         $.each(data, function (index, elem) {
    //             html += '<option value="' + elem.id + '">' + elem.name + '</option>';
    //         });
    //         $("#depid").append(html);
    //         form.render('select');
    //         var username = $("#username").val();
    //         $.ajax({
    //             url: "emp/queryDepEmp?username=" + username,
    //             dataType: 'json',
    //             success: function (data) {
    //                 // $.each(data, function (i, val) {
    //                 //     console.log(val)
    //                 $("#depid").find("option[value=" + data.depid + "]").attr('selected', 'true');
    //                 // })
    //                 form.render('select');
    //             }
    //         })
    //     }
    // });

    var username = $("#username").val();
    //获取部门id
    $.ajax({
        url: "../emp/queryDepEmp?username=" + username,
        dataType: 'json',
        success: function (data) {
             //绑定下拉框并绑定原有的值
             baseSelectto('../dep/queryDep','depid',data.depid) ;
        }
    })

    form.on("submit(updateEmp)", function (data) {
        var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        var datas = 'username=' + $('#username').val() + '';
        var username = $('#username').val();
        var id = $('#id').val();
        console.log(username);
        $.ajax({
            type: "post",
            dataType: "json",
            url: '../emp/queryDepy?id=' + id + '&username=' + username,
            success: function (data) {
                if (data.msg == '已存在') {
                    top.layer.msg('修改失败！！！登陆名称重复！');
                } else {
                    $.post("../emp/updateEmp", {
                        id: $('#id').val(),
                        username: $("#username").val(),
                        password: $("#password").val(),
                        realname: $("#realname").val(),
                        tele: $("#tele").val(),  //文章内容
                        gender: $('#sexradio input[name="gender"]:checked ').val(),
                        email: $("#email").val(),
                        address: $('#address').val(),
                        depid: $('#depid').val()
                    }, function (res) {

                    })
                    setTimeout(function () {
                        top.layer.close(index);
                        top.layer.msg("修改员工成功！");
                        layer.closeAll();
                        //刷新父页面
                        parent.location.reload();
                    }, 500);
                }
            }
        });
        return false;
    })

})