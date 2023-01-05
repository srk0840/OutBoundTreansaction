package com.example.demo.Exception;

public class Insufficient extends RuntimeException{
	
	
	private  static final long serialVersionUID=1;

	String message1="insufficient quantity";
	
	public Insufficient() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public Insufficient(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public Insufficient(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	
	public Insufficient(int message, String cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public Insufficient(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		this.message1=message;
	}

	public Insufficient(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
