package com.stackroute.finalcasestudy.exception;

@SuppressWarnings("serial")
public class UnsupportedBrowserDriverException extends RuntimeException {
	String errorMsg;
	public UnsupportedBrowserDriverException(String errorMsg) {
		super();
		this.errorMsg=errorMsg;
	}
	
	public String toString(){
		return("UnsupportedBrowserDriverException: "+errorMsg);
	}
}
