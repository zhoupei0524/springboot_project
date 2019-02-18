<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/depot/inventory.js"></script>
</head>
<body>
<form class="layui-form layui-form-pane" id="ff">
    <blockquote class="layui-elem-quote quoteBox">
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 120px;">登记日期</label>
            <div class="layui-input-inline" style="width: 200px">
                <input type="text" id="registerstartDay" name="startDay" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 40px;">至</label>
            <div class="layui-input-inline" style="width: 200px">
                <input type="text" id="registerendDay" name="endDay" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 120px;">审核日期</label>
            <div class="layui-input-inline" style="width: 200px">
                <input type="text" id="checkstartDay" name="startDay" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 40px;">至</label>
            <div class="layui-input-inline" style="width: 200px">
                <input type="text" id="checkendDay" name="endDay" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">类型</label>
            <div class="layui-input-inline" style="width: 90px">
                <input type="radio" name="type" id="type" value="1" title="盘盈">
            </div>
            <div class="layui-input-inline" style="width: 90px">
                <input type="radio" name="type" id="type" value="2" title="盘亏">
            </div>
            <div class="layui-input-inline" style="width: 90px">
                <input type="radio" name="type" id="type" checked="true" value="" title="全部">
            </div>
        </div>
            <div class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" id="search_btn">
                <i class="layui-icon layui-icon-search">搜索</i>
            </div>
            <div class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" id="inventory_btn">
                <i class="layui-icon layui-icon-add-circle">录入</i>
            </div>
    </blockquote>
    <table id="tb" lay-filter="inventory" style="width: 100%;height: 100%;">
    </table>
    <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="check">
                <i class="layui-icon layui-icon-ok-circle">审核</i>
            </a>
    </script>
</form>
</body>
</html>