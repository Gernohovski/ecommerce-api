package br.com.fatecmogi.model.exception.livro;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class LivroNaoEncontradoException extends APIException {

    public LivroNaoEncontradoException() {
        super("Livro não encontrado.", 404);
    }

}
