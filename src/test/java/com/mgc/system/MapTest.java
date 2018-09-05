package com.mgc.system;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class MapTest {

    /**
     * 逆向匹配接口
     * 根据地址名称，匹配得到经纬度坐标
     * @param addr
     * @return
     */
   public static String geocode(String addr){
       String xyStr="";
       addr=URLEncoder.encode(addr);
       StringBuffer str = new StringBuffer();
       String lng="";
       String lat="";
       try {
           //System.out.println("http://api.map.baidu.com/geocoder?address="+addr+"&output=json");
           String sUrl="http://api.map.baidu.com/geocoder/v2/?address="+addr+"&output=json&ak=FeuQOBmCyjUYrbWkgey8eSmn";
           java.net.URL url = new java.net.URL(sUrl);
           //java.net.URL url = new java.net.URL("http://api.map.baidu.com/?qt=gc&wd="+addr+"&cn=%E5%85%A8%E5%9B%BD&ie=utf-8&oue=0&res=api&callback=BMap._rd._cbk96117");
           BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
           String line;
           while ((line = in.readLine()) != null) {
               str.append(line);
           }
           in.close();
//           JSONObject dataJson=null;
//           dataJson =JSONObject.fromObject(str.toString());
//           JSONObject result=dataJson.getJSONObject("result");
//           JSONObject location=result.getJSONObject("location");
//           lng =location.getDouble("lng")+"";
//           lat =location.getDouble("lat")+"";
//           xyStr= lng+" "+lat;
           xyStr = str.toString();
       } catch (Exception e) {
           lng="";
           lat="";
       }
       return xyStr;
   }
   
   public static void main(String [] args){
       String xy = geocode("成都市成华区建设路颐和家园7栋2801");
       System.out.println(xy);
       
//       Map address = geodecode("40.033534,116.313289");
//       System.out.println(address);
       
   }
}
