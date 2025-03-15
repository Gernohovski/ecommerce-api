package br.com.fatecmogi.model.exception.cliente;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class EmailJaCadastradoException extends APIException {

    public EmailJaCadastradoException() {
        super("E-mail já cadastrado", 404);
    }

}
