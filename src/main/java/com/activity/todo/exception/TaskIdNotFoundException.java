package com.activity.todo.exception;

public class TaskIdNotFoundException extends RuntimeException {
	 
    public TaskIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
   

	public TaskIdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TaskIdNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TaskIdNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}