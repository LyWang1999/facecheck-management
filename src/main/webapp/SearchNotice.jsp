<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        查询所有通知
    </div>
    <div style="width: 850px;margin: 0 40px;">
        <table class="layui-table" lay-data="{page:true, id:'noticeTable'}" lay-filter="test" >
            <thead>
            <tr>
                <th lay-data="{field:'title', width:100}">标题</th>
                <th lay-data="{field:'content', sort:true}">内容</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="#session.noticeList">
                <tr>
                    <td><s:property value="title"/></td>
                    <td><s:property value="content"/></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <form action="searchNotice.action" method="post" >
            <s:hidden value="%{#session.teacher.teaID}" name="notice.teaID"/>
            <button class="layui-btn" lay-submit type="submit">查询</button>
        </form>
    </div>
</div>
<%--    <script>--%>
<%--        layui.use('form', function () {--%>
<%--            var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功--%>
<%--            form.render();--%>
<%--        });--%>
<%--    </script>--%>
<script>
    window.onload = function () {
        document.getElementById("queryMsg").className = "layui-this";
    }
</script>
<%@ include file="UIbottom.jsp" %>
</html>
