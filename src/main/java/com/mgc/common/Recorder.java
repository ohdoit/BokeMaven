package com.mgc.common;

/**
 * 记录器
 * @author Administrator
 *
 */
public class Recorder {
	
	public void before(){
		System.out.println("执行方法之前...");
	}
	
	public void after(){
		System.out.println("执行方法之后...");
	}
}
