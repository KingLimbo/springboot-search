layui.use(['form', 'table'], function () {
    var layer = layui.layer
        , form = layui.form //获取form模块
        , table = layui.table;
    // 表格初始化
    var tableIns = table.render({
        elem: '#cashier0101Table'
        , url: 'queryList/'
        , method: 'POST'
        , where: {
        }
        ,cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            {field: 'no', title: 'NO.', sort: true}
            , {field: 'name', title: '用户名'}
            , {field: 'sex', title: '性别'}
            , {field: 'phone', title: '手机号码'}
            , {field: 'level', title: '会员级别'}
            , {field: 'discountRate', title: '折扣率', align:'right'}
            , {field: 'balance', title: '余额', align:'right', sort: true}
            , {fixed: 'right', title: '操作', align:'center', toolbar: '#cashier0101TableBar', width: '200'}
        ]]
        , page: true
    });

    //监听行工具事件
    table.on('tool(cashier0101Table)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"

        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            // iframe窗
            layer.open({
                type : 2,
                title : "查询会员信息",
                maxmin : true,
                area : ['800px', '600px'],
                content : $ctx + "/cashier0102/init?pageMode=" + PAGE_MODE_DETAIL + '&no=' + data.no,
                end : function(){
                }
            });
        } else if(layEvent === 'del'){
            layer.confirm('真的注销会员么', function(index){
                //向服务端发送删除指令
                $.ajax({
                    url : $ctx + "/cashier0101/delete/" + data.no,
                    type : "POST",
                    async : false,
                    dataType : "json",
                    success : function(result) {
                        if (result.resultFlg === RESULT_SUCCESS) {
                            obj.del(); //删除对应行（tr）的DOM结构
                        }
                        // 弹出提示消息
                        layer.msg(result.message);
                    }
                });
                layer.close(index);
            });
        } else if(layEvent === 'edit'){
            // iframe窗
            layer.open({
                type : 2,
                title : "修改会员信息",
                maxmin : true,
                area : ['800px', '600px'],
                content : $ctx + "/cashier0102/init?pageMode=" + PAGE_MODE_MODIFY + '&no=' + data.no,
                end : function(){
                    // 重新加载表格数据
                    tableIns.reload();
                }
            });
        }
    });

    // 定义表单验证规则
    form.verify({
        phoneNotReq: function(value, item){ //value：表单的值、item：表单的DOM对象
            if (value && /^1\d{10}$/.test(value)) {
                return "请输入正确的手机号";
            }
        }
    });

    // 查询处理
    form.on('submit(search)', function (data) {
        // 重新加载表格
        tableReload(data);
        //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        return false;
    });

    // 点击新增，打开新增会员页面
    $("#addBtn").click(function () {
        // 按钮禁用
        $("#addBtn").attr("disabled", "disabled");
        // iframe窗
        layer.open({
            type : 2,
            title : "新增会员",
            maxmin : true,
            area : ['800px', '600px'],
            content : $ctx + "/cashier0102/init?pageMode" + PAGE_MODE_ADD,
            end : function(){
                // 按钮解除禁用
                $("#addBtn").removeAttr("disabled");
            }
        });
    });

    function tableReload(data) {
        // 重新加载表格数据，从第一页开始查询
        tableIns.reload({
            // 设定异步数据接口的额外参数
            where: data.field
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    }
});