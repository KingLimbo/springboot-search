layui.use(['form'], function(){
    var form = layui.form
        ,layer = layui.layer;

    //监听提交
    form.on('submit(save)', function(data){

        layer.confirm('是否确认保存？', function(index){
            //向服务端发送保存指令
            $.ajax({
                url : $ctx + "/cashier0202/save/",
                type : "POST",
                data : data.field,
                async : false,
                dataType : "json",
                success : function(result) {
                    // 弹出提示消息
                    parent.layer.msg(result.message);
                    if (result.resultFlg === RESULT_SUCCESS) {
                        //当你在iframe页面关闭自身时
                        //先得到当前iframe层的索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //再执行关闭
                        parent.layer.close(index);
                    }
                }
            });
            layer.close(index);
        });
        return false;
    });
    form.verify({
        custmerNo: [
            /^[1-9]\d{0,19}$/
            ,'会员卡号必须是大于0的正整数'
        ]
        , originalPrice: [
            /^[1-9]\d{0,7}$/
            ,'原价金额必须是大于0的正整数'
        ]
    });
    initPage(form);
});

/**
 * 初始化内容
 */
function initPage (form){
    if ($("#expenseType").data("value") == "1") {
        $("#discountRate").attr("disabled", true);
    }
    var dataJson = {};
    // 循环下拉列表赋值
    $("select").each(function () {
        var value = $(this).data("value");
        if (value != undefined && value !== "") {
            dataJson[$(this).attr("name")] = value;
        }
    })
    //给表单赋值
    form.val("cashier0202Form", dataJson);
}