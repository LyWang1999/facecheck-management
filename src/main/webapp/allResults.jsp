<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<body>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        查看签到
    </div>
    <form id="form" class="layui-form" action="findSign.action" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">查询框</label>
            <div class="layui-input-block" style="width: 200px;">
                <input id="inputid" type="text" name="message" required lay-verify="required" placeholder="请输入查询内容"
                       autocomplete="off" class="layui-input">
                <s:hidden name="teacher.teaID" value="%{#session.teacher.teaID}"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">查询方式</label>
            <div class="layui-input-block">
                <input type="radio" name="searchType" value="0" title="签到项目名称" checked>
                <input type="radio" name="searchType" value="1" title="发布时间">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit>查询</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <div style="width: 650px;margin: 20px 40px;">
        <table class="layui-table" lay-data="{page:true, id:'teaTable'}" lay-filter="test">
            <thead>
            <tr>
                <th lay-data="{field:'name', width:150, sort: true}">签到项目</th>
                <th lay-data="{field:'createTime', width:150, sort: true}">发布日期</th>
                <th lay-data="{field:'description', width:200}">签到描述</th>
                <th lay-data="{field:'ope'}">操作</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="results">
                <tr>
                    <td><s:property value="name"/></td>
                    <td><s:property value="createTime"/></td>
                    <td><s:property value="description"/></td>
                    <td>
                        <a href="getDailyResult.action?signinstance.signID=<s:property value="signID"/>" class="layui-btn layui-btn-normal layui-btn-xs">查看</a>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>
</div>

<script language="javascript">
    function ActionByName(form, input) {
        var formid = document.getElementById(form);
        var inputid = document.getElementById(input);
        formid.action = "ByName";
        inputid.name = "result.name";
    }

    function ActionByTime(form, input) {
        var formid = document.getElementById(form);
        var inputid = document.getElementById(input);
        formid.action = "ByTime";
        inputid.name = "result.createTime";
    }
</script>

<script>
    layui.use('table', function () {
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function (obj) {
            console.log(obj)
        });
        var $ = layui.$, active = {
            getCheckData: function () { //获取选中数据
                var checkStatus = table.checkStatus('stuTable')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            , getCheckLength: function () { //获取选中数目
                var checkStatus = table.checkStatus('stuTable')
                    , data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
            }
            , isAll: function () { //验证是否全选
                var checkStatus = table.checkStatus('stuTable');
                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
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
<script>
    window.onload = function () {
        document.getElementById("querySign").className = "layui-this";
    }
</script>
<%@ include file="UIbottom.jsp" %>
</html>
