layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    var tableWidth = layui.$('#tb').width();
    var rootPath = $('#absolutePath').val();

    //数据加载
    var tableIns = table.render({
        elem: '#tb',
        url: '../store/queryStorePage',
        cellMinWidth: 95,
        toolbar: '#toolbarDemo',
        page: true,
        limit: 10,
        limits: [10],
        id: "store",
        cols: [[
            {type: "checkbox", fixed: "left", width: '2.3%'},
            {field: 'id', title: '编号', width: '10%', align: "center"},
            {field: 'name', title: '名称', width: '23%', align: "center"},
            {field: 'address', title: '地址', width: '35%', align: "center"},
            {field: 'realname', title: '库管员', width: '15%', align: "center"},
            {title: '操作', width: '15%', fixed: "right", align: "center", toolbar: '#barDemo'}
        ]]
    });

    /*搜索栏商品类型下拉框*/
    $.ajax({
        url: "../emp/queryEmpByRole?id=7",
        dataType: 'json',
        success: function (data) {
            var html = '';
            $.each(data, function (index, elem) {
                html += '<option value="' + elem.id + '">' + elem.realname + '</option>';
            });
            $("#empid").append(html);
            form.render('select', 'empid');
        }
    });

    //查询
    $("#search_btn").on("click", function () {
        //搜索 id origin producer unit inprice outprice goodstypeid
        var name = $("#name").val();
        var address = $("#address").val();
        var empid = $("#empid").val();
        table.reload("store", {
            method: 'post',
            where: {
                name: name,//搜索的关键字
                address: address,
                empid: empid
            }
        })
    });








    $('#add_store').click(function () {
        //var index = layui.
        layer.open({
            type: 2,
            title: '添加仓库',
            shadeClose: true,
            shade: 0.8,
            area: ['25%', '40%'],
            btn: ['提交', '取消'],
            content: 'basic/storeedit.jsp', //iframe的url
            yes: function(index, layero){
                var from = layer.getChildFrame('body', index).find("#from_addstore");
                basesubmits("../store/addStore", $(from).serialize(),index);
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
    });

    table.on('tool(store)', function(obj) {
        var data = obj.data,
            layEvent = obj.event;
        if (layEvent === 'del') {
            layer.confirm('确定删除仓库 '+ data.name +  '?', {icon: 3, title: '提示信息'}, function (index) {
                var date = 'id=' + data.id + '';
                basesubmit("../store/delStore", date);
                layer.close(index);
                window.location.reload();
            });
        } else if (layEvent === 'edit') { //编辑
            layer.open({
                type: 2,
                title: '修改仓库信息',
                shadeClose: true,
                shade: 0.8,
                area: ['25%', '40%'],
                btn: ['提交', '取消'],
                content:  'basic/storeedit.jsp', //iframe的url
                success: function (layero, index) {
                    var from = layer.getChildFrame('body', index).find("#from_addstore");
                    from.find("#id").val(data.id);
                    from.find("#address").val(data.address);
                    from.find("#name").val(data.name);
                    form.render();
                },
                yes: function(index, layero){
                    var from = layer.getChildFrame('body', index).find("#from_addstore");
                    basesubmits("../store/updateStore", $(from).serialize(),index);
                },
                end: function () {//在关闭的时候刷新表单
                    window.location.reload();
                }
            });
        }
    })






})