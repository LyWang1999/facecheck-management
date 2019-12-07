<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div style="width: 1000px;margin: 20px 40px;">
        <table class="layui-table" lay-data="{page:true}">
            <thead>
            <tr>
                <th lay-data="{field:'stuID', width:100}">签到实例id</th>
                <th lay-data="{field:'stuID', width:100}">打卡ID</th>
                <th lay-data="{field:'name', width:120, sort:true}">开始时间</th>
                <th lay-data="{field:'sex', width:120, sort:true}">结束时间</th>
                <th lay-data="{field:'clazz', width:120, sort:true}">经度</th>
                <th lay-data="{field:'depart', width:120, sort:true}">纬度</th>
                <th lay-data="{field:'depart', width:120, sort:true}">地点</th>
                <th lay-data="{field:'depart', sort:true}">打卡半径</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="signInstances">
                <tr>
                    <td><s:property value="signInstID"/></td>
                    <td><s:property value="signID"/></td>
                    <td><s:date name="startTime" format="HH:mm:ss"/></td>
                    <td><s:date name="endTime" format="HH:mm:ss"/></td>
                    <td><s:property value="longitude"/></td>
                    <td><s:property value="latitude"/></td>
                    <td><s:property value="placeName"/></td>
                    <td><s:property value="radius"/></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>

</div>
<%--    <script>--%>
<%--        layui.use('form', function () {--%>
<%--            var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功--%>

<%--            form.on('submit(formDemo)', function (data) {--%>
<%--                console.log('!!!!!!!!');--%>
<%--            });--%>


<%--            form.render();--%>
<%--        });--%>

<%--    </script>--%>
<%@ include file="UIbottom.jsp" %>
</html>
