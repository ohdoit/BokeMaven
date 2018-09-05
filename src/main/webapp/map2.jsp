<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>  
<head>  
      
    <title>地图</title>  
  
    <meta charset="utf-8" />  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
      
    <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico" />  
  	<script src="js/jquery-3.3.1.min.js" ></script>  
    
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.1/dist/leaflet.css" integrity="sha512-Rksm5RenBEKSKFjgI3a41vrjkw4EVPlJ3+OiI65vTjIdo9brlAacEuKOiQ5OFh7cOI1bkDwLqdLw3Zg0cRJAAQ==" crossorigin=""/>  
    <script src="https://unpkg.com/leaflet@1.3.1/dist/leaflet.js" integrity="sha512-/Nsx9X4HebavoBvEBuyp3I7od5tA0UzAxs+j83KgC8PU0kgB4XiK4Lfe4y4cgBtaRJQEIFCW+oC506aPT2L1zw==" crossorigin=""></script>  
    <script src="js/leaflet-search.min.js" ></script>  
    <style>  
        html, body {  
            height: 100%;  
            margin: 0;  
        }  
        #map {  
            width: 600px;  
            height: 400px;  
        }  
    </style>  
  
    <style>body { padding: 0; margin: 0; } #map { height: 100%; width: 100vw; }</style>  
</head>  
<body>  
  
<div id='map'></div>  <div id="post-it"></div>
  
<script>  
    var map = L.map('map').fitWorld();  
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox.streets',
        accessToken: 'pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw'
    }).addTo(map);
  

    //sample data values for populate map
  	var data = [
  		{"loc":[41.575330,13.102411], "title":"aquamarine"},
  		{"loc":[41.575730,13.002411], "title":"black"},
  		{"loc":[41.807149,13.162994], "title":"blue"},
  		{"loc":[41.507149,13.172994], "title":"chocolate"},
  		{"loc":[41.847149,14.132994], "title":"coral"},
  		{"loc":[41.219190,13.062145], "title":"cyan"},
  		{"loc":[41.344190,13.242145], "title":"darkblue"},	
  		{"loc":[41.679190,13.122145], "title":"darkred"},
  		{"loc":[41.329190,13.192145], "title":"darkgray"},
  		{"loc":[41.379290,13.122545], "title":"dodgerblue"},
  		{"loc":[41.409190,13.362145], "title":"gray"},
  		{"loc":[41.794008,12.583884], "title":"green"},	
  		{"loc":[41.805008,12.982884], "title":"greenyellow"},
  		{"loc":[41.536175,13.273590], "title":"red"},
  		{"loc":[41.516175,13.373590], "title":"rosybrown"},
  		{"loc":[41.506175,13.173590], "title":"royalblue"},
  		{"loc":[41.836175,13.673590], "title":"salmon"},
  		{"loc":[41.796175,13.570590], "title":"seagreen"},
  		{"loc":[41.436175,13.573590], "title":"seashell"},
  		{"loc":[41.336175,13.973590], "title":"silver"},
  		{"loc":[41.236175,13.273590], "title":"skyblue"},
  		{"loc":[41.546175,13.473590], "title":"yellow"},
  		{"loc":[41.239190,13.032145], "title":"white"}
  	];

      function localData(text, callResponse)
  	{
  		//here can use custom criteria or merge data from multiple layers
  		callResponse(data);
  		return {	//called to stop previous requests on map move
  			abort: function() {
  				console.log('aborted request:'+ text);
  			}
  		};
  	}
  	map.addControl( new L.Control.Search({sourceData: localData, text:'Color...', markerLocation:true}) );
    
    
    function onLocationFound(e) {  
        var radius = e.accuracy / 2;  
  
        L.marker(e.latlng).addTo(map)  
            .bindPopup("You are within " + radius + " meters from this point").openPopup();  
  
        L.circle(e.latlng, radius).addTo(map);  
    }  
  
    function onLocationError(e) {  
        alert(e.message);  
        map.setView([39.9788, 116.30226], 10);
        L.marker([39.9788, 116.30226]).addTo(map).bindPopup("北京").openPopup();
        

      	// GeoJson
        var geojsonFeature = {
       	    "type": "Feature",
       	    "properties": {
       	        "name": "Coors Field",
       	        "amenity": "Baseball Stadium",
       	        "popupContent": "This is where the Rockies play!"
       	    },
       	    "geometry": {
       	        "type": "Point",
       	        "coordinates": [36.9788, 113.30226]
       	    }
       	};
      	L.geoJSON(geojsonFeature).addTo(map);
    }  
  
    map.on('locationfound', onLocationFound);  
    map.on('locationerror', onLocationError);  
  	// 在自动设置地图视图时，我们在此指定16作为最大缩放。只要用户同意共享位置并且浏览器检测到该位置，地图就会将视图设置为该位置。
    map.locate({setView: true, maxZoom: 16});  
  	
</script>  
  
  
  
</body>  
</html>  