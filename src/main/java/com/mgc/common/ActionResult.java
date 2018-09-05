package com.mgc.common;

import java.io.Serializable;

public class ActionResult implements Serializable{

	private static final long serialVersionUID = 6979455135253411012L;
	
	public static final int SUCCESS = 0;
	public static final int ILLEGAL_PARAM = 1;
	public static final int SYSTEM_ERROR = 4;
	
	private String message;
	private int status;
	private Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
