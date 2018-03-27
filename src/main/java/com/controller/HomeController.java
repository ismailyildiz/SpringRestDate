package com.controller;

import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.ExceptionResponse;
import com.model.Result;
import com.service.IDateConverterService;

@RestController
public class HomeController {

	@Autowired
	private IDateConverterService dateConverterService;

	@ResponseBody
	@RequestMapping(value = "/api/berlinClock", params = {
			"time" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public Result getBerlinClock(@RequestParam(value = "time", required = true) String utcTime) {

		return this.dateConverterService.convertUtcToBerlinZone(utcTime);

	}

	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<ExceptionResponse> parsaException(DateTimeParseException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Input Failed");
		response.setErrorMessage(ex.getMessage());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
