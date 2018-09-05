package servlet;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestHttpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//重定向
//		response.setStatus(302);
//		response.setHeader("location", "http://www.baidu.com/");
		//定时刷新
//		response.setHeader("refresh", "3;url='http://www.baidu.com/'");
//		response.getWriter().write("3秒后刷新...");
		gzip(response);
		
		response.setHeader("content-disposition", "attachment;filename=index.jsp");
		download(response); 
	}

	/**
	 * 压缩
	 * @throws IOException 
	 */
	private void gzip(HttpServletResponse response) throws IOException{
		String abc = "abc";
		for(int i=0; i<1000; i++){
			abc += i;
		}
		byte[] data = abc.getBytes();
		System.out.println("数据原始大小："+data.length);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		GZIPOutputStream gos = new GZIPOutputStream(os);
		gos.write(data);
		gos.close();
		data = os.toByteArray();
		System.out.println("数据压缩后大小："+data.length);
//		response.setHeader("Content-Encoding", "gzip");
//		response.setHeader("Content-length", data.length+"");
	}
	
	/**
	 * 下载
	 */
	private void download(HttpServletResponse response) throws IOException{
		String file = this.getServletContext().getRealPath("/index.jsp");
		System.out.println("文件路径："+file);
		FileInputStream is = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		byte[] data = new byte[1024];
		int length = 0;
		while((length=is.read(data))>0){
			os.write(data,0,length);
		}
		os.close();
		is.close();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
