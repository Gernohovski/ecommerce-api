package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.carrinho.AdicionarItemCarrinhoCommand;
import br.com.fatecmogi.controller.dto.carrinho.AlterarQuantidadeItemCommand;
import br.com.fatecmogi.controller.dto.carrinho.RemoverCarrinhoCommand;
import br.com.fatecmogi.service.CarrinhoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/carrinhos")
public class CarrinhoController {

	@Inject
	CarrinhoService carrinhoService;

	@PostMapping("/{id}/adicionar")
	public Response adicionarItem(@PathVariable("id") Long clienteId,
			@RequestBody AdicionarItemCarrinhoCommand command) {
		var carrinho = carrinhoService.adicionarItem(command, clienteId);
		return Response.status(Response.Status.OK).entity(carrinho).build();
	}

	@PostMapping("/{id}/remover")
	public Response removerItem(@PathVariable("id") Long clienteId, @RequestBody RemoverCarrinhoCommand command) {
		var carrinho = carrinhoService.removerItem(command, clienteId);
		return Response.status(Response.Status.OK).entity(carrinho).build();
	}

	@GetMapping("/{id}")
	public Response buscar(@PathVariable("id") Long clienteId) {
		var carrinho = carrinhoService.getCarrinho(clienteId);
		return Response.status(Response.Status.OK).entity(carrinho).build();
	}

	@PutMapping("/alterarQuantidade")
	public Response alterarQuantidade(@RequestBody AlterarQuantidadeItemCommand command) {
		var carrinho = carrinhoService.alterarQuantidade(command);
		return Response.status(Response.Status.OK).entity(carrinho).build();
	}

}
