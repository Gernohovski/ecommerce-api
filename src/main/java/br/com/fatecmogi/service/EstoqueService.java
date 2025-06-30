package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.estoque.DarEntradaLivroEstoqueCommand;
import br.com.fatecmogi.model.entity.estoque.ItemEstoque;

public interface EstoqueService {

	void darBaixa(ItemEstoque itemEstoque);

	void darEntrada(ItemEstoque itemEstoque);

	void darEntrada(DarEntradaLivroEstoqueCommand command);

	ItemEstoque obterPorLivroId(Long livroId);

}
