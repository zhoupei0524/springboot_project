layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    /*搜索栏商品类型下拉框*/
    $.ajax({
        url: "../dep/queryDep",
        dataType: 'json',
        success: function (data) {
            var html = '';
            $.each(data, function (index, elem) {
                html += '<option value="' + elem.id + '">' + elem.name + '</option>';
            });
            $("#depid").append(html);
            form.render('select', 'depid');
        }
    });
    form.on("submit(addEmp)",function(data){
        //ar from = layer.getChildFrame('body', index).find("#from_addEmp");
        var datas='username='+$('#username').val()+'';
        $.ajax({
            type: "post",
            dataType : "json",
            url: '../emp/queryDep',
            data: datas,
            success: function(data){
                console.log(data.msg);
                if(data.msg=='已存在'){
                    top.layer.msg('增加失败！！！登陆名称重复！');
                }else{
                    var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
                    $.post("../emp/addEmp",{
                        username : $("#username").val(),
                        realname : $("#realname").val(),
                        tele : $("#tele").val(),  //文章内容
                        gender : $('#sexradio input[name="sex"]:checked ').val(),
                        email :  $("#email").val(),
                        address : $('#address').val(),
                        depid : $('#depid').val()
                    },function(res){

                    })
                    setTimeout(function(){
                        top.layer.close(index);
                        top.layer.msg("添加员工成功！");
                        layer.closeAll();
                        //刷新父页面
                        parent.location.reload();
                    },500);
                }

            }
        });
        return false;
    })

})
