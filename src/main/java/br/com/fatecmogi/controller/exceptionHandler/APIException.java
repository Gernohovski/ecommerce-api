package br.com.fatecmogi.controller.exceptionHandler;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class APIException extends WebApplicationException {

	public APIException(String messagem, int statusCode) {
		super(Response.status(statusCode)
			.entity(new ResponseError(statusCode, messagem))
			.type(MediaType.APPLICATION_JSON)
			.build());
	}

}
