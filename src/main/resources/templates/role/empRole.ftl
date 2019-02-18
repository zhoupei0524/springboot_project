<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
</head>
<body>
<form class="layui-form layui-form-pane" id="ff">
    <blockquote class="layui-elem-quote quoteBox">
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">登陆名</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="username" name="username" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 90px;">真实姓名</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="realname" name="realname" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">性别</label>
            <div class="layui-input-inline" style="width: 75px">
                <input type="radio" name="sex" id="sex" value="男" title="男">

            </div>
            <div class="layui-input-inline" style="width: 75px">
                <input type="radio" name="sex" id="sex" value="女" title="女">
            </div>
            <div class="layui-input-inline" style="width: 90px">
                <input type="radio" name="sex" id="sex" checked="true" value="" title="全部">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">Email</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="Email" name="Email" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">电话</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="tele" name="tele" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 120px;">创建时间</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="startDay" name="startDay" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 40px;">至</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="endDay" name="endDay" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">角色</label>
            <div class="layui-input-inline layui-form" lay-filter="depid" style="width: 150px;">
                <select id="depid" lay-filter="depid">
                    <option value="">请选择角色</option>
                </select>
            </div>
        </div>
        <div class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" id="search_btn">
            <i class="layui-icon layui-icon-search">搜索</i>
        </div>
    </blockquote>
    <table id="tb" lay-filter="emp" style="width: 100%;height: 100%;">
    </table>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="set">
            <i class="layui-icon ">重置密码</i>
        </a>
        <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="distribution">
            <i class="layui-icon ">分配角色</i>
        </a>
    </script>
</form>
</body>
<script>
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
            , type: 'datetime'
        });
        laydate.render({
            elem: '#endDay'
            , type: 'datetime'
        });

        /*搜索部门类型下拉框*/
        $.ajax({
            url: "../role/queryRolelist",
            dataType: 'json',
            success: function (data) {
                var html = '';
                $.each(data, function (index, elem) {
                    html += '<option value="' + elem.roleid + '">' + elem.rolename + '</option>';
                });
                $("#depid").append(html);
                form.render('select', 'depid');
            }
        });
        //数据加载
        var tableIns = table.render({
            elem: '#tb',
            url: '../emp/queryEmpRolePage',
            cellMinWidth: 95,
            page: true,
            limit: 10,
            limits: [10],
            id: "empsss",
            cols: [[
                {type: "checkbox", fixed: "left", width: '2.1%'},
                {field: 'id', title: '编号', width: '6%', align: "center"},
                {field: 'username', title: '登陆名', width: '8%', align: "center"},
                {
                    field: 'password', title: '密码', width: '10%', align: "center",
                    templet: function (value) {
                        if (value.password != null) {
                            return "********";
                        } else {
                            return "";
                        }
                    }
                },
                {field: 'realname', title: '真实姓名', width: '8%', align: "center"},
                {field: 'gender', title: '性别', width: '6%', align: "center"},
                {field: 'email', title: 'Email', width: '14%', align: "center"},
                {field: 'tele', title: '电话', width: '10%', align: "center"},
                {
                    field: 'createday', title: '创建时间', width: '13%', align: "center",
                    templet: function (value) {
                        var day = value.createday;
                        return formatterDate(day);
                    }
                },
                {field: 'rolename', title: '角色', width: '8%', align: "center"},
                {title: '操作', width: '15%', fixed: "right", align: "center", toolbar: '#barDemo'}
            ]]
        })
        //查询
        $("#search_btn").on("click", function () {
            var username = $("#username").val();
            var realname = $("#realname").val();
            var email = $("#Email").val();
            var tele = $("#tele").val();
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
                    startDay: startDay,
                    endDay: endDay,
                    depid: depid
                }
            })
            //清空文本框的值
        });
        form.on("submit(add_emp)", function (data) {

        })


        table.on('tool(emp)', function (obj) {
            var data = obj.data,
                    layEvent = obj.event;
            if (layEvent === 'distribution') {
                layer.open({
                    type: 2,
                    title: '分配角色',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['400px', '500px'],
                    btn: ['提交', '取消'],
                    content: 'role/empRoleSet.jsp', //iframe的url
                    success: function (layero, index) {
                        var from = layer.getChildFrame('body', index).find("#distribution");
                        from.find("#id").val(data.id);
                    },
                    yes: function (index, layero) {
                        var from = layer.getChildFrame('body', index).find("#distribution");
                        basesubmit("../empRole/distribution", $(from).serialize());
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
                layer.confirm('确定重置 '+ data.username + '用户密码?', {icon: 3, title: '提示信息'}, function (index) {
                    var id=data.id;
                    var datas='id='+id+'&password=123456';
                    basesubmit("../emp/updatePassword", datas);
                    layer.close(index);
                });
            }
        })
    })
</script>
</html>