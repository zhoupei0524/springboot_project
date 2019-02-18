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
    <script type="text/javascript" src="../static/js/zTree/jquery.ztree.all.min.js"></script>
    <script type="text/javascript" src="../static/js/layer/layer.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/js/layer/theme/default/layer.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>角色权限配置</legend>
</fieldset>
<a class="layui-btn layui-btn-radius layui-btn-primary" onclick="flsh();"><i class="layui-icon layui-icon-refresh-3" >刷新</i></a>
<a class="layui-btn layui-btn-radius layui-btn-primary" onclick="doAssign();"><i class="layui-icon layui-icon-file-b" >分配</i></a>
<div data-options="region:'center'" style="width: 100%" >
    <br/><br/>
    <div style="width: 300px; margin: 0 auto;"><ul id="treeid" class="ztree"></ul></div>
</div>

<script>
    $(function () {
        rid = sessionStorage.getItem('rid');
        set();
        //动态绑定方法
        function set() {
            //许可分配
            setting = {
                check: {
                    enable: true
                },
                async: {
                    enable: true,
                    url:"../Module/queryModulezTree?roleid="+rid
                },
                view: {
                    selectedMulti: false,
                    //改变图标
                    addDiyDom: function(treeId, treeNode){
                        var icoObj = $("#" + treeNode.tId + "_ico");
                        var s = "";
                        if ( treeNode.level == 0 ) {
                            //根节点
                            s = '<i class="layui-icon layui-icon-layouts" style="color: black;">&nbsp;</i>';
                        } else if ( treeNode.level == 1 ) {
                            s = '<i class="layui-icon layui-icon-file"    style="color:black;">&nbsp;</i>';
                        } else if ( treeNode.level == 2 ) {
                            s = '<i class="layui-icon layui-icon-auz"     style="color:black;">&nbsp;</i>';
                        }
                        icoObj.after(s);
                        icoObj.remove();
                    }
                }
            }
            // 异步获取树形结构数据
            $.fn.zTree.init($("#treeid"), setting);
        }
    });
    //提交
    function doAssign() {
        //获取ztree对象
        var obj = $.fn.zTree.getZTreeObj("treeid");
        //取到其中选中的所有id（它返回的是一个id数组）
        var nodes = obj.getCheckedNodes();
        if( nodes.length == 0 ){
            layer.msg("请至少选择一项权限",{time:2000,icon:5,shift:1},function(){});
        }else{
            console.log(rid)
            var d = "rid=" + rid;
            $.each(nodes , function( i,node) {
                d += "&mids="+node.id
            })
            layer.msg('玩命提交中', {
                icon: 16 ,shade: 0.6
            });
            //用AJAX来提交
            $.ajax({
                type : "post",
                url  : "../Module/Roleassign",
                data : d,
                success : function(result) {
                    layer.closeAll();
                    console.log(result);
                    if (result.success==null) {
                        layer.msg("权限分配成功", {time:2000, icon:1, shift:2}, function(){});
                        $.fn.zTree.init($("#treeid"), setting);
                    } else {
                        layer.msg("权限分配失败", {time:2000, icon:5, shift:6}, function(){});
                    }
                }
            });
        }
    }

    //刷新
    function flsh() {
        location.reload();
    }




</script>
</body>
</html>