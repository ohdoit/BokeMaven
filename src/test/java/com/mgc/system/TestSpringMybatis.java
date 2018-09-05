package com.mgc.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mgc.dao.system.SystemUserDao;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class TestSpringMybatis {
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SystemUserDao systemUserDao = (SystemUserDao)ac.getBean("systemUserDao");
		systemUserDao.getSystemUsers().stream().forEach(x->{
			 System.out.println(x.toString());  
		});
		System.out.println("logback 日志");  
		Logger logger = LoggerFactory.getLogger("com.mgc.system.TestSpringMybatis");
		logger.debug("debug logger");
		logger.info("info logger");
//		LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
//		StatusPrinter.print(lc);
	}
}
