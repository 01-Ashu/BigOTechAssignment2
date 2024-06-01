package com.Assignment.Product.Exception;

public class UserNotFoundException {
	  private CustomErrorObject customErrorObject;

	    public UserNotFoundException(String errorCode, String errorMessage) {
	       
	        this.customErrorObject = new CustomErrorObject(errorCode, errorMessage);
	    }

	    public CustomErrorObject getCustomErrorObject() {
	        return customErrorObject;
	    }
}
