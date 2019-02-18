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
<form class="layui-form" id="from_addsupplier" method="post">
    <input type="hidden"id="id" name="id"/>
    <div class="layui-form-item" style="margin-top:5px;">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >名称 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="name" name="name" style="width: 245%;" lay-verify="required"  autocomplete=""
                       placeholder="请输入名字" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >地址<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="address" name="address" style="width: 245%;" lay-verify="required" autocomplete="off"
                       placeholder="请输入地址" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >联系人<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="contact" name="contact" style="width: 245%;" lay-verify="required" autocomplete="off"
                       placeholder="请输入联系人" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >电话<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="tele" name="tele" style="width: 245%;" lay-verify="required" autocomplete="off"
                       placeholder="请输入电话" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >邮箱<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="email" name="email" style="width: 245%;" lay-verify="required|number" autocomplete="off"
                       placeholder="请输入邮箱" class="layui-input" type="tel">
            </div>
        </div>
    </div>

</form>
</body>
</html>