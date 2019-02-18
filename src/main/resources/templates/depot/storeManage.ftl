<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/depot/storeManage.js"></script>
</head>
<body>
<form class="layui-form layui-form-pane" id="ff">
    <blockquote class="layui-elem-quote quoteBox">
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">仓库:</label>
            <div class="layui-input-inline layui-form" style="width: 150px;">
                <select id="store">
                    <option value="">请选择仓库</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">商品</label>
            <div class="layui-input-inline layui-form" style="width: 150px;">
                <select id="goods">
                    <option value="">请选择商品</option>
                </select>
            </div>
        </div>
        <div class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" id="search_btn">
            <i class="layui-icon layui-icon-search">搜索</i>
        </div>
    </blockquote>
    <table id="tb" lay-filter="storedateil" style="width: 100%;height: 100%;">
    </table>

</form>
</body>
</html>