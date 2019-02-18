<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/js/zTree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" type="text/css" href="../static/js/layer/theme/default/layer.css">
    <script type="text/javascript" src="../static/js/zTree/jquery.ztree.all.min.js"></script>

    <script type="text/javascript" src="../static/js/layer/layer.js"></script>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>角色及权限</legend>
</fieldset>

<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <div class="layui-inline" title="新增">
            <i class="layui-icon layui-icon-add-1" onclick="add();">增加</i>
        </div>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="edit">
        <i class="layui-icon layui-icon-edit">编辑</i>
    </a>
    <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="del">
        <i class="layui-icon layui-icon-delete">删除</i>
    </a>
    <a class="layui-btn layui-btn-xs layui-btn-radius layui-btn-primary" lay-event="ass">
        <i class="layui-icon layui-icon-engine">授权</i>
    </a>
</script>


<script>
    layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
        var form = layui.form,
                layer = parent.layer === undefined ? layui.layer : top.layer,
                $ = layui.jquery,
                laydate = layui.laydate,
                laytpl = layui.laytpl,
                table = layui.table;
        table.render({
            elem: '#test'
            , url: '../role/queryRolelistPage'
            , toolbar: '#toolbarDemo'
            , cellMinWidth: 80
            , cols: [[
                {type: "checkbox", fixed: "left", width: '2.2%'}
                , {field: 'rolename', width: '20%', title: '角色名称', align: 'center'}
                , {field: 'remark', title: '角色描述', width: '50%', align: 'center'}
                , {fixed: 'right', width: '28%', align: 'center', toolbar: '#barDemo'}
            ]]
            , page: true
            , limit: 50
            ,limits: [10]
        });

        //监听行工具事件
        table.on('tool(test)', function (obj) {
            $ = layui.jquery;
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('您将删除角色 【' + data.rolename + '】 并清空其权限许可配置信息，确认提交？', function (index) {
                    var date = 'roleid=' + data.roleid + '';
                    basesubmit("../role/deleteByid", date);
                    layer.close(index);
                    window.location.reload();
                });
            } else if (obj.event === 'edit') {
                baseLayuiEdit(data,'编辑角色信息','320px','290px', 'role/RoleSet.jsp','form_Role','../role/updateById');
            } else if (obj.event === 'ass') {
                layui.use('layer', function () {
                    //独立版的layer无需执行这一句
                    var $ = layui.jquery,
                            layer = parent.layer === undefined ? layui.layer : top.layer;
                    sessionStorage.setItem('rid', data.roleid);
                    layer.open({
                        type: 2
                        , title: '  '
                        , area: ['500px', '500px']
                        , offset: ['130px', '500px']
                        , shade: 0
                        , content: 'role/modulea.jsp'
                        , btn: ['完成']
                        , scrollbar: false
                        , shade: 0.5
                        , success: function (layero, index) {
                            var s = layer.getChildFrame('body', index).find("#roleid");
                            s.val(data.id);
                        }
                        , yes: function (index, layero) {
                            layer.confirm('请先提交您的设置再关闭窗口，确认关闭？', function (index) {
                                layer.closeAll();
                            });
                        }
                        , cancel: function (index, layero) {
                            layer.confirm('请先提交您的设置再关闭窗口，确认关闭？', function (index) {
                                layer.closeAll();
                                layer.msg('您关闭了权限编辑窗口');
                            });
                            return false;
                        }
                    });
                });
            }
        });
    });


    function add() {
        baseLayuiInsert('增加角色','320px','290px', 'role/RoleSet.jsp','form_Role','../role/addRole','add');
    }

    function del() {
        layer.load();
        setTimeout(function () {
            layer.closeAll('loading');
        }, 2000);
    }
</script>

</body>
</html>
