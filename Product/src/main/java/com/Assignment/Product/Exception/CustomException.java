package com.Assignment.Product.Exception;


public class CustomException extends RuntimeException{

	private final CustomErrorObject customErrorObject;
	public CustomException(CustomErrorObject customErrorObject) {
		
		this.customErrorObject=customErrorObject;
		
	}
	
	public CustomErrorObject GetcustomErrorObject() {
		return customErrorObject;
		
	}
}
