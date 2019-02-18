var $ = layui.jquery;
var element = layui.element;
var form = layui.form;
var layer = layui.layer;
var html = '';


//获取菜单
//style="padding-top: 10px;" 距离顶部
$.ajax({
    url: "Module/queryModuleList",
    type: "post",
    dataType: "json",
    data: {},
    success: function (data) {
        var navs = data.result;
        html += '<ul class="layui-nav layui-nav-tree"  lay-filter="test">';
        $.each(data, function (i, item) {
            html += '<li class="layui-nav-item" >';
            html += '<a href="javascript:;"  class="'+ item.icon + '">&nbsp;&nbsp;<cite>' + item.text + '</cite></a>';
            //如果有第二级菜单
            if (item.children !== undefined && item.children.length > 0) {
                html += '<dl  class="layui-nav-child">';
                $.each(item.children, function (j, item2) {
                    html += '<dd><a  href="javascript:;" data-url="' + item2.url + '" class="' + item2.icon + '" data-id="' + item2.id + '" data-title="' + item2.text + '" class="site-demo-active" data-type="tabAdd">&nbsp;&nbsp;<cite>' + item2.text + '</cite></a></dd>';
                });
                html += '</dl>';
            }
            html += '</li>';
        });
        html += '</ul>';
        $("#admin-navbar-side").append(html);
        //渲染html
        layui.use('element', function () {
            var element = layui.element;
            element.init();
        });
    }
});
var active = {
    //在这里给active绑定几项事件，后面可通过active调用这些事件
    tabAdd: function (url, id, name,icon) {
        //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
        //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
        element.tabAdd('demo', {
            title: name,
            content: '<iframe class="'+icon+'" data-frameid="' + id + '" scrolling="auto" frameborder="0" src="' + url + '" lay-allowclose="true" style="width:100%;height:100%;"></iframe>',
            id: id //规定好的id
        })
        FrameWH();//计算ifram的大小
    },
    tabChange: function (id) {
        //切换到指定Tab项
        element.tabChange('demo', id);
    },
    tabDelete: function (id) {
        element.tabDelete("demo", id);//删除
    }
};

function FrameWH() {
    var h = $(window).height();//获取当前window的高度
    $("iframe").css("height", h + "px");
}

$(document).on('click', 'a', function () {
    if (!$(this)[0].hasAttribute('data-url') || $(this).attr('data-url') === '') return;
    var dataid = $(this);
    //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
    if ($(".layui-tab-title li[lay-id]").length <= 0) {
        //如果比零小，则直接打开新的tab项
        active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"),dataid.attr("class"));
    } else {
        //否则判断该tab项是否以及存在
        var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
        $.each($(".layui-tab-title li[lay-id]"), function () {
            //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
            if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                isData = true;
            }
        })
        if (isData == false) {
            //标志为false 新增一个tab项
            active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"),dataid.attr("class"));
        }
    }
    //最后不管是否新增tab，最后都转到要打开的选项页面上
    active.tabChange(dataid.attr("data-id"));
});





		