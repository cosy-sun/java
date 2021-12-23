package com.cosy.sun.common.exception;

public class NullServiceException extends RuntimeException {

	private static final long serialVersionUID = 3501744687870453497L;

	public NullServiceException() {
		super();
	}

	public NullServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NullServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public NullServiceException(String message) {
		super(message);
	}

	public NullServiceException(Throwable cause) {
		super(cause);
	}

	
	
}
