<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        插入新计划
    </div>
    <form class="layui-container" action="TaskOutCenterAction.action" method="post">
        <div class="layui-row layui-col-space10">

            <div class="layui-col-md3">
                <label class="layui-form-label">教师ID</label>
                <div class="layui-input-block" style="width: 200px;">
                    <s:textfield name="sign.teaID" value="%{#session.teacher.teaID}" readonly="true"
                                 class="layui-input"/>
                </div>
            </div>

            <div class="layui-col-md3">
                <label class="layui-form-label">计划名称</label>
                <div class="layui-input-block" style="width: 200px;">
                    <input type="text" name="sign.name" class="layui-input">
                </div>
            </div>

            <div class="layui-col-md3">
                <label class="layui-form-label">计划描述</label>
                <div class="layui-input-block" style="width: 200px;">
                    <input type="text" name="sign.description" class="layui-input">
                </div>
            </div>


            <div class="layui-col-md3">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">确认</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </div>
    </form>

    <div style="width: 1140px;margin: 20px 40px;">
        <table class="layui-table" lay-data="{page:true, id:'teaTable'}" lay-filter="test">
            <thead>
            <tr>
                <th lay-data="{field:'name', width:300, sort:true}">计划名称</th>
                <th lay-data="{field:'createTime', width:300, sort:true}">创建时间</th>
                <th lay-data="{field:'description', width:350}">计划描述</th>
                <th lay-data="{field:'ops', sort:true}">操作</th>
            </tr>
            </thead>
            <tbody>
            <s:if test='#session.taskList.signs.size()==0'>
            <td style="background: grey">您还没有打卡计划</td>
            </s:if>
            <s:else>
            <s:iterator id="list" value="%{#session.taskList.signs}" status="check">
            <tr>
                <td><s:property value="#list.name"/></td>
                <td><s:date format="yyyy-MM-dd HH:mm:ss" name="#list.createTime"/></td>
                <td><s:property value="#list.description"/></td>
                <td>
                    <s:a href="templistUI.jsp?signname=%{#list.name}&signid=%{#list.signID}"
                         class="layui-btn layui-btn-normal layui-btn-xs">选择计划</s:a>
                </td>
            </tr>
            </s:iterator>
            </s:else>
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

<%--    <script>--%>
<%--        //Demo--%>
<%--        layui.use('form', function () {--%>
<%--            var form = layui.form;--%>

<%--            //监听提交--%>
<%--            form.on('submit(formDemo)', function (data) {--%>
<%--                layer.msg(JSON.stringify(data.field));--%>
<%--                return false;--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>
<script>
    window.onload = function () {
        document.getElementById("planManage").className = "layui-this";
    }
</script>
<%@ include file="UIbottom.jsp" %>
</html>
