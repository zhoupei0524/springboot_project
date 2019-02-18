layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    var tableWidth = layui.$('#tb').width();
    var rootPath = $('#absolutePath').val();

    //tableWidth*0.1

    //数据加载
    var tableIns = table.render({
        elem: '#tb',
        url: '../Goods/queryGoods',
        cellMinWidth: 95,
        page: true,
        toolbar: '#toolbarDemo',
        limit: 10,
        limits:[10],
        id: "newsListTable",
        cols: [[
            {type: "checkbox", fixed: "left", width: '2.2%'},
            {field: 'id', title: '编号', width: '8%', align: "center"},
            {field: 'name', title: '名称', width: '15%', align: "center"},
            {field: 'origin', title: '产地', width: '10%', align: "center"},
            {field: 'supplier', title: '厂家', width: '15%', align: "center"},
            {field: 'unit', title: '计量单位', width: '8%', align: "center"},
            {field: 'inprice', title: '进货价格', width: '10%', align: "center"},
            {field: 'outprice', title: '销售价格', width: '10%', align: "center"},
            {field: 'goodtype', title: '商品类型', width: '8%', align: "center"},
            {title: '操作', width: '14%', fixed: "right", align: "center",toolbar: '#barDemo'}
        ]]
    });


    //查询
    $("#search_btn").on("click", function () {
        //搜索 id origin producer unit inprice outprice goodstypeid
        var id = $("#id").val();
        var origin = $("#origin").val();
        var producer = $("#producer").val();
        var unit = $("#unit").val();
        var inprice = $("#inprice").val();
        var outprice = $("#outprice").val();
        var goodstypeid = $("#goodstypeid").val();
        table.reload("newsListTable", {
            method: 'post',
            where: {
                id: id,//搜索的关键字
                origin: origin,
                producer: producer,
                unit: unit,
                inprice: inprice,
                outprice: outprice,
                goodstypeid: goodstypeid
            }
        })
    });

    /*搜索栏厂家下拉框*/
    baseSelect('../supplier/querySupplier?type=1','producer');
    /*搜索栏商品类型下拉框*/
    baseSelect('../Goodstype/queryGoodstypeList','goodstypeid');

    //点击添加商品 打开子界面
    $("#add_goods").click(function () {
        layer.open({
            type: 2,
            title: '添加商品',
            shadeClose: true,
            shade: 0.8,
            area: ['40%', '69%'],
            btn: ['提交', '取消'],
            content: 'basic/goodsDateil.jsp', //iframe的url
            yes: function(index, layero){
                var from = layer.getChildFrame('body', index).find("#from_addgoods");
                basesubmits("../Goods/addGoods", $(from).serialize(),index);
            },
            btn2: function(index){
                parent.layer.close(index); //再执行关闭，强制关闭弹窗
            },
            cancel: function(index, layero){
                parent.layer.close(index); //再执行关闭，强制关闭弹窗
            },
            end: function () {//在关闭的时候刷新表单
                window.location.reload();
            }
        });
    })
    //列表操作
    table.on('tool(newsListTable)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;
        if (layEvent === 'del') {
            layer.confirm('确定删除商品 '+ data.name +  '?', {icon: 3, title: '提示信息'}, function (index) {
                var date = 'id=' + data.id + '';
                basesubmit("../Goods/delGoods", date);
                layer.close(index);
                window.location.reload();
            });
        } else if (layEvent === 'edit') { //编辑
             layer.open({
                type: 2,
                title: '编辑商品',
                shadeClose: true,
                shade: 0.8,
                 area: ['40%', '69%'],
                 btn: ['提交', '取消'],
                 content: 'basic/goodsedit.jsp',
                success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                    form.render();
                    form.render("select");
                    $.each(data,function (i, val) {
                        body.find("#"+i).val(val);
                    })
                    form.render();
                 },
                 yes: function(index, layero){
                     var from = layer.getChildFrame('body', index).find("#from_editgoods");
                     basesubmits("../Goods/updateGoods", $(from).serialize(),index);
                 },
                 btn2: function(index){
                     parent.layer.close(index); //再执行关闭，强制关闭弹窗
                 },
                 cancel: function(index, layero){
                     parent.layer.close(index); //再执行关闭，强制关闭弹窗
                 },
                end: function () {//在关闭的时候刷新表单
                    window.location.reload();
                }
            })
        }
    });
});

//删除
function del(data) {
    layer.confirm('确定删除此商品？', {icon: 3, title: '提示信息'}, function (index) {
        var date = 'id=' + data + '';
        basesubmit("../Goods/delGoods", date);
        layui.jquery("#search_btn").click()//刷新
        layer.close(index);
    });
}



