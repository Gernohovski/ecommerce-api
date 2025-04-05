package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.carrinho.AdicionarItemCarrinhoCommand;
import br.com.fatecmogi.model.entity.pedido.Carrinho;

public interface CarrinhoService {

	Carrinho adicionarItem(AdicionarItemCarrinhoCommand command);

}
