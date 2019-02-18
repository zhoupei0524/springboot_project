<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/basic/goods.js"></script>
</head>
<body>
<form class="layui-form" id="ff">
    <blockquote class="layui-elem-quote quoteBox">
        <div class="layui-inline">
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="id" class="layui-input searchVal"
                       placeholder="请输入商品编号"/>
            </div>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="origin" class="layui-input searchVal"
                       placeholder="请输入产地"/>
            </div>
            <div class="layui-input-inline" style="width: 150px">
                <select id="producer" lay-filter="producer">
                    <option value="">请选择厂家</option>
                </select>
            </div>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="unit" class="layui-input searchVal"
                       placeholder="请输入计量单位"/>
            </div>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="inprice" class="layui-input searchVal"
                       placeholder="请输入进货价格"/>
            </div>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="outprice" class="layui-input searchVal"
                       placeholder="请输入销售价格"/>
            </div>
            <div class="layui-input-inline layui-form" lay-filter="goodstypeid" style="width: 150px;">
                <select id="goodstypeid" lay-filter="goodstypeid">
                    <option value="">请选择商品类型</option>
                </select>
            </div>
            <div class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" id="search_btn">
                <i class="layui-icon layui-icon-search">搜索</i>
            </div>
        </div>
    </blockquote>
    <table id="tb" lay-filter="newsListTable" style="width: 100%;height: 100%;">
    </table>
    <!--操作-->
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
                    <i class="layui-icon layui-icon-add-1" id="add_goods">新建</i>
                </div>
            </div>
    </script>
</form>
</body>
</html>