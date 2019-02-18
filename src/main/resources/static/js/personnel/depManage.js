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
        url: '../dep/queryDepPage',
        cellMinWidth: 95,
        toolbar: '#toolbarDemo',
        page: true,
        limit: 10,
        limits: [10],
        id: "dep",
        cols: [[
            {type: "checkbox", fixed: "left", width: '2.2%'},
            {field: 'id', title: '编号', width: '10%', align: "center"},
            {field: 'name', title: '名称', width: '38%', align: "center"},
            {field: 'tele', title: '电话', width: '35%', align: "center"},
            {title: '操作', width: '15%', fixed: "right", align: "center", toolbar: '#barDemo'}
        ]]
    });
    //查询
    $("#search_btn").on("click", function () {
        //搜索 id origin producer unit inprice outprice goodstypeid
        var name = $("#name").val();
        var tele = $("#tele").val();
        table.reload("dep", {
            method: 'post',
            where: {
                name: name,//搜索的关键字
                tele: tele
            }
        })
        //清空文本框的值
    });
    $('#add_dep').click(function () {
        //var index = layui.
        layer.open({
            type: 2,
            title: '添加部门',
            shadeClose: true,
            shade: 0.8,
            area: ['25%', '30%'],
            btn: ['提交', '取消'],
            content: 'personnel/depDateil.jsp', //iframe的url
            yes: function (index, layero) {
                var from = layer.getChildFrame('body', index).find("#from_adddep");
                basesubmits("../dep/addDep", $(from).serialize(),index);
                //parent.layer.close(index); //再执行关闭，强制关闭弹窗
            },
            btn2: function (index) {
                parent.layer.close(index); //再执行关闭，强制关闭弹窗
            },
            cancel: function (index, layero) {
                parent.layer.close(index); //再执行关闭，强制关闭弹窗
            },
            end: function () {//在关闭的时候刷新表单
                window.location.reload();
            }
        });
    })

    table.on('tool(dep)', function (obj) {
        var data = obj.data,
            layEvent = obj.event;
        if (layEvent === 'del') {
            layer.confirm('确定删除部门 ' + data.name + '?', {icon: 3, title: '提示信息'}, function (index) {
                var date = 'id=' + data.id + '';
                basesubmit("../dep/delDep", date);
                layer.close(index);
                window.location.reload();
            });
        } else if (layEvent === 'edit') { //编辑
            layer.open({
                type: 2,
                title: '修改部门信息',
                shadeClose: true,
                shade: 0.8,
                area: ['25%', '30%'],
                btn: ['提交', '取消'],
                content: 'personnel/depDateil.jsp', //iframe的url
                success: function (layero, index) {
                    var from = layer.getChildFrame('body', index).find("#from_adddep");
                    from.find("#id").val(data.id);
                    from.find("#name").val(data.name);
                    from.find("#tele").val(data.tele);
                    form.render();
                },
                yes: function (index, layero) {
                    var from = layer.getChildFrame('body', index).find("#from_adddep");
                    basesubmits("../dep/updateDep", $(from).serialize(),index);
                    //parent.layer.close(index); //再执行关闭，强制关闭弹窗
                },
                end: function () {//在关闭的时候刷新表单
                    window.location.reload();
                }
            });
        }
    })


})