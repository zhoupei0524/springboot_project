<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/personnel/empDateil.js"></script>
</head>
<body>
<form class="layui-form" id="from_addEmp" method="post">
    <input type="hidden"id="id" name="id"/>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center >登陆账号 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="text" id="username" name="username" lay-verify="required" autocomplete="off" placeholder="请输入登陆账号" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center >真实姓名 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="text" id="realname" name="realname" lay-verify="required" autocomplete="off" placeholder="请输入真实姓名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center >性别 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block" id="sexradio">
            <input type="radio" name="sex"  value="男" checked="true"  title="男" >
            <input type="radio" name="sex"  value="女" title="女" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center >Email <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="text" id="email" name="email" lay-verify="required|email" autocomplete="off" placeholder="请输入Email" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center >电话 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="text" id="tele" name="tele" lay-verify="required|phone" autocomplete="off" placeholder="请输入电话" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center >地址<span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="text" id="address" name="address"
                   lay-verify="required" autocomplete="off" placeholder="请输入地址" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center >部门<span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block layui-form" lay-filter="depid" >
            <select id="depid" lay-filter="depid" lay-verify="required">
                <option value="">请选择部门</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <center>
            <a class="layui-btn layui-btn-sm" lay-filter="addEmp" lay-submit>
                发布</a>
        </center>
    </div>
</form>
</body>
</html>