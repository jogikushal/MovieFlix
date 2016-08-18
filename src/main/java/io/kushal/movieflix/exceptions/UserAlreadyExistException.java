package io.kushal.movieflix.exceptions;

public class UserAlreadyExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException(String message){
		super(message);
	}

	public UserAlreadyExistException(String message,Throwable cause){
		super(message,cause);
	}
}
