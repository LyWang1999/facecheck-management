<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        添加兑换礼品
    </div>
    <form class="layui-form" enctype="multipart/form-data" action="giftAdd.action">
        <div class="layui-form-item">
            <label class="layui-form-label">礼品名称</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_name" required lay-verify="required" placeholder="请输入礼品名称"
                       autocomplete="off" class="layui-input" id="giftName">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品简介</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_descript" required lay-verify="required" placeholder="请输入礼品简介"
                       autocomplete="off" class="layui-input" id="giftDescript">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品积分</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_score" required lay-verify="required" placeholder="请输入礼品积分价值"
                       autocomplete="off" class="layui-input" id="giftScore">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品数量</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_quantity" required lay-verify="required" placeholder="请输入礼品数量"
                       autocomplete="off" class="layui-input" id="giftQuantity">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品图片</label>
            <div class="layui-input-block" style="width: 200px;">
                <button class="layui-btn" name="file">
                    <i class="layui-icon">&#xe67c;</i>上传图片
                </button>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn">添加</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script>
    window.onload = function () {
        document.getElementById("addGift").className = "layui-this";
    }
</script>
<%@ include file="UIbottom.jsp" %>
</html>