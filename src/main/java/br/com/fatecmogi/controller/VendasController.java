package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.vendas.FiltrarVendasCommand;
import br.com.fatecmogi.service.VendasService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vendas")
public class VendasController {

	@Inject
	private VendasService vendasService;

	@PostMapping
	public Response filtrarVendas(@RequestBody FiltrarVendasCommand command) {
		var resposta = vendasService.filtrarVendas(command);
		return Response.status(Response.Status.OK).entity(resposta).build();
	}

}
