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
        url: "../emp/queryEmpByRole?id=7",
        dataType: 'json',
        success: function (data) {
            var html = '';
            $.each(data, function (index, elem) {
                html += '<option value="' + elem.id + '">' + elem.realname + '</option>';
            });
            $("#empid").append(html);
            form.render('select', 'empid');
            var id = $("#id").val();
            $.ajax({
                url: "../store/querystoreList",
                dataType: 'json',
                success: function (data) {
                      $.each(data,function (i, val) {
                          if(val.id==id){
                              console.log(val);
                              $("#empid").find("option[value=" + val.empid + "]").attr('selected', 'true');
                          }
                      })
                    form.render('select');
                }
            })
        }
    });
})