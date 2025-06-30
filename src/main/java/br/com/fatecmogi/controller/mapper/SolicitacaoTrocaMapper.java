package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.pedido.SolicitarTrocaPedidoCommand;
import br.com.fatecmogi.model.entity.pedido.SolicitacaoTroca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface SolicitacaoTrocaMapper {

	@Mapping(target = "pedido.id", source = "pedidoId")
	SolicitacaoTroca from(SolicitarTrocaPedidoCommand command);

}
