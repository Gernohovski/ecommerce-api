package br.com.fatecmogi.model.exception.estoque;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class ItemEstoqueNaoEncontradoException extends APIException {

	public ItemEstoqueNaoEncontradoException() {
		super("Item estoque não encontrado.", 404);
	}

}
