package com.ebidingapp.exceptionHandler;

public class ResourceNotFoundException extends RuntimeException {

	public static final long serialVersionUID=1L;
	public ResourceNotFoundException (String message) {super(message);};
}
