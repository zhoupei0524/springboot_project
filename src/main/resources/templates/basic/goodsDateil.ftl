<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/basic/goodsDateil.js"></script>
</head>
<body>
<form class="layui-form" id="from_addgoods" method="post">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >商品名字 <span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="name" name="name" style="width: 245%;" lay-verify="required" autocomplete=""
                       placeholder="请输入商品名字" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >产地<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="origin" name="origin" style="width: 245%;" lay-verify="required" autocomplete="off"
                       placeholder="请输入产地" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >厂家<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline layui-form" lay-filter="producer"  style="width: 465px;">
                <select id="producer" name="producer" lay-verify="required"  lay-filter="producer">
                    <option value="">请选择厂家</option>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >计量单位<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="unit" name="unit" style="width: 245%;" lay-verify="required" autocomplete="off"
                       placeholder="请输入计量单位" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >进货价格<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline">
                <input id="inprice" name="inprice" style="width: 245%;" lay-verify="required|number" autocomplete="off"
                       placeholder="请输入进货价格" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center >销售价格<span style="color: red;">*</span>:</center>
            </label>
            <div class="layui-input-inline" >
                <input id="outprice" name="outprice" style="width: 245%;" lay-verify="required|number" autocomplete="off"
                       placeholder="请输入销售价格" class="layui-input" type="tel">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"
                   style="background-color: #EEEEEE; align-content: center;">
                <center>商品类型  <span style="color: red;">*</span>:</center></label>
            <div class="layui-input-inline layui-form" lay-filter="goodstypeidmm"  style="width: 465px;">
                <select id="goodstypeidmm" name="goodstypeid" lay-verify="required"  lay-filter="goodstypeidmm">
                    <option value="">请选择商品类型</option>
                </select>
            </div>
        </div>
    </div>
    <#--<div class="layui-form-item">-->
    <#--<center>-->
        <#--<a  class="layui-btn" id="a_addgoods"><i class="layui-icon">&#xe609;</i>增加</a>-->
    <#--</center>-->
    <#--</div>-->

</form>
</body>
</html>