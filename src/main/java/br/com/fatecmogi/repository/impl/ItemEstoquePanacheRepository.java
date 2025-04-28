package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.estoque.ItemEstoque;
import br.com.fatecmogi.model.repository.ItemEstoqueRepository;
import br.com.fatecmogi.repository.mapper.PanacheItemEstoqueMapper;
import br.com.fatecmogi.repository.table.PanacheItemEstoque;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class ItemEstoquePanacheRepository implements ItemEstoqueRepository {

	@Inject
	PanacheItemEstoqueMapper panacheItemEstoqueMapper;

	@Override
	public ItemEstoque update(ItemEstoque itemEstoque) {
		PanacheItemEstoque panacheItemEstoque = PanacheItemEstoque.findById(itemEstoque.getId());
		panacheItemEstoque = panacheItemEstoqueMapper.update(panacheItemEstoque, itemEstoque);
		panacheItemEstoque.persist();
		return panacheItemEstoqueMapper.from(panacheItemEstoque);
	}

	@Override
	public Optional<ItemEstoque> findByLivroId(Long livroId) {
		PanacheItemEstoque panacheItemEstoque = PanacheItemEstoque.find("livro.id", livroId).firstResult();
		if (panacheItemEstoque == null) {
			return Optional.empty();
		}
		return Optional.of(panacheItemEstoqueMapper.from(panacheItemEstoque));
	}

}
