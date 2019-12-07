<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        修改兑换礼品
    </div>
    <form class="layui-form" action="changeGift.action" enctype="multipart/form-data" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">礼品编号</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_id" readonly="true" value="<s:property value="#request.gift.gift_id"/>" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品名称</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_name" value="<s:property value="#request.gift.gift_name"/>" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品简介</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_descript" value="<s:property value="#request.gift.gift_descript"/>" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品积分</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_score" value="<s:property value="#request.gift.gift_score"/>" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品数量</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_quantity" value="<s:property value="#request.gift.gift_quantity"/>" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品图片</label>
            <img src="<s:property value="gift.gift_img"/>" width="200px" height="200px"/>
            <input type="hidden" name="giftImg" value="<s:property value="gift.gift_img"/>"/>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品图片</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="file" name="file">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit>修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
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

<%--        function showMessage() {--%>
<%--            layui.use('layer', function () {--%>
<%--                var layer = layui.layer;--%>
<%--                layer.msg('添加成功');--%>
<%--            });--%>
<%--        }--%>
<%--    </script>--%>



<%@ include file="UIbottom.jsp" %>
</body>
</html>
