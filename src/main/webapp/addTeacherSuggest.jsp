<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        感谢您的反馈！
    </div>
    <div  style="margin-left: -70px;width: 800px">
        <form class="layui-form" action="teaSuggestInsert.action" method="post">
            <s:hidden value="%{#session.teacher.teaID}" name="teaID"/>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <textarea name="suggest" placeholder="请输入您的反馈" class="layui-textarea"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="showMessage()">提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
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

    function showMessage() {
        layui.use('layer', function () {
            var layer = layui.layer;
            layer.msg('发送反馈');
        });
    }

</script>
<script>
    window.onload = function () {
        document.getElementById("teaFeedBack").className = "layui-this";
    }
</script>
<%@ include file="UIbottom.jsp" %>
</html>

