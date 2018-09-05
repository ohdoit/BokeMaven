package container;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简单servlet服务
 * @author Administrator
 *
 */
public class SimpleServletServer {

	private boolean shutdown = false;
	public static void main(String[] args) {
//		System.out.println("服务启动...");
//		SimpleServletServer server = new SimpleServletServer();
//		server.start();
	}
	
	public void start(){
		ServerSocket server = null;
		try {
			server = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Socket socket;
		InputStream input;
		OutputStream output;
		while(!shutdown){
			try {
				socket = server.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				SimpleServletRequest request = new SimpleServletRequest(input);
				request.print();
				SimpleServletResponse response = new SimpleServletResponse(output);
				response.sendStaticResource();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(shutdown){
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	public void shutdown(){
		this.shutdown = true;
	}
}
