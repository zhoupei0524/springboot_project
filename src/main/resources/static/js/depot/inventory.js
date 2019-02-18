layui.use(['form'], function () {
    form = layui.form;
    form.render('select');
})
layui.use(['laydate'], function () {
    laydate = layui.laydate;
    laydate.render({
        elem: '#registerstartDay'
        , type: 'datetime'
    });
    laydate.render({
        elem: '#registerendDay'
        , type: 'datetime'
    });
    laydate.render({
        elem: '#checkstartDay'
        , type: 'datetime'
    });
    laydate.render({
        elem: '#checkendDay'
        , type: 'datetime'
    });
})
layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    var rootPath = $('#absolutePath').val();

    table.render({
        elem: '#tb',
        url:'../inventory/queryInventoryMapPage',
        cellMinWidth: 95,
        page: true,
        limit: 10,
        limits: [10],
        id: "inventory",
        cols: [[
            {type: "checkbox", fixed: "left", width: '2.1%'},
            {field: 'id', title: '编号', width: '6%', align: "center"},
            {field: 'store', title: '仓库', width: '8%', align: "center"},
            {field: 'goods', title: '商品', width: '10%', align: "center"},
            {field: 'num', title: '数量', width: '6%', align: "center"},
            {field: 'type', title: '类型', width: '10%', align: "center",
                templet: function (value) {
                    var type = value.type;
                    if (type == 1) {
                        return "盘盈";
                    } else if (type == 2) {
                        return "盘亏";
                    }
                }
            },
            {field: 'createtime', title: '创建时间', width: '14%', align: "center",
                templet: function (value) {
                    var day = value.createtime;
                    return formatterDate(day);
                }
            },
            {field: 'creat', title: '录入员', width: '8%', align: "center"},
            {field: 'checktime', title: '审核时间', width: '14%', align: "center",
                templet: function (value) {
                    var day = value.checktime;
                    if (day != null) {
                        return formatterDate(day);
                    } else {
                        return "";
                    }
                }
            },
            {field: 'checks', title: '审核员', width: '8%', align: "center"},
            {field: 'state', title: '状态', width: '7%', align: "center",
                templet: function (value) {
                    var type = value.state;
                    if (type == 1) {
                        return "未审核";
                    } else if (type == 2) {
                        return "已审核";
                    }
                }
            },
            {field: 'dfgh', title: '操作', width: '7%', align: "center",toolbar: '#barDemo'}
        ]]
    })

    //查询
    $("#search_btn").on("click", function () {
        var registerstartDay = $("#registerstartDay").val();
        var registerendDay = $("#registerendDay").val();
        var checkstartDay = $("#checkstartDay").val();
        var checkendDay = $("#checkendDay").val();
        var type = $("[id='type']:checked").val();
        if (type == undefined) {
            type = '';
        }
        table.reload("inventory", {
            url:'../inventory/queryInventoryMapPage',
            method: 'post',
            where: {
                registerstartDay: registerstartDay,//搜索的关键字
                registerendDay: registerendDay,
                checkstartDay: checkstartDay,
                checkendDay: checkendDay,
                type: type
            }
        })


    });


    var rootPath = $('#absolutePath').val();
    //点击录入 打开子界面添加盘盈盘亏
    $("#inventory_btn").click(function () {
        layer.open({
            type: 2,
            title: '盘盈盘亏录入',
            shadeClose: true,
            shade: 0.8,
            area: ['25%', '59%'],
            btn: ['提交', '取消'],
           content:'depot/inventoryedit.jsp', //iframe的url
            yes: function(index, layero){
                var from = layer.getChildFrame('body', index).find("#from_inventory");
                basesubmit("../inventory/addInventory", $(from).serialize());
                parent.layer.close(index); //再执行关闭，强制关闭弹窗
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

    table.on('tool(inventory)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;
        if (layEvent === 'check') {
            if(data.state==2){
                top.layer.msg("请选择未审核的记录!!!");
            }else{
                var type ;
                if (data.type == 1) {
                    type="盘盈";
                } else if (data.type == 2) {
                    type="盘亏";
                }
                layer.confirm('确定审核'+data.store+'的'+data.goods+type+'记录?', {icon: 3, title: '提示信息'}, function (index) {
                    var date = 'id=' + data.id + '';
                    basesubmit("../inventory/updateInventory", date);
                    layer.close(index);
                    window.location.reload();
                });
            }
        }
    })








    })