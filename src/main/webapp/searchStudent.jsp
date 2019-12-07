<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<body>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        查询学生信息
    </div>
    <form class="layui-form" action="stuSearch.action" method="post">

        <div class="layui-form-item">
            <label class="layui-form-label">查询框</label>
            <div class="layui-input-block" style="width: 250px;">
                <input type="text" name="searchMess" required lay-verify="required" placeholder="请输入查询内容"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">查询方式</label>
            <div class="layui-input-block">
                <input type="radio" name="searchType" value="0" title="学号" checked>
                <input type="radio" name="searchType" value="1" title="姓名">
                <input type="radio" name="searchType" value="2" title="班级">
                <input type="radio" name="searchType" value="3" title="学院">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
                <a class="layui-btn layui-btn-primary" href="allStudents.action">查询所有</a>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

    <div style="width: 850px;margin: 20px 40px;">
        <table class="layui-table" lay-data="{page:true}" lay-filter="test" >
            <thead>
            <tr>
                <th lay-data="{field:'stuID', width:100}">学号</th>
                <th lay-data="{field:'name', width:100, sort:true}">姓名</th>
                <th lay-data="{field:'sex', width:100, sort:true}">性别</th>
                <th lay-data="{field:'clazz', width:120, sort:true}">班级</th>
                <th lay-data="{field:'depart', width:120, sort:true}">学院</th>
                <th lay-data="{field:'email', width:150, sort:false}">邮箱</th>
                <th lay-data="{field:'ope', sort:false}">操作</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="#session['studentList']">
                <tr>
                    <td><s:property value="stuID"/></td>
                    <td><s:property value="name"/></td>
                    <s:if test="%{sex==1}">
                        <td>男</td>
                    </s:if>
                    <s:else>
                        <td>女</td>
                    </s:else>
                    <td><s:property value="clazz"/></td>
                    <td><s:property value="depart"/></td>
                    <td><s:property value="email"/></td>
                    <td><a class="layui-btn layui-btn-normal layui-btn-xs" href="stuMessage.action?stuID=<s:property value="stuID"/>">编辑</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" href="stuMessageDelete.action?stuID=<s:property value="stuID"/>">删除</a></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
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
<script>
    window.onload = function () {
        document.getElementById("queryStudent").className = "layui-this";
    }
</script>
<%@ include file="UIbottom.jsp" %>
</body>
</html>