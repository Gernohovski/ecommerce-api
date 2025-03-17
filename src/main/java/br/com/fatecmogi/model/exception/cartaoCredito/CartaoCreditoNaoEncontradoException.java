package br.com.fatecmogi.model.exception.cartaoCredito;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class CartaoCreditoNaoEncontradoException extends APIException {

    public CartaoCreditoNaoEncontradoException() {
        super("Cartão de crédito não encontrado", 404);
    }

}
