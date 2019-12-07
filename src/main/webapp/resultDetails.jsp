<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        <s:property value="dailyresult.sign_name"/>
        应到:<s:property value="dailyresult.all"/>人
        实到:<s:property value="dailyresult.fact"/>人
    </div>
    <div id="resultdetails" style="width: 1100px;margin: 20px 40px;">
        <table class="layui-table">
            <thead>
            <tr>
                <th lay-data="{width:100, sort:true}">学号</th>
                <th lay-data="{width:100, sort:true}">姓名</th>
                <th lay-data="{width:100, sort:true}">班级</th>
                <th lay-data="{width:100, sort:true}">专业</th>
                <th lay-data="{width:150, sort:true}">签到时间</th>
                <th lay-data="{width:150, sort:true}">相似度</th>
                <th lay-data="{width:150, sort:true}">签到情况</th>
                <th lay-data="{sort:false}">操作</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="resultdetails">
                <tr>
                    <td><s:property value="studentsign.stuID"/></td>
                    <td><s:property value="student_name"/></td>
                    <td><s:property value="student_class"/></td>
                    <td><s:property value="student_department"/></td>
                    <td><s:property value="studentsign.signTime"/></td>
                    <td><s:property value="0.08"/></td>
                    <td>
                        <s:form action="changeResult" method="post">
                            <s:hidden name="resultdetail.studentsign.stuSignID" value="%{studentsign.stuSignID}"/>
                            <s:hidden name="resultdetail.studentsign.signInstID" value="%{studentsign.signInstID}"/>
                            <s:radio name="resultdetail.studentsign.status" list="%{#{'0':'未到','1':'请假','2':'已到'}}"
                                     value="studentsign.status" onclick="javascript:submit()"/>
                        </s:form>
                    </td>

                    <td>
                        <button id="${studentsign.stuID}+1" class="layui-btn layui-btn-normal layui-btn-xs"
                        onclick="TestBlack('${studentsign.stuSignID}+2','${studentsign.stuID}+1');">
                            查看对比图
                        </button>
                    </td>
                </tr>
                <tr id="${studentsign.stuSignID}+2" style="display:none">
                    <td colspan="5" bgcolor="#00CCFF">注册照片：<img src="<s:property value="studentsign.stuImgUrl"/>"
                                                                weight="200px" height="200px"></td>
                    <td colspan="3" bgcolor="#00CCFF">签到照片：<img src="<s:property value="studentsign.signImgUrl"/>"
                                                                weight="200px" height="200px"></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <form action="exportExcel">
            <button class="layui-btn" type="submit">下载到本地</button>

        </form>
    </div>
    <div id="AutoPlayDetail" style="display:none">
        <table>

        </table>
    </div>
</div>
<!--
<button id="AutoPlayButton" onclick="AutoPlay('AutoPlayButton','resultdetails','AutoPlayDetail');">逐条查看</button>
-->
<script language="javascript">
    function TestBlack(TagName, TagName1) {
        var obj = document.getElementById(TagName);
        var obj2 = document.getElementById(TagName1);
        if (obj.style.display == "") {
            obj.style.display = "none";
            obj2.innerHTML = "查看对比图";
        } else {
            obj.style.display = "";
            obj2.innerHTML = "收起对比图";
        }
    }
    function AutoPlay(TagName1, TagName2, TagName3) {
        var obj1 = document.getElementById(TagName1);
        var obj2 = document.getElementById(TagName2);
        var obj3 = document.getElementById(TagName3);
        if (obj1.innerHTML == "逐条查看") {
            obj1.innerHTML = "查看所有";
            obj2.style.display = "none";
            obj3.style.display = "";
        } else {
            obj1.innerHTML = "逐条查看";
            obj2.style.display = "";
            obj3.style.display = "none";
        }
        document.getElementById(TagName).style.display = "none";
    }
</script>
<%@ include file="UIbottom.jsp" %>
</html>