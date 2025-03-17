package br.com.fatecmogi.model.exception.cliente;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class SenhaAtualInformadaInvalidaException extends APIException {

	public SenhaAtualInformadaInvalidaException() {
		super("Senha atual informada é inválida", 400);
	}

}
