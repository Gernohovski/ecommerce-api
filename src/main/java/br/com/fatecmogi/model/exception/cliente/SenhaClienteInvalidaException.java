package br.com.fatecmogi.model.exception.cliente;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class SenhaClienteInvalidaException extends APIException {

    public SenhaClienteInvalidaException() {
        super("Senha inválida.", 400);
    }

}
