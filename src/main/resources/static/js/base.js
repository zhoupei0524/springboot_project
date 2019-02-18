/*
basesubmit统一增删改ajax
url:路径 datas:参数
*/
function basesubmit(url, datas) {
    console.log(datas)
    $.ajax({
        type: "post",
        dataType: "json",
        url: url,
        data: datas,
        success: function (data) {
            top.layer.msg(data.msg);
            var str = data.msg;
            var reg = RegExp(/失败/);
            if (reg.test(str)) {
                return false;
            }
        },
        error: function (msg) {
            //layer.msg('网络出现异常，请检查您的网络');
        }
    });
}

/*
basesubmits统一增删改ajax
url:路径 datas:参数 i:layui.oper弹出标识符
*/
function basesubmits(url, datas, i) {
    $.ajax({
        type: "post",
        dataType: "json",
        url: url,
        data: datas,
        success: function (data) {
            top.layer.msg(data.msg);
            var str = data.msg;
            var reg = RegExp(/失败/);
            if (reg.test(str)) {
                return false;
            } else {
                parent.layer.close(i); //再执行关闭，强制关闭弹窗
            }
        },
        error: function (msg) {
            //layer.msg('网络出现异常，请检查您的网络');
        }
    });
}

/*
baseLayuiInsert 统一layui增加
title:标题; width:宽度; height:高度; content:打开的页面; froms:提交的form表单id值; url:提交的路径;
*/
function baseLayuiInsert(title, width, height, content, froms, url) {
    layui.use('layer', function () {
        var $ = layui.jquery,
            layer = parent.layer === undefined ? layui.layer : top.layer;
        layer.open({
            type: 2,
            title: title,
            area: [width, height],
            shade: 0,
            content: content,
            btn: ['提交', '取消'],
            scrollbar: false,
            shade: 0.5,
            yes: function (index, layero) {
                var from = layer.getChildFrame('body', index).find("#" + froms);
                basesubmits(url, $(from).serialize(), index);
            },
            btn2: function (index) {
                layer.closeAll(index);
                layer.msg('您取消了录入');
            },
            cancel: function (index, layero) {
                layer.closeAll(index);
                layer.msg('您取消了录入');
            },
            end: function () {
                window.location.reload();
            }
        });
    });
}

/*
baseLayuiEdit 统一layui编辑
data:点击行的数据;title:标题; width:宽度; height:高度; content:打开的页面; froms:提交的form表单id值; url:提交的路径;
*/
function baseLayuiEdit(data,title, width, height, content, froms, url) {
    layui.use('layer', function () {
        var $ = layui.jquery,
            layer = parent.layer === undefined ? layui.layer : top.layer;
        layer.open({
            type: 2,
            title: title,
            area: [width, height],
            shade: 0,
            content: content,
            btn: ['提交', '取消'],
            scrollbar: false,
            shade: 0.5,
            success: function (layero, index) {
                var from = layer.getChildFrame('body', index).find("#"+froms);
                $.each(data, function (i, val) {
                    from.find("#" + i).val(val);
                })
            },
            yes: function (index, layero) {
                var from = layer.getChildFrame('body', index).find("#" + froms);
                basesubmits(url, $(from).serialize(), index);
            },
            btn2: function (index) {
                layer.closeAll(index);
                layer.msg('您取消了编辑');
            },
            cancel: function (index, layero) {
                layer.closeAll(index);
                layer.msg('您取消了编辑');
            },
            end: function () {
                window.location.reload();
            }
        });
    });
}

/*
baseSelect下拉框统一ajax
url:路径;id：需要追加的下拉框id值
注：默认后台传输数据格式为 id name
*/
function baseSelect(url, id) {
    layui.use(['form'], function () {
        var form = layui.form,
            $ = layui.jquery;
        $.ajax({
            url: url,
            dataType: 'json',
            success: function (data) {
                var html = '';
                $.each(data, function (index, elem) {
                    html += '<option value=' + elem.id + '>' + elem.name + '</option>'
                });
                $("#" + id).append(html);
                form.render('select');
            }
        });
    })
}

/*
baseSelectto 编辑下拉框绑定原来的数据
url:路径;id：需要追加的下拉框id值;ids:原有值
注：默认后台传输数据格式为 id name
*/
function baseSelectto(url, id, ids) {
    layui.use(['form'], function () {
        var form = layui.form,
            $ = layui.jquery;
        $.ajax({
            url: url,
            dataType: 'json',
            success: function (data) {
                var html = '';
                $.each(data, function (index, elem) {
                    html += '<option value=' + elem.id + '>' + elem.name + '</option>'
                });
                $("#" + id).append(html);
                form.render('select');
                $.each(data, function (index, elem) {
                    if (elem.id == ids) {//如果参数 需要选择的值ids等于遍历的id 追加selected
                        $("#" + id).find("option[value=" + elem.id + "]").attr('selected', 'true');
                        form.render('select');
                    }
                });
            }
        });
    })
}

function formatterDate(date) {
    var oDate = new Date(date), oYear = oDate.getFullYear(), oMonth = oDate
        .getMonth() + 1, oDay = oDate.getDate(), oHour = oDate.getHours(), oMin = oDate
        .getMinutes(), oSen = oDate.getSeconds(), oTime = oYear + '-'
        + getzf(oMonth) + '-' + getzf(oDay) + ' ' + getzf(oHour) + ':'
        + getzf(oMin) + ':' + getzf(oSen);// 最后拼接时间
    return oTime;
};

// 补0操作
function getzf(num) {
    if (parseInt(num) < 10) {
        num = '0' + num;
    }
    return num;
}