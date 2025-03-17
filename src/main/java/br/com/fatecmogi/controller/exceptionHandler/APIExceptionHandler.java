package br.com.fatecmogi.controller.exceptionHandler;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class APIExceptionHandler implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		if (exception instanceof APIException apiException) {
			return apiException.getResponse();
		}
		else if (exception instanceof ValidationException validationException) {
			return Response.status(Response.Status.BAD_REQUEST).entity(validationException.getMessage()).build();
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage()).build();
	}

}
