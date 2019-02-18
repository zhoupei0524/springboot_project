var rootPath = '';
layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery

    $("#a_addgoodstype").click(function () {
        var name = $("#name").val();
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        //parent.layer.close(index); //再执行关闭，强制关闭弹窗
        basesubmits("../Goodstype/updateGoodstype", $('#from_addgoodstype').serialize(),index);
        //关闭自身

    })
});
function add() {
}