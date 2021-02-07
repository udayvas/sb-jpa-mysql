package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerNotFoundAdvice {

	  @ResponseBody
	  @ExceptionHandler(ResourceNotFoundException.class)
	  @ResponseStatus(code = HttpStatus.NOT_FOUND)
	  ResponseEntity<StandardError> resourceNotFoundHandler(ResourceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandardError("XYZ001", "404", "Not found", false));
	  }
}
