package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.estoque.DarEntradaLivroEstoqueCommand;
import br.com.fatecmogi.service.EstoqueService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/estoques")
public class EstoqueController {

	@Inject
	EstoqueService estoqueService;

	@PutMapping("/darEntrada")
	public Response darEntrada(@RequestBody DarEntradaLivroEstoqueCommand command) {
		estoqueService.darEntrada(command);
		return Response.status(Response.Status.CREATED).build();
	}

}
