package com.example.exceptions;

public class ValidPositiveID extends MyException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ValidPositiveID(){
		
	}
	
	public ValidPositiveID(String message){
		super(message);
	}

}
