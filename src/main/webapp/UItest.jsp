<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/9
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        更新教师信息
    </div>
    <form class="layui-form" action="teaMessageUpdate">

        <div class="layui-form-item">
            <label class="layui-form-label">工号</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="teacher.teaID" required lay-verify="required" value="<s:property value="#request.teacher.teaID"/>"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="teacher.name" required lay-verify="required" value="<s:property value="#request.teacher.name"/>"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <s:if test="%{#request.teacher.sex==1}">
                    <input type="radio" name="teacher.sex" value="1" title="男" checked>
                    <input type="radio" name="teacher.sex" value="0" title="女" >
                </s:if>
                <s:else>
                    <input type="radio" name="teacher.sex" value="1" title="男">
                    <input type="radio" name="teacher.sex" value="0" title="女" checked>
                </s:else>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="teacher.password" required lay-verify="required" value="<s:property value="#request.teacher.password"/>"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="teacher.phone" required lay-verify="required" value="<s:property value="#request.teacher.phone"/>"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

</div>
<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</div>
<%@ include file="UIbottom.jsp" %>
</body>
</html>
