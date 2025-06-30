package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.pedido.Carrinho;

import java.util.List;
import java.util.Optional;

public interface CarrinhoRepository {

	List<Carrinho> findAllByClienteId(Long id);

	Carrinho salvar(Carrinho carrinho);

	Carrinho atualizar(Carrinho carrinho);

	Optional<Carrinho> buscar(Long id);

	List<Carrinho> getValid();

}
