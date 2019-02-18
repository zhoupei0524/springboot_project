<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/js/base.js"></script>
    <script type="text/javascript" src="../static/js/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/layui/lay/modules/form.js"></script>
    <script type="text/javascript" src="../static/js/hac/highcharts.js"></script>
    <script type="text/javascript" src="../static/js/hac/exporting.js"></script>
    <script type="text/javascript" src="../static/js/hac/series-label.js"></script>
    <script type="text/javascript" src="../static/js/hac/oldie.js"></script>
    <script type="text/javascript" src="../static/js/hac/highcharts-zh_CN.js"></script>
    <script type="text/javascript" src="../static/js/hac/statis.js"></script>
</head>
<body>
<form class="layui-form" id="ff">
    <blockquote class="layui-elem-quote quoteBox">
        <div class="layui-inline">
            <div class="layui-inline">
                <label class="layui-form-label" >日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="begin" id="begin"  lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input date">
                </div> -
                <div class="layui-input-inline">
                    <input type="text" name="end" id="end" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input date">
                </div>
            </div>
            <a class="layui-btn layui-icon " id="search_btn"
               data-type="reload">&nbsp;查询</a>
        </div>
    </blockquote>
    <div style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card" style="height: 600px;">
                    <div class="layui-card-header">数据表格</div>
                    <div class="layui-card-body">
                        <table id="tb" lay-filter="sptypeTable" style="width: 100%;height: 100%;">
                        </table>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6">
                <div class="layui-card" style="height: 500px;">
                    <div class="layui-card-header">统计图</div>
                    <div class="layui-card-body">
                        <div id="container" style="height: 78%"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>