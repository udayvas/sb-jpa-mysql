package com.example.demo.exceptions;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	ResponseEntity<StandardError> resourceNotFoundHandler(ResourceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new StandardError("CUST404", "404", "Not found", false));
	}

	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public final ResponseEntity<StandardError> handleConstraintViolationExceptions(ConstraintViolationException ex) {

		log.info("Constraint violation exception", ex.getConstraintViolations());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new StandardError("CUST0001", "400", ex.getMessage(), false));

	}

}
