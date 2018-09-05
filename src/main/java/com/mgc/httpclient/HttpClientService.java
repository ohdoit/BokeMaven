package com.mgc.httpclient;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgc.common.MessageUtil;

public class HttpClientService {
	private static Logger log = LoggerFactory.getLogger(HttpClientService.class);
	
	
	public static String doGet(String url){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		StringBuilder sb = null;
		try {
			CloseableHttpResponse resp = httpclient.execute(httpGet);
			System.out.println(resp.getStatusLine());
			HttpEntity entity = resp.getEntity();
			Header contentType = entity.getContentType();
			System.out.println(contentType.getName()+"="+contentType.getValue());
			InputStream is = entity.getContent();
			BufferedInputStream br = new BufferedInputStream(is);
			byte[] d = new byte[1024];
			int l = 0;
			sb = new StringBuilder();
			while((l=br.read(d))!=-1){
				sb.append(new String(d, 0, l));
			}
			System.out.println(sb.toString());
			EntityUtils.consume(entity);
			resp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("", e);
		}finally{
			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("", e);
			}
		}
		return sb!=null ? sb.toString() : null;
	}
	
	public static JsonNode doGet2Json(String url){
		String data = doGet(url);
		if(data!=null){
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.readTree(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("", e);
			}
		}
		return null;
	}
	
	public static String doPost(String url, Map<String, String> params){
		HttpPost httpPost = new HttpPost(url);
		if(params!=null){
			List<NameValuePair> nvps = params.keySet().stream()
					.map(key->new BasicNameValuePair(key, params.get(key))).collect(Collectors.toList());
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				log.error("", e);
			}
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		StringBuilder sb = null;
		try {
			CloseableHttpResponse resp = httpClient.execute(httpPost);
			HttpEntity entity = resp.getEntity();
			InputStream is = entity.getContent();
			BufferedInputStream br = new BufferedInputStream(is);
			byte[] d = new byte[1024];
			int l = 0;
			sb = new StringBuilder();
			while((l=br.read(d))!=-1){
				sb.append(new String(d, 0, l));
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("", e);
		}
		try {
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("", e);
		}
		return sb!=null ? sb.toString() : null;
	}
	
	public static JsonNode doPost2Json(String url, Map<String, String> params){
		String result = doPost(url, params);
		if(result!=null){
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.readTree(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("", e);
			}
		}
		return null;
	}
	
	public static void doGet2(String url){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		// create a custom response handler
		ResponseHandler<String> responseHandler = new ResponseHandler<String>(){
			@Override
			public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if(status>=200 && status<300){
					HttpEntity entity = response.getEntity();
					return entity!=null ? EntityUtils.toString(entity) : null;
				}else{
					throw new ClientProtocolException("Unexpected response status: "+status);
				}
			}
			
		};
		try {
			String responseBody = httpClient.execute(httpget, responseHandler);
			System.out.println(responseBody);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("", e);
		} finally{
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("", e);
			}
		}
		
	}
	
	public static void main(String[] args) {
//		doGet("http://www.baidu.com");
//		doGet2("http://www.baidu.com");
		doGet("http://localhost:8080/BokeMaven/boke/systemUser?account=admin");
		JsonNode node = doGet2Json("http://localhost:8080/BokeMaven/boke/systemUser?account=admin");
		System.out.println("node: "+node.toString());
		Map<String, String> params = new HashMap<>();
		params.put("account", "admin");
		node = doPost2Json("http://localhost:8080/BokeMaven/boke/systemUser2", params);
		System.out.println("node: "+node.toString());
		
	}
}
