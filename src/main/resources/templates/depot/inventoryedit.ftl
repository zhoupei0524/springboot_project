<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" id="from_inventory" method="post">
    <div class="layui-form-item">
        <div class="layui-inline" style="margin-top: 5px;">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center>商品<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline layui-form" style="width: 250px;">
                <select id="goodsid" name="goodsid" lay-filter="goods">
                    <option value="">请选择商品</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center>仓库 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline layui-form" style="width: 250px;">
                <select id="storeid" name="storeid">
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center>数量<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="num" name="num" lay-verify="required" style="width: 250px;"
                       placeholder="请输入数量" class="layui-input" type="tel">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center>类型 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-block" id="sexradio">
                <input type="radio" name="type"  value="1" checked="true"  title="盘盈" >
                <input type="radio" name="type"  value="2" title="盘亏" >
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center>备注<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="remark" name="remark" lay-verify="required" style="width: 250px;"
                       placeholder="请输入备注" class="layui-input" type="tel">
            </div>
        </div>
    </div>
</form>
</body>
</html>
<script>
    layui.use(['form'], function () {
        var form = layui.form;
        $.ajax({
            url: "../Goods/queryGoodsList",
            dataType: 'json',
            success: function (data) {
                var html = '';
                $.each(data, function (index, elem) {
                    html += '<option value="' + elem.id + '">' + elem.name + '</option>';
                });
                $("#goodsid").append(html);
                form.render('select');
            }
        });
        form.on('select(goods)', function (data) {
            $.ajax({
                url: "../StoreDateil/querySingStoreDateil?goodid=" + data.value,
                dataType: 'json',
                success: function (data) {
                    $.each(data, function (index, elem) {
                        $.ajax({
                            url: "../store/querystoreList?id="+elem.storeid,
                            dataType: 'json',
                            success: function (data) {
                                var html = '';
                                $.each(data, function (index, elem) {
                                    html += '<option value="' + elem.id + '">' + elem.name + '</option>';
                                });
                                $("#storeid").append(html);
                                form.render('select');
                            }
                        });
                    });
                }
            })

        })
    })
</script>