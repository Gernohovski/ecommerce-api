package br.com.fatecmogi.model.exception.cartaoCredito;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class CartaoCreditoNaoEncontratoException extends APIException {

	public CartaoCreditoNaoEncontratoException() {
		super("Cartao não encontrado", 404);
	}

}
