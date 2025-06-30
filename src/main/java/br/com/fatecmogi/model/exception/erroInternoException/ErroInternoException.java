package br.com.fatecmogi.model.exception.erroInternoException;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class ErroInternoException extends APIException {

	public ErroInternoException() {
		super("Ocorreu um erro interno. Por favor tente novamente mais tarde.", 500);
	}

}
