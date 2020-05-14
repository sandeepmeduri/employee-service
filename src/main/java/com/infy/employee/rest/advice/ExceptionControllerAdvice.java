package com.infy.employee.rest.advice;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.infy.employee.dto.ErrorMessage;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public HttpEntity<ErrorMessage> handleException(Exception ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_ACCEPTABLE);
	}

}
