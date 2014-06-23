package com.prateek.mymoviesapp.service.exception;

/**
* Root of our exception heirarchy
* @author pkakirwar
*
*/
@SuppressWarnings("serial")

public class MyMoviesAppException extends RuntimeException  {
	
	private ErrorCode errorCode;
	
	public MyMoviesAppException(ErrorCode code, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}
	
	public MyMoviesAppException(ErrorCode code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	} 

}
