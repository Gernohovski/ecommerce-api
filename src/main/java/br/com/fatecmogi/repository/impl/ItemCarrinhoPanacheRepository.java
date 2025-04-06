package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.pedido.Carrinho;
import br.com.fatecmogi.model.entity.pedido.ItemCarrinho;
import br.com.fatecmogi.model.repository.ItemCarrinhoRepository;
import br.com.fatecmogi.repository.mapper.PanacheCarrinhoMapper;
import br.com.fatecmogi.repository.mapper.PanacheItemCarrinhoMapper;
import br.com.fatecmogi.repository.table.PanacheCarrinho;
import br.com.fatecmogi.repository.table.PanacheItemCarrinho;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.Optional;

@ApplicationScoped
public class ItemCarrinhoPanacheRepository implements ItemCarrinhoRepository {

	@Inject
	PanacheItemCarrinhoMapper panacheItemCarrinhoMapper;

	@Inject
	PanacheCarrinhoMapper panacheCarrinhoMapper;

	@Override
	public Carrinho update(ItemCarrinho itemCarrinho) {
		PanacheItemCarrinho panacheItemCarrinho = PanacheItemCarrinho.findById(itemCarrinho.getId());
		panacheItemCarrinho = panacheItemCarrinhoMapper.update(panacheItemCarrinho, itemCarrinho);
		EntityManager entityManager = PanacheItemCarrinho.getEntityManager();
		entityManager.merge(panacheItemCarrinho);
		PanacheCarrinho carrinho = PanacheCarrinho.findById(itemCarrinho.getCarrinho().getId());
		return panacheCarrinhoMapper.from(carrinho);
	}

	@Override
	public Optional<ItemCarrinho> findById(Long id) {
		PanacheItemCarrinho panacheItemCarrinho = PanacheItemCarrinho.findById(id);
		if (panacheItemCarrinho == null) {
			return Optional.empty();
		}
		var itemCarrinho = panacheItemCarrinhoMapper.from(panacheItemCarrinho);
		itemCarrinho.setCarrinho(panacheCarrinhoMapper.from(panacheItemCarrinho.getCarrinho()));
		return Optional.of(itemCarrinho);
	}

}
