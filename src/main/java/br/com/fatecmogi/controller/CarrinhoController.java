package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.carrinho.AdicionarItemCarrinhoCommand;
import br.com.fatecmogi.service.CarrinhoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/carrinhos")
public class CarrinhoController {

	@Inject
	CarrinhoService carrinhoService;

	@PostMapping
	public Response adicionarItem(@RequestBody AdicionarItemCarrinhoCommand command) {
		var carrinho = carrinhoService.adicionarItem(command);
		return Response.status(Response.Status.OK).entity(carrinho).build();
	}

}
