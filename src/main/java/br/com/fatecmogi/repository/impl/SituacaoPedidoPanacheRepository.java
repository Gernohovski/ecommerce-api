package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.pedido.SituacaoPedido;
import br.com.fatecmogi.model.repository.SituacaoPedidoRepository;
import br.com.fatecmogi.repository.mapper.PanacheSituacaoPedidoMapper;
import br.com.fatecmogi.repository.table.PanacheSituacaoPedido;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class SituacaoPedidoPanacheRepository implements SituacaoPedidoRepository {

    @Inject
    PanacheSituacaoPedidoMapper panacheSituacaoPedidoMapper;


    @Override
    public List<SituacaoPedido> listarTodas() {
        return panacheSituacaoPedidoMapper.from(PanacheSituacaoPedido.findAll().list());
    }
}
