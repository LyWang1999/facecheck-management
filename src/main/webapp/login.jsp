<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>基于人脸识别的高校签到系统</title>
    <link href='layui/css/BiaoKuang.css' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="layui/css/normalize.min.css">
    <link rel="stylesheet" href="layui/css/style.css">
</head>

<body>

<div class="form">

    <ul class="tab-group">
        <li class="tab active"><a href="login.jsp">教师登录</a></li>
        <li class="tab"><a href="admin.jsp">管理员登录</a></li>
    </ul>

    <div class="tab-content">
        <div id="teacher">
            <h1>教师登录</h1>
            <form action="teacherLogin.action" method="post">
                <div class="field-wrap">
                    <input class="layui-input" type="text" name="teacher.teaID" required autocomplete="off" placeholder="请输入账号" lay-verify="required"/>
                </div>
                <div class="field-wrap">
                    <input class="layui-input" type="password" name="teacher.password" required autocomplete="off" placeholder="请输入密码" lay-verify="required"/>
                </div>
                <button type="submit" class="button button-block">登录</button>
            </form>
        </div>

        <div id="admin">
            <h1>管理员登录</h1>
            <form action="adminLogin.action" method="post">
                <div class="field-wrap">
                    <input class="layui-input" type="text" name="admin.adminID" required autocomplete="off" placeholder="请输入账号" lay-verify="required"/>
                </div>
                <div class="field-wrap">
                    <input class="layui-input" type="password" name="admin.password" required autocomplete="off" placeholder="请输入密码" lay-verify="required"/>
                </div>
                <button type="submit" class="button button-block">登录</button>
            </form>
        </div>
    </div>
</div>
<script src="layui/layui.all.js"></script>
<script>
    ;!function(){
        //无需再执行layui.use()方法加载模块，直接使用即可
        var form = layui.form
            ,layer = layui.layer;
    }();
</script>
</body>
</html>
