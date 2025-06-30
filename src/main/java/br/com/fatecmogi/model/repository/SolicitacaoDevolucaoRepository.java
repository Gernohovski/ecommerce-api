package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.pedido.SolicitacaoDevolucao;

import java.util.Optional;

public interface SolicitacaoDevolucaoRepository {

	void save(SolicitacaoDevolucao solicitacaoDevolucao);

	Optional<SolicitacaoDevolucao> findByPedidoId(Long id);

}
