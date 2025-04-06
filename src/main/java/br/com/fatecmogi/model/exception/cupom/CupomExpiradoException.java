package br.com.fatecmogi.model.exception.cupom;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class CupomExpiradoException extends APIException {

	public CupomExpiradoException() {
		super("O cupom informado expirou.", 400);
	}

}
