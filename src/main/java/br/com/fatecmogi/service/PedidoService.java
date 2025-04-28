package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.controller.dto.pedido.AdicionarPedidoCommand;
import br.com.fatecmogi.controller.dto.pedido.PedidoFiltroDTO;
import br.com.fatecmogi.controller.dto.pedido.SolicitarDevolucaoPedidoCommand;
import br.com.fatecmogi.controller.dto.pedido.SolicitarTrocaPedidoCommand;
import br.com.fatecmogi.controller.response.CustomPage;
import br.com.fatecmogi.model.entity.cupom.CupomTroca;
import br.com.fatecmogi.model.entity.pedido.Pedido;

import java.util.List;

public interface PedidoService {

	Pedido cadastrarPedido(AdicionarPedidoCommand command);

	List<Pedido> listarPedidosCliente(Long clienteId);

	Pedido buscar(Long id);

	CustomPage<Pedido> listarComFiltros(PedidoFiltroDTO filtro, PaginacaoDTO paginacao);

	Pedido cancelar(Long id);

	Pedido alterarSituacao(Long id, String acao);

	Pedido solicitarTroca(SolicitarTrocaPedidoCommand command);

	Pedido solicitarDevolucao(SolicitarDevolucaoPedidoCommand command);

	CupomTroca aprovarTroca(Long id);

}
