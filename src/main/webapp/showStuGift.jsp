<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        兑换请求
    </div>
    <div style="width: 850px;margin: 20px 40px;">
        <table class="layui-table" lay-data="{page:true}" lay-filter="test">
            <thead>
            <tr>
                <th lay-data="{width:150, sort:true}">礼品编号</th>
                <th lay-data="{width:150, sort:true}">名称</th>
                <th lay-data="{width:150, sort:true}">学号</th>
                <th lay-data="{width:150, sort:true}">数量</th>
                <th lay-data="{width:150, sort:true}">结果</th>
                <th lay-data="{sort:false}">操作</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="giftChanges">
                <tr>
                    <td><s:property value="sg.gift_id"/></td>
                    <td><s:property value="gift_name"/></td>
                    <td><s:property value="sg.student_id"/></td>
                    <td><s:property value="sg.quantity"/></td>
                    <td>
                        <s:form>
                            <s:radio name="sg.result" list="#{'false':'未兑','true':'已兑'}" value="sg.result"/>
                        </s:form>
                    </td>

                    <td>
                        <a href="applyChange.action?giftChange.sg.autoid=<s:property value="sg.autoid"/>&giftChange.sg.quantity=<s:property value="sg.quantity"/>">兑换</a>
                        <a href="refuseChange.action?giftChange.sg.autoid=<s:property value="sg.autoid"/>&giftChange.sg.quantity=<s:property value="sg.quantity"/>&giftChange.sg.gift_id=<s:property value="sg.gift_id"/>&giftChange.sg.result=<s:property value="sg.result"/>">拒绝</a>
                    </td>
                </tr>
            </s:iterator>
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
        document.getElementById("queryRequest").className = "layui-this";
    }
</script>
<%@ include file="UIbottom.jsp" %>
</html>

