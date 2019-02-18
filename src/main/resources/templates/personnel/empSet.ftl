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
<form class="layui-form" id="from_editEmp" method="post">
    <input type="hidden" id="id" name="id"/>
    <div class="layui-form-item" style="margin-top: 5px;">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>新密码 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="password" id="password" name="password" style="width: 130px;" lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
</form>
</body>
</html>