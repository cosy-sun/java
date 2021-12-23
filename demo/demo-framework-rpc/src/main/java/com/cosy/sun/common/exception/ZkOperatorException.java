package com.cosy.sun.common.exception;

public class ZkOperatorException extends RuntimeException {

	private static final long serialVersionUID = -3718572632450818522L;

	public ZkOperatorException() {
		super();
	}

	public ZkOperatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ZkOperatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ZkOperatorException(String message) {
		super(message);
	}

	public ZkOperatorException(Throwable cause) {
		super(cause);
	}

	
	
}
