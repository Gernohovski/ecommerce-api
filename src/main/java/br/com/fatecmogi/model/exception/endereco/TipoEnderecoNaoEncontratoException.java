package br.com.fatecmogi.model.exception.endereco;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class TipoEnderecoNaoEncontratoException extends APIException {

	public TipoEnderecoNaoEncontratoException() {
		super("Tipo de endereço inválido", 400);
	}

}
