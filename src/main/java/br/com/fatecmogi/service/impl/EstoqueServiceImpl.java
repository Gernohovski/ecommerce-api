package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.estoque.ItemEstoque;
import br.com.fatecmogi.model.exception.estoque.ItemEstoqueNaoEncontradoException;
import br.com.fatecmogi.model.repository.ItemEstoqueRepository;
import br.com.fatecmogi.service.EstoqueService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EstoqueServiceImpl implements EstoqueService {

	@Inject
	ItemEstoqueRepository itemEstoqueRepository;

	@Override
	public void darBaixa(ItemEstoque itemEstoque) {
		itemEstoqueRepository.update(itemEstoque);
	}

	@Override
	public void darEntrada(ItemEstoque itemEstoque) {
		itemEstoqueRepository.update(itemEstoque);
	}

	@Override
	public ItemEstoque obterPorLivroId(Long livroId) {
		return itemEstoqueRepository.findByLivroId(livroId).orElseThrow(ItemEstoqueNaoEncontradoException::new);
	}

}
