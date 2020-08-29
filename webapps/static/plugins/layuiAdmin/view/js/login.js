layui.use(['layer', 'form'], function () {
    var layer = layui.layer,
        $ = layui.jquery,
        form = layui.form

    form.verify({
        loginAccount: function (value) {
            if (value === '')
                return '请输入用户名';
        },
        loginPass: function (value) {
            if (value === '')
                return '请输入密码';
        }
    });

    var errorCount = 0;


    form.on('click(dome)', function (data) {
        // return false;
        layer.msg(JSON.stringgify(data.field));
        console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
        console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    form.on('submit(login)', function (data) {
        // layer.msg(JSON.stringify(data.field));
        $("#loginForm").submit();
    });


});

$(function() {
    // 如果存在提示消息，则弹出提示消息
    if ($("#msg").val()) {
        layer.msg("账号或密码错误！");
    }
});