<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/basic/goodstypeedit.js"></script>
</head>
<body>
<form class="layui-form" id="from_addgoodstype" method="post">
    <input type="hidden" id="id" name="id">
    <input type="hidden" id="testsdzs" name="test">
    <div class="layui-form-item" style="margin-top:5px;">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >商品类型 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="name" name="name"  lay-verify="required" autocomplete=""
                       placeholder="请输入商品类型" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <center>
            <a  class="layui-btn layui-btn-sm" id="a_addgoodstype">提交</a>
        </center>
    </div>
</form>
</body>
</html>