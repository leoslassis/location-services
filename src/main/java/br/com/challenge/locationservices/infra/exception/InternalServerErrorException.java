package br.com.challenge.locationservices.infra.exception;

public class InternalServerErrorException extends BaseException {
	public InternalServerErrorException(String message, Exception e) {
		super(message, e);
	}
}
