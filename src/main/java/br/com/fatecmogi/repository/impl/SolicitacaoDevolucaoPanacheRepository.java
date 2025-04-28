package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.pedido.SolicitacaoDevolucao;
import br.com.fatecmogi.model.repository.SolicitacaoDevolucaoRepository;
import br.com.fatecmogi.repository.mapper.PanacheSolicitacaoDevolucaoMapper;
import br.com.fatecmogi.repository.table.PanacheSolicitacaoDevolucao;
import br.com.fatecmogi.repository.table.PanacheSolicitacaoTroca;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class SolicitacaoDevolucaoPanacheRepository implements SolicitacaoDevolucaoRepository {

    @Inject
    PanacheSolicitacaoDevolucaoMapper panacheSolicitacaoDevolucaoMapper;

    @Override
    public void save(SolicitacaoDevolucao solicitacaoDevolucao) {
        PanacheSolicitacaoDevolucao panacheSolicitacaoDevolucao = panacheSolicitacaoDevolucaoMapper.from(solicitacaoDevolucao);
        panacheSolicitacaoDevolucao.persist();
    }

    @Override
    public Optional<SolicitacaoDevolucao> findByPedidoId(Long id) {
        PanacheSolicitacaoDevolucao panacheSolicitacaoDevolucao = PanacheSolicitacaoDevolucao.find("pedido.id", id).firstResult();
        if (panacheSolicitacaoDevolucao == null) {
            return Optional.empty();
        }

        return Optional.of(panacheSolicitacaoDevolucaoMapper.from(panacheSolicitacaoDevolucao));
    }

}
