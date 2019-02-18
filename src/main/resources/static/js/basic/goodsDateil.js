var rootPath = '';
layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    rootPath = $('#absolutePath').val();

    /*商品类型下拉框*/
    $.ajax({
        url: "../Goodstype/queryGoodstypeList",
        dataType: 'json',
        success: function (data) {
            var html = '';
            $.each(data, function (index, elem) {
                html += '<option value="' + elem.id + '">' + elem.name + '</option>';
            });
            $("#goodstypeidmm").append(html);
            form.render('select', 'goodstypeidmm');
        }
    });
    /*厂家下拉框*/
    $.ajax({
        url: "../supplier/querySupplier?type=1",
        dataType: 'json',
        success: function (data) {
            var html = '';
            $.each(data, function (index, elem) {
                html += '<option value="' + elem.id + '">' + elem.name + '</option>';
            });
            $("#producer").append(html);
            form.render('select', 'producer');
        }
    });

    $("#a_addgoods").click(function () {
        var inprice = $("#inprice").val();
        var outprice = $("#outprice").val();
        var reg= /^([1-9][0-9]*)+(.[0-9]{1,2})?$/;
        console.log(reg.test(inprice))
        if (!reg.test(inprice)) {
            layer.msg("进货价格格式不对,请输入一个大于0.01的数据！！");
            return false;
        }else if (!reg.test(outprice)) {
            layer.msg("销售价格格式不对,请输入一个大于0.01的数据！！！");
            return false;
        }else{
            add();
            //关闭自身
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭，强制关闭弹窗
        }

    })

});

function add() {
    basesubmit("../Goods/addGoods", $('#from_addgoods').serialize());
}







