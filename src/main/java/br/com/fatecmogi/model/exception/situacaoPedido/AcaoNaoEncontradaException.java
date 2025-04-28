package br.com.fatecmogi.model.exception.situacaoPedido;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class AcaoNaoEncontradaException extends APIException {

	public AcaoNaoEncontradaException() {
		super("Ação não encontrada.", 404);
	}

}
