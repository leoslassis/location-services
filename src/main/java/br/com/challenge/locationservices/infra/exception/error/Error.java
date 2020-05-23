package br.com.challenge.locationservices.infra.exception.error;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

	private Integer code;
	private String message;
	private String localizedMessage;

	public Error(Integer code, String message, String localizedMessage) {
		this.code = code;
		this.message = message;
		this.localizedMessage = localizedMessage;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getLocalizedMessage() {
		return localizedMessage;
	}
}
