package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.pedido.Carrinho;
import br.com.fatecmogi.model.repository.CarrinhoRepository;
import br.com.fatecmogi.repository.mapper.PanacheCarrinhoMapper;
import br.com.fatecmogi.repository.table.PanacheCarrinho;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CarrinhoPanacheRepository implements CarrinhoRepository {

	@Inject
	PanacheCarrinhoMapper panacheCarrinhoMapper;

	@Override
	public List<Carrinho> findAllByClienteId(Long id) {
		List<PanacheCarrinho> panacheCarrinho = PanacheCarrinho.find("cliente.id", id).list();
		return panacheCarrinhoMapper.from(panacheCarrinho);
	}

	@Override
	public Carrinho salvar(Carrinho carrinho) {
		PanacheCarrinho panacheCarrinho = panacheCarrinhoMapper.from(carrinho);
		panacheCarrinho.getItens().forEach(item -> {
			item.setCarrinho(panacheCarrinho);
		});
		panacheCarrinho.persistDependecies();
		panacheCarrinho.persist();
		return panacheCarrinhoMapper.from(panacheCarrinho);
	}

	@Override
	public Carrinho atualizar(Carrinho carrinho) {
		PanacheCarrinho panacheCarrinho = PanacheCarrinho.findById(carrinho.getId());
		PanacheCarrinho panacheCarrinhoAtualizado = panacheCarrinhoMapper.update(panacheCarrinho, carrinho);
		panacheCarrinho.getItens().forEach(item -> {
			item.setCarrinho(panacheCarrinhoAtualizado);
		});
		panacheCarrinho.persistDependecies();
		panacheCarrinho.persist();
		return panacheCarrinhoMapper.from(panacheCarrinho);
	}

	@Override
	public Optional<Carrinho> buscar(Long id) {
		PanacheCarrinho panacheCarrinho = PanacheCarrinho.findById(id);
		if (panacheCarrinho == null) {
			return Optional.empty();
		}
		return Optional.of(panacheCarrinhoMapper.from(panacheCarrinho));
	}

}
