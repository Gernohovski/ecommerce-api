package br.com.fatecmogi.model.exception.livro;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class LivroValorInsuficienteException extends APIException {

    public LivroValorInsuficienteException() {
        super("O valor de venda não pode ser menor que o valor mínimo calculado.", 400);
    }

}
