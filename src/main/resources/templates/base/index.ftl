<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="keywords" content="scclui框架">
    <meta name="description" content="scclui为轻量级的网站后台管理系统模版。">
    <title>首页</title>
    <#assign ctx=request.contextPath />
    <link rel="stylesheet" href="${ctx}/plugins/layuiAdmin/css/sccl.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/layuiAdmin/skin/qingxin/skin.css" id="layout-skin"/>
    <script>
        var $ctx = '${request.contextPath}';
    </script>
</head>
<body>
<div class="layout-admin">
    <header class="layout-header">
        <span class="header-logo">系统框架</span>
        <a class="header-menu-btn" href="javascript:;"><i class="icon-font">&#xe600;</i></a>
        <ul class="header-bar">
            <li class="header-bar-role"><a href="javascript:;">${(user.role.name)!!}</a></li>
            <li class="header-bar-nav">
                <a href="javascript:;">admin<i class="icon-font" style="margin-left:5px;">&#xe60c;</i></a>
                <ul class="header-dropdown-menu">
                    <#--<li><a id="my" href="Personal_information.jsp"><span>个人信息</span></a></li>-->
                    <#--<li><a href="${ctx}/changePass">修改密码</a></li>-->
                    <li><a href="javascript:logout();">退出</a></li>
                </ul>
            </li>
            <li class="header-bar-nav">
                <a href="javascript:;" title="换肤"><i class="icon-font">&#xe608;</i></a>
                <ul class="header-dropdown-menu right dropdown-skin">
                    <li><a href="javascript:;" data-val="qingxin" title="清新">清新</a></li>
                    <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                    <li><a href="javascript:;" data-val="molv" title="墨绿">墨绿</a></li>

                </ul>
            </li>
        </ul>
    </header>
    <aside class="layout-side">
        <ul class="side-menu">
            <li class="menu-header menu-item">主菜单</li>
            <li class="menu-item active">
                <a href="">
                    <i class="icon-font"></i>
                    <span>基础查询服务</span>
                    <i class="icon-font icon-right"></i>
                </a>
                <ul class="menu-item-child menu-open" id="menu-child-3" style="display: block;">
                    <li>
                        <a href="${ctx}/search/sh0201/init">
                            <i class="icon-font"></i>
                            <span>单表查询服务</span>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="menu-item">
                <a href="">
                    <i class="icon-font "></i>
                    <span>后台服务</span>
                    <i class="icon-font icon-right"></i>
                </a>
                <ul class="menu-item-child" id="menu-child-6" style="display: none;">
                    <li>
                        <a href="${ctx}/changePass">
                            <i class="icon-font"></i>
                            <span>修改密码</span>
                        </a>
                    </li>
                </ul>
            </li>

        </ul>


    </aside>

    <div class="layout-side-arrow">
        <div class="layout-side-arrow-icon"><i class="icon-font">&#xe60d;</i></div>
    </div>

    <section class="layout-main">
        <div class="layout-main-tab">
            <button class="tab-btn btn-left"><i class="icon-font">&#xe60e;</i></button>
            <nav class="tab-nav">
                <div class="tab-nav-content">
                    <a href="javascript:;" class="content-tab active" data-id="index_web.jsp">首页</a>
                </div>
            </nav>
            <button class="tab-btn btn-right"><i class="icon-font">&#xe60f;</i></button>
        </div>
        <div class="layout-main-body">
            <iframe class="body-iframe" name="iframe0" width="100%" height="99%" src="${ctx}/search/sh0201/init" frameborder="0"
                    data-id="index_web.jsp" seamless></iframe>
        </div>
    </section>
    <div class="layout-footer">@2019 11.15 www.limbo.net</div>
</div>
<script type="text/javascript" src="${ctx}/plugins/layuiAdmin/lib/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${ctx}/plugins/layuiAdmin/js/sccl.js"></script>
<script type="text/javascript" src="${ctx}/plugins/layuiAdmin/js/sccl-util.js"></script>
<script type="text/javascript" src="${ctx}/plugins/layuiAdmin/view/js/index.js"></script>
</body>
</html>