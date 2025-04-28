package br.com.fatecmogi.model.exception.itemCarrinho;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class CarrinhoNaoEncontradoException extends APIException {

	public CarrinhoNaoEncontradoException() {
		super("Carrinho não encontrado para o id informado.", 400);
	}

}
