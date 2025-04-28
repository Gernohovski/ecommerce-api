package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.pedido.SolicitacaoTroca;

import java.util.Optional;

public interface SolicitacaoTrocaRepository {

	void save(SolicitacaoTroca solicitacaoTroca);

	Optional<SolicitacaoTroca> findByPedidoId(Long id);

}
