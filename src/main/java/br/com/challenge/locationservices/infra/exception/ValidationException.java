package br.com.challenge.locationservices.infra.exception;


import br.com.challenge.locationservices.infra.exception.code.ErrorCode;
import br.com.challenge.locationservices.infra.exception.code.ErrorCodes;

public class ValidationException extends BaseException {

	public ValidationException(final ErrorCode errorCode) {
		super(errorCode);
	}

	public ValidationException(String message, ErrorCodes errorCode) {
		super(message, errorCode);
	}

	public ValidationException(String message) {
		super(message);
	}
}
