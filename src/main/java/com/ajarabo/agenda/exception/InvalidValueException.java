package com.ajarabo.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Invalid value")  // 404
public class InvalidValueException extends RuntimeException {
	
	private static final long serialVersionUID = 299264267700970717L;	

}
