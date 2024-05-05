package com.codebuffer.SpringBootTutorial.error;

public class DepartmentNotFoundException extends Exception {
	
	public DepartmentNotFoundException() {
		super();
	}
	
	public DepartmentNotFoundException(String msg) {
		super(msg);
	}
	
	public DepartmentNotFoundException(String msg,Throwable cause) {
		super(msg,cause);
	}
	
	public DepartmentNotFoundException(Throwable cause) {
		super(cause);
	}
	
}