package com.example.exceptions;

public class ValidSalary extends MyException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ValidSalary(){
		
	}
	
	public ValidSalary(String message){
		super(message);
	}

}
