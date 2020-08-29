layui.use(['form'], function(){
    var form = layui.form
        ,layer = layui.layer;

    //监听提交
    form.on('submit(save)', function(data){

        layer.confirm('是否确认保存？', function(index){
            //向服务端发送保存指令
            $.ajax({
                url : $ctx + "/cashier0102/save/",
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
        , custmerName: function(value, item){ //value：表单的值、item：表单的DOM对象
            if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                return '用户名不能有特殊字符';
            }
            if(/(^\_)|(\__)|(\_+$)/.test(value)){
                return '用户名首尾不能出现下划线\'_\'';
            }
            if(/^\d+\d+\d$/.test(value)){
                return '用户名不能全为数字';
            }
        }
    });
    initPage(form);
});

/**
 * 初始化内容
 */
function initPage (form){
    if ($("#pageMode").val() == PAGE_MODE_DETAIL) {
        $("input").attr("disabled", true);
        $("button").attr("disabled", true);
        $("select").attr("disabled", true);
        $("textarea").attr("disabled", true);
        $("#saveBtn").hide();
    } else if ($("#pageMode").val() == PAGE_MODE_MODIFY) {
        $("#no").attr("disabled", true);
    }
    var dataJson = {};
    // 循环下拉列表赋值
    $("select").each(function () {
        var value = $(this).data("value");
        if (value != undefined && value !== "") {
            dataJson[$(this).attr("name")] = value;
            // $(this).val(value);
        }
    })
    //给表单赋值
    form.val("cashier0102Form", dataJson);
}