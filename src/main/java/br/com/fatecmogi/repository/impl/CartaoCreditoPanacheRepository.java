package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;
import br.com.fatecmogi.model.repository.CartaoCreditoRepository;
import br.com.fatecmogi.repository.mapper.PanacheCartaoCreditoMapper;
import br.com.fatecmogi.repository.table.PanacheCartaoCredito;
import br.com.fatecmogi.repository.table.PanacheCliente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CartaoCreditoPanacheRepository implements CartaoCreditoRepository {

	@Inject
	PanacheCartaoCreditoMapper panacheCartaoCreditoMapper;

	@Override
	public CartaoCredito save(CartaoCredito cartaoCredito) {
		PanacheCliente panacheCliente = PanacheCliente.findById(cartaoCredito.getCliente().getId());
		PanacheCartaoCredito panacheCartaoCredito = panacheCartaoCreditoMapper.from(cartaoCredito);
		panacheCartaoCredito.setCliente(panacheCliente);
		panacheCartaoCredito.persist();
		return panacheCartaoCreditoMapper.from(panacheCartaoCredito);
	}

	@Override
	public CartaoCredito update(CartaoCredito cartaoCredito) {
		PanacheCartaoCredito panacheCartaoCreditoSalvo = PanacheCartaoCredito.findById(cartaoCredito.getId());
		PanacheCartaoCredito panacheCartaoCredito = panacheCartaoCreditoMapper.update(panacheCartaoCreditoSalvo,
				cartaoCredito);
		panacheCartaoCredito.persist();
		return panacheCartaoCreditoMapper.from(panacheCartaoCredito);
	}

	@Override
	public Optional<CartaoCredito> findById(Long id) {
		PanacheCartaoCredito panacheCartaoCredito = PanacheCartaoCredito.findById(id);
		if (panacheCartaoCredito == null) {
			return Optional.empty();
		}
		return Optional.of(panacheCartaoCreditoMapper.from(panacheCartaoCredito));
	}

	@Override
	public void delete(Long id) {
		PanacheCartaoCredito.delete("id", id);
	}

	@Override
	public List<CartaoCredito> findAllByCliente(Long clienteId) {
		List<PanacheCartaoCredito> cartoesCredito = PanacheCartaoCredito.find("cliente.id", clienteId).list();
		return panacheCartaoCreditoMapper.from(cartoesCredito);
	}

}
