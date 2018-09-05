package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 登陆验证
 *
 */
public class LoginFilter implements Filter{
	private String[] publicUrls;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)req;
		HttpServletResponse httpRes = (HttpServletResponse)res;
		boolean isPublicUrl = false;
		if(publicUrls!=null){
			for(int i=0; i<publicUrls.length; i++){
				System.out.println(httpReq.getRequestURL());
				System.out.println(publicUrls[i]);
				if(httpReq.getRequestURL().indexOf(publicUrls[i])>=0){
					isPublicUrl = true;
					break;
				}
			}
		}
		String account = (String)httpReq.getSession().getAttribute("account");
		//TODO 
//		account = "admin";
		if(!isPublicUrl && (account==null || account.isEmpty())){
			System.out.println("没有登陆跳转登陆页面...");
			httpRes.sendRedirect(httpReq.getContextPath()+"/boke/login");
		}else{
			System.out.println("当前用户名："+account);
			filterChain.doFilter(httpReq, httpRes);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String publicUrl = config.getInitParameter("publicUrls");
		if(publicUrl!=null){
			publicUrls = publicUrl.split(",");
		}
	}

}
