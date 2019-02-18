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
        url: '../supplier/querySupplierPage?type=1',
        cellMinWidth: 95,
        toolbar: '#toolbarDemo',
        page: true,
        limit: 10,
        limits: [10],
        id: "supplier",
        cols: [[
            {type: "checkbox", fixed: "left", width: '2.4%'},
            {field: 'id', title: '编号', width: '8%', align: "center"},
            {field: 'name', title: '名称', width: '14%', align: "center"},
            {field: 'address', title: '地址', width: '20%', align: "center"},
            {field: 'contact', title: '联系人', width: '14%', align: "center"},
            {field: 'tele', title: '电话', width: '14%', align: "center"},
            {field: 'email', title: '邮箱', width: '14%', align: "center"},
            {title: '操作', width: '14%', fixed: "right", align: "center", toolbar: '#barDemo'}
        ]]
    });

    //查询
    $("#search_btn").on("click", function () {
        //搜索 id origin producer unit inprice outprice goodstypeid
        var name = $("#name").val();
        var address = $("#address").val();
        var contact = $("#contact").val();
        var tele = $("#tele").val();
        var email = $("#email").val();
        table.reload("supplier", {
            method: 'post',
            where: {
                name: name,//搜索的关键字
                address: address,
                contact: contact,
                tele: tele,
                email: email
            }
        })
    });


    $('#add_supplier').click(function () {
        layer.open({
            type: 2,
            title: '添加供应商',
            shadeClose: true,
            shade: 0.8,
            area: ['40%', '53%'],
            btn: ['提交', '取消'],
            content:  'basic/supplieredit.jsp', //iframe的url
            yes: function (index, layero) {
                var from = layer.getChildFrame('body', index).find("#from_addsupplier");
                basesubmits("../supplier/addsupplier?type=1", $(from).serialize(),index);
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

    table.on('tool(supplier)', function (obj) {
        var data = obj.data,
            layEvent = obj.event;
        if (layEvent === 'del') {
            layer.confirm('确定删除供应商 ' + data.name + '?', {icon: 3, title: '提示信息'}, function (index) {
                var date = 'id=' + data.id + '';
                basesubmit("../supplier/delsupplier", date);
                layui.jquery("#search_btn").click()//刷新
                layer.close(index);
                window.location.reload();
            });
        } else if (layEvent === 'edit') { //编辑
            layer.open({
                type: 2,
                title: '修改供应商信息',
                shadeClose: true,
                shade: 0.8,
                area: ['40%', '53%'],
                btn: ['提交', '取消'],
                content: 'basic/supplieredit.jsp', //iframe的url
                success: function (layero, index) {
                    var from = layer.getChildFrame('body', index).find("#from_addsupplier");
                    from.find("#id").val(data.id);
                    from.find("#name").val(data.name);
                    from.find("#address").val(data.address);
                    from.find("#contact").val(data.contact);
                    from.find("#tele").val(data.tele);
                    from.find("#email").val(data.email);
                    form.render();
                },
                yes: function (index, layero) {
                    var from = layer.getChildFrame('body', index).find("#from_addsupplier");
                    var data="type=1&"+$(from).serialize();
                    basesubmits("../supplier/updatesupplier", data,index);
                    //parent.layer.close(index); //再执行关闭，强制关闭弹窗
                },
                end: function () {//在关闭的时候刷新表单
                    window.location.reload();
                }
            });
        }
    })


});