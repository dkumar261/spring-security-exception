package com.sx.controller.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.sx.model.exception.CustomException;
import com.sx.model.exception.ErrorModel;

@ControllerAdvice
public class CustomExceptionHandlerController{

	@ExceptionHandler(IndexOutOfBoundsException.class)
	public final ResponseEntity<Object> handleIndexOutOfBoundException(Exception ex, WebRequest request) throws Exception {
		
		ErrorModel errorModel = new ErrorModel();
		errorModel.setDetails("--customer details");
		errorModel.setMessage("--customer message without extending any class--");
		errorModel.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<Object>(errorModel, HttpStatus.NOT_FOUND);
	}	

	@ExceptionHandler(BadCredentialsException.class)
	public final ResponseEntity<Object> handleBadCredentialsException(Exception ex, WebRequest request) throws Exception {
		
		ErrorModel errorModel = new ErrorModel();
		errorModel.setDetails("User Password is Incorrect.");
		errorModel.setMessage(ex.getMessage());
		errorModel.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<Object>(errorModel, HttpStatus.UNAUTHORIZED);
	}	

	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) throws Exception {
		
		ErrorModel errorModel = new ErrorModel();
		errorModel.setDetails("username is Incorrect.");
		errorModel.setMessage(ex.getMessage());
		errorModel.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<Object>(errorModel, HttpStatus.UNAUTHORIZED);
	}	
}
