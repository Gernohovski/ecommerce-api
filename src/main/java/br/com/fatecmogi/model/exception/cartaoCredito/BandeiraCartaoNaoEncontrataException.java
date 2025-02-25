package br.com.fatecmogi.model.exception.cartaoCredito;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class BandeiraCartaoNaoEncontrataException extends APIException {

    public BandeiraCartaoNaoEncontrataException() {
        super("Bandeira do cartão de crédito não encontrada", 404);
    }

}

