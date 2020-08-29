layui.use(['form', 'table'], function(){
    var form = layui.form //获取form模块
        , table = layui.table;

    var tableInfo = table.render({
        elem: '#cashier0401TableInfo'
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
        ]]
    });

    var tableList = table.render({
        elem: '#cashier0401TableList'
        ,url:'queryList/'
        ,method: 'POST'
        ,where:{
            customerNo : ""
        }
        ,cellMinWidth : 100
        ,cols: [[
            {field:'customerNo', title: 'NO.'}
            ,{field:'expenseType', title: '交易类型'}
            ,{field:'originalPrice', title: '原价'}
            ,{field:'discountRate', title: '折扣率'}
            ,{field:'consumptionMoney', title: '开支金额'}
            ,{field:'balance', title: '账户余额', sort: true}
            ,{field:'updateDate', title: '交易时间', sort: true}
            ,{field:'remarks', title: '备注'}
        ]]
        ,page: false
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
        // 重新加载表格数据，从第一页开始查询
        tableList.reload({
            // 设定异步数据接口的额外参数
            where: data.field
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    }
});