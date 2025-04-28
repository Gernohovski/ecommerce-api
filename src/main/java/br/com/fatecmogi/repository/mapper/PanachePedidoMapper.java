package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.pedido.Pedido;
import br.com.fatecmogi.repository.table.PanachePedido;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi",
		uses = { PanacheCartaoCreditoMapper.class, PanacheEnderecoMapper.class, PanacheCartaoCreditoMapper.class,
				PanacheLivroMapper.class, PanacheCarrinhoMapper.class, PanacheItemPedidoMapper.class })
public interface PanachePedidoMapper {

	PanachePedido from(Pedido pedido);

	Pedido from(PanachePedido panachePedido);

	List<Pedido> from(List<PanachePedido> panachePedidos);

}
