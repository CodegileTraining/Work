package com.example.exceptions;

public class ValidFirstName extends MyException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ValidFirstName(){
		
	}
	
	public ValidFirstName(String message){
		super(message);
	}

}
