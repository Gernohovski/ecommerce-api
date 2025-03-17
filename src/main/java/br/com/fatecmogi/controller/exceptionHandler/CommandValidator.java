package br.com.fatecmogi.controller.exceptionHandler;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.Set;

@ApplicationScoped
public class CommandValidator {

	@Inject
	Validator validator;

	public <T> void validate(T command) {
		Set<ConstraintViolation<T>> violations = validator.validate(command);
		if (!violations.isEmpty()) {
			throw new ValidationException(violations.iterator().next());
		}
	}

}
