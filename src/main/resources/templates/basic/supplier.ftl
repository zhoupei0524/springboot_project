<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/basic/supplier.js"></script>
</head>
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
            <label class="layui-form-label" style="width: 80px;">地址</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="address" name="address" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">联系人</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="contact" name="contact" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width:80px;">电话</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="tele" name="tele" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width:80px;">Email</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="email" name="email" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" id="search_btn">
            <i class="layui-icon layui-icon-search">搜索</i>
        </div>
    </blockquote>
    <table id="tb" lay-filter="supplier" style="width: 100%;height: 100%;">
    </table>

    <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="edit">
                <i class="layui-icon layui-icon-edit">编辑</i>
            </a>
            <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="del">
                <i class="layui-icon layui-icon-delete">删除</i>
            </a>
    </script>

    <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <div class="layui-inline" title="创建">
                    <i class="layui-icon layui-icon-add-1" id="add_supplier">新建</i>
                </div>
            </div>
    </script>
</form>
</body>
</html>