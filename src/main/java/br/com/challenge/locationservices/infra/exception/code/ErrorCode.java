package br.com.challenge.locationservices.infra.exception.code;

public interface ErrorCode {
	Integer getCode();

	String getMessage();

	String getLocalizedMessage();
}
