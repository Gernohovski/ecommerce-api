package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.pedido.SituacaoPedido;
import br.com.fatecmogi.repository.table.PanacheSituacaoPedido;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PanacheSituacaoPedidoMapper {

    List<SituacaoPedido> from(List<PanacheSituacaoPedido> panacheSituacaoPedido);

}
