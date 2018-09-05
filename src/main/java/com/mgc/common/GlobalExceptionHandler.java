package com.mgc.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("GlobalExceptionHandler work...");
		ModelAndView view = new ModelAndView();
		view.setStatus(HttpStatus.BAD_REQUEST);
		view.addObject("exception", ex.getMessage());
		view.setViewName("error");
		return view;
	}

}
