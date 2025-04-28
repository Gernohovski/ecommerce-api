package br.com.fatecmogi.model.exception.pedido;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class PedidoNaoEncontradoException extends APIException {

	public PedidoNaoEncontradoException() {
		super("Pedido não encontrado.", 404);
	}

}
