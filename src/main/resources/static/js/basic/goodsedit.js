var rootPath = '';
layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    rootPath = $('#absolutePath').val();

    /*搜索栏商品类型下拉框*/
    $.ajax({
        url: "../Goodstype/queryGoodstypeList",
        dataType: 'json',
        success: function (data) {
            var html = '';
            $.each(data, function (index, elem) {
                html += '<option value="' + elem.id + '">' + elem.name + '</option>';
            });
            $("#goodstypeidsy").append(html);
            form.render('select', 'goodstypeidsy');
            var id = $("#id").val();
            $.ajax({
                url: "../Goods/querygoodsbyname?id=" + id,
                dataType: 'json',
                success: function (data) {
                    $.each(data, function (i, val) {
                        $("#goodstypeidsy").find("option[value=" + val.goodstypeid + "]").attr('selected', 'true');
                    })
                    form.render('select');
                }
            })
        }
    });
    /*搜索栏厂家下拉框*/
    $.ajax({
        url: "../supplier/querySupplier?type=1",
        dataType: 'json',
        success: function (data) {
            var html = '';
            $.each(data, function (index, elem) {
                html += '<option value="' + elem.id + '">' + elem.name + '</option>';
            });
            $("#producer").append(html);
            form.render('select');
            var id = $("#id").val();
            $.ajax({
                url: "../Goods/querygoodsbyname?id=" + id,
                dataType: 'json',
                success: function (data) {
                    $.each(data, function (i, val) {
                        $("#producer").find("option[value=" + val.producer + "]").attr('selected', 'true');
                    })
                    form.render('select');
                }
            })
        }
    });

});







