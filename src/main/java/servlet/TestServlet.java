package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServlet implements Servlet {

	public TestServlet(){
		super();
		System.out.println("TestServlet...");
	}
	
	/**
	 * 第一次调用时调用该方法初始化TestServlet，以后再调用时，服务器从缓存中获取TestServlet对象。
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		config.getInitParameter("");
		System.out.println("init...");

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service...");

	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy...");
	}

}
