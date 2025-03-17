package br.com.fatecmogi.controller.exceptionHandler;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

	@Override
	public Response toResponse(ValidationException exception) {
		return Response.status(exception.getStatusCode())
			.entity(new ErrorResponse(exception.getStatusCode(), exception.getMessage()))
			.build();
	}

	public static class ErrorResponse {

		private final int statusCode;

		private final String message;

		public ErrorResponse(int statusCode, String message) {
			this.statusCode = statusCode;
			this.message = message;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public String getMessage() {
			return message;
		}

	}

}
