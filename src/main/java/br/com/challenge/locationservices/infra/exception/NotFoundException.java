package br.com.challenge.locationservices.infra.exception;

import br.com.challenge.locationservices.infra.exception.code.ErrorCode;
import br.com.challenge.locationservices.infra.exception.code.ErrorCodes;

public class NotFoundException extends BaseException {

    public NotFoundException(final ErrorCode errorCode) {
        super(errorCode);
    }

    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException(String message, ErrorCodes errorCodes) {
        super(message, errorCodes);
    }
}