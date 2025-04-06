package br.com.fatecmogi.model.exception.cupom;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class CodigoDoCupomJaCadastradoException extends APIException {

	public CodigoDoCupomJaCadastradoException() {
		super("Código já cadastrado.", 400);
	}

}
