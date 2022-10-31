package com.ebidingapp.exceptionHandler;

public class Error {
	private String message;
	private int status;
	private Long timeStamp;
	
	public String getMessage() {return message;};
	public void setMessage(String message) {this.message=message;}
	public int getStatus() {return status;};
	public void setStatus(int status) {this.status=status;}
	public Long getTimeStamp() {return timeStamp;};
	public void setTimeStamp(Long timeStamp) {this.timeStamp=timeStamp;}

}
