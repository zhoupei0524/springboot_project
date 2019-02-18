var rootPath
layui.use(['form','table','laypage','laydate'],function() {
    var form = layui.form,//获取form模块
        table = layui.table,//获取table模块
        laypage = layui.laypage,
        laydate = layui.laydate;
    rootPath = $('#absolutePath').val();
    initialize();

    //绑定数据
    table.render({
        elem:'#tb',
        url:'../Order/queryOrdersType?date=2018',
        page:true,
        limit:10,
        id:"sptypeTable",
        page: true, //开启分页
        cols:[[//标题栏
            {field: 'month', title: '月份', width: '40%', align: "center",
                templet:function(d){
                    return d.month+"月";
                }
            },
            {field: 'stati', title: '销售额', width: '40%', align: "center",sort: true,
                templet:function (value) {
                    var num =value.stati;
                    num = num.toFixed(2); // 输出结果为 2.45
                    return num;
                }
            }
        ]]
    });

    //查询
    $("#search_btn").on("click", function () {
        //搜索  date 年份
        var date=$("#date").val();//年份
        query(date);
        console.log(date);
        table.reload("sptypeTable", {
            url:'../Order/queryOrdersType',
            method: 'post',
            where: {
                date:date
            }
        })
    });
});

function initialize(){
    var date="2018"
    $.ajax({
        url:'../Order/queryOrdType',
        data:{
            ss:date
        },
        method:'post',
        dataType:'json',
        success:function(data){
            console.log("data.data")
            console.log(data.data)
            var chart = Highcharts.chart('container', {
                title: {
                    text: data.text
                },
                subtitle: {
                    text: '数据来源：MySqldatabase .com'
                },
                yAxis: {
                    title: {
                        text: '销售额'
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                },
                plotOptions: {
                    series: {
                        label: {
                            connectorAllowed: false
                        },
                        pointStart: 1
                    }
                },
                series:data.data,
                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }
            });
        }
    });

}

function query(date){
    $.ajax({
        url:'../Order/queryOrdType',
        data:{
            ss:date
        },
        method:'post',
        dataType:'json',
        success:function(data){
            var chart = Highcharts.chart('container', {
                title: {
                    text: data.text
                },
                subtitle: {
                    text: '数据来源：MySqldatabase .com'
                },
                yAxis: {
                    title: {
                        text: '销售额'
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                },
                plotOptions: {
                    series: {
                        label: {
                            connectorAllowed: false
                        },
                        pointStart: 1
                    }
                },
                series:data.data,
                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }
            });
        }
    });
}