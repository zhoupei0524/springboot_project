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
        url: 'emp/queryEmpPage',
        cellMinWidth: 95,
        toolbar: '#toolbarDemo',
        page: true,
        limit: 10,
        limits: [10, 20, 30],
        id: "store",
        cols: [[
            {type: "checkbox", fixed: "left", width: '2.3%'},
            {field: 'id', title: '编号', width: '20%', align: "center"},
            {field: 'username', title: '名称', width: '30%', align: "center"}
        ]]
    });


})