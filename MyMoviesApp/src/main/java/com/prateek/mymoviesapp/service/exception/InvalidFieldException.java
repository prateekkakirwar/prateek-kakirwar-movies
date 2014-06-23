package com.prateek.mymoviesapp.service.exception;

/**
 * Convinience exception - we don't need this but will be used in many places so creating it
 * 
 * @author pkakirwar
 *
 */
@SuppressWarnings("serial")

public class InvalidFieldException extends MyMoviesAppException  {
	
	public InvalidFieldException(String message, Throwable throwable) {
		super(ErrorCode.INVALID_FIELD, message, throwable);
	}
	
	public InvalidFieldException(String message) {
		super(ErrorCode.INVALID_FIELD, message);
	}

}
