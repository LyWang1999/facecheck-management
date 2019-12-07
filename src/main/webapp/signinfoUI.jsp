<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UITeaHead.jsp" %>
<link rel="stylesheet" href="./cssfile/kalendae.css" type="text/css">
<script type='text/javascript' src='./js/kalendae.standalone.js'></script>

<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        创建新计划
    </div>
    <form class="layui-form" action="newInsAction.action" method="post">
        <s:hidden name="sign.teaID" value="#session.teacher.teaID"/>
        <input type="text" value="${param.templateid}" hidden name="templateid">
        <input type="text" value="${param.chooseid}" hidden name="chooseid">
        <input type="text" value="${param.choosename}" hidden name="choosename">


        <div class="layui-form-item">
            <label class="layui-form-label">时间选择</label>
            <div class="layui-input-block" style="width: 200px;padding-top: 10px">
                <s:textfield class="auto-kal layui-input" data-kal="mode:'multiple'" style="width: 100%;height:200%;"
                             readonly="true" format="YYYY-MM-DD" name="datelist" id="date"/>
            </div>
        </div>
        <s:textfield name="stulist" id="stulist" hidden="true"/>
        <div style="width: 400px;margin: 20px 40px;">
            <table id="table" class="layui-table" lay-data="{page:true}">
                <thead>
                <tr>
                    <th lay-data="{field:'startTime', width:150, sort:true}">学号</th>
                    <th lay-data="{field:'endTime', width:150, sort:true}">姓名</th>
                    <th lay-data="{field:'ope'}">操作</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator id="list" value="#request.students" status="check">
                    <tr>
                        <td><s:property value="#list.stuID"/></td>
                        <td><s:property value="#list.name"/></td>
                        <s:url var="urlName" action="CreateInsAction">
                            <s:param name="templateid" value="#list.stuID"/>
                        </s:url>
                        <td>
                            <input type="checkbox" name="box" id="#list.stuID"><label for="#list.stuID">选择</label>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="handed()">确认</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>


    <script type="text/javascript">
        function handed() {
            var rows = document.getElementById('table').rows;
            var chk = document.getElementById('table').getElementsByTagName("input");
            var str = "";
            for (var i = 0; i < chk.length; i++) {
                if (chk[i].type == "checkbox") {
                    if (chk[i].checked) {
                        var row = chk[i].parentElement.parentElement.rowIndex;
                        str += rows[row].cells[0].innerHTML + ","
                    }
                }
            }
            str = str.substring(0, str.length - 1);
            document.getElementById("stulist").value = str;
            console.log(str);
        }
    </script>

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
</html>
