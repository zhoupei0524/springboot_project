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
    //时间插件
    laydate.render({
        elem: '#startDay'
        , type: 'date'
    });
    laydate.render({
        elem: '#endDay'
        , type: 'date'
    });

    /*搜索部门类型下拉框*/
    $.ajax({
        url: "../dep/queryDep",
        dataType: 'json',
        success: function (data) {
            var html = '';
            $.each(data, function (index, elem) {
                html += '<option value="' + elem.id + '">' + elem.name + '</option>';
            });
            $("#depid").append(html);
            form.render('select', 'depid');
        }
    });
    //数据加载
    var tableIns = table.render({
        elem: '#tb',
        url: '../emp/queryEmpPage',
        cellMinWidth: 95,
        page: true,
        limit: 10,
        limits: [10],
        id: "empsss",
        cols: [[
            {type: "checkbox", fixed: "left", width: '2.2%'},
            {field: 'id', title: '编号', width: '6%', align: "center"},
            {field: 'username', title: '登陆名', width: '8%', align: "center"},
            {field: 'realname', title: '真实姓名', width: '8%', align: "center"},
            {field: 'gender', title: '性别', width: '6%', align: "center"},
            {field: 'email', title: 'Email', width: '14%', align: "center"},
            {field: 'tele', title: '电话', width: '10%', align: "center"},
            {field: 'address', title: '住址', width: '10%', align: "center"},
            {
                field: 'createday', title: '出生年月', width: '14%', align: "center",
                templet: function (value) {
                    var day = value.createday;
                    return formatterDate(day);
                }
            },
            {field: 'dep', title: '部门', width: '8%', align: "center"},
            {title: '操作', width: '14%', fixed: "right", align: "center", toolbar: '#barDemo'}
        ]]
    })
    //查询
    $("#search_btn").on("click", function () {
        var username = $("#username").val();
        var realname = $("#realname").val();
        var email = $("#Email").val();
        var tele = $("#tele").val();
        var address = $("#address").val();
        var startDay = $("#startDay").val();
        var endDay = $("#endDay").val();
        var depid = $("#depid").val();
        var sex = $("[id='sex']:checked").val();
        if (sex == undefined) {
            sex = '';
        }
        // console.log(username);
        table.reload("empsss", {
            method: 'post',
            where: {
                username: username,//搜索的关键字
                realname: realname,
                gender: sex,
                email: email,
                tele: tele,
                address: address,
                startDay: startDay,
                endDay: endDay,
                depid: depid
            }
        })
        //清空文本框的值
        // $("#username").val('');
        // $("#realname").val('');
        // $("#email").val('');
        // $("#tele").val('');
        // $("#address").val('');
        // $("#startDay").val('');
        // $("#endDay").val('');
        // $("#depid").val('');
    });
    form.on("submit(add_emp)", function (data) {

    })
    $('#add_emp').click(function () {
        //var index = layui.
        var index = layui.layer.open({
            type: 2,
            title: '添加员工',
            shadeClose: true,
            shade: 0.8,
            area: ['30%', '63%'],
            content:'../personnel/empDateil.jsp', //iframe的url
            end: function () {//在关闭的时候刷新表单
                window.location.reload();
            }
        });
        layui.layer.full(index);
    })

    table.on('tool(emp)', function (obj) {
        var data = obj.data,
            layEvent = obj.event;
        if (layEvent === 'del') {
            layer.confirm('确定删除员工 ' + data.realname + '?', {icon: 3, title: '提示信息'}, function (index) {
                var date = 'id=' + data.id + '';
                basesubmit("../emp/delEmp", date);
                layer.close(index);
                window.location.reload();
            });
        } else if (layEvent === 'distribution') {
            layer.open({
                type: 2,
                title: '分配角色',
                shadeClose: true,
                shade: 0.8,
                area: ['300px', '300px'],
                btn: ['提交', '取消'],
                content:  'role/empRoleSet.jsp', //iframe的url
                success: function (layero, index) {
                    var from = layer.getChildFrame('body', index).find("#distribution");
                    from.find("#id").val(data.id);
                },
                yes: function (index, layero) {
                    var from = layer.getChildFrame('body', index).find("#distribution");
                    //basesubmit("emp/updatePassword", $(from).serialize());
                    parent.layer.close(index); //再执行关闭，强制关闭弹窗
                },
                btn2: function (index) {
                    parent.layer.close(index); //再执行关闭，强制关闭弹窗
                },
                cancel: function (index, layero) {
                    parent.layer.close(index); //再执行关闭，强制关闭弹窗
                },
                end: function () {//在关闭的时候刷新表单
                    window.location.reload();
                }
            });
        }
        else if (layEvent === 'set') {
            layer.open({
                type: 2,
                title: '修改员工信息',
                shadeClose: true,
                shade: 0.8,
                area: ['250px', '170px'],
                btn: ['提交', '取消'],
                content:  'personnel/empSet.jsp', //iframe的url
                success: function (layero, index) {
                    var from = layer.getChildFrame('body', index).find("#from_editEmp");
                    from.find("#id").val(data.id);
                },
                yes: function (index, layero) {
                    var from = layer.getChildFrame('body', index).find("#from_editEmp");
                    basesubmit("../emp/updatePassword", $(from).serialize());
                    parent.layer.close(index); //再执行关闭，强制关闭弹窗
                },
                btn2: function (index) {
                    parent.layer.close(index); //再执行关闭，强制关闭弹窗
                },
                cancel: function (index, layero) {
                    parent.layer.close(index); //再执行关闭，强制关闭弹窗
                },
                end: function () {//在关闭的时候刷新表单
                    window.location.reload();
                }
            });
        } else if (layEvent === 'edit') { //编辑
            var index = layui.layer.open({
                type: 2,
                title: '修改员工信息',
                shadeClose: true,
                shade: 0.8,
                content: '../personnel/empedit.jsp', //iframe的url
                success: function (layero, index) {
                    var from = layui.layer.getChildFrame('body', index);
                    from.find("#dep").val(data.depid);
                    $.each(data, function (i, val) {
                        from.find("#" + i).val(val);
                        if (i == "depid") {
                            from.find(".gender input[name='gender'][title='" + data.gender + "']").prop("checked", "checked");
                        }
                        if (i == "dep") {
                            from.find(".newsStatus select").val(data.dep);
                        }
                    })
                    form.render();
                    setTimeout(function () {
                        layui.layer.tips('点击此处返回员工列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    }, 500)
                },
                end: function () {//在关闭的时候刷新表单
                    window.location.reload();
                }
            });
            layui.layer.full(index);
        }
    })

})
