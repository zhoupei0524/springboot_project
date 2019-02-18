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
    <script type="text/javascript" src="../static/js/hac/tendency.js"></script>
</head>
<body class="layui-layout-body">
<form class="layui-form" id="ff">
    <div style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">数据表格</div>
                    <div class="layui-card-body">

                        <blockquote class="layui-elem-quote quoteBox">
                            <div class="layui-inline">
                                <div class="layui-inline">
                                    <label class="layui-form-label" >年份</label>
                                    <div class="layui-input-inline">
                                        <select id="date" name="date" lay-verify="required" lay-search="">
                                            <option value="">请选择</option>
                                            <option value="2019">2019</option>
                                            <option value="2018">2018</option>
                                            <option value="2017">2017</option>
                                            <option value="2016">2016</option>
                                            <option value="2015">2015</option>
                                        </select>
                                    </div>
                                </div>
                                <a class="layui-btn layui-icon " id="search_btn"
                                   data-type="reload">&nbsp;查询</a>
                            </div>
                        </blockquote>

                        <table id="tb" lay-filter="sptypeTable" style="width: 100%;height: 100%;">
                        </table>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">趋势图</div>
                    <div class="layui-card-body">
                        <div id="container" style="height:65%"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>