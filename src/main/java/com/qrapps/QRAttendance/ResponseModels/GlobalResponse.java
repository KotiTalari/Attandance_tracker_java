package com.qrapps.QRAttendance.ResponseModels;

public class GlobalResponse {
	private String code;
	private Object data;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public GlobalResponse(String code, Object data, String message) {
		super();
		this.code = code;
		this.data = data;
		this.message = message;
	}
	public GlobalResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
