package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.pedido.SolicitarDevolucaoPedidoCommand;
import br.com.fatecmogi.model.entity.pedido.SolicitacaoDevolucao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface SolicitacaoDevolucaoMapper {

	@Mapping(target = "pedido.id", source = "pedidoId")
	SolicitacaoDevolucao from(SolicitarDevolucaoPedidoCommand command);

}
