package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.controller.dto.pedido.PedidoFiltroDTO;
import br.com.fatecmogi.controller.response.CustomPage;
import br.com.fatecmogi.model.entity.pedido.Pedido;
import br.com.fatecmogi.model.enums.SituacaoDoPedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {

	Pedido save(Pedido pedido);

	List<Pedido> findAllByClienteId(Long clienteId);

	CustomPage<Pedido> findAll(PedidoFiltroDTO filtro, PaginacaoDTO paginacao);

	Optional<Pedido> findById(Long id);

	Pedido updateSituation(Long id, SituacaoDoPedido situacaoDoPedido);

}
