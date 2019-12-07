s:hidden=""s:property=""
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Shen Kai
  Date: 2018/12/28
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../layui/css/layui.css">
<html>
<head>
    <title>教师通知</title>
</head>
<body>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">

    </div>
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        教师反馈
    </div>
    <form action="makeAnn" method="post">
        <s:hidden property ="announcement.teacher" value="#session.teacher" ></s:hidden>
        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.stuID" required lay-verify="required" placeholder="请输入标题"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <textarea name="announcement.describe" placeholder="请输入通知内容" class="layui-textarea" ></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block">
                <input type="date" name="announcement.date">
            </div>
        </div>

        <div class="layui-form-item">
            <button class="layui-btn" type="submit">提交</button>
        </div>
    </form>
</div>
</body>
</html>
