<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        学生反馈
    </div>

    <div style="margin-left: 45px;">
        <ul class="layui-timeline">
            <s:iterator value="#request.studentSuggestList">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title"><s:property value="time"/></h3>
                        <p>
                        <h2><s:property value="name"/></h2>
                        <br>
                        <s:property value="suggest"/>
                        </p>
                    </div>
                </li>
            </s:iterator>
        </ul>
    </div>

<script>
    window.onload = function () {
        document.getElementById("stuFeedBack").className = "layui-this";
    }
</script>
<%@ include file="UIbottom.jsp" %>
</html>