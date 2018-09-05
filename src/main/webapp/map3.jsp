<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>地址匹配服务</title>
	<link rel="stylesheet" href="js/bootstrap-4.1.1/css/bootstrap.min.css">
	<script src="js/jquery-3.3.1.min.js" ></script>  
	<script type="text/javascript" src="js/supermap_iclient_9.0.1/include-leaflet.js"></script>
	<script type="text/javascript" src="js/supermap_iclient_9.0.1/iclient9-leaflet.js"></script>
</head>
<body style=" margin: 0;overflow: hidden;background: #fff;width: 100%;height:100%;position: absolute;top: 0;">
<div id="map" style="width: 100%;height:100%"></div>
  	
<script type="text/javascript">
    var host = "http://support.supermap.com.cn:8090/";
    var mapUrl = host + "iserver/services/map-china400/rest/maps/China_4326";
    var map = L.map('map', {
    	crs: L.CRS.EPSG4326,
    	    center: [39.914714, 116.383572],
    	    maxZoom: 18,
    	    zoom: 11
    	});
   	L.supermap.tiledMapLayer(mapUrl).addTo(map);

   	//正向匹配参数
   	var geoCodeParam = new SuperMap.GeoCodingParameter({
   	address: "超图软件", //地址
   	    fromIndex:0, //最小索引
   	    toIndex:10, //最大索引
   	    filters: "公司", //过滤条件
   	    prjCoordSys: '{epsgcode:4326}', //坐标设置
   	    maxReturn:3 //最大结果数
   	});
   	//创建地址匹配服务
   	var addressUrl = host + "iserver/services/addressmatch-Address/restjsr/v1/address";
   	var addressMatchService = L.supermap.addressMatchService(addressUrl);
   	//向服务端发送请求进行正向地址匹配，并对返回的结果进行处理
   	addressMatchService.code(geoCodeParam, match);
   	//对返回的结果进行处理展现在地图上，并添加弹窗
   	function match(obj) {
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
        map.setView(L.latLng(39.914714, 116.383572), 10);//设置地图显示范围
   	}
    	 
</script>
</body>
</html>