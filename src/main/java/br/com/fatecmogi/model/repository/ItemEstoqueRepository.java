package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.estoque.ItemEstoque;

import java.util.Optional;

public interface ItemEstoqueRepository {

	ItemEstoque update(ItemEstoque itemEstoque);

	Optional<ItemEstoque> findByLivroId(Long livroId);

}
