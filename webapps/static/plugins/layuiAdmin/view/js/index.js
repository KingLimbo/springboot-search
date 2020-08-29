$("#my").on('click',function(e) {
    //防止有链接跳转
    e.preventDefault();

    var $this = $(this);
    addIframe2($this);
});

function logout(){
    location.href="logout";
}
function addIframe2(cur){
    var $this = cur;
    var h = $this.attr("href"),
        m = $this.data("index"),
        label = $this.find("span").text(),
        isHas = false;
    if (h == "" || $.trim(h).length == 0) {
        return false;
    }

    var fullWidth = $(window).width();
    if(fullWidth >= 750){
        $(".layout-side").show();
    }else{
        $(".layout-side").hide();
    }
    if (!isHas) {
        var tab = "<a href='javascript:;' class='content-tab active' data-id='"+h+"'>"+ label +" <i class='icon-font'>&#xe617;</i></a>";
        $(".content-tab").removeClass("active");
        $(".tab-nav-content").append(tab);
        var iframe = "<iframe class='body-iframe' name='iframe"+ m +"' width='100%' height='99%' src='"+ h +"' frameborder='0' data-id='"+ h +"' seamless></iframe>";
        $(".layout-main-body").find("iframe.body-iframe").hide().parents(".layout-main-body").append(iframe);
        addTab($(".content-tab.active"));
    }
    return false;
}