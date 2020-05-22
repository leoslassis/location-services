package br.com.challenge.locationservices.infra.exception;

import br.com.challenge.locationservices.infra.exception.code.ErrorCode;
import br.com.challenge.locationservices.infra.exception.code.ErrorCodes;

public class ConflictException extends BaseException {

    public ConflictException(final ErrorCode errorCode) {
        super(errorCode);
    }

    public ConflictException(final String message) {
        super(message);
    }

    public ConflictException(String message, ErrorCodes errorCodes) {
        super(message, errorCodes);
    }
}