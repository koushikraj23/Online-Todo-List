package com.activity.todo.exception;

public class TaskIdMismatchException extends RuntimeException {
	 
    public TaskIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }


	public TaskIdMismatchException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskIdMismatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TaskIdMismatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TaskIdMismatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}