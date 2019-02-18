<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="static/images/erp.ico">
    <link rel="stylesheet" href="static/js/layui/css/layui.css">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/base.js"></script>
    <script type="text/javascript" src="static/js/layui/layui.all.js"></script>
    <script type="text/javascript" src="static/js/index.js"></script>
    <link rel="stylesheet" href="static/css/index.css">
</head>
<body class="main_body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header">
        <div class="logo">CRM管理系统</div>
        <!-- 显示/隐藏菜单 -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item" id="shrink-nav">
                <a href="javascript:;" title="侧边伸缩" class="seraph hideMenu icon-caidan">
                    <i class="layui-icon layui-icon-shrink-right"></i>
                </a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;" class="clearCache">
                    <i class="layui-icon" data-icon="&#xe640;">&#xe640;</i>
                    <cite>清除缓存</cite>
                    <span class="layui-badge-dot"></span>
                </a>
            </li>
            <li class="layui-nav-item" id="userInfo">
                <a href="javascript:;">
                    <img src="static/images/admin.png" class="layui-nav-img userAvatar" width="35" height="35">
                    <cite class="adminName">
                        管理员
                    </cite>
                </a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="javascript:;" data-id="grzl" data-title="个人资料" data-url="base/userInfo.shtml">
                            <i class="seraph icon-ziliao" data-icon="icon-ziliao"></i>
                            <cite>个人资料</cite>
                        </a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-id="xgmm" data-title="修改密码" data-url="base/changePwd.shtml">
                            <i class="seraph icon-xiugai" data-icon="icon-xiugai"></i>
                            <cite>修改密码</cite>
                        </a>
                    </dd>
                    <dd>
                        <a href="" class="signOut">
                            <i class="seraph icon-tuichu"></i>
                            <cite>退出</cite>
                        </a>
                    </dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-green">
        <div class="user-photo">
            <a class="img" title="我的头像"><img src="static/images/admin.png" class="userAvatar"></a>
            <p>你好！<span class="userName">管理员</span>, 欢迎登录</p>
        </div>
        <div class="layui-side-scroll" id="admin-navbar-side" style="">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->

        </div>
    </div>

    <div class="layui-body layui-form">
        <!-- 内容主体区域 -->
        <div class="layui-tab mag0" lay-filter="demo" lay-allowclose="true">
            <ul class="layui-tab-title top_tab">
                <li class="layui-nav-item layui-this layui-icon" class="site-demo-active" lay-id="">
                    <i class="layui-this layui-icon site-demo-active">&#xe68e;</i>
                    <cite>后台首页</cite>
                </li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <iframe scrolling="auto" frameborder="0" src="tomain" lay-allowclose="false"
                            style="width:100%;height:100%;">
                    </iframe>
                    <script>
                        var h = $(window).height();//获取当前window的高度
                        $("iframe").css("height", h + "px");
                    </script>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 2018 Super god All Rights Reserved
    </div>

</div>
<script>
    //隐藏左侧导航
    $(".hideMenu").click(function () {
        $(".layui-layout-admin").toggleClass("showMenu");
    })

    layui.use(['layer'], function () {
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        //清除缓存
        $(".clearCache").click(function () {
            window.sessionStorage.clear();
            window.localStorage.clear();
            var index = layer.msg('清除缓存中，请稍候', {icon: 16, time: false, shade: 0.8});
            setTimeout(function () {
                layer.close(index);
                layer.msg("缓存清除成功！");
            }, 1000);
        })
    })
    baseSelect()
</script>
</body>
</html>