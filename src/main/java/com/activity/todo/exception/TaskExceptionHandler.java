package com.activity.todo.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;

@ControllerAdvice
public class TaskExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ TaskIdNotFoundException.class, EmptyResultDataAccessException.class })
	protected ModelAndView notFoundHandler(Exception ex, WebRequest request) {

		ModelAndView exceptionView = new ModelAndView();
		exceptionView.addObject("exception","Task for the given id was not found");
		exceptionView.addObject("error", HttpStatus.NOT_FOUND);
		
		exceptionView.setViewName("error");
		return exceptionView;
	}
	
	@ExceptionHandler({ UserNotFoundException.class})
	protected ModelAndView userNotFoundHandler(Exception ex, WebRequest request) {
	
		
		ModelAndView exceptionView = new ModelAndView();
		exceptionView.addObject("exception","User for the given id was not found");
		exceptionView.addObject("error", HttpStatus.NOT_FOUND);
		
		exceptionView.setViewName("error");
		return exceptionView;
		
	}
	
	@ExceptionHandler({ TaskForUserNotFoundException.class})
	protected ModelAndView emptyTaskHandler(Exception ex, WebRequest request) {

		ModelAndView exceptionView = new ModelAndView();
		exceptionView.addObject("No Task for given User id was found");
		exceptionView.addObject("error", HttpStatus.NOT_FOUND);
		
		exceptionView.setViewName("error");
		return exceptionView;
	}

	@ExceptionHandler({ TaskIdMismatchException.class, ConstraintViolationException.class,
			DataIntegrityViolationException.class, NumberFormatException.class,IllegalStateException.class,
			MethodArgumentTypeMismatchException.class,JsonParseException.class })
	public ModelAndView invalidFormatHandler(Exception ex, WebRequest request) {
		
		ModelAndView exceptionView = new ModelAndView();
		exceptionView.addObject("Missing or Invalid Argument");
		exceptionView.addObject("error", HttpStatus.UNPROCESSABLE_ENTITY);
		
		exceptionView.setViewName("error");
		return exceptionView;
	}

}