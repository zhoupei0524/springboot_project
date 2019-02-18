<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/personnel/depManage.js"></script>
</head>
<body>
<body>
<form class="layui-form layui-form-pane" id="ff">
    <blockquote class="layui-elem-quote quoteBox">
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">名称:</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="name" name="name" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">电话</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="tele" name="tele" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" id="search_btn">
            <i class="layui-icon layui-icon-search">搜索</i>
        </div>
    </blockquote>
    <table id="tb" lay-filter="dep" style="width: 100%;height: 100%;">
    </table>

    <script type="text/html" id="barDemo">
        <shiro:hasPermission name="dep:edit">
            <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="edit">
                <i class="layui-icon layui-icon-edit">编辑</i>
            </a>
        </shiro:hasPermission>
        <shiro:hasPermission name="dep:del">
            <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="del">
                <i class="layui-icon layui-icon-delete">删除</i>
            </a>
        </shiro:hasPermission>
    </script>
    <script type="text/html" id="toolbarDemo">
        <shiro:hasPermission name="dep:add">
            <div class="layui-btn-container">
                <div class="layui-inline" title="创建">
                    <i class="layui-icon layui-icon-add-1" id="add_dep">新建</i>
                </div>
            </div>
        </shiro:hasPermission>
    </script>
</form>
</body>
</html>