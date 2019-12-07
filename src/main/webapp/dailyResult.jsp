<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        签到详细信息
    </div>
    <div style="width: 1100px;margin: 20px 40px;">
        <table class="layui-table" lay-data="{page:true}" lay-filter="test">
            <thead>
            <tr>
                <th lay-data="{field:'name', width:100}">签到项目</th>
                <th lay-data="{field:'date', width:150,sort:true}">发布日期</th>
                <th lay-data="{field:'startTime', width:150, sort:true}">开始时间</th>
                <th lay-data="{field:'endTime', width:150,  sort:true}">截止时间</th>
                <th lay-data="{field:'placeName', width:400, sort:true}">签到地点</th>
                <th lay-data="{field:'ope'}">操作</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="signinstances">
                <tr>
                    <td><s:property value="result.name"/>
                    <td><s:property value="date"/></td>
                    <td><s:property value="startTime"/></td>
                    <td><s:property value="endTime"/></td>
                    <td><s:property value="placeName"/></td>
                    <td><a href="getResultDetail.action?dailyresult.signinstance.signInstID=<s:property value="signInstID"/>"
                            class="layui-btn layui-btn-normal layui-btn-xs">查看</a>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
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

<%@ include file="UIbottom.jsp" %>
</html>
