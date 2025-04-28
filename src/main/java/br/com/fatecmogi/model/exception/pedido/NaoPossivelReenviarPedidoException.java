package br.com.fatecmogi.model.exception.pedido;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class NaoPossivelReenviarPedidoException extends APIException {

	public NaoPossivelReenviarPedidoException() {
		super("Não é possível reenviar o pedido devido a indisponibilidade de estoque.", 422);
	}

}
