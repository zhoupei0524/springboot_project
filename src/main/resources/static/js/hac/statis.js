var rootPath
layui.use(['form','table','laypage','laydate'],function() {
    var form = layui.form,//获取form模块
        table = layui.table,//获取table模块
        laypage = layui.laypage,
        laydate = layui.laydate;
    rootPath = $('#absolutePath').val();
    initialize()

    laydate.render({
        elem: '#begin'//指定元素
    });
    laydate.render({
        elem: '#end'//指定元素
    });

    //绑定数据
    table.render({
        elem:'#tb',
        url:'../StatisType/view',
        page:true,
        limit:10,
        id:"sptypeTable",
        page: true, //开启分页
        cols:[[//标题栏
            {field: 'name', title: '商品类型', width: '50%', align: "center"},
            {field: 'y', title: '销售额', width: '50%', align: "center",sort: true,
                templet:function (value) {
                    var num =value.y;
                    num = num.toFixed(2); // 输出结果为 2.45
                    return num;
                }
            }
        ]]
    });

    //查询
    $("#search_btn").on("click", function () {
        //搜索 begin 开始日期     end 结束日期
        var begin=$("#begin").val();//登录名
        var end=$("#end").val();//性别
        query(begin,end);
        table.reload("sptypeTable", {
            method: 'post',
            where: {
                begin:begin,
                end: end
            }

        })
    });
});

function initialize(){
    var begin='';
    var end='';
    $.ajax({
        url:'../StatisType/queryStaType',
        data:{
            begin:begin,
            end:end
        },
        method:'post',
        dataType:'json',
        success:function(data){
            // console.log(data);
            Highcharts.chart('container', {
                chart: {
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false,
                    type: 'pie'
                },
                title: {
                    text: data.text
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: false
                        },
                        showInLegend: true
                    }
                },
                series: [{
                    name: 'Brands',
                    colorByPoint: true,
                    data:data.data[0]
                }]
            });
        }
    });
}

function query(begin,end){
    $.ajax({
        url:'../StatisType/queryStaType',
        data:{
            begin:begin,
            end:end
        },
        method:'post',
        dataType:'json',
        success:function(data){
            Highcharts.chart('container', {
                chart: {
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false,
                    type: 'pie'
                },
                title: {
                    text: data.text
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: false
                        },
                        showInLegend: true
                    }
                },
                series: [{
                    name: 'Brands',
                    colorByPoint: true,
                    data:data.data[0]
                }]
            });
        }
    });
}