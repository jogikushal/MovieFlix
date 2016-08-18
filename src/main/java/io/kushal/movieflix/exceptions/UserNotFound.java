package io.kushal.movieflix.exceptions;

public class UserNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2774420616956240938L;
	
	public UserNotFound(String message){
		super(message);
	}

	public UserNotFound(String message,Throwable cause){
		super(message,cause);
	}
}
