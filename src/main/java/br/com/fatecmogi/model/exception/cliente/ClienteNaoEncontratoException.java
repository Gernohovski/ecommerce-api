package br.com.fatecmogi.model.exception.cliente;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class ClienteNaoEncontratoException extends APIException {

    public ClienteNaoEncontratoException() {
        super("Cliente não encontrado.", 404);
    }
}
