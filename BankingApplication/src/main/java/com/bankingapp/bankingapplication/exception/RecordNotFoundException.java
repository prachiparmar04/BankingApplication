package com.bankingapp.bankingapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author PRACHI PARMAR
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid token..")
public class RecordNotFoundException extends RuntimeException {
	/**
	 * @param msg
	 */
	public RecordNotFoundException(String msg) {
		super(msg);
	}
}
