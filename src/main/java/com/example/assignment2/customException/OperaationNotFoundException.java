package com.example.assignment2.customException;

public class OperaationNotFoundException extends RuntimeException {
	 public OperaationNotFoundException(String message) {
	        super(message);
	    }

}
