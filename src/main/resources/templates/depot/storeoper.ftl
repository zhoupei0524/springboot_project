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
<form class="layui-form layui-form-pane" id="ff">
    <blockquote class="layui-elem-quote quoteBox">
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">员工</label>
            <div class="layui-input-inline layui-form" style="width: 150px;">
                <select id="emp">
                    <option value="">请选择员工</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 120px;">操作时间</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="startDay" name="startDay" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 40px;">至</label>
            <div class="layui-input-inline" style="width: 150px">
                <input type="text" id="endDay" name="endDay" class="layui-input searchVal"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">仓库</label>
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
        <div class="layui-inline">
            <label class="layui-form-label" style="width: 80px;">类型</label>
            <div class="layui-input-inline layui-form" style="width: 150px;">
                <select id="type">
                    <option value="">请选择类型</option>
                    <option value="1">入库</option>
                    <option value="2">出库</option>
                    <option value="">全部</option>
                </select>
            </div>
        </div>
        <div class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" id="search_btn">
            <i class="layui-icon layui-icon-search">搜索</i>
        </div>
    </blockquote>
    <table id="tb" lay-filter="storedateil" style="width: 100%;height: 100%;">
    </table>

    <script type="text/html" id="barDemo">
    </script>

    <script type="text/html" id="toolbarDemo">

    </script>
</form>
</body>
<script>
    layui.use(['form'], function () {
        var form = layui.form;
        /*搜索栏员工下拉框*/
        $.ajax({
            url: "../emp/queryEmpByRole?id=7",
            dataType: 'json',
            success: function (data) {
                var html = '';
                $.each(data, function (index, elem) {
                    html += '<option value="' + elem.id + '">' + elem.realname + '</option>';
                });
                $("#emp").append(html);
                form.render('select');
            }
        });
        /*搜索栏仓库下拉框*/
        $.ajax({
            url: "../store/querystoreList",
            dataType: 'json',
            success: function (data) {
                var html = '';
                $.each(data, function (index, elem) {
                    html += '<option value="' + elem.id + '">' + elem.name + '</option>';
                });
                $("#store").append(html);
                form.render('select');
            }
        });
        /*搜索栏仓库下拉框*/
        $.ajax({
            url: "../Goods/queryGoodsList",
            dataType: 'json',
            success: function (data) {
                var html = '';
                $.each(data, function (index, elem) {
                    html += '<option value="' + elem.id + '">' + elem.name + '</option>';
                });
                $("#goods").append(html);
                form.render('select');
            }
        });
        form.render('select');
    })
    layui.use(['laydate'], function () {
        laydate = layui.laydate;
        laydate.render({
            elem: '#startDay'
            , type: 'datetime'
        });
        laydate.render({
            elem: '#endDay'
            , type: 'datetime'
        });
    })
    layui.use(['table'], function () {
        table = layui.table;
        table.render({
            elem: '#tb',
            url: '../storeoper/queryStoreoperMapPage',
            cellMinWidth: 95,
            page: true,
            limit: 10,
            limits: [10],
            id: "storeoper",
            cols: [[
                {type: "checkbox", fixed: "left", width: '2.4%'},
                {field: 'id', title: '编号', width: '10%', align: "center"},
                {field: 'emp', title: '员工', width: '12%', align: "center"},
                {field: 'opertime', title: '创建时间', width: '18%', align: "center",
                    templet: function (value) {
                        var day = value.opertime;
                        return formatterDate(day);
                    }
                },
                {field: 'store', title: '仓库', width: '12%', align: "center"},
                {field: 'goods', title: '商品', width: '20%', align: "center"},
                {field: 'num', title: '数量', width: '14%', align: "center"},
                {field: 'type', title: '类型', width: '12%', align: "center",
                    templet: function (value) {
                        var type = value.type;
                        if (type == 1) {
                            return "入库";
                        } else if (type == 2) {
                            return "出库";
                        }
                    }
                }
            ]]
        })

        //查询
        $("#search_btn").on("click", function () {
            var emp = $("#emp").val();
            var store = $("#store").val();
            var goods = $("#goods").val();
            var type = $("#type").val();
            var startDay = $("#startDay").val();
            var endDay = $("#endDay").val();
            table.reload("storeoper", {
                url: '../storeoper/queryStoreoperMapPage',
                method: 'post',
                where: {
                    empid: emp,//搜索的关键字
                    storeid: store,
                    goodsid: goods,
                    type: type,
                    startDay: startDay,
                    endDay: endDay
                }
            })
            //清空文本框的值
        });

    })

</script>
</html>