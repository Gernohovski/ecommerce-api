package br.com.fatecmogi.model.exception.cliente;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class CpfJaCadastradoException extends APIException {

    public CpfJaCadastradoException() {
        super("CPF já cadastrado", 404);
    }

}
