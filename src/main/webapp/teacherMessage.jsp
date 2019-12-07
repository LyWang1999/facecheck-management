<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        更新教师信息
    </div>
    <form class="layui-form" action="teaMessageUpdate.action" method="post">

        <div class="layui-form-item">
            <label class="layui-form-label">工号</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="teacher.teaID" lay-verify="number" value="<s:property value="#request.teacher.teaID"/>"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="teacher.name" lay-verify="required" value="<s:property value="#request.teacher.name"/>"
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
                <input type="text" name="teacher.password" lay-verify="required" value="<s:property value="#request.teacher.password"/>"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="teacher.phone" lay-verify="phone" value="<s:property value="#request.teacher.phone"/>"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo1">修改</button>
                <a class="layui-btn layui-btn-danger" href="teaMessageDelete.action?teaID=<s:property value="teaID"/>">删除</a>
            </div>
        </div>
    </form>
    <div class="layui-text" style="color: #cf6865;padding-left: 70px">
        <s:property value="#request.tip"/>
    </div>
</div>
<%--<script>--%>
<%--    //Demo--%>
<%--    layui.use('form', function () {--%>
<%--        var form = layui.form;--%>

<%--        //监听提交--%>
<%--        form.on('submit(formDemo)', function (data) {--%>
<%--            layer.msg(JSON.stringify(data.field));--%>
<%--            return false;--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<%@ include file="UIbottom.jsp" %>
</body>
</html>


