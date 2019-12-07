<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<%@ include file="UITeaHead.jsp" %>
<link rel="stylesheet" type="text/css" href="/cssfile/Releasetask.css"/>
<link rel="stylesheet" type="text/css" href="/cssfile/DateTimePicker.css"/>
<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/js/DateTimePicker.js"></script>
<script type="text/javascript">
    $(function () {

        var teaPhone = document.getElementById("phone").value;

        $("#code_btn").on("click", function () {
            $.ajax({
                async: false,
                cache: false,
                type: 'POST',
                data: {'phone': teaPhone},
                url: 'ReleaseAction.action', // 请求的action路
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        console.log("发送成功");
                        addCookie("code", data.obj, 480);
                    } else {
                        console.log("网络异常");
                    }
                }
            });

            addCookie("secondsremained", 60, 60); //添加cookie记录,有效时间60s
            settime($("#code_btn")); //开始倒计时
        })


        var v = getCookieValue("secondsremained") ? getCookieValue("secondsremained") : 0;//获取cookie值


        if (v > 0) {

            settime($("#code_btn")); //开始倒计时
        }
    })

    function check() {


        var code = document.getElementById("code").value;
        var cookiecode = getCookieValue("code");
        console.log(cookiecode);
        if (code == null || code == "") {
            alert("请输入验证码");
            return false;
        } else if (cookiecode == null) {
            alert("请先获取验证码");
            return false;
        } else if (code != cookiecode) {
            alert("验证码不正确");
            return false;
        } else return true;
        return true;

    }


    //发送验证码时添加cookie
    function addCookie(name, value, expiresHours) {
        var cookieString = name + "=" + escape(value);
        //判断是否设置过期时间,0代表关闭浏览器时失效
        if (expiresHours > 0) {
            var date = new Date();
            date.setTime(date.getTime() + expiresHours * 1000);
            cookieString = cookieString + ";expires=" + date.toUTCString();
        }
        document.cookie = cookieString;
    }

    //修改cookie的值
    function editCookie(name, value, expiresHours) {
        var cookieString = name + "=" + escape(value);
        if (expiresHours > 0) {
            var date = new Date();
            date.setTime(date.getTime() + expiresHours * 1000); //单位是毫秒
            cookieString = cookieString + ";expires=" + date.toGMTString();
        }
        document.cookie = cookieString;
    }


    //根据名字获取cookie的值
    function getCookieValue(name) {
        var strCookie = document.cookie;
        var arrCookie = strCookie.split("; ");
        for (var i = 0; i < arrCookie.length; i++) {
            var arr = arrCookie[i].split("=");
            if (arr[0] == name) {
                return unescape(arr[1]);
                break;
            }
        }


    }


    //开始倒计时
    var countdown;

    function settime(obj) {
        this.countdown = getCookieValue("secondsremained");
        var tim = setInterval(function () {
            countdown--;
            console.log(countdown);
            $(obj).attr("disabled", true);
            $(obj).attr("value", "重新发送(" + countdown + ")");
            if (countdown <= 0) {
                clearInterval(tim);
                $(obj).removeAttr("disabled");
                $(obj).attr("value", "请输入验证码");
            }
            editCookie("secondsremained", countdown, countdown);
        }, 1000) //每1000毫秒执行一次


    }


    $(document).ready(function () {
        $("#dtBox").DateTimePicker();
    });


    function myFunction() {
        var message = sessionStorage.getItem('message'), str;
        if (message != null) {
            str = JSON.parse(message);
            var result = str.position.split(",");
            document.getElementById("longitude").value = result[0];
            document.getElementById("latitude").value = result[1];
            document.getElementById("address").value = str.address;
            sessionStorage.clear();
        }
    }

</script>

<div id="dtBox"></div>
<div class="layui-body" onload="return myFunction()">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        模板创建
    </div>
    <form action="templateAction.action" method="post" class="layui-form">
        <s:hidden id="phone" value="%{#session.teacher.phone}"/>
        <s:hidden name="template.teaID" value="%{#session.teacher.teaID}"/>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width:150px ">签到起始时间</label>
            <div class="layui-input-block">
                <input type="text" name="template.startTime" data-field="time" readonly required lay-verify="required"
                       style="width: 40%" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width:150px ">签到结束时间</label>
            <div class="layui-input-block">
                <input type="text" name="template.endTime" data-field="time" readonly required lay-verify="required"
                       style="width: 40%" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width:150px ">签到经度</label>
            <div class="layui-input-block">
                <input type="text" name="template.longitude" id="longitude" readonly style="width: 40%"
                       placeholder="请打开地图" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width:150px ">签到纬度</label>
            <div class="layui-input-block">
                <input type="text" name="template.latitude" id="latitude" readonly style="width: 40%"
                       placeholder="请打开地图" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width:150px ">签到半径（米）</label>
            <div class="layui-input-block">
                <input type="text" name="template.radius" required lay-verify="required" style="width: 40%"
                       placeholder="请输入（米）" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width:150px ">签到地点</label>
            <div class="layui-input-block">
                <input type="text" id="address" readonly name="template.placeName" required lay-verify="required"
                       style="width: 40%" placeholder="请打开地图" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width:150px ">
                <input id="code_btn" type="button" class="layui-btn"
                       style="overflow:hidden;" value="点击获取验证码"/>
            </label>
            <div class="layui-input-block">
                <div>
                    <input type="text" id="code" placeholder="Please input your code" backgroundColor="#E4E4E4"
                           style="width:40%; overflow:hidden; white-space:nowrap;" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width:150px "></label>
            <div class="layui-input-block">
                <input type="submit" class="layui-btn" value="确认" id="go" onclick="return check()"/>
                <input type="button" class="layui-btn" value="打开地图" align="right"
                       onclick="javascrtpt:window.open('locate.jsp','newindow')"/></div>
        </div>
        <%--
            <label>
                <span>&nbsp;</span>
                <input type="submit" class="button" value="确认" id="go" onclick="return check()"/>
                <input type="button" class="button" value="打开地图" align="right"  onclick="javascrtpt:window.open('locate.jsp','newindow')"/>
            </label>--%>
    </form>
</div>
<%@ include file="UIbottom.jsp" %>
</html>
