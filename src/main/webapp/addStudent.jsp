<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        添加学生信息
    </div>
    <form class="layui-form" action="studentAdd.action" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.stuID" lay-verify="number" placeholder="请输入学号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.name" lay-verify="required" placeholder="请输入姓名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="student.sex" value="1" title="男">
                <input type="radio" name="student.sex" value="0" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">班级</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.clazz" lay-verify="required" placeholder="请输入班级"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">专业</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.depart" required lay-verify="required" placeholder="请输入专业"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.email" lay-verify="email" placeholder="请输入邮箱"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit data-type="auto" lay-filter="formDemo">添加</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <div class="layui-text" style="color: #cf6865;padding-left: 70px">
        <s:property value="#request.tip"/>
    </div>

<%--    <script>--%>
<%--        Demo--%>
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
<%--                layer.msg('添加学生');--%>
<%--            });--%>
<%--        }--%>
<%--    </script>--%>
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        批量导入
        <span style="font-size: x-small; ">可以批量导入后缀为xls的excel表格</span>
    </div>
    <form action="inputExcel.action" enctype="multipart/form-data" method="post">
        <div class="layui-input-block">
            <a href="javascript:;" class="a-upload mr10">
                <input type="file" name="file" id="file">选择文件</a>
        </div>
        <br>

        <div class="showFileName"></div>
        <div class="layui-input-block">
            <button class="layui-btn" type="submit">上传文件</button>
        </div>
        <br>
    </form>
    <style>
        .a-upload {
            padding: 4px 10px;
            height: 30px;
            line-height: 20px;
            position: relative;
            cursor: pointer;
            color: #555;
            background: #fff;
            border: 1px solid #c9c9c9;
            border-radius: 4px;
            overflow: hidden;
            display: inline-block;
            *display: inline;
            *zoom: 1
        }

        .a-upload input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
            filter: alpha(opacity=0);
            cursor: pointer
        }

        .a-upload:hover {
            color: #444;
            background: #eee;
            border-color: #ccc;
            text-decoration: none
        }
    </style>
    <script>
        $(function () {
            //显示隐藏的文件名并上传状态切换
            $('.showFileName').hide();
            $('#uploadBtn').hide();
            $("#upload").on("change", "input[type='file']", function () {
                var filePath = $(this).val();
                //如果仅上传图片 if(filePath.indexOf("jpg") != -1 || filePath.indexOf("png") != -1) {
                if (filePath) {
                    $(".fileerrorTip").html("").hide();
                    var arr = filePath.split('\\');
                    var fileName = arr[arr.length - 1];
                    $('.showFileName').show();
                    $('#uploadBtn').show();
                    $(".showFileName").html("已选择文件名：" + fileName);
                    $('#upload').hide();
                } else {
                    $(".showFileName").html("");
                    $(".fileerrorTip").html("您未上传文件，或者您上传文件类型有误！").show();
                    return false
                }
            });
        });
    </script>
    <script>
        window.onload = function () {
            document.getElementById("addStudent").className = "layui-this";
        }
    </script>
<%@ include file="UIbottom.jsp" %>
</html>