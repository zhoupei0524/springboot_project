layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    var rootPath = $('#absolutePath').val();


    //数据加载
    var tableIns = table.render({
        elem: '#tb',
        url: '../Goodstype/queryGoodstypeListPage',
        cellMinWidth: 95,
        page: true,
        toolbar: '#toolbarDemo',
        limit: 10,
        limits: [10],
        id: "newsListTable",
        cols: [[
            {type: "checkbox", fixed: "left", width: '2.2%'},
            {field: 'id', title: '商品类型编号', width: '10%', align: "center"},
            {field: 'name', title: '商品类型名称', width: '75%', align: "center"},
            {title: '操作', width: '13%', fixed: "right", align: "center", toolbar: '#barDemo'}

        ]]
    });

    //查询
    $("#search_btn").on("click", function () {
        //搜索 id origin producer unit inprice outprice goodstypeid
        var id = $("#id").val();
        table.reload("newsListTable", {
            method: 'post',
            where: {
                id: id//搜索的关键字
            }
        })
        //清空文本框的值
    });

    //点击添加商品 打开子界面
    $("#addgoodstype_btn").click(function () {
        layer.open({
            type: 2,
            title: '添加商品类型',
            shadeClose: true,
            shade: 0.8,
            area: ['23%', '25%'],
            content:  'basic/goodstypeadd.jsp', //iframe的url
            end: function () {//在关闭的时候刷新表单
                window.location.reload();
            }
        });
    })


    //列表操作
    table.on('tool(newsListTable)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'del'){
            layer.confirm('确定删除此商品类型？', {icon: 3, title: '提示信息'}, function (index) {
                var date = 'id=' + data.id + '';
                basesubmit("../Goodstype/delGoodstype", date);
                layui.jquery("#search_btn").click()//刷新
                layer.close(index);
                window.location.reload();
            });
        } else if (layEvent === 'edit') { //编辑
           layer.open({
                type: 2,
                title: '编辑商品类型',
                shadeClose: true,
                shade: 0.8,
                area: ['23%', '25%'],
                content: 'basic/goodstypeedit.jsp',
                success: function (layero, index) {
                    var from = layer.getChildFrame('body', index).find("#from_addgoodstype");
                    from.find("#id").val(data.id);
                    from.find("#testsdzs").val(data.name);
                    from.find("#name").val(data.name);
                    form.render();
                },
                end: function () {//在关闭的时候刷新表单
                    window.location.reload();
                }
            })
        }
    });










});

//删除
function del(id) {
    layer.confirm('确定删除此商品类型？', {icon: 3, title: '提示信息'}, function (index) {
        var date = 'id=' + id + '';
        basesubmit("Goodstype/delGoodstype", date);
        layui.jquery("#search_btn").click()//刷新
        layer.close(index);
        window.location.reload();
    });

}


