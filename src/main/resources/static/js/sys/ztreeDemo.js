var rootPath;
var zTreeObj;
$(function(){
    rootPath=$('#absolutePath').val();
    initzTree();
});
//  初始化权限zTree
function initzTree(){
    var setting={
        check:{
            enable: true //每个节点上是否显示 CheckBox
        },
        data: {
            simpleData: {//简单数据模式
                enable:true,
            }
        }
    };
    $.ajax({
        url:'Module/queryModulezTree',
        dataType:'json',
        type:'post',
        async:false,
        success:function(data){
            zTreeObj=$.fn.zTree.init($('#authTree'),setting,data);
        }
    });
}