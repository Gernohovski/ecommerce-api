package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.controller.dto.pedido.AdicionarPedidoCommand;
import br.com.fatecmogi.controller.dto.pedido.PedidoFiltroDTO;
import br.com.fatecmogi.controller.dto.pedido.SolicitarDevolucaoPedidoCommand;
import br.com.fatecmogi.controller.dto.pedido.SolicitarTrocaPedidoCommand;
import br.com.fatecmogi.service.PedidoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {

	@Inject
	PedidoService pedidoService;

	@PostMapping
	public Response cadastrar(@RequestBody AdicionarPedidoCommand command) {
		var pedido = pedidoService.cadastrarPedido(command);
		return Response.status(Response.Status.CREATED).entity(pedido).build();
	}

	@GetMapping("/{id}")
	public Response buscar(@PathVariable("id") Long id) {
		var pedido = pedidoService.buscar(id);
		return Response.status(Response.Status.OK).entity(pedido).build();
	}

	@GetMapping
	public Response listarTodos(@BeanParam PedidoFiltroDTO filtro, @BeanParam PaginacaoDTO paginacao) {
		var pedidos = pedidoService.listarComFiltros(filtro, paginacao);
		return Response.status(Response.Status.OK).entity(pedidos).build();
	}

	@PutMapping("/{id}/cancelar")
	public Response cancelar(@PathVariable("id") Long id) {
		var pedido = pedidoService.cancelar(id);
		return Response.status(Response.Status.OK).entity(pedido).build();
	}

	@PutMapping("/{id}/{acao}")
	public Response alterarSituacao(@PathVariable("id") Long id, @PathVariable("acao") String acao) {
		var pedido = pedidoService.alterarSituacao(id, acao);
		return Response.status(Response.Status.OK).entity(pedido).build();
	}

	@PostMapping("/solicitar-troca")
	public Response solicitarTroca(@RequestBody SolicitarTrocaPedidoCommand command) {
		var pedido = pedidoService.solicitarTroca(command);
		return Response.status(Response.Status.OK).entity(pedido).build();
	}

	@PostMapping("/solicitar-devolucao")
	public Response solicitarDevolucao(@RequestBody SolicitarDevolucaoPedidoCommand command) {
		var pedido = pedidoService.solicitarDevolucao(command);
		return Response.status(Response.Status.OK).entity(pedido).build();
	}

	@PutMapping("{id}/aprovar-troca")
	public Response aprovarTroca(@PathVariable("id") Long id) {
		var cupomTroca = pedidoService.aprovarTroca(id);
		return Response.status(Response.Status.OK).entity(cupomTroca).build();
	}

}
