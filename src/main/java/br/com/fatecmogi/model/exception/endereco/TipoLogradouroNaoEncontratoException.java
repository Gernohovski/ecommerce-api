package br.com.fatecmogi.model.exception.endereco;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class TipoLogradouroNaoEncontratoException extends APIException {

    public TipoLogradouroNaoEncontratoException() {
        super("Tipo do logradouro não encontrato", 404);
    }
}
