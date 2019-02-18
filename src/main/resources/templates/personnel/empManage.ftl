<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/personnel/empManage.js"></script>

</head>
<body>
<form class="layui-form layui-form-pane" id="ff">
    <blockquote class="layui-elem-quote quoteBox">
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">登陆名</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="username"name="username"  class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 90px;">真实姓名</label>
            <div class="layui-input-inline"  style="width: 150px">
                <input type="text" id="realname" name="realname" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">性别</label>
            <div class="layui-input-inline"  style="width: 75px">
                <input type="radio" name="sex" id="sex" value="男" title="男">
            </div>
            <div class="layui-input-inline"  style="width: 75px">
                <input type="radio" name="sex" id="sex" value="女" title="女">
            </div>
            <div class="layui-input-inline"  style="width: 90px">
                <input type="radio" name="sex" id="sex" checked="true"  value="" title="全部" >
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">Email</label>
            <div class="layui-input-inline"  style="width: 150px">
                <input type="text" id="Email" name="Email" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">电话</label>
            <div class="layui-input-inline"  style="width: 150px">
                <input type="text" id="tele" name="tele" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">住址</label>
            <div class="layui-input-inline"  style="width: 150px">
                <input type="text" id="address" name="address" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 120px;">出生年月</label>
            <div class="layui-input-inline"  style="width: 150px">
                <input type="text" id="startDay" name="startDay" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 40px;">至</label>
            <div class="layui-input-inline"  style="width: 150px">
                <input type="text" id="endDay" name="endDay" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">部门</label>
            <div class="layui-input-inline layui-form" lay-filter="depid" style="width: 150px;">
                <select id="depid" lay-filter="depid">
                    <option value="">请选择部门</option>
                </select>
            </div>
        </div>
        <div class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" id="search_btn">
            <i class="layui-icon layui-icon-search">搜索</i>
        </div>
            <div class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" id="search_btn">
                <i class="layui-icon layui-icon-add-1" id="add_emp">新建</i>
            </div>
    </blockquote>
    <table id="tb" lay-filter="emp" style="width: 100%;height: 100%;">
    </table>
    <script type="text/html" id="toolbarDemo">

    </script>
    <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="edit">
                <i class="layui-icon layui-icon-edit">编辑</i>
            </a>
            <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="del">
                <i class="layui-icon layui-icon-delete">删除</i>
            </a>
    </script>
</form>
</body>
</html>