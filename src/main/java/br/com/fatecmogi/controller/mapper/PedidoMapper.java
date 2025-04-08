package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.pedido.AdicionarPedidoCommand;
import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;
import br.com.fatecmogi.model.entity.pedido.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface PedidoMapper {

	@Mapping(target = "cartoesCredito", source = "cartoesCreditoId", qualifiedByName = "mapCartoes")
	@Mapping(target = "endereco.id", source = "enderecoId")
	@Mapping(target = "carrinho.id", source = "carrinhoId")
	@Mapping(target = "cliente.id", source = "clienteId")
	Pedido from(AdicionarPedidoCommand command);

	@Named("mapCartoes")
	default List<CartaoCredito> mapCartoesPorId(List<String> ids) {
		if (ids == null)
			return new ArrayList<>();
		return ids.stream().map(id -> {
			CartaoCredito c = new CartaoCredito();
			c.setId(Long.valueOf(id));
			return c;
		}).toList();
	}

}
