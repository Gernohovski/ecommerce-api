package br.com.fatecmogi.model.exception.cupom;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class CupomNaoEncontradoException extends APIException {

	public CupomNaoEncontradoException() {
		super("Cupom não encontrado.", 400);
	}

}
