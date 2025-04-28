package br.com.fatecmogi.model.exception.solicitacaoTroca;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class SolicitacaoTrocaNaoEcontradaException extends APIException {

	public SolicitacaoTrocaNaoEcontradaException() {
		super("Solicitação de troca não encontrada.", 404);
	}

}
