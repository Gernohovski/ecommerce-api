package br.com.fatecmogi.model.exception.cartaoCredito;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class CartaoCreditoClienteDiferenteException extends APIException {

    public CartaoCreditoClienteDiferenteException() {
        super("Cliente diferente do cliente do cartão", 400);
    }

}
