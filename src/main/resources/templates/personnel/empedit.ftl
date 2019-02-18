<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/personnel/empedit.js"></script>
</head>
<body>
<form class="layui-form" id="from_editEmp" method="post">
    <input type="hidden" id="id" name="id"/>
    <input type="hidden" id="dep"/>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>登陆账号 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="text" id="username" name="username" lay-verify="required" autocomplete="off"
                   placeholder="请输入登陆账号" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>真实姓名 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="text" id="realname" name="realname" lay-verify="required" autocomplete="off"
                   placeholder="请输入真实姓名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item gender">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>性别 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block" id="sexradio">
            <input type="radio" name="gender" value="男" title="男">
            <input type="radio" name="gender" value="女" title="女">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>Email <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="text" id="email" name="email" lay-verify="required|email" autocomplete="off"
                   placeholder="请输入Email" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>电话 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="text" id="tele" name="tele" lay-verify="required|phone" autocomplete="off" placeholder="请输入电话"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>地址<span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block">
            <input type="text" id="address" name="address"
                   lay-verify="required" autocomplete="off" placeholder="请输入地址" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>部门<span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-block layui-form newsStatus" lay-verify="dep">
            <select id="depid" name="depid" lay-filter="dep" lay-verify="required">
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <center>
            <a class="layui-btn layui-btn-sm" lay-filter="updateEmp" lay-submit>
                发布</a>
        </center>
    </div>

</form>
</body>
</html>