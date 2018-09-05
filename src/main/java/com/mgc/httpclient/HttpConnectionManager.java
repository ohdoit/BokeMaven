package com.mgc.httpclient;

import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpConnectionManager {
	private Logger log = LoggerFactory.getLogger(HttpConnectionManager.class);
	
	private PoolingHttpClientConnectionManager cm = null;
	
	//该注解修饰的方法将会在依赖注入完成后调用
	@PostConstruct
	public void init(){
		LayeredConnectionSocketFactory sslsf = null;
		try {
			sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
		} catch (NoSuchAlgorithmException e) {
			log.error("", e);
			return;
		}
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("https", sslsf)
				.register("http", new PlainConnectionSocketFactory()).build();
		cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		cm.setMaxTotal(300);
		cm.setDefaultMaxPerRoute(30);
		System.out.println("http connection pool init success!");
	}
	
	public CloseableHttpClient getHttpClient(){
		if(cm!=null){
			return HttpClients.custom().setConnectionManager(cm).build();
		}else{
			System.out.println("create default HttpClient!");
			return HttpClients.createDefault();
		}
	}
}
