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
<form class="layui-form" id="distribution">
    <input type="hidden" id="id" name="empid">
    <center>
        <div class="layui-form-item" style="margin-top: 20px;margin-left: 20px;">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >角色 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline layui-form" lay-filter="roleid" style="width: 180px;">
                <select id="roleid" name="roleid" lay-filter="roleid">
                    <option value="">请选择角色</option>
                </select>
            </div>
        </div>
    </center>
</form>
</body>
<script>
    layui.use(['form', 'layer' , ], function () {
        var form = layui.form,
                $ = layui.jquery
        /*搜索栏商品类型下拉框*/
        $.ajax({
            url: "../role/queryRolelist",
            dataType: 'json',
            success: function (data) {
                var html = '';
                $.each(data, function (index, elem) {
                    html += '<option value="' + elem.roleid + '">' + elem.rolename + '</option>';
                });
                $("#roleid").append(html);
                form.render('select', 'roleid');
            }
        });
    })
</script>
</html>
