package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.estoque.DarEntradaLivroEstoqueCommand;
import br.com.fatecmogi.controller.exceptionHandler.CommandValidator;
import br.com.fatecmogi.model.entity.estoque.ItemEstoque;
import br.com.fatecmogi.model.exception.estoque.ItemEstoqueNaoEncontradoException;
import br.com.fatecmogi.model.repository.ItemEstoqueRepository;
import br.com.fatecmogi.service.EstoqueService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EstoqueServiceImpl implements EstoqueService {

	@Inject
	ItemEstoqueRepository itemEstoqueRepository;

	@Inject
	CommandValidator commandValidator;

	@Override
	public void darBaixa(ItemEstoque itemEstoque) {
		itemEstoqueRepository.update(itemEstoque);
	}

	@Override
	@Transactional
	public void darEntrada(ItemEstoque itemEstoque) {
		itemEstoqueRepository.update(itemEstoque);
	}

	@Override
	@Transactional
	public void darEntrada(DarEntradaLivroEstoqueCommand command) {
		commandValidator.validate(command);
		var itemEstoque = itemEstoqueRepository.findByLivroId(command.getLivroId())
			.orElseThrow(ItemEstoqueNaoEncontradoException::new);
		itemEstoque.setQuantidade(itemEstoque.getQuantidade() + command.getQuantidade());
		itemEstoqueRepository.update(itemEstoque);
	}

	@Override
	public ItemEstoque obterPorLivroId(Long livroId) {
		return itemEstoqueRepository.findByLivroId(livroId).orElseThrow(ItemEstoqueNaoEncontradoException::new);
	}

}
