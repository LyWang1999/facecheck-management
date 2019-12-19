<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh-CN">

<head>
    <!-- 原始地址：//webapi.amap.com/ui/1.0/ui/misc/PositionPicker/examples/positionPicker.html -->
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>拖拽选址</title>
    <style>
        html,
        body {
            height: 100%;
            margin: 0;
            width: 100%;
            padding: 0;
            overflow: hidden;
            font-size: 13px;
        }

        .map {
            height: 100%;
            width: 60%;
            float: right;
        }

        #right {
            color: #444;
            background-color: #f8f8f8;
            width: 40%;
            float: left;
            height: 100%;
            position: absolute;
            bottom: 0;
            left: 0;
        }

        #start,
        #stop,
        #right input {
            margin: 4px;
            margin-left: 15px;
        }

        .title {
            width: 97.5%;
            background-color: #dadada
        }

        button {
            border: solid 1px;
            margin-left: 15px;
            background-color: #dadafa;
        }

        .c {
            font-weight: 600;
            padding-left: 15px;
            padding-top: 4px;
        }

        #lnglat,
        #address,
        #nearestJunction,
        #nearestRoad,
        #nearestPOI,
        .title {
            padding-left: 15px;
        }
    </style>
</head>

<body>
<div id="container" class="map" tabindex="0"></div>
<div id='right'>
    <div>
        <div class='title'>选择模式</div>
        <input type='radio' name='mode' value='dragMap' checked>拖拽地图模式</input>
        </br>
        <input type='radio' name='mode' value='dragMarker'>拖拽Marker模式</input>
    </div>
    <div>
        <button id='start'>选点确认</button>
        <button id='stop'>选点重置</button>
    </div>
    <div>
        <div class='title'>选址结果</div>
        <div class='c'>经纬度:</div>
        <div id='lnglat'></div>
        <div class='c'>地址:</div>
        <div id='address'></div>
        <div class='c'>最近的路口:</div>
        <div id='nearestJunction'></div>
        <div class='c'>最近的路:</div>
        <div id='nearestRoad'></div>
        <div class='c'>最近的POI:</div>
        <div id='nearestPOI'></div>
    </div>
</div>
<script type="text/javascript"
        src='//webapi.amap.com/maps?v=1.4.11&key=dfc7143e090aa248641a491478a76d04&plugin=AMap.ToolBar'></script>
<!-- UI组件库 1.0 -->
<script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
<script type="text/javascript">
    AMapUI.loadUI(['misc/PositionPicker'], function (PositionPicker) {
        var map = new AMap.Map('container', {
            zoom: 16,
            scrollWheel: true
        })

        var positionPicker = new PositionPicker({
            mode: 'dragMap',
            map: map
        });


        map.plugin('AMap.Geolocation', function () {
            geolocation = new AMap.Geolocation({
                enableHighAccuracy: true,//是否使用高精度定位，默认:true
                timeout: 10000,          //超过10秒后停止定位，默认：无穷大
                maximumAge: 0,           //定位结果缓存0毫秒，默认：0
                convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
                buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
                showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true
                panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
                zoomToAccuracy: true      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            });
            map.addControl(geolocation);
            geolocation.getCurrentPosition();
            AMap.event.addListener(geolocation, 'complete', function () {
                alert("success get location")
            });//返回定位信息
            AMap.event.addListener(geolocation, 'error', function () {
                alert("fail to get location")
            });      //返回定位出错信息
        });

        positionPicker.on('success', function (positionResult) {
            document.getElementById('lnglat').innerHTML = positionResult.position;
            document.getElementById('address').innerHTML = positionResult.address;
            document.getElementById('nearestJunction').innerHTML = positionResult.nearestJunction;
            document.getElementById('nearestRoad').innerHTML = positionResult.nearestRoad;
            document.getElementById('nearestPOI').innerHTML = positionResult.nearestPOI;
        });
        positionPicker.on('fail', function (positionResult) {
            console.log(positionResult);
            document.getElementById('lnglat').innerHTML = ' ';
            document.getElementById('address').innerHTML = ' ';
            document.getElementById('nearestJunction').innerHTML = ' ';
            document.getElementById('nearestRoad').innerHTML = ' ';
            document.getElementById('nearestPOI').innerHTML = ' ';
        });
        var onModeChange = function (e) {
            positionPicker.setMode(e.target.value)
        };
        var startButton = document.getElementById('start');
        var stopButton = document.getElementById('stop');
        var dragMapMode = document.getElementsByName('mode')[0];
        var dragMarkerMode = document.getElementsByName('mode')[1];
        AMap.event.addDomListener(startButton, 'click', function () {

            var message = new Object();
            message.position = document.getElementById('lnglat').innerHTML;
            message.address = document.getElementById('address').innerHTML;
            message.nearestJunction = document.getElementById('nearestJunction').innerHTML;
            message.nearestRoad = document.getElementById('nearestRoad').innerHTML;
            message.nearestPOI = document.getElementById('nearestPOI').innerHTML;
            var json = JSON.stringify(message);
            sessionStorage.setItem('message', json);
            document.cookie = document.getElementById('lnglat').innerHTML + ","
                + document.getElementById('address').innerHTML;
            // window.open("/templateUI.jsp", 'window');
            // history.go(-1);
            // window.location.href='templateUI.jsp'
            // self.location=document.referrer;
            window.open('templateUI.jsp', 'window');
        });
        AMap.event.addDomListener(stopButton, 'click', function () {
            geolocation.getCurrentPosition();

        });
        AMap.event.addDomListener(dragMapMode, 'change', onModeChange);
        AMap.event.addDomListener(dragMarkerMode, 'change', onModeChange);
        positionPicker.start();
        //map.panBy(0, 1);以像素为单位，沿x方向和y方向移动地图，x向右为正，y向下为正

        map.addControl(new AMap.ToolBar({
            liteStyle: false //左上方的控件
        }))
    });
</script>
</body>

</html>