package com.mgc.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.web.servlet.support.RequestContext;

public class MessageUtil {
	
	public static String getMessage(MessageSource ms, String code, Object[] args, Locale locale){
		return ms.getMessage(code, args, code, locale);
	}
	

	public static String getMessage(MessageSource ms, String code){
		return getMessage(ms, code, null, null);
	} 
	
	public static String getMessage(HttpServletRequest request, String code){
		return new RequestContext(request).getMessage(code);
	}
}
