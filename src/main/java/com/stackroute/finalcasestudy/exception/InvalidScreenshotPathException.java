package com.stackroute.finalcasestudy.exception;

@SuppressWarnings("serial")
public class InvalidScreenshotPathException extends RuntimeException {
	String errorMsg;
	public InvalidScreenshotPathException(String errorMsg) {
		super();
		this.errorMsg=errorMsg;
	}
	
	public String toString(){
		return("InvalidScreenshotPathException: "+errorMsg);
	}
}
