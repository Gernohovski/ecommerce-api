package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.carrinho.AdicionarItemCarrinhoCommand;
import br.com.fatecmogi.controller.dto.carrinho.AlterarQuantidadeItemCommand;
import br.com.fatecmogi.controller.dto.carrinho.CarrinhoDTO;
import br.com.fatecmogi.controller.dto.carrinho.RemoverCarrinhoCommand;

public interface CarrinhoService {

	CarrinhoDTO adicionarItem(AdicionarItemCarrinhoCommand command, Long clienteId);

	CarrinhoDTO removerItem(RemoverCarrinhoCommand command, Long clienteId);

	CarrinhoDTO getCarrinho(Long clienteId);

	CarrinhoDTO alterarQuantidade(AlterarQuantidadeItemCommand command);

}
