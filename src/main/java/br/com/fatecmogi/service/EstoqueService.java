package br.com.fatecmogi.service;

import br.com.fatecmogi.model.entity.estoque.ItemEstoque;

public interface EstoqueService {

	void darBaixa(ItemEstoque itemEstoque);

	void darEntrada(ItemEstoque itemEstoque);

	ItemEstoque obterPorLivroId(Long livroId);

}
