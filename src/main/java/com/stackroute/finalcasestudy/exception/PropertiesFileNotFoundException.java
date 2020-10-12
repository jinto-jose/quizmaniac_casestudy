package com.stackroute.finalcasestudy.exception;

@SuppressWarnings("serial")
public class PropertiesFileNotFoundException extends RuntimeException {
	String errorMsg;
	public PropertiesFileNotFoundException(String errorMsg) {
		super();
		this.errorMsg=errorMsg;
	}
	
	public String toString(){
		return("PropertiesFileNotFoundException: "+errorMsg);
	}
}
