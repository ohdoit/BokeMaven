<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>地址匹配服务</title>
	<link rel="stylesheet" href="js/bootstrap-4.1.1/css/bootstrap.min.css">
</head>
<body style=" margin: 0;overflow: hidden;background: #fff;width: 100%;height:100%;position: absolute;top: 0;">
<div id="map" style="width: 100%;height:100%"></div>
  	<script src="js/jquery-3.3.1.min.js" ></script>  
<script type="text/javascript" src="js/supermap_iclient_9.0.1/include-leaflet.js"></script>
<script type="text/javascript" src="js/supermap_iclient_9.0.1/iclient9-leaflet.js"></script>
<script type="text/javascript">
    var host = "http://support.supermap.com.cn:8090";
    var map, codeMarkers = [], decodeMarkers = [],
        url = host + "/iserver/services/map-china400/rest/maps/China_4326",
        addressUrl = host + "/iserver/services/addressmatch-Address/restjsr/v1/address",
        addressMatchService = L.supermap.addressMatchService(addressUrl);
    map = L.map('map', {
        crs: L.CRS.EPSG4326,
        center: [39.914714, 116.383572],
        maxZoom: 18,
        zoom: 11
    });
    L.supermap.tiledMapLayer(url).addTo(map);
    var control = L.control({position: 'topright'});
    control.onAdd = function () {
        var popup = L.DomUtil.create('div');
        popup.style.width = '20%';
        popup.innerHTML = "<div class='panel panel-default'>" +
            "<div class='panel-body'>" +
            "<ul class='nav nav-tabs nav-justified'>" +
            "<li id='geocode' role='presentation' class='active'><a href='#'>正向匹配</a></li>" +
            "<li id='geodecode' role='presentation'><a href='#'>反向匹配</a></li>" +
            "</ul><br/>" +
            "<div class='tab-content'>" +
            "<div id='geocodeParam' role='tabpanel' class='tab-pane deplistContent active'>" +
            "<div class='input-group'>" +
            "<span class='input-group-addon'>地址　　　</span>" +
            "<input id='address' type='text' class='form-control' placeholder='公司'/>" +
            "</div><br/>" +
            "<div class='input-group'>" +
            "<span class='input-group-addon'>过滤字段　</span>" +
            "<input id='filters' type='text' class='form-control'placeholder='北京'/>" +
            "</div><br/>" +
            "<div align='right'>" +
            "<input type='button' id='codeBtn' class='btn btn-primary' value='匹配'/>" +
            "</div></div>" +
            "<div id='geodecodeParam' role='tabpanel' class='tab-pane deplistContent'>" +
            "<div class='input-group'>" +
            "<span class='input-group-addon'>横坐标　　</span>" +
            "<input id='xCoord' type='text' class='form-control' placeholder='116.3518541194752'/>" +
            "</div><br/>" +
            "<div class='input-group'>" +
            "<span class='input-group-addon'>纵坐标　　</span>" +
            "<input id='yCoord' type='text' class='form-control' placeholder='40.00097839595237'/>" +
            "</div><br/>" +
            "<div class='input-group'>" +
            "<span class='input-group-addon'>过滤字段　</span>" +
            "<input id='filters2' type='text' class='form-control' placeholder=''/>" +
            "</div><br/>" +
            "<div align='right'>" +
            "<input type='button' id='decodeBtn' class='btn btn-primary' value='匹配'/>" +
            "</div></div></div>";
        handleMapEvent(popup, this._map);
        return popup;
    };
    control.addTo(map);

    $("#geocode").click(function () {
        $("#geocode")[0].className = 'active';
        $("#geodecode")[0].className = '';
        $("#geocodeParam").addClass('active');
        $("#geodecodeParam").removeClass('active');
    });
    $("#geodecode").click(function () {
        $("#geocode")[0].className = '';
        $("#geodecode")[0].className = 'active';
        $("#geodecodeParam").addClass('active');
        $("#geocodeParam").removeClass('active');
    });

    //判断输入字符串是否为空或者全部都是空格
    function isNull(str) {
        if (str == "") return true;
        var regu = "^[ ]+$";
        var re = new RegExp(regu);
        return re.test(str);
    }

    var filters = $('#filters').val() || $('#filters').attr('placeholder');
    $("#codeBtn").click(function () {
        var geoCodeParam = new SuperMap.GeoCodingParameter({
            address: $('#address').val() || $('#address').attr('placeholder'),
            fromIndex: 0,
            toIndex: 10,
            filters: isNull(filters) ? '' : filters,
            prjCoordSys: '{epsgcode:4326}',
            maxReturn: 3
        });
        addressMatchService.code(geoCodeParam, match);
    });
    $("#decodeBtn").click(function () {
        var geoDecodeParam = new SuperMap.GeoDecodingParameter({
            x: $('#xCoord').val() || $('#xCoord').attr('placeholder'),
            y: $('#yCoord').val() || $('#yCoord').attr('placeholder'),
            fromIndex: $('#fromIndex2').val() || $('#fromIndex2').attr('placeholder'),
            toIndex: $('#toIndex2').val() || $('#toIndex2').attr('placeholder'),
            filters: $('#filters2').val() || $('#filters2').attr('placeholder'),
            prjCoordSys: $('#prjCoordSys2').val() || $('#prjCoordSys2').attr('placeholder'),
            maxReturn: $('#maxReturn2').val() || $('#maxReturn2').attr('placeholder'),
            geoDecodingRadius: $('#geoDecodingRadius').val() || $('#geoDecodingRadius').attr('placeholder'),
        });
        addressMatchService.decode(geoDecodeParam, match);
    });

    function match(obj) {
        clearMarkers();
        obj.result.map(function (item) {
            var marker = L.marker([item.location.y, item.location.x]);
            decodeMarkers.push(marker);
            var innerHTML = "";
            innerHTML += "地址:" + item.address + "<br>";
            var x = Number(item.location.x.toString().match(/^\d+(?:\.\d{0,2})?/));
            var y = Number(item.location.y.toString().match(/^\d+(?:\.\d{0,2})?/));
            innerHTML += "坐标:[" + x + "," + y + "]<br>";
            if (item.score > 0) {
                innerHTML += "匹配度:" + item.score + "<br>";
            }
            innerHTML += "过滤字段:" + item.filters + "<br>";
            marker.bindPopup(innerHTML);
        });
        for (var i = 0; i < decodeMarkers.length; i++) {
            decodeMarkers[i].addTo(map);
        }
        map.setView(L.latLng(39.914714, 116.383572), 10);
    }

    function clearMarkers() {
        if (codeMarkers) {
            for (var i = 0; i < codeMarkers.length; i++) {
                codeMarkers[i].remove();
            }
        }
        if (decodeMarkers) {
            for (var i = 0; i < decodeMarkers.length; i++) {
                decodeMarkers[i].remove();
            }
        }
        codeMarkers = [];
        decodeMarkers = [];
    }

    function handleMapEvent(div, map) {
        if (!div || !map) {
            return;
        }
        div.addEventListener('mouseover', function () {
            map.dragging.disable();
            map.scrollWheelZoom.disable();
            map.doubleClickZoom.disable();
        });
        div.addEventListener('mouseout', function () {
            map.dragging.enable();
            map.scrollWheelZoom.enable();
            map.doubleClickZoom.enable();
        });
    }
</script>
</body>
</html>