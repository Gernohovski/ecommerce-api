package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.pedido.SolicitacaoTroca;
import br.com.fatecmogi.model.repository.SolicitacaoTrocaRepository;
import br.com.fatecmogi.repository.mapper.PanacheSolicitacaoTrocaMapper;
import br.com.fatecmogi.repository.table.PanacheSolicitacaoTroca;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class SolicitacaoTrocaPanacheRepository implements SolicitacaoTrocaRepository {

	@Inject
	PanacheSolicitacaoTrocaMapper panacheSolicitacaoTrocaMapper;

	@Override
	public void save(SolicitacaoTroca solicitacaoTroca) {
		PanacheSolicitacaoTroca panacheSolicitacaoTroca = panacheSolicitacaoTrocaMapper.from(solicitacaoTroca);
		panacheSolicitacaoTroca.persist();
	}

	@Override
	public Optional<SolicitacaoTroca> findByPedidoId(Long id) {
		PanacheSolicitacaoTroca panacheSolicitacaoTroca = PanacheSolicitacaoTroca.find("pedido.id", id).firstResult();
		if (panacheSolicitacaoTroca == null) {
			return Optional.empty();
		}

		return Optional.of(panacheSolicitacaoTrocaMapper.from(panacheSolicitacaoTroca));
	}

}
