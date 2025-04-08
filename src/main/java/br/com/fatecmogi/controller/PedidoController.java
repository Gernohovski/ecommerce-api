package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.pedido.AdicionarPedidoCommand;
import br.com.fatecmogi.service.PedidoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
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
	public Response listar(@PathVariable("id") Long id) {
		var pedidos = pedidoService.listarPedidosCliente(id);
		return Response.status(Response.Status.OK).entity(pedidos).build();
	}

}
