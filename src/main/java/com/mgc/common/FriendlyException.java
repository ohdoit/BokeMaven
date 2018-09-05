package com.mgc.common;

public class FriendlyException extends RuntimeException {

	private static final long serialVersionUID = -8967033095901793734L;

	private String detailMessage;
	
	private int responseStatus;
	
	public FriendlyException(){}
	
	public FriendlyException(String detailMessage, int responseStatus){
		this.detailMessage = detailMessage;
		this.responseStatus = responseStatus;
	}

//	public static FriendlyException newInstance (String messageCode, int status){
//		return new FriendlyException(new MessageUtil().getMessage(messageCode), status);
//	}
	
	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public int getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
}
