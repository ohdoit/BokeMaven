package filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * 最常见的使用过滤器的例子有：登录验证（有些页面只有登录了才能访问），
 * 错误日志记录（网站运行出现错误时记录下错误日志），编码转换等。
 * @author Administrator
 *
 */
public class TestFilter implements Filter{

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println(config.getFilterName());
		Enumeration enumeration = config.getInitParameterNames();
        System.out.println("----filter init----");  
		while(enumeration.hasMoreElements()){
			String name = enumeration.nextElement().toString();
			System.out.println(name+"="+config.getInitParameter(name));
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
        System.out.println("----filter destroy----");  
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
        System.out.println("----filter doFilter----");  
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		System.out.println("----调用service之前执行一段代码----");  
		if(req instanceof HttpServletRequest)
		filter.doFilter(new TestServletRequestWrapper((HttpServletRequest)req), res);
		else filter.doFilter(req, res);
        System.out.println("----调用service之后执行一段代码----");  
	}

	/*
	 * 装修类，用于修改 HttpServletRequest 属性或参数值
	 */
	private class TestServletRequestWrapper extends HttpServletRequestWrapper{

		public TestServletRequestWrapper(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}

		@Override
	    public String getParameter(String name) {
			System.out.println("修改前："+name+"="+super.getParameter(name));
	        return "修改后："+name+"=modify-"+super.getParameter(name);
	    }
	}
}
