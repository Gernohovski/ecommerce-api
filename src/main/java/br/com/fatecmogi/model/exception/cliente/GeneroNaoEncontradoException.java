package br.com.fatecmogi.model.exception.cliente;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class GeneroNaoEncontradoException extends APIException {

    public GeneroNaoEncontradoException() {
        super("Genêro não encontrado", 404);
    }

}
