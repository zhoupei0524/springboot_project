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
<form class="layui-form" id="form_Role">
    <input type="hidden" id="roleid" name="roleid">
    <div class="layui-form-item" style="margin-top: 20px;margin-left: 20px;">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center >角色名称 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-inline layui-form" lay-filter="roleid" style="width: 180px;">
            <input type="text" id="rolename" name="rolename" class="layui-input searchVal"/>
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 20px;margin-left: 20px;">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center >角色描述 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-inline layui-form" lay-filter="roleid" style="width: 180px;">
            <input type="text" id="remark" name="remark" class="layui-input searchVal"/>
        </div>
    </div>
</form>
</body>
</html>