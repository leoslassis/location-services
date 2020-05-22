package br.com.challenge.locationservices.infra.exception.code;

public enum ErrorCodes implements ErrorCode {

	//NOT_FOUND
	ENDPOINT_NOT_FOUND(404001, "Endpoint Not Found"),
	POSTAL_CODE_NOT_FOUND(404002, "Location Not Found"),

	//BAD_REQUEST
	INVALID_PARAMETER_TYPE(400001, "Invalid parameter type"),
	POSTAL_CODE_IS_MANDATORY(400002, "Postal code is mandatory"),
	INVALID_POSTAL_CODE(400003, "Invalid postal code"),

	//UNSUPPORTED_MEDIA_TYPE
	INVALID_MEDIA_TYPE(415000, "Invalid content type");

    private final Integer code;
	private final String message;

	ErrorCodes(final Integer code, final String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getLocalizedMessage() {
		return null;
	}
}
