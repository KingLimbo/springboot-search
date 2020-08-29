layui.use('form', function(){
    var form = layui.form
        ,layer = layui.layer;

    //监听提交
    form.on('submit(save)', function(data){

        layer.confirm('是否确认保存？', function(index){
            //向服务端发送保存指令
            $.ajax({
                url : $ctx + "/changePass",
                type : "POST",
                data : data.field,
                async : false,
                dataType : "json",
                success : function(result) {
                    // 弹出提示消息
                    layer.msg(result.message);
                }
            });
            layer.close(index);
        });
        return false;
    });
    form.verify({
        pass: [
        /^[\S]{6,12}$/
        ,'密码必须6到12位，且不能出现空格'
    ]
});
});