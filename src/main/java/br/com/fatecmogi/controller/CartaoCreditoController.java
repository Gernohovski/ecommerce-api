package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.cartaoCredito.CadastrarCartaoCreditoClienteCommand;
import br.com.fatecmogi.controller.dto.cartaoCredito.EditarCartaoCreditoClienteCommand;
import br.com.fatecmogi.service.CartaoCreditoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cartoesCredito")
public class CartaoCreditoController {

	@Inject
	CartaoCreditoService cartaoCreditoService;

	@PostMapping
	public Response salvar(@RequestBody CadastrarCartaoCreditoClienteCommand command) {
		var cartao = cartaoCreditoService.salvar(command);
		return Response.status(Response.Status.CREATED).entity(cartao).build();
	}

	@PutMapping("/{id}")
	public Response atualizar(@PathVariable("id") Long id, @RequestBody EditarCartaoCreditoClienteCommand command) {
		var cartao = cartaoCreditoService.atualizar(id, command);
		return Response.status(Response.Status.OK).entity(cartao).build();
	}

	@DeleteMapping("/{id}")
	public Response deletar(@PathVariable("id") Long id) {
		cartaoCreditoService.deletar(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}

	@PutMapping("/{id}/{clienteId}")
	public Response tornarPrincipal(@PathVariable("id") Long id, @PathVariable("clienteId") Long clienteId) {
		cartaoCreditoService.tornarPrincipal(id, clienteId);
		return Response.status(Response.Status.NO_CONTENT).build();
	}

}
