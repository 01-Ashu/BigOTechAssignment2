package com.Assignment.Product.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {
	  @ExceptionHandler(ProductNotFoundException.class)
	    public ResponseEntity<CustomErrorObject> handleProductNotFoundException(ProductNotFoundException ex) {
	        CustomErrorObject customErrorObject = ex.getCustomErrorObject();
	        return new ResponseEntity<>(customErrorObject, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<CustomErrorObject> handleUserNotFoundException(UserNotFoundException ex) {
	        CustomErrorObject customErrorObject = ex.getCustomErrorObject();
	        return new ResponseEntity<>(customErrorObject, HttpStatus.BAD_REQUEST);
	    }
	    
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<CustomErrorObject> handleGenericException(Exception ex) {
	        CustomErrorObject customErrorObject = new CustomErrorObject("GENERIC_ERROR", ex.getMessage());
	        return new ResponseEntity<>(customErrorObject, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
   
}
