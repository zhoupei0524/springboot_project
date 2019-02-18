<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/basic/storeedit.js"></script>

</head>
<body>
<form class="layui-form" id="from_addstore" method="post">
    <input type="hidden"id="id" name="id"/>
    <div class="layui-form-item" style="margin-top:5px;">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >库管员 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline layui-form" lay-filter="empid"  style="width: 230px;">
                <select id="empid" name="empid" lay-verify="required"  lay-filter="empid">
                    <option value="">请选择库管员</option>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item" style="margin-top:5px;">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >名字 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="name" name="name" style="width: 230px;" lay-verify="required" autocomplete=""
                       placeholder="请输入名字" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item" style="margin-top:5px;">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >地址 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="address" name="address" style="width: 230px;" lay-verify="required" autocomplete=""
                       placeholder="请输入地址" class="layui-input" type="tel">
            </div>
        </div>
    </div>

</form>
</body>
</html>