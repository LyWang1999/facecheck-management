<%@ page language="java" pageEncoding="UTF-8" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>签到系统管理员端</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">
    <!-- 头部区域 -->
    <div class="layui-header">
        <div class="layui-logo">签到系统管理员端</div>
        <ul class="layui-nav layui-layout-left"></ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img" alt="头像">
                    <s:property value="#session.admin.name"/>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="admin.jsp">退出</a></li>
        </ul>
    </div>

    <!-- 左侧导航区域 -->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">教师信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="addTeacher.jsp" id="addTeacher">添加教师</a></dd>
                        <dd><a href="allTeachers.action" id="queryTeacher">教师信息查询</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">学生信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="addStudent.jsp" id="addStudent">添加学生</a></dd>
                        <dd><a href="allStudents.action" id="queryStudent">学生信息查询</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">签到信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="getAllSign.action" id="querySignPrimary">签到信息基础查询</a></dd>
                        <dd><a href="searchSignByDate.jsp" id="querySignDate">签到信息日期查询</a></dd>
                        <dd><a href="searchSignfuzzily.jsp" id="querySignFuzzy">签到信息模糊查询</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">反馈信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="getStuSuggest.action" id="stuFeedBack">学生反馈</a></dd>
                        <dd><a href="getTeaSuggest.action" id="teaFeedBack">教师反馈</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">礼品兑换管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="lookAllGift.action" id="queryAllGift">查看所有礼品</a></dd>
                        <dd><a href="uploadGift.jsp" id="addGift">添加礼品</a></dd>
                        <dd><a href="lookStudentGift.action" id="queryRequest">查看兑换请求</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

