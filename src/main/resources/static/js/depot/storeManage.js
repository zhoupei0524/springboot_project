layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

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
    /*搜索栏商品下拉框*/
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

    //数据加载
    var tableIns = table.render({
        elem: '#tb',
        url: '../StoreDateil/queryStoreDateil',
        cellMinWidth: 95,
        toolbar: '#toolbarDemo',
        page: true,
        limit: 10,
        limits: [10],
        id: "storedateil",
        cols: [[
            {type: "checkbox", fixed: "left", width: '2.3%'},
            {field: 'id', title: '编号', width: '10%', align: "center"},
            {field: 'goodname', title: '名称', width: '23%', align: "center"},
            {field: 'storename', title: '仓库', width: '40%', align: "center"},
            {field: 'num', title: '数量', width: '25%', align: "center"}
        ]]
    });

     //查询
    $("#search_btn").on("click", function () {
        var store = $("#store").val();
        var goods = $("#goods").val();
        table.reload("storedateil", {
            url:'../StoreDateil/queryStoreDateil',
            method: 'post',
            where: {
                storeid: store,//搜索的关键字
                goodid: goods
            }
        })
        //清空文本框的值
        // $("#store").val('');
        // $("#goods").val('');
        // form.render('select');
    });

})