<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<body>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        模板管理
    </div>
    <div style="padding-left: 35px;">
    <button class="layui-btn" onclick="javascrtpt:window.open('templateUI.jsp', 'window');">创建模板</button>
    </div>
    <div style="width: 1200px;margin: 20px 40px;">
        <table class="layui-table" lay-data="{page:true, id:'teaTable'}" lay-filter="test">
            <thead>
            <tr>
                <th lay-data="{field:'tempID', width:100}">模板号</th>
                <th lay-data="{field:'startTime', width:150, sort:true}">签到起始时间</th>
                <th lay-data="{field:'endTime', width:150, sort:true}">签到结束时间</th>
                <th lay-data="{field:'longitude', width:120, sort:true}">经度</th>
                <th lay-data="{field:'latitude', width:120, sort:true}">纬度</th>
                <th lay-data="{field:'placeName', width:370, sort:true}">打卡地点</th>
                <th lay-data="{field:'ope', sort:false}">操作</th>
            </tr>
            </thead>
            <tbody>
            <%--    <s:iterator value="#session['teacherList']">
                    <tr>
                        <td lay-data="{type:'checkbox'}">#stuID</td>
                        <td><s:property value="teaID"/></td>
                        <td><s:property value="name"/></td>
                        <s:if test="%{sex==1}">
                            <td>男</td>
                        </s:if>
                        <s:else>
                            <td>女</td>
                        </s:else>
                        <td><s:property value="phone"/></td>
                        <td><a href="teaMessage?teaID=<s:property value="teaID"/>">编辑</a>
                            <a href="teaMessageDelete?teaID=<s:property value="teaID"/>">删除</a></td>
                    </tr>--%>
            <%--   </s:iterator>--%>
            <s:if test="#session.taskList.templates.size()==0">
            <td>您的列表为空</td>
            <tr>
                </s:if>
                <s:else>
                <s:iterator id="list" value="#session.taskList.templates" status="check">
                <td><s:property value="#list.tempID"/></td>
                <td><s:property value="#list.startTime"/></td>
                <td><s:property value="#list.endTime"/></td>
                <td><s:property value="#list.longitude"/></td>
                <td><s:property value="#list.latitude"/></td>
                <td><s:property value="#list.placeName"/></td>
                <s:url var="addurl" action="CreateInsAction">
                    <s:param name="templateid" value="#list.tempID"/>
                    <s:param name="chooseid">${param.signid}</s:param>
                    <s:param name="choosename">${param.signname}</s:param>
                </s:url>
                <s:url var="deleteurl" action="DeleteInsAction">
                    <s:param name="templateid" value="#list.tempID"/>
                    <s:param name="chooseid">${param.signid}</s:param>
                    <s:param name="choosename">${param.signname}</s:param>
                </s:url>
                <td>
                    <s:a href="%{addurl}" onclick="return myclick();" class="layui-btn layui-btn-normal layui-btn-xs">选择模板</s:a>
                    <s:a href="%{deleteurl}" onclick="if (confirm('确认删除该模板？')) return true; else return false;" class="layui-btn layui-btn-danger layui-btn-xs">删除模板</s:a>
                </td>

            </tr>

            </s:iterator>
            </s:else>
            </tbody>
        </table>
    </div>
</div>

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
        document.getElementById("templateManage").className = "layui-this";
    };
    function myclick() {
        var url = location.search;
        if (url.indexOf("?") != -1) {
            return true;
        }        //直接弹出第一个参数 （如果有多个参数 还要进行循环的）
        else {
            alert("请先到计划页面选择计划");
            return false;
        }
    }
</script>
<%@ include file="UIbottom.jsp" %>
</html>
