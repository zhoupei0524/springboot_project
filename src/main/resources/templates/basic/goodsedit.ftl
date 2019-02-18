<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/basic/goodsedit.js"></script>
</head>
<body>
<form class="layui-form" id="from_editgoods" method="post">
    <input  id="id" type="hidden" name="id"/>
    <div class="layui-form-item" style="margin-top:5px;margin:0 auto；">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>商品名字 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-inline">
            <input type="text" id="name"  style="width: 245%;" name="name" lay-verify="title"
                   autocomplete="off" placeholder="请输入商品名字" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-top:5px;">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>产地 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-inline">
            <input type="text" id="origin"  style="width: 245%;" name="origin" lay-verify="title"
                   autocomplete="off" placeholder="请输入产地" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-top:5px;">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>厂家 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-inline layui-form" lay-filter="producer" style="width: 465px;">
            <select id="producer" name="producer" lay-verify="producer" >
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="margin-top:5px;">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>计量单位 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-inline">
            <input type="text" id="unit" name="unit" lay-verify="title" style="width: 465px;"
                   autocomplete="off" placeholder="请输入计量单位" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-top:5px;">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>进货价格 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-inline">
            <input type="text" id="inprice" name="inprice" lay-verify="title" style="width: 465px;"
                   autocomplete="off" placeholder="请输入进货价格" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-top:5px;">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>销售价格 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-inline">
            <input type="text" id="outprice" name="outprice" lay-verify="title" style="width: 465px;"
                   autocomplete="off" placeholder="请输入销售价格" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-top:5px;">
        <label class="layui-form-label"
               style="background-color: #EEEEEE; align-content: center;">
            <center>商品类型 <span style="color: red;">*</span>:</center>
        </label>
        <div class="layui-input-inline layui-form" lay-filter="goodstypeidsy" style="width: 465px;">
            <select id="goodstypeidsy" name="goodstypeid" lay-verify="goodstypeidsy" >
            </select>
        </div>
    </div>
</form>
</body>
</html>