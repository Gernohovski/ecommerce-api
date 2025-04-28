package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.pedido.ItemPedido;
import br.com.fatecmogi.repository.table.PanacheItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi", uses = { PanacheClienteMapper.class, PanacheLivroMapper.class })
public interface PanacheItemPedidoMapper {

	@Mapping(target = "carrinho", ignore = true)
	List<ItemPedido> from(List<PanacheItemPedido> panacheItemPedido);

	@Mapping(target = "carrinho", ignore = true)
	ItemPedido from(PanacheItemPedido itemPedido);

	@Mapping(target = "carrinho", ignore = true)
	PanacheItemPedido from(ItemPedido itemPedido);

}
