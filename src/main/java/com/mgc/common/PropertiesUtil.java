package com.mgc.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	protected static Properties p;
	
	public static Properties getProperties(){
		if(p==null){
			p = new Properties();
			InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("system.properties");
			try {
				p.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					if(in!=null) in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return p;
	}
	
	public static String getUploadDirectory(){
		return getProperties().getProperty("upload_directory");
	}
}
