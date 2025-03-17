package br.com.fatecmogi.model.exception.endereco;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class TipoResidenciaNaoEncontratoException extends APIException {

	public TipoResidenciaNaoEncontratoException() {
		super("Tipo de residência não encontrado", 404);
	}

}
