package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.pedido.SolicitacaoDevolucao;
import br.com.fatecmogi.repository.table.PanacheSolicitacaoDevolucao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi",
		uses = { PanachePedidoMapper.class, PanacheItemPedidoMapper.class, PanacheClienteMapper.class })
public interface PanacheSolicitacaoDevolucaoMapper {

	PanacheSolicitacaoDevolucao from(SolicitacaoDevolucao solicitacaoDevolucao);

	SolicitacaoDevolucao from(PanacheSolicitacaoDevolucao panacheSolicitacaoDevolucao);

}
