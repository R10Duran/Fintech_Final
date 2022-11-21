package br.com.fintech.exception;

public class DBException extends Exception {
	
	public DBException() {
		super();
		// TODO AUto-generate constructor stub
	}
	
	public DBException (String message, Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression,
				writableStackTrace);
		// TODO Auto generate constructor stub
	}
	
	public DBException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public DBException (String message) {
		super(message);
	}
	
	public DBException (Throwable cause) {
		super(cause);
	}
	
	
}
