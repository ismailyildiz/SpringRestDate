package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.model.ExceptionResponse;

@ControllerAdvice(basePackages = { "com.controller" })
public class GlobalControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> generalException(Exception ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Failed");
		response.setErrorMessage(ex.getMessage());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
