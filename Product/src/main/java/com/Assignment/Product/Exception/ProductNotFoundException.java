package com.Assignment.Product.Exception;

public class ProductNotFoundException {
	private CustomErrorObject customErrorObject;

    public ProductNotFoundException(String errorCode, String errorMessage) {
       
        this.customErrorObject = new CustomErrorObject(errorCode, errorMessage);
    }

    public CustomErrorObject getCustomErrorObject() {
        return customErrorObject;
    }
}
