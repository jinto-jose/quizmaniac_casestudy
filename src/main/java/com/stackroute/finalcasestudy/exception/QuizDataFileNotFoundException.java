package com.stackroute.finalcasestudy.exception;

@SuppressWarnings("serial")
public class QuizDataFileNotFoundException extends RuntimeException {
	String errorMsg;
	public QuizDataFileNotFoundException(String errorMsg) {
		super();
		this.errorMsg=errorMsg;
	}
	
	public String toString(){
		return("QuizDataFileNotFoundException: "+errorMsg);
	}
}
