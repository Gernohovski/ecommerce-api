package br.com.fatecmogi.model.exception.endereco;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class EnderecoClienteDiferenteException extends APIException {

    public EnderecoClienteDiferenteException() {
        super("Cliente diferente do cliente do endereço", 400);
    }

}
