package br.com.fatecmogi.controller.exceptionHandler;

import jakarta.validation.ConstraintViolation;
import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
  private final int statusCode;
  private final String message;

  public ValidationException(ConstraintViolation<?> violation) {
    super(violation.getMessage());
    this.statusCode = 400;
    this.message = violation.getMessage();
  }
}
