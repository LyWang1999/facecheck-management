<%@ page language="java" contentType="text/html; charset=GBK"
         pageEncoding="GBK" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <title>用户登录页面</title>

</head>

<form action="Teacherlogin" method="post">

    请输入用户名：<input name="teacher.teacherId" type="text"><BR>
    请输入密码：<input name="teacher.password" type="password">
    <input type="submit" value="教师登录">

</form>
<form action="Adminlogin" method="post">
    请输入用户名：<input name="admin.adminId" type="text"><BR>
    请输入密码：<input name="admin.password" type="password">
    <input type="submit" value="管理员登录">
</form>
</form>
<form action="AdminRegister" method="post">
    请输入用户名：<input name="admin.adminId" type="text"><BR>
    请输入密码：<input name="admin.password" type="password">
    <input type="submit" value="管理员注册">
</form>
</html>


