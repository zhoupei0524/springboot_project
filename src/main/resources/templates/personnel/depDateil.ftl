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
<form class="layui-form" id="from_adddep" method="post">
    <input type="hidden"id="id" name="id"/>
    <div class="layui-form-item" style="margin-top:5px;">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >名称 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="name" name="name" style="width: 230px;" lay-verify="required" autocomplete=""
                       placeholder="请输入名称" class="layui-input" type="tel">
            </div>
        </div>

    </div>
    <div class="layui-form-item" style="margin-top:5px;">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >电话 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="tele" name="tele" style="width: 230px;" lay-verify="required" autocomplete=""
                       placeholder="请输入电话" class="layui-input" type="tel">
            </div>
        </div>
    </div>

</form>
</body>
</html>