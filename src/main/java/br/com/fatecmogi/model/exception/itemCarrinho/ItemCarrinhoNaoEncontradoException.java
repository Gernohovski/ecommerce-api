package br.com.fatecmogi.model.exception.itemCarrinho;

import br.com.fatecmogi.controller.exceptionHandler.APIException;

public class ItemCarrinhoNaoEncontradoException extends APIException {

  public ItemCarrinhoNaoEncontradoException() {
    super("Item carrinho não encontrado para o id informado.", 400);
  }

}
