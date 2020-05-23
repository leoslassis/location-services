package br.com.challenge.locationservices.infra.exception.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;
import java.util.Collections;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResource {

	private Collection<Error> errors;

	public ErrorResource() {
	}

	public Collection<Error> getErrors() {
		return errors;
	}

	public void setErrors(final Collection<Error> errors) {
		this.errors = errors;
	}
}