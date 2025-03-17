package br.com.fatecmogi.model.exception.endereco;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class EnderecoNaoEncontradoException extends APIException {

	public EnderecoNaoEncontradoException() {
		super("Endereço não encontrado", 404);
	}

}
