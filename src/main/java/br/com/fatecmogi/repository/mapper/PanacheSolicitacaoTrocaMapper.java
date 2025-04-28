package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.pedido.SolicitacaoTroca;
import br.com.fatecmogi.repository.table.PanacheSolicitacaoTroca;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi",
		uses = { PanachePedidoMapper.class, PanacheItemPedidoMapper.class, PanacheClienteMapper.class })
public interface PanacheSolicitacaoTrocaMapper {

	PanacheSolicitacaoTroca from(SolicitacaoTroca solicitacaoTroca);

	SolicitacaoTroca from(PanacheSolicitacaoTroca panacheSolicitacaoTroca);

}
