package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener{
	private static int count = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSession().isNew()) count++;
		System.out.println("当前在线人数："+count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		if(count>0) count--;
		System.out.println("当前在线人数："+count);
	}

	public static int getCount(){
		return count;
	}
}
