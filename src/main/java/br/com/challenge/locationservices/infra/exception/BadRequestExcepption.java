package br.com.challenge.locationservices.infra.exception;

import br.com.challenge.locationservices.infra.exception.code.ErrorCode;
import br.com.challenge.locationservices.infra.exception.code.ErrorCodes;

public class BadRequestExcepption extends BaseException {

    public BadRequestExcepption(final ErrorCode errorCode) {
        super(errorCode);
    }

    public BadRequestExcepption(final String message) {
        super(message);
    }

    public BadRequestExcepption(String message, ErrorCodes errorCodes) {
        super(message, errorCodes);
    }
}