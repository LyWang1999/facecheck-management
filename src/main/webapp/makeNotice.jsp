<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
       发送通知
    </div>
    <form class="layui-form" action="notice.action" method="post">
        <s:hidden value="%{#session.teacher.teaID}" name="notice.teaID"/>
        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="notice.title" required lay-verify="required" placeholder="请输入标题"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">通知内容</label>
            <div class="layui-input-block" style="width: 800px">
                <textarea name="notice.content" placeholder="请输入通知内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="submit">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    window.onload = function () {
        document.getElementById("sendMsg").className = "layui-this";
    }
</script>
<%@ include file="UIbottom.jsp" %>
</html>
