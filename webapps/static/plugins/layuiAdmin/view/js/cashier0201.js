layui.use(['form', 'table'], function(){
    var form = layui.form //获取form模块
        , table = layui.table;

    var tableInfo = table.render({
        elem: '#cashier0201Table'
        ,url:'getCustomerInfo/'
        ,method: 'POST'
        ,where:{
            customerNo : ""
            ,phone : ""
        }
        ,cellMinWidth : 100
        ,cols: [[
            {field:'customerNo', title: 'NO.', sort: true}
            ,{field:'name', title: '用户名'}
            ,{field:'sex', title: '性别'}
            ,{field:'phone',title: '手机号码'}
            ,{field:'level', title: '会员级别'}
            ,{field:'balance', title: '余额', sort: true}
            , {fixed: 'right', title: '操作', align:'center', toolbar: '#cashier0201TableBar'}
        ]]
    });

    //监听行工具事件
    table.on('tool(cashier0201Table)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"

        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'del'){
            // iframe窗
            layer.open({
                type : 2,
                title : "会员充值",
                maxmin : true,
                area : ['800px', '600px'],
                content : $ctx + "/cashier0202/init?expenseType=0&customerNo=" + data.customerNo,
                end : function(){
                    //获取表单区域所有值
                    var data = form.val("cashier0201Form");
                    // 重新加载表格
                    tableReload(data);
                }
            });
        } else if(layEvent === 'add'){
            // iframe窗
            layer.open({
                type : 2,
                title : "会员消费",
                maxmin : true,
                area : ['800px', '600px'],
                content : $ctx + "/cashier0202/init?expenseType=1&customerNo=" + data.customerNo,
                end : function(){
                    //获取表单区域所有值
                    var data = form.val("cashier0201Form");
                    // 重新加载表格
                    tableReload(data);
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

    /**
     * 表格数据重新加载
     *
     * @param data
     */
    function tableReload(data) {
        // 重新加载表格数据，从第一页开始查询
        tableInfo.reload({
            // 设定异步数据接口的额外参数
            where: data.field
            , page: false
        });
    }
});