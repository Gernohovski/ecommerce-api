package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.pedido.Carrinho;
import br.com.fatecmogi.model.entity.pedido.ItemCarrinho;

import java.util.Optional;

public interface ItemCarrinhoRepository {

	Carrinho update(ItemCarrinho itemCarrinho);

	Optional<ItemCarrinho> findById(Long id);

}
