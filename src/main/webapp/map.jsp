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
    var map, currentData, layersName = [], info, fieldService,
    mapURL = host + "/iserver/services/map-world/rest/maps/World",
    dataURL = host + "/iserver/services/data-world/rest/data";
	map = L.map('map', {
	    preferCanvas: true,
	    crs: L.CRS.EPSG4326,
	    center: {lon: 0, lat: 0},
	    maxZoom: 18,
	    zoom: 2
	});
	L.supermap.tiledMapLayer(mapURL).addTo(map);
	initResultInfoWin();
	showLayersInfo();

    function initResultInfoWin() {
        info = L.control({position: 'bottomleft'});
        info.onAdd = function () {
            this._div = L.DomUtil.create('div', 'resultInfo');
            info.update();
            handleMapEvent(this._div, this._map);
            return this._div;
        };

        info.update = function (currentStatisticResult) {
            if (!currentStatisticResult) {
                return;
            }
            var innerHTMLStr = '<div style="line-height: 35px;">'
                + '<strong>图层</strong>（continent_T@World）&nbsp;&nbsp;&nbsp;<strong>字段</strong>（' + currentStatisticResult.fieldName + '）<div>';
            innerHTMLStr += '<div style="line-height: 35px;">'
                + '<strong>统计结果：</strong><div>';
            var keys = ["AVERAGE", "MAX", "MIN", "STDDEVIATION", "SUM", "VARIANCE"];
            var tableStr = "<table id='trafficRes' class='table table-bordered'><tr><td>平均值</td><td>最大值</td><td>最小值</td>"
                + "<td>标准差</td><td>和</td><td>方差</td></tr>";
            var resultTR = "<tr>";
            for (var i = 0; i < keys.length; i++) {
                resultTR += "<td>" + currentStatisticResult[keys[i]] + "</td>";
            }
            resultTR += "</tr>";
            tableStr += resultTR + "</table>";
            innerHTMLStr += tableStr;
            this._div.innerHTML = innerHTMLStr;
        };
        info.addTo(map);
    }

    //获取子图层信息
    function showLayersInfo() {
        var subLayer;
        L.supermap
            .layerInfoService(mapURL)
            .getLayersInfo(function (serviceResult) {
                var result = serviceResult.result;
                var layers = result.subLayers.layers;
                if (!layers) return;
                for (var i = 0, len = layers.length; i < len; i++) {
                    subLayer = layers[i];
                    if ("UGC" == subLayer.type) {
                        //记录数据源，数据集信息供字段查询统计使用
                        if (subLayer.datasetInfo.name && subLayer.datasetInfo.dataSourceName) {
                            layersName[i] = {
                                dataSetName: subLayer.datasetInfo.name,
                                dataSourceName: subLayer.datasetInfo.dataSourceName,
                                layerName: subLayer.name
                            };
                        }
                    }
                }
                getFields();
            });
    }

    //获取字段
    function getFields() {
        var name = 'continent_T@World';
        var dataInfo;
        for (var i = 0; i < layersName.length; i++) {
            dataInfo = layersName[i];
            if (dataInfo.layerName == name) {
                //设置数据集，数据源，查询fields信息
                currentData = dataInfo;
                var param = new SuperMap.FieldParameters({
                    datasource: currentData.dataSourceName,
                    dataset: currentData.dataSetName,
                });
                L.supermap.fieldService(dataURL).getFields(param, function (serviceResult) {
                    if (serviceResult.result && serviceResult.result.fieldNames) {
                        console.log("---------------------------------");
                        console.log(serviceResult.result);
                    	fieldStatistic(serviceResult.result.fieldNames[0]);
                    }
                });
            }
        }
    }

    //统计结果
    function fieldStatistic(fieldName) {

        if (currentData) {
            var param = new SuperMap.FieldStatisticsParameters({
                datasource: currentData.dataSourceName,
                dataset: currentData.dataSetName,
                fieldName: fieldName,
                statisticMode: [
                    SuperMap.StatisticMode.MAX,
                    SuperMap.StatisticMode.MIN,
                    SuperMap.StatisticMode.SUM,
                    SuperMap.StatisticMode.AVERAGE,
                    SuperMap.StatisticMode.STDDEVIATION,
                    SuperMap.StatisticMode.VARIANCE
                ]
            });
            L.supermap.fieldService(dataURL).getFieldStatisticsInfo(param, function (serviceResult) {
                info.update(serviceResult.result);
            });
        }
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