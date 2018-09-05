package com.mgc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
	
	//请谨慎使用ANT风格
	/**
	 * ANT 风格1
	 * 1.使用?作为路径的占位符，一个?表示一个字符，表示请求路径必须补充同样数量的字符。
	 * @return
	 */
	@RequestMapping("/testAntOne???")
	public String testAnt1(){
		return "test/test";
	}
	
	/**
	 * ANT 风格2
	 * 2.使用*作为路径的占位符，表示0个或多个字符，表示请求路径可以补充任意个字符。
	 * @return
	 */
	@RequestMapping("/testAntTwo*")
	public String testAnt2(){
		return "test/test";
	}
	
	/**
	 * 路径参数
	 */
	@RequestMapping("/testPathVariable/{username}")
	public ModelAndView testPathVariable(@PathVariable("username") String user){
		System.out.println(user);
		ModelAndView view = new ModelAndView();
		view.setViewName("test/test");
		view.addObject("user", user);
		return view;
	}
	
	/**
	 * 请求参数
	 */
	@RequestMapping("/testRequestParam")
	public ModelAndView testRequestParam(@RequestParam("username") String user){
		System.out.println(user);
		ModelAndView view = new ModelAndView();
		view.setViewName("test/test");
		view.addObject("username", user);
		return view;
	}
}
